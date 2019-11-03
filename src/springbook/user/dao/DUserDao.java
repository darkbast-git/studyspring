package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class DUserDao extends UserDao{
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		// D사의 UserDao
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook", "root", "");
		return c;
	}
}
