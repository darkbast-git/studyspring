package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정을 담당하는 오브젝트
@Configuration
public class DaoFactory {
	
	// 오브젝트 생성을 담당
	@Bean
	public UserDao userDao() throws ClassNotFoundException, SQLException{
		UserDao userDao = new UserDao(getConnectionMaker());
		return userDao;
	}
	
	// 각종 Dao들이 존재할때마다 ConnectionMaker를 생성하게 된다.
	// 커넥션을 지정하는 것으로 DaoFactory를 복수 지정하는 것만으로
	// 다른 커넥션으로 연결되는 DaoFactory를 만들 수 있다.
//	public ConnectionMaker getConnectionMaker(){
//		return new 각 커넥션들;
//	}
	
	public ConnectionMaker getConnectionMaker(){
		return new DConnectionMaker();
	}
	
}
