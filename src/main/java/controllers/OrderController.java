package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HoaDonDao;
import model.HoaDon;


@WebServlet("/OrderController")
public class OrderController extends HttpServlet {

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
		HoaDonDao hoaDonDao = new HoaDonDao();
		List<HoaDon>hoaDons = hoaDonDao.selectAllHoaDon();
		
		req.setAttribute("danhsach_hd", hoaDons);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Orderadmin.jsp");
		requestDispatcher.forward(req, resp);
		}
		
	}
	
	
}
