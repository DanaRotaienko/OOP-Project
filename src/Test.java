import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import Items.DiscountIndependentItem;
import Items.Item;
import Items.ItemWithDiscount;
import StoreBaskets.StoreBasket;
import StoreBaskets.StoreBasketEmployee;
import StoreBaskets.StoreBasketLoyalCustomer;
import Users.Cashier;
import Users.Customer;
import Users.EmployeeCustomer;
import Users.LoyalCustomer;

public class Test {

	public static void main(String[] args){
		
		Cashier c1 = new Cashier("name", "surname", "username", "password", "address", "phoneNumber", "internalPhoneNumber", 243.23, 3);
		Locale localeEn = new Locale("en", "UK");
		Locale localeRu = new Locale("ru", "RU");
		
		ResourceBundle labelsEn = ResourceBundle.getBundle("language.newResourceBundle_en_UK", localeEn);
		System.out.println(labelsEn.getString("cashier1"));
	
		ResourceBundle labelsRu = ResourceBundle.getBundle("language.newResourceBundle_ru_RU", localeRu);
		System.out.println(labelsRu.getString("cashier1"));
		
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		
		System.out.println("Date: " + date + ", time: " + time.getHour() + ":" + time.getMinute());
		
		long hours = 96;
	    long days = TimeUnit.DAYS.convert(hours, TimeUnit.HOURS);
	    long minutes = TimeUnit.MINUTES.convert(days, TimeUnit.DAYS);
	  
	    System.out.println(hours + " Hours = " + days + " Days = " + minutes + " Minutes");
	      
	    long startTime = System.nanoTime();
	    System.out.println(startTime);
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println(elapsedTime);
		long elapsedTimeSeconds = TimeUnit.HOURS.convert(elapsedTime, TimeUnit.NANOSECONDS);
	    System.out.println(elapsedTimeSeconds);
	    
	    Cashier c = new Cashier("Anna", "Kramer", "AnnaKr123", "kramnna12031997", "3868  Still Street", "+372-651-3048", "+372-46-9926", 603.33, 6);
	    c.WorkingHours(9);
	    c.BonusForWorkingHours();
	    
	    System.out.println(c.BonusForWorkingHours());
	    EmployeeCustomer customer = new EmployeeCustomer(c);
	    LoyalCustomer customer2 = new LoyalCustomer("Charlene", "Bentz", "2450  Gateway Road", "+372-264-8072");
	    StoreBasketEmployee s = new StoreBasketEmployee("address", c);
	    StoreBasketLoyalCustomer s2 = new StoreBasketLoyalCustomer("address", c);
	    s.setCustomer(customer);
	    s2.setCustomer(customer2);
	    System.out.println();
	    Item item = new Item("item", 30);
	    s.putItem(item, 300);
	    s2.putItem(item, 10);
	    s.setPoints();
	    s2.setPoints();
	    
	    customer.setBasket(s);
	    customer2.setBasket(s2);
	    customer.calculatePoints();
	    customer2.calculatePoints();
	    System.out.println(customer.getSalary() + " after " + customer.getSalaryWithBonus());
	    
	    System.out.println(s2.getPoints());
	    System.out.print(s2.getTotalAmount() + " after ");
	    s2.payWithBonus();
	    System.out.print(s2.getTotalAmount());
	    
	}
	
	
}
