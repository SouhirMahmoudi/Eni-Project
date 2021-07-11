/**
 * 
 */
package eni.fr.onlineAuctionSite.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eni.fr.onlineAuctionSite.bo.Enchere;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.EnchereDAO;

/**
 * @author smahmoudi2021
 *
 */
public class EnchereDAOImplJdbc implements EnchereDAO {
	
	private static final String sqlselectByNoArticle ="select dateEnchere,montant_enchere"+ "from Enchere where noArticle=?";

	@Override
	public List<Enchere> selectByNoArticle(int noArticle) throws DALException {
	
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
	
		Enchere enchere = null;
		List<Enchere> liste = new ArrayList<Enchere>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlselectByNoArticle);
			rqt.setInt(1, noArticle);
			rs = rqt.executeQuery();
		
			while (rs.next()) {
				
				enchere = new Enchere (rs.getDate("dateEnchere").toLocalDate(),rs.getInt("montant_enchere"));
				}
			
				
				liste.add(enchere);
			
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

	
	

	
