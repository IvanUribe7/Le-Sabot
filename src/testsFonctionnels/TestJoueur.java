package testsFonctionnels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Cartes.*;
import jeu.Joueur;
import jeu.ZoneDeJeu;

public class TestJoueur {

    private ZoneDeJeu zoneDeJeu;
    private Joueur joueur;

    @BeforeEach
    public void setUp() {
        // Initialize the ZoneDeJeu and Joueur before each test
        zoneDeJeu = new ZoneDeJeu(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        joueur = new Joueur("TestPlayer", zoneDeJeu);
    }

    @Test
    public void testDeposerBorneCards() {
        // Test depositing 25km, 50km, and 75km cards
        Borne borne25 = new Borne(25);
        Borne borne50 = new Borne(50);
        Borne borne75 = new Borne(75);
        
        System.out.println("Deposer carte 25 km");
        joueur.deposer(borne25);
        
        System.out.println("Deposer carte 50 km");
        joueur.deposer(borne50);
        
        System.out.println("Deposer carte 75 km");
        joueur.deposer(borne75);
        
        // Verify the total kilometers
        int totalKm = joueur.donnerKmParcourus();
        System.out.println("Total des bornes : " + totalKm);
        assertEquals(150, totalKm, "The total kilometers should be 150");
    }

    @Test
    public void testDeposerLimitationCards() {
        // Test depositing Limitation and FinLimite cards
        Limite limitation = new Limite();
        FinLimite finLimite = new FinLimite();

        // Initially, the speed limit should be 200
        int initialLimit = zoneDeJeu.donnerLimitationVitesse();
        System.out.println("Limite : " + initialLimit);
        assertEquals(200, initialLimit, "The initial speed limit should be 200");

        // Deposit a Limitation card
        joueur.deposer(limitation);
        int limitAfterLimitation = zoneDeJeu.donnerLimitationVitesse();
        System.out.println("Limite : " + limitAfterLimitation);
        assertEquals(50, limitAfterLimitation, "The speed limit should be 50 after depositing a Limitation card");

        // Deposit a FinLimite card
        joueur.deposer(finLimite);
        int limitAfterFinLimite = zoneDeJeu.donnerLimitationVitesse();
        System.out.println("Limite : " + limitAfterFinLimite);
        assertEquals(200, limitAfterFinLimite, "The speed limit should be 200 after depositing a FinLimite card");
    }

}
