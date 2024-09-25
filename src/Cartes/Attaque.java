package Cartes;

public class Attaque extends Bataille {
	
	private Type type;

	public Attaque(Type type) {
		super(type);
	}

	@Override
    public String toString() {
        return "Attaque: " + type.getAttaque();
    }
	
}
