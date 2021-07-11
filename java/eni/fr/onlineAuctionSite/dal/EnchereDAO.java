/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;

import java.util.List;

import eni.fr.onlineAuctionSite.bo.Enchere;

/**
 * @author smahmoudi2021
 *
 */
public interface EnchereDAO {
	
	

	//Sélectionner une liste d'encheres  pour un article par son noArticle
	public List<Enchere> selectByNoArticle(int noArticle) throws DALException;
			
	

	
	
	
	
}
