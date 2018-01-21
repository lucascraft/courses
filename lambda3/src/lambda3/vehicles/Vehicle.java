
package lambda3.vehicles;

public class Vehicle 
{
	
	private int nbWheels;
	private int nbSeats;
	private Brand brand;
	private String kind;
	private String mk;
	
	public int getNbWheels() {
		return nbWheels;
	}
	
	public void setNbWheels(int nbWheels) {
		this.nbWheels = nbWheels;
	}
	
	public int getNbSeats() {
		return nbSeats;
	}
	
	public void setNbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getMk() {
		return mk;
	}
	
	public void setMk(String mk) {
		this.mk = mk;
	}
	
	public Vehicle(String _brand, String kind, String mk, Object wheel)
	{
		this.brand = Brand.valueOf(_brand);
		this.kind = kind;
		this.mk = mk;
		this.nbWheels = ((Integer)wheel).intValue();
	}
	
	@Override
	public String toString() {
		return "[" + brand.name() + "][" + kind + "][" + mk + "][" + nbWheels + " wheels]";
	}
}
