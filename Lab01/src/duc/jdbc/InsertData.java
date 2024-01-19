package duc.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.mysql.cj.xdevapi.Statement;

public class InsertData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
// Tạo kết nối
		Connection connection = ConnectionUtils.getMySQLConnection();
		Statement statement = connection.createStatement();
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Nhập thông tin khách hàng:");
	        System.out.print("ID: ");
	        int cusID = scanner.nextInt();
	        scanner.nextLine();

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
// Tạo truy vấn thêm
	        String sql = "INSERT INTO customer(CusID, CusUser, CusPass, CusName, CusPhone, CusAdd, CusEmail, CusFacebook, CusSkyper, CusStatus) " +
	                "VALUES(" + cusID + ", '" + cusUser + "', '" + cusPass + "', '" + cusName + "', '" + cusPhone + "', '" + cusAdd + "', '" +
	                cusEmail + "', '" + cusFacebook + "', '" + cusSkyper + "', " + cusStatus + ")";

// Thực thi câu lệnh truy vấn
		int rowCount = statement.executeUpdate(sql);
		System.out.println("Đã thêm mới 1 bản ghi: " +rowCount);
		statement.close();
        connection.close();
	}
}
