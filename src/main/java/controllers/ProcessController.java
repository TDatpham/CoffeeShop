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

import dao.TableDao;
import dao.ThucDonDao;
import model.Cart;
import model.Item;
import model.Table;
import model.ThucDon;

@WebServlet("/ProcessController")
public class ProcessController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int slDetail = Integer.parseInt(req.getParameter("sldetail"));
		
		int idDetail = Integer.parseInt(req.getParameter("iddetail"));
		
		ThucDonDao thucDonDao = new ThucDonDao();
		ThucDon thucDon = thucDonDao.selectThucDon(idDetail);
		Item item = new Item(thucDon, slDetail, thucDon.getDon_gia());
		
		HttpSession sessioncart =   req.getSession();
		Cart cart = new Cart();
		
		if (sessioncart.getAttribute("cart") != null) {
			Object object =  sessioncart.getAttribute("cart");
			cart = (Cart) object;
		}
		

		cart.addItem(item);
		sessioncart.setAttribute("cart", cart);
		

		HttpSession sessionquatity =   req.getSession();
		sessionquatity.setAttribute("quantityofcart", cart.getItems().size());
		
		
		TableDao tableDao = new TableDao();
		HttpSession sessionTable = req.getSession();
		List<Table> tables = tableDao.selectAllTabe();
		sessionTable.setAttribute("dstable", tables);
		
		
		
		RequestDispatcher rq = req.getRequestDispatcher("/HomeService");
		rq.forward(req, resp);;
		
	}
}
