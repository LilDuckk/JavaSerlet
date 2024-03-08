package nguyenngocviet.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class nguyenngocvietConnection {
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "NguyenNgocViet_2110900054_db";
		String userName = "root";
		String password = "";
		String connectionURL = "jdbc:mysql://" + hostName +	":3306/" + dbName;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connectionURL,userName,password);
		return conn;
	}
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			
		}
	}
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			
		}
	}
}
