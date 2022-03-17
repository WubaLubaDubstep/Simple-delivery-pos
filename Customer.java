public class Customer extends User {

	private String contact_number;
	private String address;
	private String email;
	
	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String name, String location, String contact_number, String address, String email) {
		
		super(name, location);
		this.contact_number = contact_number;
		this.address = address;
		this.email = email;
	}
	
	public String toString() {
		 
		String output = "";
		
		output += "Customer: " + super.getName() + "\nEmail: " + email + "\nPhone number: " + contact_number + "\nLocation: " + super.getLocation() + "\n";
		
		return output;
	}
}
