package Vietpackage.jbdc;
import java.sql.*;

public class ConnectionUtil {
	public static Connection getMySQLConnection() 
			throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "lab1";
		String userName = "root";
		String password = "";
		String connectionURL = "jdbc:mysql://" + hostName +	":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL,userName,password);
		return conn;
	}
}
