/**
 * 
 */
package testsFonctionnels;
import Cartes.*;
/**
 * 
 */

public class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        Cartes[] cartes = jeu.donnerCartes();
        System.out.println("JEU:" + jeu.affichageJeuDeCartes());
        
        if (!jeu.checkCount()) {
            System.out.println("Erreur de nombre");
        }else {
        	System.out.println("donnerCarte est:" + jeu.checkCount() + "\n");
        }
        
        for(int i = 0 ; i < cartes.length; i++)
        	System.out.println(cartes[i]);
        
    }
}

