/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;

import java.util.List;

import eni.fr.onlineAuctionSite.bo.Categorie;

/**
 * @author smahmoudi2021
 *
 */
public interface CategorieDAO {
	
	//Sélectionner tous les categories 
	public List<Categorie> selectAll() throws DALException;
	
	//Sélectionner id de catégorie par libelle
	public  int selectNoCategorie (String libelle) throws DALException;
			

	
	//Insérer une nouvelle categorie
	public void insert(Categorie categorie ) throws DALException;
	
	//Supprimer une categorie
	public void delete(int id) throws DALException;
	
	
}
