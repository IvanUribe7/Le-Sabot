package testsFonctionnels;
import jeu.*;

import java.util.Iterator;

import Cartes.*;

public class TestSabot {

	public static void main(String[] args) {
        Cartes[] cartes = {
            new Borne(200),
            new Attaque(Type.FEU),
            new Parade(Type.FEU),
            new Botte(Type.FEU)
        };
        
        System.out.println("~~~~~~~ Test Pioche sans Iterator et Remove ~~~~~~~ \n");

         Sabot sabot = new Sabot(cartes);

         Cartes carte;  // Declare the variable here
         while ((carte = sabot.piocher()) != null) {
             System.out.println("je pioche " + carte.toString());
         } 
         
         System.out.println("\n~~~~~~~ Fin Test: Toutes les cartes ont été piochées ~~~~~~~\n");
         
         System.out.println("~~~~~~~ Test Pioche avec Iterator et Remove ~~~~~~~ \n");
         
         Cartes[] cartes2 = {
                 new Borne(200),
                 new Attaque(Type.FEU),
                 new Parade(Type.FEU),
                 new Botte(Type.FEU)
             };
         
         sabot = new Sabot(cartes2);
         
         Iterator<Cartes> it = sabot.iterator();
         Cartes carteIteree;
         while (it.hasNext()) {
        	 
        	 carteIteree = it.next();
        	 System.out.println("je pioche " + carteIteree.toString());
             it.remove();
             
         }
         System.out.println("Le sabot est vide\n");
         System.out.println("\n~~~~~~~ Fin Test: Toutes les cartes ont été piochées ~~~~~~~\n");
         
	     System.out.println("~~~~~~~ Test Pioche avec Iterator , Remove et Exceptions ~~~~~~~ \n");
	         
	         Cartes[] cartes3 = {
	                 new Borne(200),
	                 new Attaque(Type.FEU),
	                 new Parade(Type.FEU),
	                 new Botte(Type.FEU)
	             };
	         
	         sabot = new Sabot(cartes3);
	         
	         Iterator<Cartes> it2 = sabot.iterator();
	         Cartes carteIteree2;
	         while (it.hasNext()) {
	        	 
	        	 carteIteree2 = it2.next();
	        	 System.out.println("je pioche " + carteIteree2.toString());
	             it.remove();
	             
	             try {
	            	 carteIteree2 = sabot.piocher();
	                 System.out.println("je pioche " + carteIteree2.toString());
	             } catch (Exception e) {
	                 System.out.println("Erreur: " + e.getMessage());
	             }

	             try {
	                 sabot.ajouterCarte(new Botte(Type.ACCIDENT));                
	             } catch (Exception e) {
	                 System.out.println("Erreur lors de l'ajout d'une carte: " + e.getMessage());
	             }
	             
	         }
	         
	      System.out.println("Le sabot est vide\n");
	      System.out.println("\n~~~~~~~ Fin Test: Toutes les cartes ont été piochées ~~~~~~~\n");

         
         
	}
 }




