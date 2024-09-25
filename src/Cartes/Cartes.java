package Cartes;

public abstract class Cartes {

	private static class Configuration extends Cartes {

		private int nbExemplaires;
		private Cartes carte;
		
		public Configuration(int nbExemplaires, Cartes carte) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Cartes getCarte() {
			return carte;
		}
			
	}

}
