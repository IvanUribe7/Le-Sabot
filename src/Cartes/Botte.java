package Cartes;

public class Botte extends Probleme {

	private Type type;

    public Botte(Type type) {
        super(type);
    }

    @Override
    public String toString() {
        return "Botte: " + type.getBotte();
    }
	
}
