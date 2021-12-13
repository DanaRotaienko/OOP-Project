package Users;

public class EmployeeCustomer extends Customer {

	private double salary;
	private Cashier cashier;
	private int id;
	private static int nextId = 1;
	private int points;
	private double salaryWithBonus;

	public EmployeeCustomer(Cashier cashier) {
		super();
		this.cashier = cashier;
		super.setName(cashier.getName());
		super.setSurname(cashier.getSurname());
		super.setAddress(cashier.getAddress());
		super.setPhoneNumber(cashier.getPhoneNumber());
		this.salary = cashier.getBaseSalary();
		this.id = nextId++;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public double getSalaryWithBonus() {
		return this.salaryWithBonus;
	}
	
	public Cashier getCashier() {
		return cashier;
	}

	public void calculatePoints() {
		this.salaryWithBonus = salary + points/2;;
	}
	
	public void printInfo() {
		System.out.println("Name: " + super.getName() + ", Surname: " + super.getSurname() + ", Address: " + super.getAddress() + ", Phone number: " + super.getPhoneNumber() + ", Salary: " + this.salary);
	}
	
	@Override
	public String toString() {
		return "Employee customer || ID: " + id + ", " + super.toString() + ", Bonus points: " + points + ", Salary: " + salary + " €, Salary with bonus: " + salaryWithBonus + " €";
	}
	

	
	
	
	
}
