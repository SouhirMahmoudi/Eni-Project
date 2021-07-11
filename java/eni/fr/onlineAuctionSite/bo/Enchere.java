package eni.fr.onlineAuctionSite.bo;

import java.time.LocalDate;

public class Enchere {
	private LocalDate dateEnchère;
	private Integer montant_enchere;
	private Article articleEnchere;
	
		public Enchere(LocalDate dateEnchère, Integer montant_enchere) {
		super();
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;

	}

	public Enchere() {
		super();
	
	}
	
	public LocalDate getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(LocalDate dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Article getArticleEnchere() {
		return articleEnchere;
	}

	public void setArticleEnchere(Article articleEnchere) {
		this.articleEnchere = articleEnchere;
	}



	
	
}
