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

@WebServlet("/DisplayOther")
public class DisplayOther extends HttpServlet {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		  
		  //clear 
		 
		if(session.getAttribute("session_user") != null)
		{	
		
		
		List<ThucDon> thucDons = new ArrayList<ThucDon>();
		
		ThucDonDao thucDonDao = new ThucDonDao();
		
		thucDons = thucDonDao.getListNotCafeTea();
		
		req.setAttribute("listproduce", thucDons);
		req.setAttribute("ten_loai", "Món khác");
		
		LoaiDao loaiDao = new LoaiDao();
		List<Loai> listloai = new ArrayList<Loai>();
		listloai =  loaiDao.selectCafeAndTea();
		req.setAttribute("listcafetra", listloai);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cafeview.jsp");
		requestDispatcher.forward(req, resp);
		}
		else {
			resp.sendRedirect("loginUser.jsp");
		}
	}
	
	
}
