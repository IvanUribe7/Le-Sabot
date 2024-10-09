package jeu;
import Cartes.*;
import utils.*;
import java.util.Arrays;
import java.util.List;

public class Jeu {
	
	private Sabot sabot;

	public Jeu(Sabot sabot) {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Cartes[] cartes = jeuDeCartes.donnerCartes();
        List<Cartes> listeCartes = Arrays.asList(cartes);
        listeCartes = GestionCartes.melanger(listeCartes);
        Cartes[] cartesMelangees = listeCartes.toArray(new Cartes[0]);
        this.sabot = new Sabot(cartesMelangees);
    }
	
	public Sabot getSabot() {
		return sabot;
	}

}
