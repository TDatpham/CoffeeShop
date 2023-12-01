package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.DataSource;
import model.HoaDon;

public class HoaDonDao  extends DataSource {

	private static final String INSERT_HOADON_SQL = "INSERT INTO hoa_don" + "(ban_id,thanh_tien,user_id,create_at,update_at ,ten_nguoi_mua ,so_dien_thoai) VALUES" + "(?, ?, ?, ?, ?, ?, ?);";
 
	private static final String SELECT_NEW_HOADON = " SELECT top (1) hoadon_id FROM hoa_don ORDER BY hoadon_id desc;";
	private static final String SELECT_HOADON_BY_USER_ID = "select * from hoa_don where [user_id]=? order by hoadon_id desc";
	private static final String SELECT_ALL_HOADON = "select * from hoa_don";
	private static final String SELECT_NEW_HOADON_BY_USER_ID = "select top(1) * from hoa_don where [user_id]=? order by hoadon_id desc;";
	// lay hoa don moi nhatbang id user 
	
		public HoaDon getNewHoaDonById(int user_id){
			HoaDon hoaDon = null;
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement= connection.prepareStatement(SELECT_NEW_HOADON_BY_USER_ID);){
					preparedStatement.setInt(1, user_id);
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						 int hoadon_id = resultSet.getInt("hoadon_id");
						 int ban_id =resultSet.getInt("ban_id");
						 float thanh_tien = resultSet.getFloat("thanh_tien");
					
						 String create_at = resultSet.getString("create_at");
						 String create_update = resultSet.getString("update_at");
						 String ten_nguoi_mua = resultSet.getString("ten_nguoi_mua");
						 String so_dien_thoai = resultSet.getString("so_dien_thoai");
						hoaDon = new HoaDon(hoadon_id, ban_id, thanh_tien, user_id, create_at, create_update, ten_nguoi_mua, so_dien_thoai);
					}
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
			
			return hoaDon;
		}
	
	// lay hoa don bang id user
	
	public List<HoaDon> getHoaDonById(int user_id){
		List<HoaDon> hoaDons = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(SELECT_HOADON_BY_USER_ID);){
				preparedStatement.setInt(1, user_id);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					 int hoadon_id = resultSet.getInt("hoadon_id");
					 int ban_id =resultSet.getInt("ban_id");
					 float thanh_tien = resultSet.getFloat("thanh_tien");
				
					 String create_at = resultSet.getString("create_at");
					 String create_update = resultSet.getString("update_at");
					 String ten_nguoi_mua = resultSet.getString("ten_nguoi_mua");
					 String so_dien_thoai = resultSet.getString("so_dien_thoai");
					hoaDons.add(new HoaDon(hoadon_id, ban_id, thanh_tien, user_id, create_at, create_update, ten_nguoi_mua, so_dien_thoai));
				}
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		
		return hoaDons;
	}
	
	
	// them hoa don;
	
	public void themHoaDon(HoaDon hoaDon) {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOADON_SQL);) {
				preparedStatement.setInt(1, hoaDon.getBan_id());
				preparedStatement.setFloat(2, hoaDon.getThanh_tien());
				preparedStatement.setInt(3, hoaDon.getUser_id());
				preparedStatement.setString(4, hoaDon.getCreate_at());
				preparedStatement.setString(5, hoaDon.getCreate_update());
				preparedStatement.setString(6, hoaDon.getTen_nguoi_mua());
				preparedStatement.setString(7, hoaDon.getSo_dien_thoai());
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
		
	}
		
	
	// lay hoadon_id moi
	public int getNewIdHoaDon ()
	{
		

		int id = 0;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEW_HOADON);) {
				
		
			ResultSet resultSet= preparedStatement.executeQuery();
			while (resultSet.next()) {
				int hoadon_id = resultSet.getInt("hoadon_id");
				
 				id = hoadon_id;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return id;
	}
	
	
	
	//select all hoadon 
			public List<HoaDon> selectAllHoaDon(){
				//using try-with-resources to avoid closing resources (boiler palate code)
				// su dung try-with- tai nguyen de tranh dong tai nguyen
				List<HoaDon> hoaDons = new ArrayList<>();
				//Step 1: Establishing a Connection
				try (Connection connection = getConnection();
						//Step 2: Create a statement using connection object 
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOADON);){
				
					//Step 3: Execute the query or update query
					
					ResultSet resultSet = preparedStatement.executeQuery();
					
					//Step 4: Process the ResultSet object.
					while (resultSet.next()) {
						 int hoadon_id = resultSet.getInt("hoadon_id");
						 int ban_id =resultSet.getInt("ban_id");
						 float thanh_tien = resultSet.getFloat("thanh_tien");
						 int user_id = resultSet.getInt("user_id");
						 String create_at = resultSet.getString("create_at");
						 String create_update = resultSet.getString("update_at");
						 String ten_nguoi_mua = resultSet.getString("ten_nguoi_mua");
						 String so_dien_thoai = resultSet.getString("so_dien_thoai");
						hoaDons.add(new HoaDon(hoadon_id, ban_id, thanh_tien, user_id, create_at, create_update, ten_nguoi_mua, so_dien_thoai));
					}
					
					
				} catch (SQLException e) {
					// TODO: handle exception
					printSQLException(e);
				}
				return hoaDons;
			}
			
			
			public static void main(String[] args) {
				HoaDonDao hoaDonDao = new HoaDonDao();
				
				HoaDon hoaDon = hoaDonDao.getNewHoaDonById(1);
				
						System.out.println(hoaDon.toString());
			}

}
