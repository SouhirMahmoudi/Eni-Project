package eni.fr.onlineAuctionSite.dal.jdbc;

import java.time.LocalDate;


import eni.fr.onlineAuctionSite.bo.Article;
import eni.fr.onlineAuctionSite.bo.Categorie;
import eni.fr.onlineAuctionSite.bo.Utilisateur;
import eni.fr.onlineAuctionSite.dal.ArticleDAO;
import eni.fr.onlineAuctionSite.dal.CategorieDAO;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;
import eni.fr.onlineAuctionSite.dal.UtilisateurDAO;

public class testArticleDao {

	public static void main(String[] args) {
		//Déclaration et instanciation de la DAO
		UtilisateurDAO utilisateurDao = DAOFactory.getDAOUtilisateur();
		CategorieDAO categoriDao = DAOFactory.getDAOCategorie();
		ArticleDAO articleDAO = DAOFactory.getDAOArticle();
        

        Article a1 = new Article("Robe fille","robe courte pour fille de couleur rouge taille 5 ans", LocalDate.of(2021,06,01) ,LocalDate.of(2021,05,04) ,50, 60,"en cours");
		Article a2 = new Article("Jupe Fille","jupe  pour fille de couleur rouge taille 6 ans", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,40, 50,"en cours");
		Article a3 = new Article("Pantalon garçon","Pantalon pour garçon de couleur verte taille 5 ans", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,20, 30,"en cours");
		Article a4 = new Article("tshirt garçon","tshirt pour garçon  de couleur bleu taille 6 ans", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,30, 40,"en cours");
		Article a5 = new Article("Chaise","Chaise en bois", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,50, 60,"en cours");
		Article a6 = new Article("Table","table en marbre", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,50, 60,"en cours");
		Article a7 = new Article("Vélo elliptique","Vélo elliptique maMarque connecté de couleur noir", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,120, 130,"en cours");
		Article a8 = new Article("tapis de course","tapis de course connecté de couleur noir", LocalDate.of(2021,06,05) ,LocalDate.of(2021,04,05) ,110, 120,"en cours");

		System.out.println("Ajout des articles... ");
		//TODO...
		try {
			
			
			int noCtegorie = categoriDao.selectNoCategorie("vetement");
			Categorie cat1 = new Categorie(noCtegorie,"vetement");
			int noCtegorie1 = categoriDao.selectNoCategorie("Ameublement");
			Categorie cat2 = new Categorie(noCtegorie1,"Ameublement");
			int noCtegorie2 = categoriDao.selectNoCategorie("Sport&Loisirs");
			Categorie cat3 = new Categorie(noCtegorie2,"Sport&Loisirs");
			
			
			
			a1.setCategorieArticle(cat1);
			a2.setCategorieArticle(cat1);
			a3.setCategorieArticle(cat1);
			a4.setCategorieArticle(cat1);
			a5.setCategorieArticle(cat2);
			a6.setCategorieArticle(cat2);
			a7.setCategorieArticle(cat3);
			a8.setCategorieArticle(cat3);

	
			int noUtilisateur = utilisateurDao.selectNoUtilisateurByPseudo("sou");
			Utilisateur user1= new Utilisateur (noUtilisateur);
		    a1.setEtatVente("en cours");
		    a2.setEtatVente("en cours");
		    a3.setEtatVente("en cours");
		    a4.setEtatVente("en cours");
			a1.setUtilisateur(user1);
			a2.setUtilisateur(user1);
			a3.setUtilisateur(user1);
			a4.setUtilisateur(user1);
			int noUtilisateur1 = utilisateurDao.selectNoUtilisateurByPseudo("jou");
			Utilisateur user2= new Utilisateur (noUtilisateur1);
			a5.setUtilisateur(user2);
			a6.setUtilisateur(user2);
			a7.setUtilisateur(user2);
			a8.setUtilisateur(user2);
			 a5.setEtatVente("en cours");
			 a6.setEtatVente("en cours");
			 a7.setEtatVente("en cours");
			 a8.setEtatVente("en cours");
			
			
			
			
			articleDAO.insert(a1);
			articleDAO.insert(a2);
			articleDAO.insert(a3);
			articleDAO.insert(a4);
			articleDAO.insert(a5);
			articleDAO.insert(a6);
			articleDAO.insert(a7);
			articleDAO.insert(a8);
			
			 
			
			 
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

		}


