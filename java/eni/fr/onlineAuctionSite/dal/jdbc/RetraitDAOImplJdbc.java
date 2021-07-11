/**
 * 
 */
package eni.fr.onlineAuctionSite.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eni.fr.onlineAuctionSite.bo.Retrait;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.RetraitDAO;

/**
 * @author smahmoudi2021
 *
 */
public class RetraitDAOImplJdbc implements RetraitDAO {
 private static final String sqlInsert = "insert into RETRAITS (no_article, rue,code_postal,ville) values(?,?,?,?)";
 private static final String sqlUpdate ="update RETRAITS  set no_article =?, rue=?,code_postal=?,ville=?";

	@Override
	public void insert(Retrait retrait) throws DALException {
	
			Connection cnx = null;
			PreparedStatement rqt = null;
			
			
			try {
				cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert);
			rqt.setInt(1, retrait.getNo_article());
			rqt.setString(2, retrait.getRue());
			rqt.setString(3, retrait.getCode_postal());
			rqt.setString(4, retrait.getVille());
			rqt.executeUpdate();
		

		}catch(SQLException e){
			throw new DALException("Insert retrait failed - " + retrait, e);
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
	public void update(Retrait retrait) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		
		
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			
			rqt.setInt(1, retrait.getArticle().getNoArticle());
			rqt.setString(2, retrait.getRue());
			rqt.setString(3, retrait.getCode_postal());
			rqt.setString(4, retrait.getVille());
			
			
			rqt.executeUpdate();
			
				
			
		} catch (SQLException e) {
			throw new DALException("update retrait failed - " , e);
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

	