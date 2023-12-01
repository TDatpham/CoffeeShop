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

import dao.LoaiDao;
import dao.ThucDonDao;
import model.Loai;
import model.ThucDon;

@WebServlet("/SearchService")
public class SearchService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		  
		  //clear 
		 
		if(session.getAttribute("session_user") == null)
		{
			resp.sendRedirect("loginUser.jsp");
		}
		else {
			
		
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// TODO Auto-generated method stub
		String foodName = req.getParameter("txtSearch");
		ThucDonDao thucDonDao = new ThucDonDao();
		List<ThucDon> thucDons = thucDonDao.searchThucDons(foodName);
		
		req.setAttribute("listproduce", thucDons);
		req.setAttribute("save_search", foodName);
		
		LoaiDao loaiDao = new LoaiDao();
		List<Loai> listloai = new ArrayList<Loai>();
		listloai =  loaiDao.selectCafeAndTea();
		req.setAttribute("listcafetra", listloai);
		
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cafeview.jsp");
		requestDispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
