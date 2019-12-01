package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.domain.User;

public class UserDao {

	private JdbcContext jdbcContext;
	
	public void setJdbcContext(JdbcContext jdbcContext){
		this.jdbcContext = jdbcContext;
	}
	
	/*
	 * 내부클래스를 사용하는 방법
	 */
	public void add(User user) throws ClassNotFoundException, SQLException{
		
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy(){

			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(
						"insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		});
	}
	
	/**
	 * final User를 사용에 외부변수를 내부변수에 전달
	 */
	public void add2(final User user) throws ClassNotFoundException, SQLException{
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy(){
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(
						"insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		});

	}
	
	/**
	 * 익명 내부 클래스
	 */
	public void add3(final User user) throws ClassNotFoundException, SQLException{
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy(){
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(
						"insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		});
	}
	
	/**
	 * 익명 내부 클래스
	 */
	public void add4(final User user) throws ClassNotFoundException, SQLException{
		StatementStrategy st = new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(
						"insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		};
		
	}
	
	/**
	 * 익명 내부 클래스
	 */
	public void add5(final User user) throws ClassNotFoundException, SQLException{
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(
						"insert into users(id, name, password) values(?,?,?)");
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		});
	}

	/*
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select * from users where id = ?");

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		
		User user = null;
		if (rs.next()){
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		ps.close();
		c.close();
		
		if (user == null) throw new EmptyResultDataAccessException(1);

		return user;
	}
	*/

	public void deleteAll() throws SQLException{
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
			
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(
						"delete from users");
				return ps;
			}
		});
		
	}
	
	
	/*
	 * UPDATE/DELETE/INSERT형의 대응만 존재
	public int getCount() throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// JDBC try/catch/finally 코드의 문제점
		// DB연결이 일어날때 마다 반복적으로 발생하므로, 동일처리를 매번 반복해야함.
		try{
			c = dataSource.getConnection();
			ps = c.prepareStatement("select count(*) from users");
			rs = ps.executeQuery();
			return rs.getInt(1);
		}catch(SQLException e){
			throw e;
		}finally {
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException e){
				}
			}
			
			if (c != null){
				try{
					c.close();
				}catch(SQLException e){
				}
			}
		}
	}
	*/
	
	/*
	public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		
		try{
			c = dataSource.getConnection();
			ps = stmt.makePreparedStatement(c);
			ps.executeUpdate();
		}catch(SQLException e){
			throw e;
		}finally {
			if(ps != null) { try{ ps.close(); }catch(SQLException e){} }
			if(c != null) { try{ c.close(); }catch(SQLException e){} }
		}
	}
	*/
}
