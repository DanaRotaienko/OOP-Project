package Users;

public class Cashier extends User {

	private String internalPhoneNumber;
	private double baseSalary;
	private int hoursOfWork;
	private long worked;
	private int bonus = 0;
	
	public Cashier() {
		super();
	}

	public Cashier(String name, String surname, String username, String password, String address, String phoneNumber,
			String internalPhoneNumber, double baseSalary, int hoursOfWork) {
		super(name, surname, username, password, address, phoneNumber);
		this.internalPhoneNumber = internalPhoneNumber;
		this.baseSalary = baseSalary;
		this.hoursOfWork = hoursOfWork;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}

	public void WorkingHours(long hours) {
		this.worked = hours;
	}
	
	public int BonusForWorkingHours() {
		worked -= hoursOfWork;
		if (worked > 0) {
			bonus = (int) worked * 10;
		} 
		return bonus;
	}

	@Override
	public String toString() {
		return "Cashier || " + ", " + super.toString() + " ,Internal phone number: " + internalPhoneNumber + ", Salary: " + baseSalary + " €";
	} 
	
	
	
}
