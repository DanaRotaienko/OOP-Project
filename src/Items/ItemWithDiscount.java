package Items;

import java.text.DecimalFormat;

import Users.Manager;
import Users.User;

public class ItemWithDiscount extends Item {
	
	private int discount;

	public ItemWithDiscount(String name, double priceForOne) {
		super(name, priceForOne);
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount, User user) {
		if (user instanceof Manager) {
			this.discount = discount;
			super.setPriceForOne(super.getPriceForOne() - super.getPriceForOne() * discount / 100);
		}
	}
	
	public void printInfo() {
		System.out.println("ID: " + super.getId() + "Name: " + super.getName() + ", Price per item: " + super.getPriceForOne() + " €, Price for all: " + Double.parseDouble(new DecimalFormat("##.##").format(super.getPriceForAll())) + " €, Amount: " + super.getAmount() + ", Discount: " + this.discount);
	}

	@Override
	public String toString() {
		return super.toString() + ", Discount: " + discount;
	}
	
}
