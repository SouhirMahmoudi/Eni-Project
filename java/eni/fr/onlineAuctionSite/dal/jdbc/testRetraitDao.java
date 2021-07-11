package eni.fr.onlineAuctionSite.dal.jdbc;


import eni.fr.onlineAuctionSite.bo.Retrait;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;
import eni.fr.onlineAuctionSite.dal.RetraitDAO;

public class testRetraitDao {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        RetraitDAO retraitDao = DAOFactory.getDAORetrait();
	        /*try {
				Article art1 = articleDAO.selectByNoArticle(6);
				Retrait r = new Retrait("25","rue albert","92500", art1);
				   Article a = articleDAO.selectByNoArticle(6);
		             r.setArticle(a);
					retraitDao.insert(r);
			} catch (DALException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
   Retrait r1 = new Retrait("25","rue albert","75017",6);
   Retrait r2 = new Retrait("25","rue albert","75017",7);
   Retrait r3 = new Retrait("25","rue albert","75017",8);
   Retrait r4 = new Retrait("25","rue albert","75017",9);
   Retrait r5 = new Retrait("28","rue Achille","75013",10);
   Retrait r6 = new Retrait("28","rue Achille","75013",11);
   Retrait r7 = new Retrait("28","rue Achille","75013",12);
   Retrait r8 = new Retrait("28","rue Achille","75013",13);
   
   try {
	retraitDao.insert(r1);
	
	retraitDao.insert(r2);

	retraitDao.insert(r3);

	retraitDao.insert(r4);

	retraitDao.insert(r5);

	retraitDao.insert(r6);

	retraitDao.insert(r7);

	retraitDao.insert(r8);

	
} catch (DALException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}





		}}
			
			
