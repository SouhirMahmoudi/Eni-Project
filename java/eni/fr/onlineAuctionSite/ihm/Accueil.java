package eni.fr.onlineAuctionSite.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eni.fr.onlineAuctionSite.bll.ArticleManager;
import eni.fr.onlineAuctionSite.bll.BLLException;
import eni.fr.onlineAuctionSite.bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Article> articles = new ArrayList<Article>();
		
		try {
			 ArticleManager articleManager = new ArticleManager();
			 articles = articleManager.getListeArticles();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("Articles", articles);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

}
}

