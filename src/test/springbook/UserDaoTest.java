package test.springbook;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
//		
//		User user = new User();
//		user.setId("whiteship5");
//		user.setName("차차5");
//		user.setPassword("marry5");
//		userDao.add(user);
//		
//		User user2 = new User();
//		user2 = userDao.get(user.getId());
//		
//		assertThat(user.getName(), is(user2.getName()));
//		assertThat(user.getPassword(), is(user2.getPassword()));
		
		dao.deleteAll();
		User user = new User();
		user.setId("1");
		user.setName("N1");
		user.setPassword("P1");
	
		dao.add(user);
		assertThat(dao.getCount(), is(1));
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}
}
