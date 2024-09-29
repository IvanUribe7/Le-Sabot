package Cartes;

public class Botte extends Probleme {

	private Type type;

    public Botte(Type type) {
        super(type);
        this.type = type;
    }

    @Override
    public String toString() {
        return type.getBotte();
    }
	
}
