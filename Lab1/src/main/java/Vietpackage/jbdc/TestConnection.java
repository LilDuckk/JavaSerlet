package Vietpackage.jbdc;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) 
				throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Get connection ... ");
		
		Connection conn = ConnectionUtil.getMySQLConnection();
		System.out.println("Get connection " + conn);
		System.out.println("Done!");
	}

}
