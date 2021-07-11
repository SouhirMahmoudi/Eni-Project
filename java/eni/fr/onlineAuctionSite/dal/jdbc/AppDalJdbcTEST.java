package eni.fr.onlineAuctionSite.dal.jdbc;



import java.util.List;

import eni.fr.onlineAuctionSite.bll.ArticleManager;
import eni.fr.onlineAuctionSite.bll.BLLException;
import eni.fr.onlineAuctionSite.bll.CategorieManager;
import eni.fr.onlineAuctionSite.bo.Article;


import eni.fr.onlineAuctionSite.dal.ArticleDAO;
import eni.fr.onlineAuctionSite.dal.CategorieDAO;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;
import eni.fr.onlineAuctionSite.dal.EnchereDAO;
import eni.fr.onlineAuctionSite.dal.RetraitDAO;
import eni.fr.onlineAuctionSite.dal.UtilisateurDAO;


public class AppDalJdbcTEST {

	public static void main(String[] args) throws DALException, BLLException {
		       

		
		//Déclaration et instanciation de la DAO
	
		CategorieDAO categoriDao = DAOFactory.getDAOCategorie();
		ArticleDAO articleDAO = DAOFactory.getDAOArticle();
        RetraitDAO retraitDao = DAOFactory.getDAORetrait();
        UtilisateurDAO utilisateurDao = DAOFactory.getDAOUtilisateur();
        EnchereDAO EnchereDao = DAOFactory.getDAOEnchere();

      
//recuperer une liste d'articles par libelle
        List<Article> articles1 = null;
        try {
       
			articles1 = articleDAO.selectByNoCategorie(1);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sélection de tous les articles  : " + articles1.toString() );

		//recuperer une liste d'articles par motcle
        List<Article> articles2= null;
        try {
       String motcle="fille";
			articles2 = articleDAO.selectByMotCle(motcle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sélection de tous les articles  : " + articles2.toString() );

        
        
        
			//Sélection de tous les articles
			//TODO...
			List<Article> articles = null;
			try {
				articles = articleDAO.selectAll();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Sélection de tous les articles  : " + articles.toString() );

			
			
			ArticleManager articleManager = null;
			articleManager = new ArticleManager();

 CategorieManager categorieManager;

			categorieManager = new CategorieManager();

 String categorie ="Ameublement";
 if ("Ameublement".equals(categorie))
 {
				int noCategorie1 = categorieManager.SelectNoCategorieByLibelle("Ameublement");
			
				
			articles1= articleManager.SelectArticleByNoCategorie(noCategorie1);
			System.out.println("Sélection de tous les articles  : " + articles1.toString() );

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

	}
}
	
	
			//Modification d'un article
			//TODO...
			/*System.out.println("Modification d'un article  : " );
			System.out.println("Article avant modification : "  + a1.toString());
			((Article) a1).setDescription("modification reussi");
			((Article) a1).setNomArticle("modification reussi");
			((Article) a1).setPrixVente(500);
			articleDAO.update(a1);
			System.out.println("Article après modification  : " + a1.toString() );
			
			
			//Suppression d'un article
			//TODO...
			System.out.println("Suppression de l'article  : " + a1.toString());
			articleDAO.delete(a1.getNoArticle());
			articles = articleDAO.selectAll();
			//System.out.println("Liste des articles après suppression : " + articles.toString() );
			System.out.println("Liste des articles après suppression : "  );
			StringBuffer sb = new StringBuffer();
				sb.append(a1.getNoArticle());
				sb.append(", ref=");
				sb.append(a1.getNomArticle()).append("]\n");
			
			System.out.println(sb.toString());
			System.out.println("---------------------------------------------------------------");

		} catch (DALException e) {
			e.printStackTrace();
		}*/






		
		
		
		
