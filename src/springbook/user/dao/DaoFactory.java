package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

// 설정을 담당하는 오브젝트
public class DaoFactory {
	
//	public DataSource dataSource(){
//	
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//		dataSource.setDriver(driver);
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection(
//				"jdbc:mysql://localhost/springbook", "root", "");
//		return c;
//	}

}
