package Cartes;

public class Borne extends Cartes {

	private int km ;
		
	public Borne(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}
	
	@Override
	 public String toString() {
	     return this.getKm() + "KM";
	 }

}
