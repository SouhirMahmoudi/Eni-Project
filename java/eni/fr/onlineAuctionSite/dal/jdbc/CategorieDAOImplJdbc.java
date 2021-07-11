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

import eni.fr.onlineAuctionSite.bo.Categorie;
import eni.fr.onlineAuctionSite.dal.CategorieDAO;
import eni.fr.onlineAuctionSite.dal.DALException;

/**
 * @author smahmoudi2021
 *
 */
public class CategorieDAOImplJdbc implements CategorieDAO{
	
	private static final String sqlSelectAll = "select libelle"
			+ " from CATEGORIES"; 
	private static final String selectNoCategorieByLibelle ="select no_categorie "+ "from CATEGORIES where libelle=?";
	
	private static final String sqlInsert = "insert into CATEGORIES (libelle) values(?)";

	private static final String sqlDelete = "delete from CATEGORIES where no_categorie=?";
	
	@Override
	public int selectNoCategorie(String libelle) throws DALException {
			Connection cnx = null;
			PreparedStatement rqt = null;
			ResultSet rs = null;
			 int  noCategorie=0;
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(selectNoCategorieByLibelle);
				rqt.setString(1, libelle);
				rs = rqt.executeQuery();
				if (rs.next()) {
			   noCategorie= rs.getInt("no_categorie");
				}
								
			} catch (SQLException e) {
				throw new DALException("selectNoCategorieByLibelle - " , e);
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
			return noCategorie;

		}


	@Override
	public void insert(Categorie categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
		rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		rqt.setString(1, categorie.getLibelle());
		int nbRows = rqt.executeUpdate();
		if(nbRows == 1){
			 ResultSet rs = rqt.getGeneratedKeys();
			if(rs.next()){
				categorie.setNoCategorie(rs.getInt(1));
			}

		}

	}catch(SQLException e){
		throw new DALException("Insert categorie failed - " + categorie, e);
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
	public void delete(int noCategorie) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {		
			cnx = JdbcTools.getConnection();
	
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, noCategorie);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + noCategorie, e);
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
	public List<Categorie> selectAll() throws DALException {

			Connection cnx = null;
			PreparedStatement rqt = null;
			ResultSet rs = null;
			
		
			Categorie categorie = null;
			List<Categorie> liste = new ArrayList<Categorie>();
			try {
				cnx = JdbcTools.getConnection();
				rqt = cnx.prepareStatement(sqlSelectAll);
				rs = rqt.executeQuery();
			
				while (rs.next()) {
								categorie = new Categorie (rs.getString("libelle"));
					}
				
					
					liste.add(categorie);
				
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




