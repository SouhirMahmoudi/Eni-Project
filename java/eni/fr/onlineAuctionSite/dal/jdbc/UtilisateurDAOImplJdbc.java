/**
 * 
 */
package eni.fr.onlineAuctionSite.dal.jdbc;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eni.fr.onlineAuctionSite.bo.Utilisateur;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.UtilisateurDAO;

/**
 * @author smahmoudi2021
 *
 */
public class UtilisateurDAOImplJdbc implements UtilisateurDAO{
	
	private static final String sqlInsert = "insert into UTILISATEURS ( pseudo ,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe) values(?,?,?,?,?,?,?,?,?)";
	private static final String sqlUpdate = "update  UTILISATEURS set pseudo=? ,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?";
	private static final String sqlDelete = "delete from UTILISATEURS where no_utilisateur=?";

	private static final String sqlSelectByNoUtilisateur = "select pseudo ,nom,prenom,email,telephone,rue,code_postal,ville "+" from UTILISATEURS where no_utilisateur=?";
	private static final String sqlSelectByPseudo = "select pseudo ,nom,prenom,email,telephone,rue,code_postal,ville "+" from UTILISATEURS where pseudo=?";
	private static final String sqlSelectNoUtilisateurByPseudo ="select no_utilisateur "+"from UTILISATEURS where pseudo=?";
	private static final String sqlSelectAll = "select pseudo ,nom,prenom,email,telephone,rue,code_postal,ville"+"from UTILISATEURS";
	
	@Override
	public void insert(Utilisateur user) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
	
		
		
		try {
			cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		
		rqt.setString(1, user.getPseudo());
		rqt.setString(2, user.getNom());
		rqt.setString(3, user.getPrenom());
		rqt.setString(4, user.getEmail());
		rqt.setString(5, user.getTelephone());
		rqt.setString(6, user.getRue());
		rqt.setString(7, user.getCodePostal());
		rqt.setString(8, user.getVille());
		rqt.setString(9, user.getMotDePasse());
	  
		int nbRows = rqt.executeUpdate();
		if(nbRows == 1){
			ResultSet rs = rqt.getGeneratedKeys();
			if(rs.next()){
				user.setNoUtilisateur(rs.getInt(1));
				
			}

		}

	}catch(SQLException e){
		throw new DALException("Insert utilisateur failed - " + user, e);
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
	public void update(Utilisateur user) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, user.getPseudo());
			rqt.setString(2, user.getNom());
			rqt.setString(3, user.getPrenom());
			rqt.setString(4, user.getEmail());
			rqt.setString(5, user.getTelephone());
			rqt.setString(6, user.getRue());
			rqt.setString(7, user.getCodePostal());
			rqt.setString(8, user.getVille());
			rqt.setString(9, user.getMotDePasse());
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
	public void delete(int noUtilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
	
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, noUtilisateur);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + noUtilisateur, e);
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
	public Utilisateur selectByNoUtilisateur(int noUtilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Utilisateur utilisateur = null;
	
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNoUtilisateur);
			rqt.setInt(1, noUtilisateur);
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("codePostal"),rs.getString("ville"));
		
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
		
		return utilisateur;

	}



	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Utilisateur utilisateur = null;
	
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByPseudo);
			rqt.setString(1, pseudo);
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("codePostal"),rs.getString("ville"));
		
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
		
		return utilisateur;
	}





	@Override
	public int selectNoUtilisateurByPseudo(String pseudo) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		 int  noUtilisateur=0;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectNoUtilisateurByPseudo);
			rqt.setString(1, pseudo);
			rs = rqt.executeQuery();
			if(rs.next()) {
				noUtilisateur = rs.getInt("no_Utilisateur");
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
		
		return noUtilisateur;
	}





	@Override
	public List<Utilisateur> selectAll() throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Utilisateur utilisateur= null;
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectAll);
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("rue"),rs.getString("codePostal"),rs.getString("ville"));
				}
			
				
				liste.add(utilisateur );
			
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
	


	}


	
	
