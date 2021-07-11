package eni.fr.onlineAuctionSite.dal.jdbc;

import eni.fr.onlineAuctionSite.bo.Article;
import eni.fr.onlineAuctionSite.bo.Retrait;
import eni.fr.onlineAuctionSite.dal.ArticleDAO;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;
import eni.fr.onlineAuctionSite.dal.RetraitDAO;

public class testEnchereDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        RetraitDAO retraitDao = DAOFactory.getDAORetrait();
        ArticleDAO articleDAO = DAOFactory.getDAOArticle();
		Retrait r = new Retrait("25","rue albert","92500");
		try {
			
             Article a = articleDAO.selectByNoArticle(4);
             r.setArticle(a);
			retraitDao.insert(r);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
