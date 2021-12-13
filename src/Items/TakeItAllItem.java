package Items;

import java.text.DecimalFormat;

import Users.Manager;
import Users.User;

public class TakeItAllItem extends ItemWithDiscount {

	private int N;
	private double priceWithoutDiscount;
	
	public TakeItAllItem(String name, double priceForOne) {
		super(name, priceForOne);
		this.priceWithoutDiscount = super.getPriceForOne();
	}

	public void setN(int minAmount, User user) {
		if (user instanceof Manager) {
			this.N = minAmount;
		}
	}
	
	public void setDiscount(int discount, User user) {
		if (user instanceof Manager) {
			super.setDiscount(discount, user);
			super.setPriceForOne(super.getPriceForOne() - super.getPriceForOne() * discount / 100);
		}
	}
	
	public double calculatePrice(int amount) {
		if (amount >= N) {
			return super.calculatePrice(amount);
		} else {
			super.setPriceForOne(priceWithoutDiscount);
		}
		return super.calculatePrice(amount);
		
	}
	
	public void printInfo() {
		System.out.println("Name: " + super.getName() + ", Price per item: " + super.getPriceForOne() + " €, Price for all: " + Double.parseDouble(new DecimalFormat("##.##").format(super.getPriceForAll())) + " €, Amount" + super.getAmount());
	}

	@Override
	public String toString() {
		return "Name: " + super.getName() + ", Price for one: " + priceWithoutDiscount + " €, Discount for not less than " + N + " items: " + super.getDiscount();
	}
	
}
