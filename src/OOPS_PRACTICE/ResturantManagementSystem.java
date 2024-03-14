package OOPS_PRACTICE;

// Concept of Abstraction
abstract class menu_item{
	protected String name;
	protected double price;
	
	// parameterized constructor to initialize menu_item
	public menu_item(String name, double price){
		this.name = name;  // for this particular instance of the menu_item assign the name provided in parameter
		this.price = price;   // for this particular instance of the menu_item assign the price provided in parameter  
	}
	
	// abstract method for calculating the cost of the menu_item
	public abstract double calculate_cost();
}

// Concept of Inheritance
// actual blueprint of a starter which is a menu_item 
class Starters extends menu_item {
	
	// constructor for Starters which will be used to call superclass constructor(menu_item)
	public Starters(String name, double price) {
		super(name, price);
	}
	public double calculate_cost() {
		
		// Starter items have 15% discount;
		return price-(0.15*price);
	}
}

// actual blueprint of a Maincourse which is a menu_item 
class Maincourse extends menu_item{
	
	// constructor for MainCourse which will be used to call superclass constructor(menu_item)
	public Maincourse(String name, double price) {
		super(name, price);
	}
	
	// Maincourse items have no discount hence we only return the price;
	public double calculate_cost() {
		return price;
	}
}

// actual blueprint of a Dessert which is also a menu_item
class Dessert extends menu_item{
	
	// constructor for Dessert which will be used to call superclass constructor(menu_item)
	public Dessert(String name, double price) {
		super(name, price);
	}
	
	// Dessert items have 5% discount
	public double calculate_cost() {
		return price-(0.05*price);
	}
}

// Concept of Encapsulation
class Order {
	private menu_item[] items;
	
	public Order(menu_item[] items) {
		this.items = items;
	}
	
	public double calculate_total() {
		double totalPrice = 0.0;
		for(int i = 0 ; i < items.length; i++) {
			totalPrice += items[i].calculate_cost(); /* this demonstrates 
			Polymorphism as different menu_items have different 
			calculate_cost functions*/
		}
		return totalPrice;
	}
}

// Main Class where the execution begins
public final class ResturantManagementSystem {
public static void main(String[] args) {
	
	 	// manually creating some menu_item objects
		menu_item Starter = new Starters("Salad", 59.99);
		menu_item Maincourse = new Maincourse("Biriyani", 99.99);
		menu_item Dessert = new Dessert("Ice-Cream", 65.00);
		
		menu_item[] items = {Starter, Maincourse, Dessert};
		Order orders = new Order(items);
		
		double total_cost = orders.calculate_total();
		System.out.println("Total Cost of the Order: Rs."+Math.round(total_cost));
	}
}
