/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;

import java.util.List;

import eni.fr.onlineAuctionSite.bo.Article;



/**
 * @author smahmoudi2021
 *
 */
public interface ArticleDAO {
	
		//Sélectionner les articles par mot clé
		//On recherche le mot clé dans la description de l'article ou dans le nom
		public List<Article> selectByMotCle(String motCle) throws DALException;
        
		//Sélectionner tous les articles 
		public List<Article> selectAll() throws DALException;
		
		//Sélectionner un article par noArticle 
		public Article selectByNoArticle(int noArticle) throws DALException;
		
		//Sélectionner un article par le nocategorie
		public List<Article> selectByNoCategorie(int noCategorie) throws DALException;
		

		//Sélectionner un article par son etat de vente
		public List<Article> selectByEtatDeVente(String etatDeVente) throws DALException;
		
		//Sélectionner une liste des articles par noUtilisateur et etatdevente
		public List<Article> selectByNoUtilisateurEtEtatDeVente(int noUtilisateur ,String EtatDeVente) throws DALException;
		
		//Sélectionner une liste des articles qui appartiennent pas à unUtilisateur selon leur etatdevente
		public List<Article> selectByEtatDeVenteEtPseudo(String pseudo,String EtatDeVente) throws DALException;
		
		//Modifier les attributs d'un article connu en BD
		public void update(Article data) throws DALException;
		
		//update prixDevente
		public void updatePrixDeVente(Article article,int nouveauPrix) throws DALException;
		
		//update EtatDeVente 
		public void updateEtatDeVente(Article article,String nouveauEtatDeVente) throws DALException;
		
		//Insérer un nouvel article
		public void insert(Article data) throws DALException;
		
		//Supprimer un article
		public void delete(int id) throws DALException;
		
		
	}

