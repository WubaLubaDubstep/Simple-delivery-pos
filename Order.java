public class Order {

	private int order_number;
	private Customer customer;
	private Restaurant restaurant;
	private Driver driver;
	private Meal[] order;
	private String special_instructions;
	private double total;
	
	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Meal[] getOrder() {
		return order;
	}

	public void setOrder(Meal[] order) {
		this.order = order;
	}

	public String getSpecial_instructions() {
		return special_instructions;
	}

	public void setSpecial_instructions(String special_instructions) {
		this.special_instructions = special_instructions;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public Order(int order_number, Customer customer, Restaurant restaurant, Driver driver, Meal[] order, String special_instructions, double total) {
		
		this.order_number = order_number;
		this.customer = customer;
		this.restaurant = restaurant;
		this.driver = driver;
		this.order = order;
		this.special_instructions = special_instructions;
		this.total = total;
	}
	
	public String toString() {
		
		String output = "";
		
		output += "Order Number: " + String.valueOf(order_number) + "\n";
		
		output += customer + "\n";
		
		output += "You have ordered the following from " + restaurant.getName() + " in " + restaurant.getLocation() + ":\n\n";
		
		for(int i=0; i<order.length; i++) {
			output += order[i];
		}
		output += "\n";
		
		if(special_instructions != null) {
			output += "Special instrucations: " + special_instructions + "\n";
		}
		
		output += "Total" + String.valueOf(total) + "\n";
		
		if(driver == null) {
			output += "Sorry! Our drivers are too far away from you to be able to deliver to your location";
		}
		else {
		
			output += driver.getLocation() + " is the nearest to the restaurant and so he will be delivering your order to you at:\n" + customer.getAddress() + "\n";
			
			output += "If you need to contact the restaurant, their number is " + restaurant.getContact_number();
			
		}
		
		return output;
	}
}