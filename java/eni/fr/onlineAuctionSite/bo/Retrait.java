package eni.fr.onlineAuctionSite.bo;

public class Retrait {
	private String rue;
	private String code_postal;
	private String ville;
	private Article article;
	private int no_article;
	
	
	
	
	public Retrait(String rue, String code_postal, String ville, int no_article) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.no_article = no_article;
	}


	

	public int getNo_article() {
		return no_article;
	}




	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}




	public Retrait(String rue, String code_postal, String ville, Article article) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.article = article;
	}


	public Retrait(String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + "]";
	}
	
	
	
	

	
	
	
	
	
	
	

	
	

}
