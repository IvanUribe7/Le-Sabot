package Cartes;

public class Parade extends Bataille {

	private Type type;
	
	public Parade(Type type) {
		super(type);
		this.type = type;
	}
	
	 @Override
	 public String toString() {
	     return type.getParade();
	 }

}
