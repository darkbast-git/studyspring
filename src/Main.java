import java.sql.SQLException;

import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("차차");
		user.setPassword("marry");
		
		dao.add(user);

	}

}
