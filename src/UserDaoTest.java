import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		
		// 설정정보를 읽어드린다. @Configuration
		// CGLIB is required to process @Configuration classes.
		// @Configuration을 읽는건 다른 cglib였다.
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		// 설정정보에서 읽어드린 정보에서 Bean정보를 읽어드린다. @Bean
		// userDao는 DaoFactory의 메소드명으로 빈명이 정해지기 때문에
		UserDao userDao = context.getBean("userDao", UserDao.class);
		
		ConnectionMaker connectionMaker = new DConnectionMaker();
		userDao = new UserDao(connectionMaker);

		User user = new User();
		user.setId("whiteship3");
		user.setName("차차3");
		user.setPassword("marry3");
		userDao.add(user);
	}

}
