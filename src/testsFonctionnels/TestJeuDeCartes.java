/**
 * 
 */
package testsFonctionnels;
import Cartes.JeuDeCartes;
/**
 * 
 */

public class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        
        System.out.println("JEU:\n" + jeu.affichageJeuDeCartes());
        
        if (!jeu.checkCount()) {
            System.out.println("Erreur de nombre");
        }
    }
}
