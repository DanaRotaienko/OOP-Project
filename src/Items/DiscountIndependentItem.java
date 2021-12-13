package Items;

import Users.Manager;
import Users.User;

public class DiscountIndependentItem extends ItemWithDiscount{
	
	private int discountIndependence;

	public DiscountIndependentItem(String name, double priceForOne) {
		super(name, priceForOne);
	}

	public void setDiscount(int discountIndependence, int discount, User user) {
		if (user instanceof Manager) {
			this.discountIndependence = discountIndependence + discount;
			super.setPriceForOne(super.getPriceForOne() - super.getPriceForOne() * discountIndependence / 100);
		}
	}
	
	public void printInfo() {
		System.out.println( "Name: " + super.getName() + ", Price per item: " + super.getPriceForOne() + " €, Price for all: " + super.getPriceForAll() + " €, Amount: " + super.getAmount() + ", Discount: " + this.discountIndependence);
	}

	@Override
	public String toString() {
		return "Name: " + super.getName() + ", Price for one: " + super.getPriceForOne() + " €, Discount: " + discountIndependence;
	}

}
