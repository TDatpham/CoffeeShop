package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.DataSource;
import model.Loai;
import model.ThucDon;


public class ThucDonDao extends DataSource{

	
	
	private static final String INSERT_THUCDON_SQL = "INSERT INTO thuc_don" + "(ten_mon,images,don_gia,loai_id) VALUES" + "(?, ?, ?, ?);";
	private static final String SELECT_THUCDON_BY_ID = "select ten_mon,images,don_gia,loai_id from thuc_don where thucdon_id=?";
	private static final String SELECT_ALL_THUCDON = "select * from thuc_don";
	private static final String DELETE_THUCDON_SQL = "delete from thuc_don where thucdon_id = ?;";
	private static final String UPDATE_THUCDON_SQL = "update thuc_don set ten_mon = ?,images = ?,don_gia = ?,loai_id=?  where thucdon_id = ?;";
	private static final String SELECT_THUCDON_BY_LOAI_ID = "select * from thuc_don where loai_id=?";
	private static final String SELECT_THUCDON_NOT_CAFE_TEA = "select * from thuc_don where loai_id NOT IN (?, ?);";
	private static final String SELECT_NEW_THUCDON = " SELECT top (?) * FROM thuc_don ORDER BY thucdon_id desc;";
	private static final String SELECT_THUCDON_BY_TEN_MON = "SELECT * FROM thuc_don WHERE ten_mon LIKE ?;";
	private static final String CHECK_THUCDON_BY_TEN_MON = "SELECT * FROM thuc_don where ten_mon =?;";
	
	// LAY RA THUC DON BANG TEN MON
	
	public ThucDon getThucDonByTenMon(String ten_mon) {
		ThucDon thucDon = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(CHECK_THUCDON_BY_TEN_MON);){
			
			preparedStatement.setString(1, ten_mon);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int thucdon_id = resultSet.getInt("thucdon_id");
				
				String images  = resultSet.getString("images");
				float don_gia = resultSet.getFloat("don_gia");
				int loai_id = resultSet.getInt("loai_id");
				thucDon = new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return thucDon;
	}
	
	// LAY DANH sach mon theo ten da tim kiem
	
	public List<ThucDon> searchThucDons(String foodName){
		List<ThucDon> thucDons = new ArrayList<>();
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THUCDON_BY_TEN_MON);){
			preparedStatement.setString(1, "%"+foodName+"%");
			System.out.println(preparedStatement);
			System.out.println("co chay qua day");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int thucdon_id = resultSet.getInt("thucdon_id");
				String ten_mon  = resultSet.getString("ten_mon");
				String images  = resultSet.getString("images");
				float don_gia = resultSet.getFloat("don_gia");
				int loai_id = resultSet.getInt("loai_id");
				thucDons.add(new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return thucDons;
	}
	
	
	// lay danh sach cafe
	
	
	
	public List<ThucDon> getNewThucDons (int quatity)
	{
		

		List<ThucDon> thucDons = new ArrayList<ThucDon>();
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEW_THUCDON);) {
				preparedStatement.setInt(1, quatity);
		
			ResultSet resultSet= preparedStatement.executeQuery();
			while (resultSet.next()) {
				int thucdon_id = resultSet.getInt("thucdon_id");
				String ten_mon = resultSet.getString("ten_mon");
				
				String images = resultSet.getString("images");
				
				float don_gia = resultSet.getFloat("don_gia");
				int loai_id = resultSet.getInt("loai_id");
 				thucDons.add(new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thucDons;
	}
	
	
	//
	public List<ThucDon> getListNotCafeTea ()
	{
		LoaiDao loaiDao = new LoaiDao();
		List<Loai> listloai = new ArrayList<Loai>();
		
		listloai = loaiDao.selectCafeAndTea();
		int[] tenloai = new int[listloai.size()];
		
		for (int i = 0; i < listloai.size() ; i++) {
			 tenloai[i] = listloai.get(i).getLoai_id();
			 
		}
		
		List<ThucDon> thucDons = new ArrayList<ThucDon>();
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THUCDON_NOT_CAFE_TEA);) {
				preparedStatement.setInt(1, tenloai[0]);
				preparedStatement.setInt(2, tenloai[1]);
			ResultSet resultSet= preparedStatement.executeQuery();
			while (resultSet.next()) {
				int thucdon_id = resultSet.getInt("thucdon_id");
				String ten_mon = resultSet.getString("ten_mon");
				
				String images = resultSet.getString("images");
				
				float don_gia = resultSet.getFloat("don_gia");
				int loai_id = resultSet.getInt("loai_id");
 				thucDons.add(new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thucDons;
	}
	
	
	
	public List<ThucDon> getListByLoaiId (int loai_id)
	{
		List<ThucDon> thucDons = new ArrayList<ThucDon>();
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THUCDON_BY_LOAI_ID);) {
			preparedStatement.setInt(1, loai_id);
			ResultSet resultSet= preparedStatement.executeQuery();
			while (resultSet.next()) {
				int thucdon_id = resultSet.getInt("thucdon_id");
				String ten_mon = resultSet.getString("ten_mon");
				
				String images = resultSet.getString("images");
				
				float don_gia = resultSet.getFloat("don_gia");
				
				thucDons.add(new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thucDons;
	}
	
	// insert thucdon
		public void insertThucDon(ThucDon thucDon) {
			
			try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THUCDON_SQL);) {
				preparedStatement.setString(1, thucDon.getTen_mon());
				preparedStatement.setString(2, thucDon.getImages());
				preparedStatement.setFloat(3, thucDon.getDon_gia());
				preparedStatement.setInt(4, thucDon.getLoai_id());
				
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
		}
		// select thucdon by id
		public ThucDon selectThucDon(int thucdon_id) {
			ThucDon thucDon = null;
			//Step 1: Establishing a Connection(thiet lap ket noi);
			
			try(Connection connection = getConnection();
					//Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THUCDON_BY_ID);) {
				preparedStatement.setInt(1, thucdon_id);
			
				//Step 3:Execute the query or update query 
				ResultSet resultSet = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object(Xu ly doi tuong ResultSet)
				while (resultSet.next()) {
					String ten_mon = resultSet.getString("ten_mon");
					
					String images = resultSet.getString("images");
					
					float don_gia = resultSet.getFloat("don_gia");
					
					int loai_id = resultSet.getInt("loai_id");
					
					thucDon = new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id);
					
				}
						
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
			return thucDon;
		}
		
		//select all thucdon 
		public List<ThucDon> selectAllThucDon(){
			//using try-with-resources to avoid closing resources (boiler palate code)
			// su dung try-with- tai nguyen de tranh dong tai nguyen
			List<ThucDon> thucDons = new ArrayList<>();
			//Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					//Step 2: Create a statement using connection object 
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THUCDON);){
			
				//Step 3: Execute the query or update query
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object.
				while (resultSet.next()) {
					int thucdon_id = resultSet.getInt("thucdon_id");
					String ten_mon  = resultSet.getString("ten_mon");
					String images  = resultSet.getString("images");
					float don_gia = resultSet.getFloat("don_gia");
					int loai_id = resultSet.getInt("loai_id");
					thucDons.add(new ThucDon(thucdon_id, ten_mon, images, don_gia, loai_id));
					
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
			return thucDons;
		}
		// update thucdon
		public boolean updateThucDon(ThucDon thucDon) throws SQLException {
			boolean rowUpdated = false;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_THUCDON_SQL);) {
				preparedStatement.setString(1, thucDon.getTen_mon());
				preparedStatement.setString(2, thucDon.getImages());
				preparedStatement.setFloat(3, thucDon.getDon_gia());
				preparedStatement.setInt(4, thucDon.getLoai_id());
				preparedStatement.setInt(5, thucDon.getThucdon_id());
				
				rowUpdated = preparedStatement.executeUpdate() >  0;
			} 
			return rowUpdated;
		}
		//delete thucdon
		public boolean deleteThucDon(int thucdon_id) throws SQLException {
			boolean rowDelete = false;
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(DELETE_THUCDON_SQL);) {
				preparedStatement.setInt(1, thucdon_id);
				rowDelete = preparedStatement.executeUpdate() >0;
				
			}
			return rowDelete;
		}
	
		
		
		
		
		
		

	
	
	
	
	
	
	
	
}
