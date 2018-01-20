package lambda3;

import java.util.UUID;

public class AcountableAsset {
	String id;
	float price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public AcountableAsset(Vehicle v)
	{
		price = (v.getBrand().equals(Brand.Fiat) ? 10 : 50);
		id = v.getBrand() + "__" + UUID.randomUUID().toString();
	}
	
	@Override
	public String toString() {
		return "[" + id + "][" + price + "]";
	}
	
}
