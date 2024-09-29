package Cartes;

public class Attaque extends Bataille {
	
	private Type type;

	public Attaque(Type type) {
		super(type);
		this.type = type;
	}

	@Override
    public String toString() {
        return type.getAttaque();
    }

}
