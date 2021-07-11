package eni.fr.onlineAuctionSite.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eni.fr.onlineAuctionSite.bll.ArticleManager;
import eni.fr.onlineAuctionSite.bll.BLLException;
import eni.fr.onlineAuctionSite.bo.Article;

/**
 * Servlet implementation class AccueilRechercherParMotCle
 */
@WebServlet("/AccueilRechercherParMotCle")
public class AccueilRechercherParMotCle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Article> articles1 = new ArrayList<Article>();
		
			try {
				 ArticleManager articleManager = new ArticleManager();
				
				 String motCle= request.getParameter("motCle");
				 articles1= articleManager.SelectArticleByMotCle(motCle);
				
				
				 request.setAttribute("Articles", articles1);
					this.getServletContext().getRequestDispatcher("/WEB-INF/FiltrerParMotCle.jsp").forward(request, response);
				
			} catch (BLLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
