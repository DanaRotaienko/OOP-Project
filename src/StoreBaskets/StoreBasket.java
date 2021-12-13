package StoreBaskets;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Items.Item;
import StorePayableSection.Payable;
import Users.Cashier;
import Users.Customer;
import Users.User;

public class StoreBasket implements Payable {

	private int id;
	public static int nextId = 1;
	private int netAmount;
	private double totalAmount;
	private ArrayList<Item> items;
	private LocalDate date;
	private LocalTime time;
	private String address;
	private String cashierName;
	public static double vat = 0.05;
	private Customer customer;
	
	public StoreBasket(String address, User cashier) {
		super();
		this.id = nextId++;
		this.items = new ArrayList<Item>();
		this.address = address;
		this.cashierName = cashier.getName();
	}
	
	public StoreBasket() {
		super();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setPoints() {
		
	}

	public int getId() {
		return id;
	}

	public int getNetAmount() {
		return netAmount;
	}
	
	public void setTotalAmount(double money) {
		this.totalAmount = money;
	}

	public double getTotalAmount() {
		return  Double.parseDouble(new DecimalFormat("##.##").format(totalAmount));
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void payWithBonus() {

	}
	
	public void putItem(Item item, int amount) {
		item.setAmount(amount);
		item.calculatePrice(amount);
		totalAmount = Double.parseDouble(new DecimalFormat("##.##").format(totalAmount + item.getPriceForAll()));
		netAmount += amount;
		boolean isTheSame = false;
		for (Item i: items) {
			if ( i.getName() == item.getName()) {
				isTheSame = true;
				i.setAmount(i.getAmount() + item.getAmount());
				i.calculatePrice(i.getAmount());
			}
		}
		if (isTheSame == false) {
			items.add(item);
		}
	}
	
	public void removeItem(int index) {
		
		netAmount -= items.get(index).getAmount();
		totalAmount = Double.parseDouble(new DecimalFormat("##.##").format(totalAmount - items.get(index).getPriceForAll()));
		items.remove(index);
		
	}
	
	public void printItems() {
		this.items.stream().forEach(i -> System.out.println(this.items.indexOf(i) + 1 + ") " + i));
	}
	
	public void printItemsForBasketInfo() {
		this.items.stream().forEach(i -> System.out.println(this.items.indexOf(i) + 1 + ") " + i + ", Price for all: " + i.getPriceForAll() + ", Amount: " + i.getAmount()));
	}
	
	public double ChristmasPromotion() {
		return this.totalAmount -= totalAmount * 0.1;
	}
	
	public void setBonusMoney(double bonusMoney) {
		
	}

	@Override
	public boolean calculatePayment() {
		if (totalAmount != 0) {
			this.time = LocalTime.now();
			this.date = LocalDate.now();
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Store Basket|| ID: " + id + ", Amount of items: " + netAmount + ", Price: " +  Double.parseDouble(new DecimalFormat("##.##").format(totalAmount)) + " €, Address: " + address + ", Cashier's name: " + cashierName + ", Customer: " + customer;
	}



	
	
	
	
	
}
