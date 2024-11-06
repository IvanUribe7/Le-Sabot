package jeu;

import Cartes.*;

public class Joueur {

	private String nom;
	private MainJoueur mainJoueur;
	private ZoneDeJeu zoneDeJeu;
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
        this.nom = nom;
        this.mainJoueur = new MainJoueur();
        this.zoneDeJeu = zoneDeJeu; // Initialize the zoneDeJeu
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
	
	
	public int donnerKmParcourus() {
        return zoneDeJeu.donnerKmParcourus(); 
    }
	
	public void deposer(Cartes carte) {
	   zoneDeJeu.deposer(carte);
	}
	
	public boolean estDepotAutorise(Cartes carte) {
	    return zoneDeJeu.estDepotAutorise(carte);
	}



}
