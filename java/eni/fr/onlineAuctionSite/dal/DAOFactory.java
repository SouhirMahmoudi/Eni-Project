/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;



/**
 * @author smahmoudi2021
 *
 */
public class DAOFactory {


	@SuppressWarnings("deprecation")
	public static UtilisateurDAO getDAOUtilisateur() {

		 UtilisateurDAO utilisateurDAO=null;
 		try {
 			utilisateurDAO=(UtilisateurDAO ) Class.forName("eni.fr.onlineAuctionSite.dal.jdbc.UtilisateurDAOImplJdbc").newInstance();
 		} catch (InstantiationException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IllegalAccessException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return utilisateurDAO; 
 	}

 


	  

	    	@SuppressWarnings("deprecation")
			public static ArticleDAO getDAOArticle()  {
	    		ArticleDAO articleDAO=null;
	    		try {
	    			articleDAO=(ArticleDAO ) Class.forName("eni.fr.onlineAuctionSite.dal.jdbc.ArticleDAOImplJdbc").newInstance();
	    		} catch (InstantiationException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (IllegalAccessException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		return articleDAO; 
	    	}

	    
	    
	    @SuppressWarnings("deprecation")
		public static CategorieDAO getDAOCategorie() {

	    	CategorieDAO categorieDAO =null;
    		try {
    			categorieDAO=(CategorieDAO) Class.forName("eni.fr.onlineAuctionSite.dal.jdbc.CategorieDAOImplJdbc").newInstance();
    		} catch (InstantiationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return categorieDAO; 
    	}

  

	    @SuppressWarnings("deprecation")
		public static EnchereDAO getDAOEnchere() {

	    	EnchereDAO enchereDAO=null;
    		try {
    			enchereDAO=(EnchereDAO ) Class.forName("eni.fr.onlineAuctionSite.dal.jdbc.EnchereDAOImplJdbc").newInstance();
    		} catch (InstantiationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return enchereDAO; 
    	}

    

	    @SuppressWarnings("deprecation")
		public static RetraitDAO getDAORetrait() {

	    	RetraitDAO retraitDAO=null;
    		try {
    			retraitDAO=(RetraitDAO) Class.forName("eni.fr.onlineAuctionSite.dal.jdbc.RetraitDAOImplJdbc").newInstance();
    		} catch (InstantiationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return retraitDAO; 
    	}

   
}
