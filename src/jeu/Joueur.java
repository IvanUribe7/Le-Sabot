package jeu;

import Cartes.Cartes;

public class Joueur {

	private String nom;
	private MainJoueur mainJoueur;

    public Joueur(String nom) {
        this.nom = nom;
        this.mainJoueur = new MainJoueur();
    }

    public MainJoueur getMainJoueur() {
        return mainJoueur;
    }

    public void donner(Cartes carte) {
        mainJoueur.prendre(carte);
    }
	
    public boolean equalsJ(Joueur joueur) {
        return nom.equals(joueur.nom);
    }
	
	@Override
    public String toString() {
        return nom;
    }
	
	public Cartes prendreCarte(Sabot sabot) {
	    if (sabot.estVide()) {
	        return null;
	    }
	    Cartes carte = sabot.piocher();
	    this.donner(carte);
	    return carte;
	}

}
