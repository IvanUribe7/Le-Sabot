package Cartes;

public class JeuDeCartes {
	
	private Configuration[] configuration ;
	
	public JeuDeCartes() {
		this.configuration = new Configuration[19]; // Initialisation du tableau avec 19 éléments
	}
	
	

	private class Configuration {

		private int nbExemplaires;
		private Cartes carte;
		
		public Configuration(Cartes carte,int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		public Cartes getCarte() {
			return carte;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
