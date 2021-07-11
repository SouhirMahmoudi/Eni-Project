package eni.fr.onlineAuctionSite.bo;



public class Categorie {

	// Attributs d'instance
		private Integer noCategorie ;
		private String libelle;
		
		public Categorie( String libelle) {
			super();
			
			this.libelle = libelle;
		}

		public Categorie(Integer noCategorie, String libelle) {
			super();
			this.noCategorie = noCategorie;
			this.libelle = libelle;
		}

		public Categorie() {
			super();
			
		}
		
		public Integer getNoCategorie() {
			return noCategorie;
		}
		public void setNoCategorie(Integer noCategorie) {
			this.noCategorie = noCategorie;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		
		
		
		@Override
		public String toString() {
			StringBuffer bf = new StringBuffer(); 
			bf.append("Categorie [");
			bf.append("noCategorie=");
			bf.append(noCategorie);
			bf.append("libelle=");
			bf.append(libelle);
		
			return bf.toString();
		}
	
}
 