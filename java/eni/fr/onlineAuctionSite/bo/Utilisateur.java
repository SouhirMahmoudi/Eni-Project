/**
 * 
 */
package eni.fr.onlineAuctionSite.bo;


import java.util.List;

/**
 * @author smahmoudi2021 
 *
 */
public class Utilisateur {
	//Attributs d'instance
	 private Integer noUtilisateur;
	 private String pseudo;
	 private String nom;
	 private String prenom;
	 private String email;
	 private String telephone;
	 private String rue;
	 private String codePostal;
	 private String ville;
	 private String motDePasse;
	 private Integer credit;
	
	 private List<Article> articles;
	
	 //Constructeurs 
	
	
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;

		
		
		
	}
	

	public Utilisateur(Integer noUtilisateur) {
		super();
		this.noUtilisateur = noUtilisateur;
	}


	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	

	public Utilisateur(Integer noUtilisateur, String pseudo, String telephone) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.telephone = telephone;
	}
	
	

	

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	//Getters et setters
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}



	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	

	@Override
	public String toString() {
		
				StringBuffer bf = new StringBuffer(); 
				bf.append("Utilisateur [");
				bf.append("noUtilisateur=");
				bf.append(noUtilisateur);
				bf.append(", pseudo=");
				bf.append(pseudo);
				bf.append("nom=");
				bf.append(nom);
				bf.append("prenom=");
				bf.append(prenom);
				bf.append("email=");
				bf.append(email);
				bf.append("telephone=");
				bf.append("codePostal");
				bf.append(codePostal);
				bf.append("ville");
				bf.append(ville);
				bf.append("motDePasse");
				bf.append(motDePasse);
				bf.append("credit");
				bf.append(credit);
				bf.append(" administrateur");
				
				bf.append("rue");
				bf.append(rue);
				
				bf.append("articlesVendus [");
				if (articles!= null) {
					bf.append("articles =");
					bf.append(getArticles().toString());
					bf.append("]");}
					
					
						return bf.toString();
				
	}


	
}
				
	

	