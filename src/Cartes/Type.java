package Cartes;

public enum Type {

    FEU("feuRouge", "feuVert", "vehicule prioritaire"),
    ESSENCE("panne essence", "essence", "citerne"),
    CREVAISON("crevaison", "roue de secours", "increvable"),
    ACCIDENT("accident", "reparations", "as du volant");
	
	private final String attaque;
	private final String parade;
	private final String botte;

	Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}


}
