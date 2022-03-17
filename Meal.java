public class Meal {
	
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Meal(String name, double price) {
		
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		
		String output = "";
		
		output = name + " (R" + String.valueOf(price) + ")\n";
		
		return output;
	}

}
