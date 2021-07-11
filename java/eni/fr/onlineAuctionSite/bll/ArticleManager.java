package eni.fr.onlineAuctionSite.bll;

import java.util.List;

import eni.fr.onlineAuctionSite.bo.Article;
import eni.fr.onlineAuctionSite.dal.ArticleDAO;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;



public class ArticleManager {

	private static ArticleDAO daoArticles;

	public ArticleManager() throws BLLException{
			//Instancier le Data Access Object
		 	daoArticles =DAOFactory.getDAOArticle();
	}
	
	
	public List<Article> getListeArticles() throws BLLException{
		List<Article> articles=null;
		try {
			articles = daoArticles.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération articles", e);
		}
		
		return articles;
	}

	
	/**
	 * Ajout d'un article 
	 * @param newArticle
	 * @return index du nouvel article dans le catalogue
	 * @throws BLLException 
	 */
	public void addArticle(Article newArticle) throws BLLException {
		if(newArticle.getNoArticle()!=null){
			throw new BLLException("Article deja existant.");
		}
		try {
			validerArticle(newArticle);
			daoArticles.insert(newArticle);
		} catch (DALException e) {
			throw new BLLException("Echec addArticle", e);
		}
	}

	/**
	 * updateArticle : Modifier un article du catalogue
	 * @param article
	 * @throws BLLException
	 */
	public void updateArticle(Article article) throws BLLException{
		try {
			validerArticle(article);
			daoArticles.update(article);
			
		} catch (DALException e) {
			throw new BLLException("Echec updateArticle-article:"+article, e);
		}
	}
	
	public List<Article> SelectArticleByMotCle( String motCle) throws BLLException{
		List<Article> articles=null;
		try {
			articles = daoArticles.selectByMotCle(motCle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération articles", e);
		}
		
		return articles;
	}

	
	public List<Article> SelectArticleByEtatDeVente( String EtatDeVente) throws BLLException{
	
			List<Article> articles=null;
			try {
				articles = daoArticles.selectByEtatDeVente(EtatDeVente);
			} catch (DALException e) {
				e.printStackTrace();
				throw new BLLException("Erreur récupération articles", e);
			}
			
			return articles;
		}

	
	public List<Article> SelectArticleByEtatDeVneteEtPseudo( String EtatDeVente, String Pseudo) throws BLLException{
		List<Article> articles=null;
		try {
			articles = daoArticles.selectByEtatDeVenteEtPseudo(Pseudo, EtatDeVente);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération articles", e);
		}
		
		return articles;
	}
	public Article SelectArticleByNoArticle ( int noArticle) throws BLLException{
		Article article =null;
		try {
			article = daoArticles.selectByNoArticle(noArticle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération articles", e);
		}
		
		return article;
	}
	
	public List<Article> SelectArticleByNoCategorie ( int noCategorie) throws BLLException{
		try {
			
			return daoArticles.selectByNoCategorie(noCategorie);
			
		} catch (DALException e) {
			throw new BLLException("Echec SelectArticleByNoCategorie:"+noCategorie, e);
		}
	}
	public void SelectArticleByNoUtilisateurEtEtatDeVente( int noUtilisateur, String Pseudo) throws BLLException{
		try {
			daoArticles.selectByNoUtilisateurEtEtatDeVente(noUtilisateur,Pseudo);
			
		} catch (DALException e) {
			throw new BLLException("selectByNoUtilisateurEtEtatDeVente:"+noUtilisateur + Pseudo , e);
		}
	}
	
	
	/**
	 * Supprimer un article du catalogue
	 * @param index
	 * @throws BLLException
	 */
	public void removeArticle(Article article) throws BLLException{
		try {
			daoArticles.delete(article.getNoArticle());
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'article - ", e);
		}
		
	}
	
	/**
	 * Valider les données d'un article
	 * @param a
	 * @throws BLLException
	 */
	public void validerArticle(Article a) throws BLLException
	{
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		
		if(a==null){
			throw new BLLException("Article null");
		}
		//Les attributs des articles sont obligatoires
		if(a.getNomArticle()==null || a.getNomArticle().trim().length()==0){
			sb.append("Le nom d'article est obligatoire.\n");
			valide = false;
		}
		if(a.getDescription()==null || a.getDescription().trim().length()==0){
			sb.append("La description est obligatoire.\n");
			valide = false;
		}
		if(a.getDateDebutEncheres()==null ){
			sb.append("La date de début d'encheres  est obligatoire.\n");
			valide = false;
		}
		
		if(a.getDateFinEncheres()==null ){
			sb.append("La date de début d'encheres  est obligatoire.\n");
			valide = false;
		}
		if(a.getMiseAPrix()==null){
			sb.append("Le prix   est obligatoire.\n");
			valide = false;
		}
		
		
		if(!valide){
			throw new BLLException(sb.toString());
		}

	}
	
	

}


