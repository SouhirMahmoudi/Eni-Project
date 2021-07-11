package eni.fr.onlineAuctionSite.bll;

import java.util.List;

import eni.fr.onlineAuctionSite.bo.Categorie;
import eni.fr.onlineAuctionSite.dal.CategorieDAO;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;

public class CategorieManager {

		private static CategorieDAO daoCategories;

		public CategorieManager() throws BLLException{
				//Instancier le Data Access Object
			daoCategories =DAOFactory.getDAOCategorie();
		}
		
		
		public List<Categorie> getListeCategories() throws BLLException{
			List<Categorie> categories=null;
			try {
				categories = daoCategories.selectAll();
			} catch (DALException e) {
				e.printStackTrace();
				throw new BLLException("Erreur récupération categories", e);
			}
			
			return categories;
		}

		
		/**
		 * Ajout d'une categorie 
		 * @param newCategorie
		 * @return index du nouvelle categorie  dans le catalogue
		 * @throws BLLException 
		 */
		public void addCategorie(Categorie newCategorie) throws BLLException {
			if(newCategorie.getNoCategorie()!=null){
				throw new BLLException("Article deja existant.");
			}
			try {
				validerCategorie(newCategorie);
				daoCategories.insert(newCategorie);
			} catch (DALException e) {
				throw new BLLException("Echec addCategorie", e);
			}
		}

		/**
		 * selectionner le numero de  categorie par libelle
		 * @param libelle
		 * @throws BLLException
		 */
		
		public int  SelectNoCategorieByLibelle( String libelle) throws BLLException{
			try {
				int noCategorie = daoCategories.selectNoCategorie(libelle);
				return noCategorie;
				
			} catch (DALException e) {
				throw new BLLException("Echec SelectNoCategorieByLibelle:"+libelle, e);
			}
			
		}
		
		
		
		/**
		 * Supprimer une categorie
		 * @param index
		 * @throws BLLException
		 */
		public void removeCategorie(Categorie categorie) throws BLLException{
			try {
				daoCategories.delete(categorie.getNoCategorie());
			} catch (DALException e) {
				throw new BLLException("Echec de la suppression de la categorie- ", e);
			}
			
		}
		
		/**
		 * Valider les données d'une categorie
		 * @param a
		 * @throws BLLException
		 */
		public void validerCategorie(Categorie c) throws BLLException
		{
			boolean valide = true;
			StringBuffer sb = new StringBuffer();
			
			if(c==null){
				throw new BLLException("Categorie null");
			}
			//Les attributs des categories sont obligatoires
			if(c.getLibelle()==null || c.getLibelle().trim().length()==0){
				sb.append("Le libelle est obligatoire.\n");
				valide = false;
			
			
			
			if(!valide){
				throw new BLLException(sb.toString());
			}

			}
		}
}

