package jeu;
import java.util.List;
import Cartes.Cartes;

public class ZoneDeJeu {
	
	List<Cartes> pileLimites_Et_Fin;
	List<Cartes> pileDiteDeBataille;
	List<Cartes> pileDeBornes;
	
	public List<Cartes> getPileLimites_Et_Fin() {
		return pileLimites_Et_Fin;
	}

	public List<Cartes> getPileDiteDeBataille() {
		return pileDiteDeBataille;
	}

	public List<Cartes> getPileDeBornes() {
		return pileDeBornes;
	}

	public ZoneDeJeu(List<Cartes> pileLimites_Et_Fin, List<Cartes> pileDiteDeBataille, List<Cartes> pileDeBornes) {
		this.pileLimites_Et_Fin = pileLimites_Et_Fin;
		this.pileDiteDeBataille = pileDiteDeBataille;
		this.pileDeBornes = pileDeBornes;
	}

	

}
