package Vietpackage.jbdc;

import java.sql.*;

public class QueryDataUtils {
	public static ResultSet getAll(String sql)

			throws SQLException,

			ClassNotFoundException {
		Connection connection = ConnectionUtil.getMySQLConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
