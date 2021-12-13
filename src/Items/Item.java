package Items;

import java.text.DecimalFormat;

import StoreBaskets.StoreBasket;

public class Item {

	private int id;
	private static int nextId = 1;
	private double priceForOne;
	private double priceForAll;
	private int amount;
	private String name;
	
	public Item(String name, double priceForOne) {
		super();
		this.name = name;
		this.id = nextId++;
		this.priceForOne = Double.parseDouble(new DecimalFormat("##.##").format(priceForOne + (StoreBasket.vat * priceForOne)));
	}
		
	public int getId() {
		return id;
	}

	public double getPriceForOne() {
		return priceForOne;
	}

	public double getPriceForAll() {
		return Double.parseDouble(new DecimalFormat("##.##").format(priceForAll));
	}

	public int getAmount() {
		return amount;
	}
	
	public String getName() {
		return name;
	}
	

	public void setPriceForOne(double priceForOne) {
		this.priceForOne = Double.parseDouble(new DecimalFormat("##.##").format(priceForOne + (StoreBasket.vat * priceForOne)));
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double calculatePrice(int amount) {
		this.amount = amount;
		this.priceForAll = priceForOne * amount;
		return Double.parseDouble(new DecimalFormat("##.##").format(priceForAll));
	}
	
	public double calculatePrice(int amount, int discount) {
		this.amount = amount;
		this.priceForAll = priceForOne * amount;
		this.priceForAll -= priceForAll * discount / 100;
		return Double.parseDouble(new DecimalFormat("##.##").format(priceForAll));
	}
	
	public void printInfo() {	
		System.out.println("Name: "+ name + ", Price per item: " + priceForOne + " €, Price for all: " + Double.parseDouble(new DecimalFormat("##.##").format(priceForAll)) + " €, Amount: " + amount);
	}


	@Override
	public String toString() {
		return "Name: " + name + ", Price for one: " + priceForOne + " €";
	}


	
	
	
	
}
