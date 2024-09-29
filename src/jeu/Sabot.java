package jeu;

import java.util.Arrays;

import Cartes.*;

public class Sabot {

    private Cartes[] cartes;  
    private int nbCartes;   
    private int capaciteMax = 106;

    public Sabot(Cartes[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;  
    }
   
    public boolean estVide() {
        return this.nbCartes == 0;
    }
    
    public void ajouterCarte(Cartes carte) throws Exception {
        if (nbCartes > capaciteMax) {
            throw new Exception("Le sabot est plein.");
        }
        cartes[nbCartes] = carte;
        nbCartes++;
    }

}
