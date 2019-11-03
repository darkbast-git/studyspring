import java.sql.SQLException;

import springbook.user.dao.DUserDao;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDao dao = new DUserDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("차차");
		user.setPassword("marry");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());

	}

}
