package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.*;
import model.*;

//kết nối xử lý database
public class UserDao extends DataSource{
	
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(user_name,pass_word,ten_nguoi_dung,sdt) VALUES" + "(?, ?, ?, ?);";
	private static final String SELECT_USERS_BY_ID = "select user_id,user_name,pass_word,ten_nguoi_dung,sdt from users where user_id=?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where user_id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set user_name = ?,pass_word = ?,ten_nguoi_dung = ?,sdt=?  where user_id = ?;";
	private static final String SELECT_USER_BY_TK_MK = "select * from users where user_name=? and pass_word=?;";
	private static final String SELECT_USER_BY_USER_NAME= "SELECT * FROM users WHERE [user_name] = ?;";
	
	// lay ra tai khoan cua user
	public User getUserByUserName(String user_name) {
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USER_NAME);){
				preparedStatement.setString(1, user_name);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					 int user_id = resultSet.getInt("user_id");
					
					 String pass_word = resultSet.getString("pass_word");
					 String ten_nguoi_dung = resultSet.getString("ten_nguoi_dung");
					 String sdt= resultSet.getString("sdt");
					 user = new User(user_id, user_name, pass_word, ten_nguoi_dung, sdt);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
	
	//kiem tra user password;
	public User checkUser(String username, String pass) {
		
		User user = null;
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement= connection.prepareStatement(SELECT_USER_BY_TK_MK);){
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, pass);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					 int user_id = resultSet.getInt("user_id");

					 String ten_nguoi_dung = resultSet.getString("ten_nguoi_dung");
					 String sdt=resultSet.getString("sdt");
					 
					 user = new User(user_id, username, pass, ten_nguoi_dung, sdt);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return user;
	}
	
	
	// insert user
		public void insertUser(User user) {
			System.out.println(INSERT_USERS_SQL);
			try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
				preparedStatement.setString(1, user.getUser_name());
				preparedStatement.setString(2, user.getPass_word());
				preparedStatement.setString(3, user.getTen_nguoi_dung());
				preparedStatement.setString(4, user.getSdt());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
		}
		// select user by id
		public User selectUser(int id) {
			User user = null;
			//Step 1: Establishing a Connection(thiet lap ket noi);
			
			try(Connection connection = getConnection();
					//Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				//Step 3:Execute the query or update query 
				ResultSet resultSet = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object(Xu ly doi tuong ResultSet)
				while (resultSet.next()) {
					String usernameString = resultSet.getString("user_name");
					
					String passString = resultSet.getString("pass_word");
					
					String tenString = resultSet.getString("ten_nguoi_dung");
					
					String sdtString = resultSet.getString("sdt");
					
					user = new User(id, usernameString, passString, tenString, sdtString);
					
				}
						
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
			return user;
		}
		
		//select all users 
		public List<User> selectAllUsers(){
			//using try-with-resources to avoid closing resources (boiler palate code)
			// su dung try-with- tai nguyen de tranh dong tai nguyen
			List<User> users = new ArrayList<>();
			//Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					//Step 2: Create a statement using connection object 
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
				System.out.println(preparedStatement);
				//Step 3: Execute the query or update query
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object.
				while (resultSet.next()) {
					int id = resultSet.getInt("user_id");
					String usernameString = resultSet.getString("user_name");
					String passString = resultSet.getString("pass_word");
					String tenString = resultSet.getString("ten_nguoi_dung");
					String sdtString = resultSet.getString("sdt");
					users.add(new User(id, usernameString, passString, tenString,sdtString));
					
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
			return users;
		}
		// update user 
		public boolean updateUser(User user) throws SQLException {
			boolean rowUpdated = false;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
				preparedStatement.setString(1, user.getUser_name());
				preparedStatement.setString(2, user.getPass_word());
				preparedStatement.setString(3, user.getTen_nguoi_dung());
				preparedStatement.setString(4, user.getSdt());
				preparedStatement.setInt(5, user.getUser_id());
				
				rowUpdated = preparedStatement.executeUpdate() >  0;
			} 
			return rowUpdated;
		}
		//delete user
		public boolean deleteUser(int id) throws SQLException {
			boolean rowDelete = false;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
				preparedStatement.setInt(1, id);
				rowDelete = preparedStatement.executeUpdate() >0;
				
			}
			return rowDelete;
		}
		
		
		
		public static void main(String[] args) {
			UserDao userDao = new UserDao();
			User user = userDao.getUserByUserName("nhanpt1792003@gmail.com");
			if (user !=null) {
				System.out.println(user.toString());
			}
			else {
				System.out.println("khong co");
			}
			
		}
		
		

}
