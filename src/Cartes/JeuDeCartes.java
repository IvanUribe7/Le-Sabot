package Cartes;

public class JeuDeCartes {
	
	private Configuration[] configuration ;
	
    public JeuDeCartes() {
        this.configuration = new Configuration[]{
                new Configuration(new Cartes("25KM"), 10),
                new Configuration(new Cartes("50KM"), 10),
                new Configuration(new Cartes("75KM"), 10),
                new Configuration(new Cartes("100KM"), 12),
                new Configuration(new Cartes("200KM"), 4),
                new Configuration(new Cartes("Feu Vert"), 14),
                new Configuration(new Cartes("Fin Limite"), 6),
                new Configuration(new Cartes("Bidon d'essence"), 6),
                new Configuration(new Cartes("Roue de secours"), 6),
                new Configuration(new Cartes("Réparation"), 6),
                new Configuration(new Cartes("Feu Rouge"), 5),
                new Configuration(new Cartes("Limite 50"), 4),
                new Configuration(new Cartes("Panne d'essence"), 3),
                new Configuration(new Cartes("Crevaison"), 3),
                new Configuration(new Cartes("Accident"), 3),
                new Configuration(new Cartes("Prioritaire"), 1),
                new Configuration(new Cartes("Citerne"), 1),
                new Configuration(new Cartes("Increvable"), 1),
                new Configuration(new Cartes("As du volant"), 1)
        };
    }

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder("JEU:\n");
        for (Configuration config : configuration) {
            sb.append(config.getNbExemplaires())
                    .append(" ")
                    .append(config.getCarte())
                    .append("\n");
        }
        return sb.toString();
    }
	
	

	private static class Configuration {

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
