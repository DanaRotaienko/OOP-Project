package Users;

public class LoyalCustomer extends Customer {

	private int id;
	private static int nextId = 1;
	private int points;
	private double bonusMoney;

	public LoyalCustomer(String name, String surname, String address, String phoneNumber) {
		super(name, surname, address, phoneNumber);
		this.id = nextId++;
	}
		
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public double getBonusMoney() {
		return this.bonusMoney;
	}

	public int getId() {
		return id;
	}
	
	public void calculatePoints() {
		this.bonusMoney = points / 10;
		super.getBasket().setBonusMoney(this.bonusMoney);
	}
	
	public void printInfo() {
		System.out.println("Name: " + super.getName() + ", Surname: " + super.getSurname()
			+ ", Address: " + super.getAddress() + 
			", Phone number: " + super.getPhoneNumber() );
	}

	@Override
	public String toString() {
		return "Loyal customer || ID: " + id + ", " + super.toString() + ", Bonus points: " + points;
	}
	
	
	
	
}
