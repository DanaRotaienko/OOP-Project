package Users;

import Items.Item;
import Items.ItemWithDiscount;
import StorePayableSection.Payable;

public class Manager extends User {

	private String internalPhoneNumber;
	private String PIN;

	public Manager(String name, String surname, String username, String password, String address, String phoneNumber,
			String internalPhoneNumber, String PIN) {
		super(name, surname, username, password, address, phoneNumber);
		this.internalPhoneNumber = internalPhoneNumber;
		PIN = PIN;
	}

	@Override
	public String toString() {
		return "Manager || Internal phone number=" + internalPhoneNumber + ", PIN: " + PIN + ", " + super.toString();
	}
	
	
	
}
