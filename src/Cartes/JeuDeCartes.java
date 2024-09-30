package Cartes;

public class JeuDeCartes {
	
	private Configuration[] configuration ;
	
    public JeuDeCartes() {
        this.configuration = new Configuration[]{
        		new Configuration(new Borne(25), 10),
                new Configuration(new Borne(50), 10),
                new Configuration(new Borne(75), 10),
                new Configuration(new Borne(100), 12),
                new Configuration(new Borne(200), 4),
                new Configuration(new Attaque(Type.FEU), 5),
                new Configuration(new Parade(Type.FEU), 14),
                new Configuration(new Botte(Type.FEU), 1),
                new Configuration(new Attaque(Type.ESSENCE), 3),
                new Configuration(new Parade(Type.ESSENCE), 6),
                new Configuration(new Botte(Type.ESSENCE), 1),
                new Configuration(new Attaque(Type.CREVAISON), 3),
                new Configuration(new Parade(Type.CREVAISON), 6),
                new Configuration(new Botte(Type.CREVAISON), 1),
                new Configuration(new Attaque(Type.ACCIDENT), 3),
                new Configuration(new Parade(Type.ACCIDENT), 6),
                new Configuration(new Botte(Type.ACCIDENT), 1),
                new Configuration(new DebutLimite(), 4),
                new Configuration(new FinLimite(), 6)
        };
    }

    public String affichageJeuDeCartes() {
    		
    		StringBuilder sb = new StringBuilder();

    	    for (Configuration config : this.configuration) {
    	    	
    	        Object carte = config.getCarte(); 
    	        
    	        int nbExemplaires = config.getNbExemplaires(); 

    	        sb.append(nbExemplaires + " " + carte.toString() + "\n");
    	        	
    	      }
    	    
    	    System.out.println(sb.toString());
    	    return "\n";

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
		JeuDeCartes jdC = new JeuDeCartes();
		jdC.affichageJeuDeCartes();

	}	
	
    public Cartes[] donnerCartes() {
    	int i = 0;
    	Cartes[] cartes = new Cartes[106];   
    	JeuDeCartes jDC = new JeuDeCartes();
    	for (Configuration config : jDC.configuration) {
            int nbExemplaires = config.getNbExemplaires(); 
            
            for (int j = 0; j < nbExemplaires;j++, i++) {
            	
            	cartes[i] = config.getCarte();
            	
            }    		
            
    	}
    	
    	return cartes;
    	
    }
    
    
	public boolean checkCount() {
		Cartes[] cartes = donnerCartes();
        return cartes.length == 106;
    }
	
	
}
