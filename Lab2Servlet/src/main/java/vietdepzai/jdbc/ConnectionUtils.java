package vietdepzai.jdbc;

import java.sql.*;

public class ConnectionUtils {
	public static Connection getMySQLConnection() 
			throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "lb2";
		String userName = "root";
		String password = "";
		String connectionURL = "jdbc:mysql://" + hostName +	":3306/" + dbName;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connectionURL,userName,password);
		return conn;
	}
}
