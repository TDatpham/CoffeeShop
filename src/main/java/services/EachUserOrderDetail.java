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
import model.ChiTietHoaDon;

@WebServlet("/EachUserOrderDetail")
public class EachUserOrderDetail extends HttpServlet {

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
		
		int hoadon_id = Integer.parseInt(req.getParameter("hoadon_id"));
		ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDao.selectAllChiTietHoaDonByIdHoaDon(hoadon_id);
		req.setAttribute("chitiethoadon_admin", chiTietHoaDons);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminOrderDetail.jsp");
		requestDispatcher.forward(req, resp);
		}
	}
}
