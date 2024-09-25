package Cartes;

public class Parade extends Bataille {

	private Type type;
	
	public Parade(Type type) {
		super(type);
	}
	
	 @Override
	    public String toString() {
	        return "Parade: " + type.getParade();
	    }

}
