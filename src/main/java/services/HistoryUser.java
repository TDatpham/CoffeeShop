package services;

import java.io.IOException;
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
import model.ChiTietHoaDon;
import model.HoaDon;

@WebServlet("/HistoryUser")
public class HistoryUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (session.getAttribute("session_name") == null) {
			resp.sendRedirect("login.jsp");
		}
		else {
			
		
		// TODO Auto-generated method stub
		
		
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		// lay tat ca danh danh hoa don theo id user
		HoaDonDao hoaDonDao = new HoaDonDao();
		List<HoaDon> hoaDons = hoaDonDao.getHoaDonById(user_id);
		
		
		// lay tat ca danh sach chi tiet hoa don
		
		ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDao.selectAllChiTietHoaDon();
		
		/// set atribute ds hoa don va ds chi tiet hoa don
		
		req.setAttribute("dshoadon", hoaDons);
		req.setAttribute("dschitiethoadon", chiTietHoaDons);
		
		
		// hien thi button cafe va tra
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/historyUser.jsp");
		requestDispatcher.forward(req, resp);
		}
	}
}
