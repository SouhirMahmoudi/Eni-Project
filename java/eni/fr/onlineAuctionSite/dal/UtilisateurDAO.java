/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;


import java.util.List;

import eni.fr.onlineAuctionSite.bo.Utilisateur;

/**
 * @author smahmoudi2021
 *
 */
public interface UtilisateurDAO {
	
	
		//Insérer un nouveau utilisateur 
		public void insert(Utilisateur user) throws DALException;
	
	    //Modifier les attributs d'un utilisateur connu en BD
		public void update(Utilisateur user) throws DALException;
	
		
		//Supprimer un utilisateur par son id 
		public void delete(int id) throws DALException;
		
	    // Sélectionner un  noUtilisateur par son pseudo 
		public int selectNoUtilisateurByPseudo(String pseudo) throws DALException;
		
		//Sélectionner un utilisateur par son noUtilsateur 
		public Utilisateur selectByNoUtilisateur(int noUtilisateur) throws DALException;
				
		//Sélectionner un utilisateur par son pseudo
		 public Utilisateur selectByPseudo(String pseudo) throws DALException;
				
		//Sélectionner tous les articles 
			public List<Utilisateur> selectAll() throws DALException;
	
}

