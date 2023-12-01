package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.DataSource;
import model.Table;

public class TableDao extends DataSource{

	private static final String SELECT_ALL_TABLE = "select * from ban";
	private static final String SELECT_TABLE_BY_ID = "select ban_id,ten_ban,so_luong from ban where ban_id=?";

	
	//select all ban 
			public List<Table> selectAllTabe(){
				//using try-with-resources to avoid closing resources (boiler palate code)
				// su dung try-with- tai nguyen de tranh dong tai nguyen
				List<Table> tables = new ArrayList<>();
				//Step 1: Establishing a Connection
				try (Connection connection = getConnection();
						//Step 2: Create a statement using connection object 
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TABLE);){
					
					//Step 3: Execute the query or update query
					
					ResultSet resultSet = preparedStatement.executeQuery();
					
					//Step 4: Process the ResultSet object.
					while (resultSet.next()) {
						 int ban_id = resultSet.getInt("ban_id");
						 String ten_ban = resultSet.getString("ten_ban");
						 boolean status = resultSet.getBoolean("so_luong");
							
						tables.add(new Table(ban_id, ten_ban, status));
						
					}
					
					
				} catch (SQLException e) {
					// TODO: handle exception
					printSQLException(e);
				}
				return tables;
			}
			
			
			// select ban by id
			public Table selectTalbeById(int ban_id) {
				Table table = null;
				//Step 1: Establishing a Connection(thiet lap ket noi);
				
				try(Connection connection = getConnection();
						//Step 2:Create a statement using connection object
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TABLE_BY_ID);) {
					preparedStatement.setInt(1, ban_id);
					//Step 3:Execute the query or update query 
					ResultSet resultSet = preparedStatement.executeQuery();
					
					//Step 4: Process the ResultSet object(Xu ly doi tuong ResultSet)
					while (resultSet.next()) {
						String  ten_ban = resultSet.getString("ten_loai");
						Boolean status = resultSet.getBoolean("so_luong");

						
						table = new Table(ban_id, ten_ban, status);
						
					}
							
				} catch (SQLException e) {
					// TODO: handle exception
					printSQLException(e);
				}
				return table;
			}	
			
			
			public static void main(String[] args) {
				TableDao tableDao = new TableDao();
				List<Table> tables = tableDao.selectAllTabe();
				for (Table table2 : tables) {
						System.out.println(table2.toString());
				}
				
				
			}
}
