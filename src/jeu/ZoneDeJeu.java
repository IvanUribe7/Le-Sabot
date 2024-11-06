package jeu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Cartes.*;

public class ZoneDeJeu {
	
	List<Cartes> pileLimitesEtFin;
	List<Cartes> pileDiteDeBataille;
	List<Cartes> pileDeBornes;
	private Set<Botte> bottes = new HashSet<>();
	
	public List<Cartes> getPileLimitesEtFin() {
		return pileLimitesEtFin;
	}

	public List<Cartes> getPileDiteDeBataille() {
		return pileDiteDeBataille;
	}

	public List<Cartes> getPileDeBornes() {
		return pileDeBornes;
	}
	
	public void ajouterBotte(Botte botte) {
        bottes.add(botte);  
    }

    public boolean contientBotte(Botte botte) {
        return bottes.contains(botte);  
    }

    public Set<Botte> getBottes() {
        return bottes; 
    }

	public ZoneDeJeu() {
		this.pileLimitesEtFin = new ArrayList<>();
        this.pileDiteDeBataille = new ArrayList<>();
        this.pileDeBornes = new ArrayList<>();
	}

	public int donnerLimitationVitesse() {
		if (estPrioritaire()) {
            return 0;  
        }else if(pileLimitesEtFin.isEmpty() || pileLimitesEtFin.get(pileLimitesEtFin.size() - 1) instanceof FinLimite) {
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

	    } else if (carte instanceof Botte) {
	        // Ajoute les cartes de type Botte à l'ensemble des bottes
	        bottes.add((Botte) carte); // On cast la carte en Botte car c'est ce type qui est attendu
	        System.out.println("Botte ajoutée : " + carte); // Optionnel : pour débogage
	        
	    } else {
	        throw new IllegalArgumentException("Unsupported card type for deposit.");
	    }

	}
	
	public boolean peutAvancer() {
	    // Vérifier si la pile de bataille est vide et si le joueur est prioritaire
	    if (pileDiteDeBataille.isEmpty() && estPrioritaire()) {
	        return true;
	    }

	    // Récupérer le sommet de la pile de bataille
	    Carte sommet = pileDiteDeBataille.isEmpty() ? null : (Carte) pileDiteDeBataille.get(pileDiteDeBataille.size() - 1);

	    // Vérifier si le sommet est un feu vert
	    if (sommet instanceof Parade && sommet.equals(Carte.FEU_VERT)) {
	        return true;
	    }

	    // Vérifier si le sommet est une parade et si le joueur est prioritaire
	    if (sommet instanceof Parade && estPrioritaire()) {
	        return true;
	    }

	    // Vérifier si le sommet est une attaque de type FEU et si le joueur est prioritaire
	    if (sommet instanceof Attaque && sommet.equals(Carte.FEU_ROUGE) && estPrioritaire()) {
	        return true;
	    }

	    // Vérifier si le sommet est une attaque d'un autre type et si le joueur possède une botte correspondante
	    if (sommet instanceof Attaque && !sommet.equals(Carte.FEU_ROUGE) && estPrioritaire()) {
	        Type typeSommet = ((Attaque) sommet).getType();
	        return bottes.contains(new Botte(typeSommet)); // Le joueur possède la botte correspondante
	    }

	    return false; // Si aucune des conditions n'est remplie, le joueur ne peut pas avancer
	}


	public boolean estDepotFeuVertAutorise() {
	    // Si la pile est vide, on peut déposer un Feu Vert
	    if (pileDiteDeBataille.isEmpty()) {
	        return true;
	    }

	    // Récupérer le sommet de la pile
	    Cartes sommet = pileDiteDeBataille.get(pileDiteDeBataille.size() - 1);

	    // Vérifier si le sommet est un Feu Rouge (Attaque de type FEU)
	    if (sommet instanceof Attaque && ((Attaque) sommet).getType() == Type.FEU) {
	        return true;
	    }

	    // Vérifier si le sommet est une Parade mais pas un Feu Vert
	    if (sommet instanceof Parade && ((Parade) sommet).getType() != Type.FEU) {
	        return true;
	    }

	    // Sinon, le dépôt n'est pas autorisé
	    return false;
	}

	public boolean estDepotBorneAutorise(Borne borne) {
	    if (!peutAvancer()) {
	        return false;
	    }

	    int limitationVitesse = donnerLimitationVitesse();
	    if (borne.getKm() > limitationVitesse) {
	        return false;
	    }

	    int totalKm = donnerKmParcourus();
	    if (totalKm + borne.getKm() > 1000) {
	        return false;
	    }

	    return true;
	}

	public boolean estDepotLimiteAutorise(Limite limite) {
	    
	    if (limite instanceof DebutLimite) {

	        return pileLimitesEtFin.isEmpty() || pileLimitesEtFin.get(pileLimitesEtFin.size() - 1) instanceof FinLimite;
	    }

	    if (limite instanceof FinLimite) {

	        return !pileLimitesEtFin.isEmpty() && pileLimitesEtFin.get(pileLimitesEtFin.size() - 1) instanceof DebutLimite;
	    }

	    return false;
	}
	
	public boolean estDepotBatailleAutorise(Bataille bataille) {
	    // Cas si c'est une Attaque
	    if (bataille instanceof Attaque) {
	        // On peut déposer une Attaque si on n'est pas bloqué
	        return peutAvancer();
	    }

	    // Cas si c'est une Parade
	    if (bataille instanceof Parade) {
	        Parade parade = (Parade) bataille;

	        // Cas du Feu Vert
	        if (parade.equals(Carte.FEU_VERT)) {
	            return pileDiteDeBataille.isEmpty() || // Si la pile est vide
	                   pileDiteDeBataille.get(pileDiteDeBataille.size() - 1).equals(Carte.FEU_ROUGE) || // Si le sommet est un Feu Rouge
	                   !(pileDiteDeBataille.get(pileDiteDeBataille.size() - 1).equals(Carte.FEU_VERT)); // Si le sommet n'est pas un Feu Vert
	        }

	        // Cas des autres Parades (non Feu Vert)
	        return !pileDiteDeBataille.isEmpty() &&
	               pileDiteDeBataille.get(pileDiteDeBataille.size() - 1) instanceof Attaque && // Le sommet est une Attaque
	               pileDiteDeBataille.get(pileDiteDeBataille.size() - 1).getClass().equals(bataille.getClass()); // Le sommet est du même type que la carte à déposer
	    }

	    // Si ce n'est ni une Attaque ni une Parade, on renvoie false
	    return false;
	}
	
	public boolean estDepotAutorise(Cartes carte) {
	    if (carte instanceof Borne) {
	        return estDepotBorneAutorise((Borne) carte);
	    } else if (carte instanceof Limite) {
	        return estDepotLimiteAutorise((Limite) carte);
	    } else if (carte instanceof Bataille) {
	        return estDepotBatailleAutorise((Bataille) carte);
	    } else {
	        return false;
	    }
	}

	public boolean estPrioritaire() {
	    for (Botte botte : bottes) {
	        if ((botte.toString()).equals("vehicule prioritaire")) {
	            return true;  
	        }
	    }
	    return false;  
	}

}
