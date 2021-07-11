/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;


import eni.fr.onlineAuctionSite.bo.Retrait;

/**
 * @author smahmoudi2021
 *
 */
public interface RetraitDAO {

	// insérer un nouveau lieu de retrait 
	
	public void insert(Retrait retrait) throws DALException;	
	
	
	// modifier un mlieu de retrait
	
	public void update(Retrait retrait) throws DALException;
	

}
