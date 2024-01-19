package Vietpackage.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Tạo kết nối
				Connection connection = ConnectionUtil.getMySQLConnection();
				 Scanner scanner = new Scanner(System.in);
				 System.out.println("Nhập thông tin khách hàng:");
			        System.out.print("ID: ");
			        int cusID = scanner.nextInt();
			        scanner.nextLine();
			        // Tạo truy vấn xóa
			        String sql = "DELETE FROM customer WHERE CusID = ?";
			        PreparedStatement pstm = connection.prepareStatement(sql);

			        // Gán giá trị cho biến tham số
			        pstm.setInt(1, cusID);

			        // Thực thi câu lệnh truy vấn
			        int rowCount = pstm.executeUpdate();
			        System.out.println("Đã xóa bản ghi có ID " + cusID + ": " + rowCount);

			        // Đóng kết nối và các tài nguyên khác
			        pstm.close();
			        connection.close();
			        scanner.close();
			    }
}
