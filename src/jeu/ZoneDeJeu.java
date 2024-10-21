package jeu;
import java.util.List;
import Cartes.*;

public class ZoneDeJeu {
	
	List<Cartes> pileLimitesEtFin;
	List<Cartes> pileDiteDeBataille;
	List<Cartes> pileDeBornes;
	
	public List<Cartes> getPileLimitesEtFin() {
		return pileLimitesEtFin;
	}

	public List<Cartes> getPileDiteDeBataille() {
		return pileDiteDeBataille;
	}

	public List<Cartes> getPileDeBornes() {
		return pileDeBornes;
	}

	public ZoneDeJeu(List<Cartes> pileLimitesEtFin, List<Cartes> pileDiteDeBataille, List<Cartes> pileDeBornes) {
		this.pileLimitesEtFin = pileLimitesEtFin;
		this.pileDiteDeBataille = pileDiteDeBataille;
		this.pileDeBornes = pileDeBornes;
	}

	public int donnerLimitationVitesse() {
		
		if(pileLimitesEtFin.isEmpty() || pileLimitesEtFin.get(pileLimitesEtFin.size() - 1) instanceof FinLimite) {
			return 200;
		}else {
			return 50;
		}
		
	}
	
	public int donnerKmParcourus() {
	    int totalKm = 0;
	    for (Cartes carte : pileDeBornes) {
	        if (carte instanceof Borne) {
	            totalKm += ((Borne) carte).getKm();
	        }
	    }
	    return totalKm;
	}


	public void deposer(Cartes carte) {
	    if (carte instanceof Borne) {
	        
	        pileDeBornes.add(carte);
	        
	    } else if (carte instanceof DebutLimite|| carte instanceof FinLimite) {

	        pileLimitesEtFin.add(carte);

	    }else if (carte instanceof Bataille) {

			pileDiteDeBataille.add(carte);

		} else {
	        throw new IllegalArgumentException("Unsupported card type for deposit.");
	    }

	}
	
	public boolean peutAvancer() {
	    return !pileDiteDeBataille.isEmpty() && pileDiteDeBataille.get(pileDiteDeBataille.size() - 1) instanceof Carte FEU_VERT;
	}
	
	public boolean estDepotFeuVertAutorise() {
	    if (pileDiteDeBataille.isEmpty()) {
	        return true; 
	    }

	    Cartes sommet = pileDiteDeBataille.get(pileDiteDeBataille.size() - 1);

	    return sommet instanceof Attaque && sommet.equals(Carte.FEU_ROUGE) ||
	           (sommet instanceof Parade && !sommet.equals(Carte.FEU_VERT));
	}



}
