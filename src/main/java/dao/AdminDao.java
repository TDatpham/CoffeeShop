package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import configs.DataSource;


public class AdminDao extends DataSource{

	private static final String SELECT_ADMIN_BY_TK_MK = "select * from admins where tk=? and mk=?;";
	public AdminDao() 
	{
		
	}
	
	public boolean checkAdmin(String tk, String mk) 
	{
		//Step 1: Establishing a Connection(thiet lap ket noi);
		boolean isAdmin = false;
		try(Connection connection = getConnection();
				//Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_TK_MK);) {
			preparedStatement.setString(1, tk);
			preparedStatement.setString(2, mk);
			System.out.println(preparedStatement);
			//Step 3:Execute the query or update query 
			 ResultSet resultSet = preparedStatement.executeQuery();
			
			try {
				if (resultSet.next()) 
				{
					isAdmin = true;						
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return isAdmin;
	}
	
}