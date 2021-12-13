package StorePayableSection;

import java.util.ArrayList;
import java.util.stream.Stream;

import Items.Item;
public class Section {

	private String name;
	private ArrayList<Item> items;
	
	public Section(String name) {
		super();
		this.name = name;
		this.items = new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void putItem(Item item) {
		items.add(item);
	}
	
	public void printItems() {
		for (Item i: items) {
			System.out.println(items.indexOf(i) + 1 + ") " + i);
		}
	}

	@Override
	public String toString() {
		return name + "";
	}
	
	
	
}
