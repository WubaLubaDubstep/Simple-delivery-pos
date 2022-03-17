public class Driver extends User{

	private int load;
	
	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}

	public Driver(String name, String location, int load) {
		
		super(name, location);
		this.load = load;
	}
	
	public String toString() {
		
		String output = "";
		
		output += "Name: " + super.getName() + "\n" + "Location: " + super.getLocation() + "\n" + "load: " + String.valueOf(load) + "\n";
		
		return output;
	}
}
