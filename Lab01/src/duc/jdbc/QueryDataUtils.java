package duc.jdbc;

import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.mysql.cj.xdevapi.Statement;

public class QueryDataUtils {
	public static ResultSet getAll(String sql)

			throws SQLException,

			ClassNotFoundException {
		Connection connection = ConnectionUtils.getMySQLConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
