package jeu;
import java.util.ArrayList;
import java.util.List;
import Cartes.*;

public class MainJoueur {
	
	private List<Cartes> cartesEnMain;

    public MainJoueur() {
        this.cartesEnMain = new ArrayList<>();
    }

    public void prendre(Cartes carte) {
        this.cartesEnMain.add(carte);
    }

    public void jouer(Cartes carte) {
        assert this.cartesEnMain.contains(carte) : "La carte doit être présente dans la main";
        this.cartesEnMain.remove(carte);
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Cartes en main: ");
        for (Cartes carte : cartesEnMain) {
            sb.append(carte.toString()).append(", ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }


}
