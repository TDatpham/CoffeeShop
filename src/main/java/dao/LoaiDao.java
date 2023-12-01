package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.DataSource;
import model.Loai;


public class LoaiDao extends DataSource{

	private static final String INSERT_LOAI_SQL = "INSERT INTO loai" + "(ten_loai) VALUES" + "(?);";
	private static final String SELECT_LOAI_BY_ID = "select loai_id,ten_loai from loai where loai_id=?";
	private static final String SELECT_ALL_LOAI = "select * from loai";
	private static final String DELETE_LOAI_SQL = "delete from loai where loai_id = ?;";
	private static final String UPDATE_LOAI_SQL = "update loai set ten_loai=?  where loai_id = ?;";
	private static final String SELECT_CAFE_TEA = "select * from loai where ten_loai IN ('Cafe','Tea');";
	private static final String SELECT_LOAI_BY_TEN_LOAI = "SELECT * FROM loai WHERE [ten_loai] =?;";
	
	// select loai bang ten loai
	public Loai getLoaiByTenLoai(String ten_loai) {
		Loai loai =null;
		try(Connection connection = getConnection();
				//Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOAI_BY_TEN_LOAI);) {
			preparedStatement.setString(1,ten_loai);
		
			//Step 3:Execute the query or update query 
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//Step 4: Process the ResultSet object(Xu ly doi tuong ResultSet)
			while (resultSet.next()) {
				
				
				int loai_id = resultSet.getInt("loai_id");
				
				loai = new Loai(loai_id, ten_loai);
				
			}
					
		} catch (SQLException e) {
			// TODO: handle exception
			printSQLException(e);
		}
		
		
		return loai;
	}
	
	// insert loai
		public void insertLoai(Loai loai) {
			try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOAI_SQL);) {
				preparedStatement.setString(1, loai.getTen_loai());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
		}
		// select loai by id
		public Loai selectLoai(int loai_id) {
			Loai loai = null;
			//Step 1: Establishing a Connection(thiet lap ket noi);
			
			try(Connection connection = getConnection();
					//Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOAI_BY_ID);) {
				preparedStatement.setInt(1, loai_id);
				System.out.println(preparedStatement);
				//Step 3:Execute the query or update query 
				ResultSet resultSet = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object(Xu ly doi tuong ResultSet)
				while (resultSet.next()) {
					String  ten_loai= resultSet.getString("ten_loai");
					

					
					loai = new Loai(loai_id, ten_loai);
					
				}
						
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
			return loai;
		}
		
		//select all loai 
		public List<Loai> selectAllLoai(){
			//using try-with-resources to avoid closing resources (boiler palate code)
			// su dung try-with- tai nguyen de tranh dong tai nguyen
			List<Loai> loais = new ArrayList<>();
			//Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					//Step 2: Create a statement using connection object 
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOAI);){
				System.out.println(preparedStatement);
				//Step 3: Execute the query or update query
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object.
				while (resultSet.next()) {
					int loai_id = resultSet.getInt("loai_id");
					String ten_loai = resultSet.getString("ten_loai");

					loais.add(new Loai(loai_id, ten_loai));
					
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
			return loais;
		}
		// update loai 
		public boolean updateLoai(Loai loai) throws SQLException {
			boolean rowUpdated = false;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOAI_SQL);) {
				preparedStatement.setString(1, loai.getTen_loai());

				preparedStatement.setInt(2, loai.getLoai_id());
				
				rowUpdated = preparedStatement.executeUpdate() >  0;
			} 
			return rowUpdated;
		}
		//delete user
		public boolean deleteLoai(int loai_id) throws SQLException {
			boolean rowDelete = false;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOAI_SQL);) {
				preparedStatement.setInt(1, loai_id);
				rowDelete = preparedStatement.executeUpdate() >0;
				
			}
			return rowDelete;
		}
		

		public LoaiDao() { } 
		
		public List<Loai> selectCafeAndTea () {
			List<Loai> listloai = new ArrayList<Loai>();
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement= connection.prepareStatement(SELECT_CAFE_TEA);){
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int loai_id = resultSet.getInt("loai_id");
					String ten_loai = resultSet.getString("ten_loai");
					listloai.add(new Loai(loai_id, ten_loai));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return listloai;
		}
		
		public static void main(String[] args) {
			LoaiDao loaiDao = new LoaiDao();
			
			Loai loai = loaiDao.getLoaiByTenLoai("Đồ ăn");
			if (loai!=null) {
				System.out.println(loai.toString());
			}
			else {
				System.out.println("khong co");
			}
			
		}
	
	
}
