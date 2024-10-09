package jeu;

public class Joueur {
	
	

	private String nom;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
    public boolean equalsJ(Joueur joueur) {
        return nom.equals(joueur.nom);
    }
	
	@Override
    public String toString() {
        return nom;
    }

}
