package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker{

	public Connection makeConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.jdbc.oracle");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook", "root", "");
		return c;
	}
}