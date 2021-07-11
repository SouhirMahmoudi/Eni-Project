package eni.fr.onlineAuctionSite.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eni.fr.onlineAuctionSite.bll.ArticleManager;
import eni.fr.onlineAuctionSite.bll.BLLException;
import eni.fr.onlineAuctionSite.bll.CategorieManager;
import eni.fr.onlineAuctionSite.bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AccueilRechercherParCategorie")
public class AccueilRechercherParCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
         List<Article> articles = new ArrayList<Article>();
		
		try {
			 ArticleManager articleManager = new ArticleManager();
			 CategorieManager categorieManager = new CategorieManager();
			 String categorie = request.getParameter("categorie");
			 if ("Ameublement".equals(categorie))
			 {
				int noCategorie1 = categorieManager.SelectNoCategorieByLibelle("Ameublement");
				articles= articleManager.SelectArticleByNoCategorie(noCategorie1);
			 }
			
			 
			 else if  ("SportLoisirs".equals(categorie))
			 {
				 int noCategorie2 = categorieManager.SelectNoCategorieByLibelle("SportLoisirs");
				 articles= articleManager.SelectArticleByNoCategorie(noCategorie2);
			 }
			 
			 
			 else if  ("Informatique".equals(categorie))
			 {
				 int noCategorie3 = categorieManager.SelectNoCategorieByLibelle("Informatique");
					articles= articleManager.SelectArticleByNoCategorie(noCategorie3);
			 }
			 
			 else if  ("vetement".equals(categorie))
			 {
				 int noCategorie4 = categorieManager.SelectNoCategorieByLibelle("vetement");
					articles= articleManager.SelectArticleByNoCategorie(noCategorie4);
			 }
			 
			 else 
			 {
				 articles = articleManager.getListeArticles();
			 }
			 
			 request.setAttribute("Articles", articles);
				this.getServletContext().getRequestDispatcher("/WEB-INF/FiltrerCategorie.jsp").forward(request, response);
			
		} catch (BLLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
		
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     

		doGet(request, response);
	}
	}
