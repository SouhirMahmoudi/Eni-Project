package eni.fr.onlineAuctionSite.dal.jdbc;


import eni.fr.onlineAuctionSite.bo.Categorie;
import eni.fr.onlineAuctionSite.dal.CategorieDAO;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;


public class testCategorieDao {

	public static void main(String[] args) {
		//Déclaration et instanciation de la DAO
		CategorieDAO categorieDao = DAOFactory.getDAOCategorie();
		Categorie cat= new Categorie("Sport&Loisirs");
		Categorie cat1= new Categorie("Ameublement");
		Categorie cat2= new Categorie("Informatique");
				
	      try {
			 categorieDao.insert(cat);
			 categorieDao.insert(cat1);
			 categorieDao.insert(cat2);
			 
			
			

		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}

