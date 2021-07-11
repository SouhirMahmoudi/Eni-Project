package eni.fr.onlineAuctionSite.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import eni.fr.onlineAuctionSite.bo.Article;
import eni.fr.onlineAuctionSite.bo.Retrait;
import eni.fr.onlineAuctionSite.bo.Utilisateur;
import eni.fr.onlineAuctionSite.dal.ArticleDAO;

import eni.fr.onlineAuctionSite.dal.DALException;





public class ArticleDAOImplJdbc implements ArticleDAO{
	/**
	 * @author smahmoudi2021 
	 *
	 */
	
	private static final String sqlSelectByMotCle = "select a.no_article, nom_article , description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etatVente, a.no_utilisateur, u.pseudo, u.telephone, r.rue, r.code_postal, r.ville"+
			"  from ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur INNER JOIN RETRAITS r ON a.no_article=r.no_article where a.nom_article like ? or a.description like ? ";
	   
	private static final String sqlSelectAll = "select a.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etatVente, a.no_utilisateur, u.no_utilisateur, u.pseudo, u.telephone, r.rue, r.code_postal, r.ville"
			+ " from ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur INNER JOIN RETRAITS r ON a.no_article = r.no_article";
	private static final String sqlUpdate ="update ARTICLES set nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?, prix_initial=?, prix_vente=?, etatVente=? ";
	
	private static final String sqlSelectByEtatDeVente = "select no_article,nom_article , description, date_debut_encheres,   date_fin_encheres, prix_initial, prix_vente, etatVente,no_utilisateur,pseudo,telephone,rue, code_postal, ville"+
			" from ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur INNER JOIN RETRAITS r ON a.no_article=r.no_article where etatDeVente= ?";
	   
	private static final String sqlInsert = "insert into ARTICLES(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,etatVente) values(?,?,?,?,?,?,?,?,?)";
	private static final String sqlDelete = "delete from ARTICLES where no_article=?";
	private static final String sqlSelectByNoCategorie ="select a.no_article, nom_article , description, date_debut_encheres,  date_fin_encheres, prix_initial, prix_vente, etatVente, a.no_utilisateur, u.pseudo, u.telephone, r.rue, r.code_postal, r.ville"
			+ " from ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur INNER JOIN RETRAITS r ON a.no_article=r.no_article where a.no_categorie =?";
			
	private static final String sqlSelectById = "select a.no_article,nom_article , description, date_debut_encheres,   date_fin_encheres, prix_initial, prix_vente, etatVente,u.no_utilisateur,pseudo,telephone,r.rue, r.code_postal, r.ville"
			+ " from ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur INNER JOIN RETRAITS r ON a.no_article = r.no_article where a.no_article = ?";
	private static final String sqlselectByNoUtilisateurEtEtEtatDeVente="select no_article,nom_article , description, date_debut_encheres,   date_fin_encheres, prix_initial, prix_vente, etatVente,no_utilisateur,pseudo,telephone,rue, code_postal, ville"
			+ " from ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur INNER JOIN RETRAITS r ON a.no_article=r.no_article where etatDeVente= ? and no_utilisateur=?";
	private static final String sqlUpdateEtatDeVente="update ARTICLES set etatVente=?";
	private static final String sqlUpdatePrixDeVente="update ARTICLES set prix_vente=?";
	
	
	@Override
	public List<Article> selectByMotCle(String motCle) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		
		List<Article> liste = new ArrayList<Article>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByMotCle);
			rqt.setString(1, '%'+motCle + '%');
			rqt.setString(2, '%'+motCle + '%');
			rs = rqt.executeQuery();
			Article article = null;
			Utilisateur user=null;
			Retrait retrait =null;
			while (rs.next()) {
				 user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
                 retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt("prix_vente"),rs.getString("etatVente"),retrait,user);
				liste.add(article);
			}
			
				
				
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		
		return liste;

	}

	@Override
	public List<Article> selectAll() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
	
		List<Article> liste = new ArrayList<Article>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectAll);
			rs = rqt.executeQuery();
			Retrait retrait =null;
			Utilisateur user=null;
			Article article = null;
		
			while (rs.next()) {
				 user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
				 retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt("prix_vente"),rs.getString("etatVente"),retrait,user);
				liste.add(article);
			}
			
			return liste;	
			
		} catch (SQLException e) {
			throw new DALException("selectAll failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		

	}
	

	@Override
	public List<Article> selectByNoCategorie(int noCategorie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		List<Article> liste = new ArrayList<Article>();
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNoCategorie);
			rqt.setInt(1, noCategorie);
			rs = rqt.executeQuery();
			Article article = null;
            Retrait retrait=null;
             Utilisateur user=null;
			while (rs.next()) {
				user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
				retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt("prix_vente"),rs.getString("etatVente"),retrait,user);
				liste.add(article);


			}
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		
		return liste;

	}
	
	
	
	
	@Override
	public void update(Article data) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, data.getNomArticle());
			rqt.setString(2, data.getDescription());
			rqt.setDate(3, Date.valueOf(data.getDateDebutEncheres()));
			rqt.setDate(4, Date.valueOf(data.getDateFinEncheres()));
			rqt.setInt(5, data.getMiseAPrix());
			rqt.setInt(6, data.getPrixVente());
			rqt.setString(7, data.getEtatVente());
			rqt.executeUpdate();
			
				
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {

				try {
					if (rqt != null){
						rqt.close();
					}
					if(cnx !=null){
						cnx.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
	}

	@Override
	public Article selectByNoArticle(int noArticle) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Article article = null;
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, noArticle);
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				Utilisateur user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
				Retrait retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt(" prix_vente"),rs.getString("etatVente"),retrait,user);
				}
			
				
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		
		return article;

	}

	@Override
	public void insert(Article data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		
		try {
			cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		
		rqt.setString(1, data.getNomArticle());
		rqt.setString(2, data.getDescription());
		rqt.setDate(3, Date.valueOf(data.getDateDebutEncheres()));
		rqt.setDate(4, Date.valueOf(data.getDateFinEncheres()));
		rqt.setInt(5, data.getMiseAPrix());
		rqt.setInt(6, data.getPrixVente());
		rqt.setInt(7,data.getUtilisateur().getNoUtilisateur());
		rqt.setInt(8,data.getCategorieArticle().getNoCategorie());
		rqt.setString(9, data.getEtatVente());
		
	

		int nbRows = rqt.executeUpdate();
		if(nbRows == 1){
			ResultSet rs = rqt.getGeneratedKeys();
			if(rs.next()){
				data.setNoArticle(rs.getInt(1));
			}

		}

	}catch(SQLException e){
		throw new DALException("Insert article failed - " + data, e);
	}
	finally {
		try {
			if (rqt != null){
				rqt.close();
			}
			if(cnx!=null){
				cnx.close();
			}
		} catch (SQLException e) {
			throw new DALException("close failed - ", e);
		}

	}
}


	

	@Override
	public void delete(int no_article) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
	
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, no_article);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + no_article, e);
		} finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}

		}		
	}

		
	

	@Override

	public List<Article> selectByEtatDeVente(String etatDeVente) throws DALException{
		    Connection cnx = null;
			PreparedStatement rqt = null;
			ResultSet rs = null;
			
		
			Article article = null;
			List<Article> liste = new ArrayList<Article>();
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(sqlSelectByEtatDeVente);
				rqt.setString(1, etatDeVente);
				rs = rqt.executeQuery();
			
				while (rs.next()) {
					Utilisateur user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
					Retrait retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
					article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt(" prix_vente"),rs.getString("etatVente"),retrait,user);
					}
				
					
					liste.add(article);
				
			} catch (SQLException e) {
				throw new DALException("selectByMotCle failed - " , e);
			} finally {
				try {
					if (rs != null){
						rs.close();
					}
					if (rqt != null){
						rqt.close();
					}
					if(cnx!=null){
						cnx.close();
					}
				} catch (SQLException e) {
					throw new DALException("close failed " , e);
				}
			}
			
			return liste;

		}

	@Override
	public List<Article> selectByNoUtilisateurEtEtatDeVente(int noUtilisateur , String EtatDeVente) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Article article = null;
		List<Article> liste = new ArrayList<Article>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlselectByNoUtilisateurEtEtEtatDeVente);
			rqt.setInt(1,noUtilisateur);
			rqt.setString(2,EtatDeVente);
			
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				Utilisateur user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
				Retrait retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt(" prix_vente"),rs.getString("etatVente"),retrait,user);
				}
			
				
				liste.add(article);
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		
		return liste;


	}

	@Override
	public List<Article> selectByEtatDeVenteEtPseudo(String pseudo, String EtatDeVente) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Article article = null;
		List<Article> liste = new ArrayList<Article>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlselectByNoUtilisateurEtEtEtatDeVente);
			rqt.setString(1,pseudo);
			rqt.setString(2,EtatDeVente);
			
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				Utilisateur user = new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"),rs.getString("telephone"));
				Retrait retrait = new Retrait (rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				article = new Article (rs.getInt("no_article"),rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("prix_initial"),rs.getInt("prix_vente "),rs.getString("etatVente"),retrait,user);
				}
			
				
				liste.add(article);
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
		}
		
		return liste;



	}

	@Override
	public void updatePrixDeVente(Article article,int nouveauPrix) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdatePrixDeVente);
			rqt.setInt(1, article.getPrixVente());
			
			rqt.executeUpdate();
			
				
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
			
			
		}
		
	}

	@Override
	public void updateEtatDeVente(Article article, String nouveauEtatDeVente) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdateEtatDeVente);
			rqt.setInt(1, article.getPrixVente());
			
			rqt.executeUpdate();
			
				
			
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - " , e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed " , e);
			}
			
			
		}
		
	}

	}



