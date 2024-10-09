package Cartes;

public interface Carte {
	
	Cartes PRIORITAIRE = new Botte(Type.FEU);
    Cartes FEU_ROUGE = new Attaque(Type.FEU);
    Cartes FEU_VERT = new Parade(Type.FEU);

}