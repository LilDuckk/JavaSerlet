package duc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class UpdateData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Tạo kết nối
        Connection connection = ConnectionUtils.getMySQLConnection();
        Scanner scanner = new Scanner(System.in);

        // Nhập mã khách hàng cần cập nhật
        System.out.print("Nhập mã khách hàng cần cập nhật: ");
        int cusID = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới sau khi nhập số để tránh lỗi

        // Kiểm tra xem khách hàng có tồn tại không
        if (!isCustomerExist(connection, cusID)) {
            System.out.println("Không tìm thấy khách hàng có mã " + cusID);
            return;
        }

        // Nhập thông tin khách hàng mới
        System.out.println("Nhập thông tin khách hàng mới:");

        System.out.print("Tên người dùng: ");
        String cusUser = scanner.nextLine();

        System.out.print("Mật khẩu: ");
        String cusPass = scanner.nextLine();

        System.out.print("Tên: ");
        String cusName = scanner.nextLine();

        System.out.print("Số điện thoại: ");
        String cusPhone = scanner.nextLine();

        System.out.print("Địa chỉ: ");
        String cusAdd = scanner.nextLine();

        System.out.print("Email: ");
        String cusEmail = scanner.nextLine();

        System.out.print("Facebook: ");
        String cusFacebook = scanner.nextLine();

        System.out.print("Skyper: ");
        String cusSkyper = scanner.nextLine();

        System.out.print("Trạng thái: ");
        int cusStatus = scanner.nextInt();

        // Tạo truy vấn cập nhật
        String sql = "UPDATE customer SET CusUser = ?, CusPass = ?, CusName = ?, CusPhone = ?, " +
                "CusAdd = ?, CusEmail = ?, CusFacebook = ?, CusSkyper = ?, CusStatus = ? WHERE CusID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        // Gán giá trị cho biến tham số
        pstm.setString(1, cusUser);
        pstm.setString(2, cusPass);
        pstm.setString(3, cusName);
        pstm.setString(4, cusPhone);
        pstm.setString(5, cusAdd);
        pstm.setString(6, cusEmail);
        pstm.setString(7, cusFacebook);
        pstm.setString(8, cusSkyper);
        pstm.setInt(9, cusStatus);
        pstm.setInt(10, cusID);

        // Thực thi câu lệnh truy vấn
        int rowCount = pstm.executeUpdate();
        System.out.println("Đã cập nhật thông tin khách hàng có mã " + cusID + ": " + rowCount + " bản ghi");

        // Đóng kết nối và các tài nguyên khác
        pstm.close();
        connection.close();
        scanner.close();
    }

    // Phương thức kiểm tra xem khách hàng có tồn tại không
    private static boolean isCustomerExist(Connection connection, int cusID) throws SQLException {
        String sql = "SELECT * FROM customer WHERE CusID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, cusID);
        ResultSet rs = pstm.executeQuery();
        boolean exist = rs.next();
        rs.close();
        pstm.close();
        return exist;
    }
}