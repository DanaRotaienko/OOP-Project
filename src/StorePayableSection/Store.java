package StorePayableSection;

import java.util.ArrayList;

import StoreBaskets.StoreBasket;
import StoreBaskets.StoreBasketEmployee;
import StoreBaskets.StoreBasketLoyalCustomer;
import Users.Cashier;
import Users.User;
public class Store {

	private ArrayList<StoreBasket> servingBaskets;	
	private ArrayList<StoreBasket> servedBaskets;
	private String address;
	private String name;
	
	public Store(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.servingBaskets = new ArrayList<StoreBasket>();
		this.servedBaskets = new ArrayList<StoreBasket>();
	}

	public String getAddress() {
		return address;
	}
	

	public ArrayList<StoreBasket> getServingBaskets() {
		return servingBaskets;
	}

	public ArrayList<StoreBasket> getServedBaskets() {
		return servedBaskets;
	}

	public String getName() {
		return name;
	}

	public boolean newBasket(User user, int index) {
		if (user instanceof Cashier) {
			if (index == 1) {
				StoreBasket basket = new StoreBasket(getAddress(), user);
				servingBaskets.add(basket);
				return true;
			} else if (index == 2) {
				StoreBasketLoyalCustomer basket = new StoreBasketLoyalCustomer(getAddress(), user);
				servingBaskets.add(basket);
				return true;
			} else if (index == 3) {
				StoreBasketEmployee basket = new StoreBasketEmployee(getAddress(), user);
				servingBaskets.add(basket);
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public StoreBasket returnBasketWithID(int id) {
		for (StoreBasket b: servingBaskets) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	public double getPriceForAllServedBaskets() {
		 double price = 0;
		  for (StoreBasket b: this.servedBaskets) {
			  price += b.getTotalAmount();
		  }
		  return price;
	}
	
	public int amountOfSoldItems() {
		int amount = 0;
		for (StoreBasket b: this.servedBaskets) {
			  amount += b.getNetAmount();
		}
		return amount;
	}
	
	@Override
	public String toString() {
		return "Store || Serving baskets: " + servingBaskets + ", Served baskets: " + servedBaskets + ", Address: " + address
				+ ", Name: " + name;
	}

	
	
}
