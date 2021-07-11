package eni.fr.onlineAuctionSite.bo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author smahmoudi2021 
 *
 */
public class Article {
	//Attributs d'instance
	private Integer noArticle;
	private String nomArticle;
	private String description ;
	private LocalDate dateDebutEncheres; 
	private LocalDate dateFinEncheres ;
	private Integer miseAPrix ;
	private Integer prixVente;
	private String etatVente;
	private Categorie categorieArticle;
	private List<Enchere> listeEncheres;
	private Retrait lieuRetrait;
	private Utilisateur utilisateur;

	
	//Constructeurs
	
	
	
	
		
	public Article() {
		super();
		
	}

	



	public Article(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Retrait lieuRetrait, Utilisateur utilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		
		this.lieuRetrait = lieuRetrait;
		this.utilisateur = utilisateur;
	}





	public Article(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	    
	}


	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
        this.etatVente= etatVente;
	}

	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		
		listeEncheres= new ArrayList<Enchere>() ;
	}
	




	public Integer getNoArticle() {
		return noArticle;
	}



	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}



	public String getNomArticle() {
		return nomArticle;
	}



	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}



	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}



	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}



	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}



	public Integer getMiseAPrix() {
		return miseAPrix;
	}



	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}



	public Integer getPrixVente() {
		return prixVente;
	}



	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}



	public String getEtatVente() {
		return etatVente;
	}



	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}



	public Categorie getCategorieArticle() {
		return categorieArticle;
	}



	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}



	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}



	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}



	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}



	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}





	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", categorieArticle="
				+ categorieArticle + ", lieuRetrait=" + lieuRetrait + ",utilisateur " + utilisateur +"]";
	}


	
	
	
	
	
	
	
	
	
}
