package Users;

import StoreBaskets.StoreBasket;

public class Customer extends User {
	
	private StoreBasket basket;
	private int id;
	public static int nextId = 1;
	
	public Customer(String name, String surname, String address, String phoneNumber) {
		super(name, surname, address, phoneNumber);
		this.id = nextId++;
	}
	
	public Customer() {
		super();
		this.id = nextId++;
	}
	
	public StoreBasket getBasket() {
		return basket;
	}

	public int getId() {
		return id;
	}
	
	public double getBonusMoney() {
		return 0;
	}

	public void setBasket(StoreBasket basket) {
		this.basket = basket;
	}
	
	public void setPoints(int points) {
		
	}
	
	public void calculatePoints() {
		
	}

	public void printInfo() {
		System.out.println("Name: " + super.getName() + ", Surname: " + super.getSurname() + ", Address: " + super.getAddress() + ", Phone number: " + super.getPhoneNumber());
	}

	@Override
	public String toString() {
		return "Customer || ID: " + id + ", " + super.toString();
	}




	
	
}
