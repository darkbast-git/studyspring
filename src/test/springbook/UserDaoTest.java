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
	public void delelteAll() throws Exception{
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
	}

	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
//		
		User user1 = new User("1-1","N1-1","P1-1");
		User user2 = new User("1-2","N1-2","P1-2");
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(),is(2));
		
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
	}
	
	@Test
	public void count() throws Exception{
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user1 = new User("1","N1","P1");
		User user2 = new User("2","N2","P2");
		User user3 = new User("3","N3","P3");
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));

	}
}
