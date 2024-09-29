package testsFonctionnels;
import jeu.*;
import Cartes.*;

public class TestSabot {

	public static void main(String[] args) {
        Cartes[] cartes = {
            new Borne(200),
            new Attaque(Type.FEU),
            new Parade(Type.FEU),
            new Botte(Type.FEU)
        };

         Sabot sabot = new Sabot(cartes);

         Cartes carte;  // Declare the variable here
         while ((carte = sabot.piocher()) != null) {
             System.out.println("je pioche " + carte.toString());
         } 
        System.out.println("Cartes restantes dans le sabot :");
        
        }
 }




