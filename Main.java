import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;
import java.text.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean bContinue = true;
		char testCase = 'A';
		int iCnt = 0;
		Driver[] drivers = new Driver[1];
		Scanner sc = null;
		
		try {
			File x = new File("C:\\\\Users\\\\Darshik Garach\\\\Dropbox\\\\Tyrone Aaron-116863\\\\2. Advanced Programming Concepts\\\\Task 7\\\\drivers.txt");
			sc = new Scanner(x);
			drivers = readDrivers(sc);
		}
		catch(FileNotFoundException e) {
			System.out.println("drivers.txt not found");
		}
		
		while(bContinue) {
			
			System.out.println("-------------------------------------------------------");
			System.out.println("What would you like to do?\n A) Place an Order\n B) Add a new Customer\n C) Add a new Restaurant\n D) End program\n(eg. enter A)");
			testCase = input.next().charAt(0);

			if(testCase == 'A') {
				writeInvoice(null);
			}
			else if(testCase == 'B') {
				createCustomer();
			}
			else if(testCase == 'C') {
				createRestaurant();
			}
			else if(testCase =='D') {
				bContinue = false;
			}
			else {
				System.out.println("Invalid input");
			}
			
		}//end while
		
	}
	
	public static Driver[] readDrivers(Scanner sc) {
		
		Driver[] drivers = new Driver[1];
		
		while(sc.hasNextLine()) {
			
			String textin = sc.nextLine();
			StringBuffer inText = new StringBuffer(textin);
			String name, location, strload;
			int load;
			
			try {
				name = textin.substring(0, textin.indexOf(','));
				inText = inText.replace(0, textin.indexOf(',')+2, "");
				textin = inText.toString();
				
				location = textin.substring(0, textin.indexOf(','));
				inText = inText.replace(0, textin.indexOf(',')+1, "");
				textin = inText.toString();
				
				textin = textin.substring(1, textin.length());
				load = Integer.parseInt(textin);
				
				Driver driver = new Driver(location, location, load);
				//System.out.println(driver);
				drivers = extendDriverArray(drivers, driver);
			}
			catch(Exception e) {
				System.out.println("A drivers name was invalid");
				System.out.println(e.getMessage());
			}
			
			
		}//end while sc.nextline()
		
		return drivers;
		
	}
	
	public static Driver[] extendDriverArray(Driver[] drivers, Driver driver) {
		
		//Create temp array to store all menu array values and create new menu array with length +1
		Driver[] arrayTemp = drivers.clone();
		int iCnt = drivers.length;
		drivers = new Driver[iCnt+1];
		
		//Copy everything from temp array into new menu array
		for(int i=0; i<arrayTemp.length; i++) {
			drivers[i] = arrayTemp[i];
		}
		
		drivers[iCnt] = driver;
		
		return drivers;
	}
	
	public static void writeInvoice(Order order) {
		
		try {
			//Formatter f = new Formatter("C:\\\\\\\\Users\\\\\\\\Darshik Garach\\\\\\\\Dropbox\\\\\\\\Tyrone Aaron-116863\\\\\\\\2. Advanced Programming Concepts\\\\\\\\Task 7\\\\\\\\invoice.txt");
			Formatter f = new Formatter("invoice.txt");
			f.format("%s", order);
			f.close();
		}
		catch(Exception e) {
			System.out.println("Failed to make invoice");
		}
	}
	
 	public static void createCustomer() {
		
 		try {
 			Scanner input = new Scanner(System.in);
 			String name, location, contact_number, address, email;
 			
 			System.out.println("\nEnter the Name of the customer:");
 			name = input.nextLine();
 			
 			System.out.println("\nEnter the Location(city) of the customer:");
 			location = input.nextLine();
 			
 			System.out.println("\nEnter the Contact Number of the customer:");
 			contact_number = input.nextLine();
 			
 			System.out.println("\nEnter the Address of the customer:");
 			address = input.nextLine();
 			
 			System.out.println("\nEnter the email of the customer:");
 			email = input.nextLine();
 			
 			Customer cust = new Customer(name, location, contact_number, address, email);
 			
 			System.out.println("You have addded\n\n" + cust + "\nto the database");
 		}
 		catch(Exception e) {
 			System.out.println("Customer cannot be added to database");
 			System.out.println(e.getMessage());
 		}
		
	}

	public static void createRestaurant() {
		
		//Create variables
		Scanner input = new Scanner(System.in);
		String name, location, contact_number, mealname;
		double price;
		Meal[] menu = new Meal[0];
		boolean bContinue = true;
		
		try {
			System.out.println("\nEnter the Name of the restaurant:");
			name = input.nextLine();
			
			System.out.println("\nEnter the Location(city) of the restaurant:");
			location = input.nextLine();

			System.out.println("\nEnter the Contact Number of the restaurant:");
			contact_number = input.nextLine();
			
			/*
			System.out.println("Please enter the name of menu item (item " + String.valueOf(menu.length) + ")\nEnter ** to end menu input");
			mealname = input.nextLine();
			*/
			while(bContinue) {
				
				System.out.println("Please enter the name of menu item (item " + String.valueOf(menu.length) + ")\nEnter ** to end menu input");
				mealname = input.nextLine();
				
				if(mealname.indexOf('*') == 0) {
					
					bContinue = false;
				}
				else {
					
					System.out.println("Please enter the price of this item (enter only the number eg 54.99)");
					price = Double.parseDouble(input.nextLine());
					
					Meal meal = new Meal(mealname, price);
					
					menu = extendMenuArray(menu, meal);
				}
				
				
			}
			
			Restaurant rest = new Restaurant(name, location, contact_number, menu);
			
			System.out.println("You have addded\n\n" + rest + "\nto the database");
		}
		catch(Exception e) {
			System.out.println("Customer cannot be added to database");
 			System.out.println(e.getMessage());
		}
		
		
	}
	
	//Extend the menu array
	public static Meal[] extendMenuArray(Meal[] menu, Meal meal) {
		
		//Create temp array to store all menu array values and create new menu array with length +1
		Meal[] arrayTemp = menu.clone();
		int iCnt = menu.length;
		menu = new Meal[iCnt+1];
		
		//Copy everything from temp array into new menu array
		for(int i=0; i<arrayTemp.length; i++) {
			menu[i] = arrayTemp[i];
		}
		
		menu[iCnt] = meal;
		
		return menu;
		
	}
	
	public static Driver smallestLoad(Driver[] drivers, Customer customer, Restaurant restaurant) {
		
		//Create and initialize variables
		Driver smallestLoadDriver = drivers[0];
		boolean bfound = false;
		
		//loop through the drivers array to find a driver with the smallest load in the customer's area
		for(int i=0; i<drivers.length; i++) {
			
			if((restaurant.getLocation() == drivers[i].getLocation()) && (customer.getLocation() == drivers[i].getLocation())) {
				
				bfound = true;
				
				if(drivers[i].getLoad() < smallestLoadDriver.getLoad()) {
					smallestLoadDriver = drivers[i];
				}
			}
		}//end for loop
		
		//If no driver is found within the customer's area null is returned
		if(bfound) {
			return smallestLoadDriver;
		}
		else {
			return null;
		}
		
	}
	
}
