package StoreBaskets;

import Users.User;

public class StoreBasketEmployee extends StoreBasket {

	private int points;

	public StoreBasketEmployee(String address, User cashier) {
		super(address, cashier);
	}


	public void setPoints() {
		this.points = (int) (super.getTotalAmount() / 15);
		super.getCustomer().setPoints(points);
	}
	
	public int getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Store Basket for Employee, " + super.toString();
	}
	
	


	
	
}
