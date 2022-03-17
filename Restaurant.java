public class Restaurant extends User {
	
	private String contact_number;
	private Meal[] menu=null;
	
	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public Meal[] getMenu() {
		return menu;
	}

	public void setMenu(Meal[] menu) {
		this.menu = menu;
	}

	public Restaurant(String name, String location, String contact_number, Meal[] menu) {
		
		super(name, location);
		this.contact_number = contact_number;
		this.menu = menu;
	}
	
	public String toString() {
		
		String output = "";
		
		output += "Name: " + super.getName() + "\n" + "Location: " + super.getLocation() + "\n" + "Contact Number: " + contact_number + "\n\n" + "The menu is:\n";
		
		for(int i=0; i<menu.length; i++) {
			output += menu[i];
		}
		
		return output;
	}

}
