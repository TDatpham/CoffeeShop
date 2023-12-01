package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

@WebServlet("/AddAndRemove")
public class AddAndRemove extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sessionuser = req.getSession();
		  
		  //clear 
		 
		if(sessionuser.getAttribute("session_user") != null)
		{	
		
		int num = Integer.parseInt(req.getParameter("num"));
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		Object object= session.getAttribute("cart");
		Cart cart = (Cart) object;
		int sl = cart.getItemById(id).getQuantity();
		switch (num) {
		case 1:
			
			cart.getItemById(id).setQuantity(sl+num);
			break;
		case 0:
			cart.removeItem(id);
			break;
		default:
		
			if(sl ==1 ) {
				cart.removeItem(id);
				break;
			}
			cart.getItemById(id).setQuantity(sl - 1);
			break;
		}
		
		session.setAttribute("cart", cart);
		
		HttpSession sessionquatity =   req.getSession();
		if(cart.getItems().size() == 0) {
			sessionquatity.removeAttribute("quantityofcart");
		}
		else {
			sessionquatity.setAttribute("quantityofcart", cart.getItems().size());

		}
		
		resp.sendRedirect("cart.jsp");
		}
		else {
			resp.sendRedirect("loginUser.jsp");
		}
	}
}
