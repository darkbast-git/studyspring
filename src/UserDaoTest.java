import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception{
		System.out.println("");
		// XML설정을 읽는 것으로 변경
		// src 폴더낸의 applicationContext.xml의 설정 정보를 읽어옴.
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 설정정보에서 읽어드린 정보에서 Bean정보를 읽어드린다. @Bean
		// userDao는 DaoFactory의 메소드명으로 빈명이 정해지기 때문에
		UserDao userDao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("whiteship4");
		user.setName("차차4");
		user.setPassword("marry4");
		userDao.add(user);
	}

}
