package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.LoaiDao;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.Loai;
import model.User;
@WebServlet("/NewOrder")
public class NewOrder extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionuser = req.getSession();
		
		Object object = sessionuser.getAttribute("session_user");
		if(object != null)
		{
		User user = (User) object;
		int user_id = user.getUser_id();
		// lay tat ca danh danh hoa don theo id user
			HoaDonDao hoaDonDao = new HoaDonDao();
			HoaDon hoaDon = hoaDonDao.getNewHoaDonById(user_id);
			
			
			// lay tat ca danh sach chi tiet hoa don
			if(hoaDon != null) {
				ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
				List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDao.selectAllChiTietHoaDonByIdHoaDon(hoaDon.getHoadon_id());
			
				req.setAttribute("hoadon1", hoaDon);
				req.setAttribute("dschitiethoadon", chiTietHoaDons);
			
			}
			
			
			/// set atribute ds hoa don va ds chi tiet hoa don
			

			
			
			/// hien thi button cafe va tra
			LoaiDao loaiDao = new LoaiDao();
			List<Loai> listloai = new ArrayList<Loai>();
			listloai =  loaiDao.selectCafeAndTea();
			req.setAttribute("listcafetra", listloai);
			
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newOrder.jsp");
		requestDispatcher.forward(req, resp);
		}
		else {
			resp.sendRedirect("loginUser.jsp");
		}
	}
}
