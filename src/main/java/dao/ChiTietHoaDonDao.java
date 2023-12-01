package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.DataSource;
import model.ChiTietHoaDon;

public class ChiTietHoaDonDao extends DataSource {

	private static final String INSERT_CHITIETHOADON_SQL = "INSERT INTO chi_tiet_hoa_don" + "(hoadon_id, thucdon_id, so_luong,don_gia) VALUES" + "(?, ?, ?, ?);";
 
	private static final String SELECT_ALL_CHITIETHOADON = "select * from chi_tiet_hoa_don";
	private static final String SELECT__CHITIETHOADON_BY_ID = "select * from chi_tiet_hoa_don where hoadon_id=?";
	// them chi tiet hoa don;
	
	public void themHoaDonChiTiet(ChiTietHoaDon  chiTietHoaDon) {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHITIETHOADON_SQL);) {
				preparedStatement.setInt(1, chiTietHoaDon.getHoadon_id());
				preparedStatement.setInt(2, chiTietHoaDon.getThucdon_id());
				preparedStatement.setInt(3, chiTietHoaDon.getSo_luong());
				preparedStatement.setFloat(4, chiTietHoaDon.getDon_gia());

				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				printSQLException(e);
			}
		
	}
	
	//sellect all chi tiet hoa don
	public List<ChiTietHoaDon> selectAllChiTietHoaDon (){
		List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CHITIETHOADON);){
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					 int hoadon_id = resultSet.getInt("hoadon_id");
					
					 int thucdon_id= resultSet.getInt("thucdon_id");
					
					 int so_luong = resultSet.getInt("so_luong");
					
					 float don_gia = resultSet.getFloat("don_gia");
					 
					 chiTietHoaDons.add(new ChiTietHoaDon(hoadon_id, thucdon_id, so_luong, don_gia));
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return chiTietHoaDons;
		
	}
	
	//sellect  chi tiet hoa don by id hoa don
		public List<ChiTietHoaDon> selectAllChiTietHoaDonByIdHoaDon (int hoadon_id){
			List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT__CHITIETHOADON_BY_ID);){
					preparedStatement.setInt(1, hoadon_id);
					ResultSet resultSet = preparedStatement.executeQuery();
					
					
					while (resultSet.next()) {
						 
						
						 int thucdon_id= resultSet.getInt("thucdon_id");
						
						 int so_luong = resultSet.getInt("so_luong");
						
						 float don_gia = resultSet.getFloat("don_gia");
						 
						 chiTietHoaDons.add(new ChiTietHoaDon(hoadon_id, thucdon_id, so_luong, don_gia));
					}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return chiTietHoaDons;
			
		}
	
	public static void main(String[] args) {
		ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDao.selectAllChiTietHoaDonByIdHoaDon(1);
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
			System.out.println(chiTietHoaDon.toString());
				
		}
	}
}
