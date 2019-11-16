package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

public class DConnectionMaker implements ConnectionMaker{

	//	<bean id="connectionMaker" class="springbook.user.dao.DConnectionMaker" />
	// DConnectionMaker를 빈으로 정의
	public Connection makeConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook", "root", "");
		return c;
	}
}