package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import model.Cart;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.Item;
import model.Table;
import model.User;

@WebServlet("/BuyController")
public class BuyController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessionlg = req.getSession();
		  
		  //clear 
		 
		if(sessionlg.getAttribute("session_user") == null)
		{
			resp.sendRedirect("loginUser.jsp");
		}
		else {
			
		
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		
		String buyer_name= req.getParameter("buyer_name");
		String buyer_number= req.getParameter("buyer_number");
		
		int ban_id = Integer.parseInt(req.getParameter("ban_id"));
		
		System.out.println(buyer_name);
		System.out.println(buyer_number);
		System.out.println(ban_id);
		
		// lay id user
		HttpSession sessionlogin = req.getSession();
		
		Object o = sessionlogin.getAttribute("session_user");
		User us = (User) o;
		int userId =  us.getUser_id(); // lay id user
		//---------------------------------------
		
		//lay gio hang
		HttpSession session = req.getSession();
	
		Object object = session.getAttribute("cart");
		
		Cart cart = (Cart) object;
		//-----------------------------------------------
		

		//lay thoi gian
		LocalDate today = LocalDate.now();
		String date = today.toString();
		System.out.println(today);
		HoaDonDao hoaDonDao = new HoaDonDao();
		HoaDon hoaDon = new HoaDon(ban_id, cart.getTotalMoney(), userId, date, date, buyer_name, buyer_number);
		// them vao hoadon database
		hoaDonDao.themHoaDon(hoaDon);
		
		
		int hoadon_id = hoaDonDao.getNewIdHoaDon(); 
		ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
		ChiTietHoaDon chiTietHoaDon;
		for (Item item : cart.getItems()) {
			chiTietHoaDon = new ChiTietHoaDon(hoadon_id, item.getThucdon().getThucdon_id(), item.getQuantity(), item.getPrice());
			chiTietHoaDonDao.themHoaDonChiTiet(chiTietHoaDon);
				// them vao chi tiet hoa don database
		}
		
		
		// chinh sua trang thai cua bang

		HttpSession sessionTable = req.getSession();
		Object obtable = sessionTable.getAttribute("dstable");
		
	
		@SuppressWarnings("unchecked")
		List<Table> tables = (List<Table>) obtable;
		for (Table table : tables) {
			if (table.getBan_id() ==ban_id) {
				table.setStatus(false);
				break;
			}
		}
		
		
		sessionTable.setAttribute("dstable", tables);
		
		
		// huy session cart va quantity
		HttpSession sessionquatity =   req.getSession();
		sessionquatity.removeAttribute("quantityofcart");
		session.removeAttribute("cart");
		
		resp.sendRedirect(req.getContextPath()+"/HomeService");
		}
	}
	
	
}
