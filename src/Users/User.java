package Users;

import StorePayableSection.Payable;

public class User implements Payable {

	private String name;
	private String surname;
	private int id;
	private String username;
	private String password;
	private String Address;
	private String phoneNumber;
	public static int nextId = 1;
	
	public User(String name, String surname, String username, String password, String address,
			String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = nextId++;
		this.username = username;
		this.password = password;
		Address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public User() {
		super();
	}
	
	public User(String name, String surname, String address, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		Address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean calculatePayment() {
		System.out.println("Payment succeeded");
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Surname: " + surname + ", Address: " + Address + ", Phone number: " + phoneNumber;
	}
	
	
	
	
	
}
