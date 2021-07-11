package eni.fr.onlineAuctionSite.dal.jdbc;

import java.util.ArrayList;
import java.util.List;

import eni.fr.onlineAuctionSite.bo.Utilisateur;
import eni.fr.onlineAuctionSite.dal.DALException;
import eni.fr.onlineAuctionSite.dal.DAOFactory;
import eni.fr.onlineAuctionSite.dal.UtilisateurDAO;

public class testUtilisateurDao {
	public static void main(String[] args) {

	//Déclaration et instanciation de la DAO
	UtilisateurDAO utilisateurDao = DAOFactory.getDAOUtilisateur();
       
	Utilisateur u= new Utilisateur("sou","Souhir","Mahmoudi","souhir.fr","0614301425","rue alibert","75017","paris","1234");
	Utilisateur u1= new Utilisateur("jou","Jeanna","b","Jeanne.fr","0623123216","rue Achille","75013","paris","5678");
	Utilisateur u2= new Utilisateur("Nou","Nadia","Benyahya","nadia.fr","0623143216","rue Alboni","75012","paris","0123");
	Utilisateur u3= new Utilisateur("ches","Anthony","Chesne","anthnoy.fr","0625123216","rue Allent","75013","paris","4567");

	
	System.out.println("Ajout des utilisateurs... ");
	try {
             //insert
		 utilisateurDao.insert(u);
		 System.out.println("utilisateur ajouté  : " + u.toString() );
		 utilisateurDao.insert(u1);
		 System.out.println("utilisateur ajouté  : " + u.toString() );
		 utilisateurDao.insert(u2);
		 System.out.println("utilisateur ajouté  : " + u.toString() );
		 utilisateurDao.insert(u3);
		 
		
		//Sélection de l'utilisateur par pseudo
		//TODO...
		Utilisateur user  = utilisateurDao.selectByPseudo(u.getPseudo());
		System.out.println("Sélection de l'utilisateur par son pseudo  : " + u.toString() );
 
		//Sélection de l'utilisateur par noutilisateur
		//TODO...
		Utilisateur user1  = utilisateurDao.selectByNoUtilisateur(u.getNoUtilisateur());
		System.out.println("Sélection de l'utilisateur par son pseudo  : " + u.toString() );
	

		//Modification d'un utilisateur
		//TODO...
		System.out.println("Modification d'un utilisateur : " );
		System.out.println("utilisateur avant modification : "  + u.toString());
		((Utilisateur) u).setNom("modification reussi");
		((Utilisateur) u).setPseudo("modification reussi");
		
		utilisateurDao.update(u);
		System.out.println("Article après modification  : " + u.toString() );
		
		
		//Suppression d'un utilisateur
		//TODO...
		System.out.println("Suppression de l'utilisateur : " + u.toString());
		utilisateurDao.delete(u.getNoUtilisateur());
		List<Utilisateur>liste =new ArrayList<Utilisateur>();
		liste = utilisateurDao.selectAll();
		System.out.println("Liste des articles après suppression : " + liste.toString() );
		System.out.println("Liste des articles après suppression : "  );
		StringBuffer sb = new StringBuffer();
		    sb.append("no utilisateur");
			sb.append(u.getNoUtilisateur());
			sb.append(", pseudo=");
			sb.append(u.getPseudo()).append("]\n");
		
		System.out.println(sb.toString());
		System.out.println("---------------------------------------------------------------");

	} catch (DALException e) {
		e.printStackTrace();
	}


	}

}


	
	


