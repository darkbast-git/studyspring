package test.springbook;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setUp(){
		ApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		this.dao = context.getBean("userDao", UserDao.class);
		this.user1 = new User("1","N1","P1");
		this.user2 = new User("2","N2","P2");
		this.user3 = new User("3","N3","P3");
	}
	
	@Test
	public void delelteAll() throws Exception{
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
	}

	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
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
		
//		User user1 = new User("1","N1","P1");
//		User user2 = new User("2","N2","P2");
//		User user3 = new User("3","N3","P3");
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));

	}
	
	// get()예외조건에 대한 테스트
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws Exception{
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		User user = dao.get("unknown");
	}
}
