package testsFonctionnels;

import Cartes.*;

public class TestMethodeEquals {

	public static void main(String[] args) {

		Cartes carte25Km = new Borne(25);
		Cartes carteFeuRouge = new Attaque(Type.FEU);
		Cartes carteFeuVert = new Parade(Type.FEU);
		
		System.out.println("Deux cartes de 25km sont identiques ?" + carte25Km.equal(carte25Km));
		System.out.println("Deux cartes de feux rouge sont identiques ?" + carteFeuRouge.equal(carteFeuRouge));
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ?" + carteFeuVert.equal(carteFeuRouge));

	}

}

