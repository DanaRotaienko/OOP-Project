package StoreBaskets;

import Users.User;

public class StoreBasketLoyalCustomer extends StoreBasket {

	private int points;
	private double bonusMoney;

	public StoreBasketLoyalCustomer(String address, User cashier) {
		super(address, cashier);
	}
	
	public void setPoints() {
		this.points = (int) (super.getTotalAmount() / 5);
		super.getCustomer().setPoints(points);
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setBonusMoney(double money) {
		this.bonusMoney = money;
	}
	
	public void payWithBonus() {
		super.setTotalAmount(super.getTotalAmount() - this.bonusMoney);
	}

	@Override
	public String toString() {
		return "Store Basket for loyal customer, " + super.toString();
	}




	
	
}
