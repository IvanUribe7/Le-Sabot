package Cartes;

public abstract class Probleme extends Cartes {
	
	private Type type;
	
	public Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
