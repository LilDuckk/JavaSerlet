package duc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class FindbyName {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Tạo kết nối
        Connection connection = ConnectionUtils.getMySQLConnection();
        Scanner scanner = new Scanner(System.in);

        // Nhập tên khách hàng cần tìm kiếm
        System.out.print("Nhập tên khách hàng cần tìm kiếm: ");
        String cusName = scanner.nextLine();

        // Tạo truy vấn tìm kiếm
        String sql = "SELECT * FROM customer WHERE CusName LIKE ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        // Gán giá trị cho biến tham số
        pstm.setString(1, "%" + cusName + "%"); // Sử dụng LIKE để tìm kiếm theo phần của tên

        // Thực thi câu lệnh truy vấn
        ResultSet rs = pstm.executeQuery();

        // Hiển thị kết quả
        while (rs.next()) {
            int cusID = rs.getInt("CusID");
            String resultCusName = rs.getString("CusName");
            String cusUser = rs.getString("CusUser");
            String cusPass = rs.getString("CusPass");
            String cusPhone = rs.getString("CusPhone");
            String cusAdd = rs.getString("CusAdd");
            String cusEmail = rs.getString("CusEmail");
            String cusFacebook = rs.getString("CusFacebook");
            String cusSkyper = rs.getString("CusSkyper");
            int cusStatus = rs.getInt("CusStatus");

            System.out.println("Mã khách hàng: " + cusID);
            System.out.println("Tên khách hàng: " + resultCusName);
            System.out.println("Tên người dùng: " + cusUser);
            System.out.println("Mật khẩu: " + cusPass);
            System.out.println("Số điện thoại: " + cusPhone);
            System.out.println("Địa chỉ: " + cusAdd);
            System.out.println("Email: " + cusEmail);
            System.out.println("Facebook: " + cusFacebook);
            System.out.println("Skyper: " + cusSkyper);
            System.out.println("Trạng thái: " + cusStatus);
            System.out.println("-----------------------------");
        }

        // Đóng kết nối và các tài nguyên khác
        rs.close();
        pstm.close();
        connection.close();
        scanner.close();
    }
}
