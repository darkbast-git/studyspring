package springbook.user.dao;

import java.sql.SQLException;

public class DaoFactory {
	public UserDao userDao() throws ClassNotFoundException, SQLException{
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
}
