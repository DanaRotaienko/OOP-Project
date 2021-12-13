package Items;

import java.text.DecimalFormat;

import Users.Manager;
import Users.User;

public class BuyMorePayLessItem extends Item {
	
	private int changedAmount;

	public BuyMorePayLessItem(String name, double priceForOne) {
		super(name, priceForOne);
		this.changedAmount = 1;
	}

	public void setChangedAmount(User user, int changedAmount) {
		if (user instanceof Manager) {
			this.changedAmount = changedAmount;
		}
	}
	
	public double calculatePrice(int amount) {	
		if (amount < 11) {
			System.out.println(Math.round(amount/changedAmount));
			return super.calculatePrice(Math.round(amount/changedAmount));
		}
		return super.calculatePrice(amount);
	}
	
	public void printInfo() {	
		System.out.println("Name: " + super.getName() + ", Price per item: " + super.getPriceForOne() + " €, Price for all: " + Double.parseDouble(new DecimalFormat("##.##").format(super.getPriceForAll())) + " €, Amount: " + super.getAmount());
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}



	