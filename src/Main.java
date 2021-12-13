
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Items.BuyMorePayLessItem;
import Items.DiscountIndependentItem;
import Items.Item;
import Items.ItemWithDiscount;
import Items.TakeItAllItem;
import StoreBaskets.StoreBasket;
import StoreBaskets.StoreBasketEmployee;
import StoreBaskets.StoreBasketLoyalCustomer;
import StorePayableSection.Section;
import StorePayableSection.Store;
import Users.Cashier;
import Users.Customer;
import Users.EmployeeCustomer;
import Users.LoyalCustomer;
import Users.Manager;
import Users.User;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Localization (Done)
		
		Locale localeEn = new Locale("en", "UK");
		Locale localeRu = new Locale("ru", "RU");
		
		ResourceBundle messages = null;
		
		// Initializing store, cashiers, manager, items and sections
		Cashier cashier1 = new Cashier("Anna", "Kramer", "AnnaKr123", "kramnna12031997", "3868  Still Street", "+372-651-3048", "+372-46-9926", 603.33, 6);
		Cashier cashier2 = new Cashier("Jeremy", "Stewart", "MC", "MC606", "3890  Broad Street", "+372-421-9119", "+372-46-9926", 893.21, 8);
		Cashier cashier3 = new Cashier("Bridgette", "Bains", "CraftedMH", "AhP5keenee", "3903  Elk Street", "+372-724-3377", "+372-46-9926", 765.64, 7);
		Cashier cashier4 = new Cashier("Tracie", "Knudson", "seth_marqu1983", "Hei3se3Leigh", "2167  Russell Street", "+372-912-3001", "+372-46-9926", 965.32, 9);
		Cashier cashier5 = new Cashier("Martha", "Jones", "fritz_medh1980", "ufud8aeW5ch", "3524  Joes Road", "+372-683-9265", "+372-46-9926", 567.43, 5);

		LoyalCustomer customer1 = new LoyalCustomer("Charlene", "Bentz", "2450  Gateway Road", "+372-264-8072");
		LoyalCustomer customer2 = new LoyalCustomer("Maria", "Sawyer", "624  Zimmerman Lane", "+372-504-4679");
		LoyalCustomer customer3 = new LoyalCustomer("Cecil", "Johnson", "2865  Broad Street", "+372-486-5189");
		
		EmployeeCustomer eCustomer1 = new EmployeeCustomer(cashier1);
		EmployeeCustomer eCustomer2 = new EmployeeCustomer(cashier2);
		EmployeeCustomer eCustomer3 = new EmployeeCustomer(cashier3);
		EmployeeCustomer eCustomer4 = new EmployeeCustomer(cashier4);
		EmployeeCustomer eCustomer5 = new EmployeeCustomer(cashier5);
		
		Customer simpleCustomer = new Customer();
		
		Manager manager = new Manager("Douglas", "Pratt", "Seven", "God707", "1942  Johnny Lane", "+372-304-4423", "+372-46-9926", "53221");

		Store store = new Store("Safeway store", "188  Weekley Street");
		
		Section dairySection = new Section("Dairy section");
		Section confectionarySection = new Section("Confectionary section");
		Section vegetableAndFruitSection = new Section("Vegetable and fruit section");
		Section meatSection = new Section("Meat section");
		Section drinksSection = new Section("Drinks section");
		
		Item milk = new Item("Milk", 0.73); 
		ItemWithDiscount cheese = new ItemWithDiscount("Cheese", 6.73);
		TakeItAllItem yogurt = new TakeItAllItem("Yogurt", 1.8);
		DiscountIndependentItem butter = new DiscountIndependentItem("Butter", 2);
		BuyMorePayLessItem kefir = new BuyMorePayLessItem("Kefir", 0.9);		
		dairySection.putItem(milk);
		dairySection.putItem(cheese);
		dairySection.putItem(yogurt);
		dairySection.putItem(butter);
		dairySection.putItem(kefir);
		
		Item bread = new Item("Bread", 0.8); 
		ItemWithDiscount chocolate = new ItemWithDiscount("Chocolate", 3.90);
		TakeItAllItem cake = new TakeItAllItem("Cake", 9);
		DiscountIndependentItem snickers = new DiscountIndependentItem("Snickers", 0.8);
		BuyMorePayLessItem iceCream = new BuyMorePayLessItem("Ice cream", 0.6);		
		confectionarySection.putItem(bread);
		confectionarySection.putItem(chocolate);
		confectionarySection.putItem(cake);
		confectionarySection.putItem(snickers);
		confectionarySection.putItem(iceCream);
		
		Item apple = new Item("Apple", 0.4); 
		ItemWithDiscount lemon  = new ItemWithDiscount("Lemon", 0.70);
		TakeItAllItem avocado = new TakeItAllItem("Avocado", 1.2);
		DiscountIndependentItem banana = new DiscountIndependentItem("Banana", 0.5);
		BuyMorePayLessItem potato = new BuyMorePayLessItem("Potato", 0.35);		
		vegetableAndFruitSection.putItem(apple);
		vegetableAndFruitSection.putItem(lemon);
		vegetableAndFruitSection.putItem(avocado);
		vegetableAndFruitSection.putItem(banana);
		vegetableAndFruitSection.putItem(potato);
		
		Item freshBeef = new Item("Fresh beef", 0.4); 
		ItemWithDiscount mincedMeat = new ItemWithDiscount("Minced meat", 0.70);
		TakeItAllItem chickenBreast = new TakeItAllItem("Chicken breast", 1.2);
		DiscountIndependentItem wholeChicken = new DiscountIndependentItem("Whole chicken", 0.5);
		BuyMorePayLessItem freshFish = new BuyMorePayLessItem("Fresh Fish", 0.35);		
		meatSection.putItem(freshBeef);
		meatSection.putItem(mincedMeat);
		meatSection.putItem(chickenBreast);
		meatSection.putItem(wholeChicken);
		meatSection.putItem(freshFish);
		
		Item water = new Item("Water", 0.65); 
		ItemWithDiscount wine = new ItemWithDiscount("Wine", 7);
		TakeItAllItem beer = new TakeItAllItem("Beer", 1.40);
		DiscountIndependentItem juice = new DiscountIndependentItem("Juice", 0.90);
		BuyMorePayLessItem cocaCola = new BuyMorePayLessItem("Coca-Cola", 1.70);		
		drinksSection.putItem(water);
		drinksSection.putItem(wine);
		drinksSection.putItem(beer);
		drinksSection.putItem(juice);
		drinksSection.putItem(cocaCola);
		
		ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
		cashiers.add(cashier1);
		cashiers.add(cashier2);
		cashiers.add(cashier3);
		cashiers.add(cashier4);
		cashiers.add(cashier5);
		
		ArrayList<Section> sections = new ArrayList<Section>();
		sections.add(dairySection);
		sections.add(confectionarySection);
		sections.add(vegetableAndFruitSection);
		sections.add(meatSection);
		sections.add(drinksSection);
		
		ArrayList<LoyalCustomer> loyalCustomers = new ArrayList<LoyalCustomer>();
		loyalCustomers.add(customer1);
		loyalCustomers.add(customer2);
		loyalCustomers.add(customer3);

		ArrayList<EmployeeCustomer> eCustomers = new ArrayList<EmployeeCustomer>();
		eCustomers.add(eCustomer1);
		eCustomers.add(eCustomer2);
		eCustomers.add(eCustomer3);
		eCustomers.add(eCustomer4);
		eCustomers.add(eCustomer5);
		// The end of introducing local variables
		
		boolean chosenLanguage = false;
		boolean isFinished =false;
		boolean isTrue = false;
		User user = new User();
		while (isFinished == false) {
			isTrue = false;
			while (isTrue == false) {
				System.out.print("Username: ");
				String username = input.nextLine();		
				for (Cashier c: cashiers) {
					if (username.equals(c.getUsername())) {
						isTrue = true;
						user = c;
					}				
				} 
				if (username.equals(manager.getUsername())) {
					isTrue = true;
					user = manager;
				} else if (user.getName() == null){
					System.out.println("Wrong username");
				}
			}
			isTrue = false;
			while (isTrue == false) {
				System.out.print("Password: ");
				String password = input.nextLine();
				isTrue = checkPassword(password, manager, cashiers);
			}
			long startTime = System.nanoTime();
			isTrue = false;	 
			// Print menu
			while (isTrue == false) {
				while (chosenLanguage == false) {
					System.out.println("Choose menu language: ");
					System.out.println("◦ English (eng)");
					System.out.println("◦ Russian (rus)");
					String userLanguage = input.nextLine();
					if (userLanguage.equalsIgnoreCase("eng")) {
						messages = ResourceBundle.getBundle("language.newResourceBundle_en_UK", localeEn);	
						chosenLanguage = true;
					} else if (userLanguage.equalsIgnoreCase("rus")) {
						messages = ResourceBundle.getBundle("language.newResourceBundle_ru_RU", localeRu);
						chosenLanguage = true;
					} else {
						System.out.println("You need to choose Eng or Rus");
					}
				}
				printMenu(user, messages);
				System.out.print("Choose an option: ");
				String option = input.nextLine();
				System.out.println();
				boolean indexChosen = false;
				if (user instanceof Cashier) {
					switch(option) {
						case "1":  // New basket (Done)
							while (indexChosen == false) {	
								System.out.println();
								System.out.println("1) Store basket");
								System.out.println("2) Store basket for loyal customer");
								System.out.println("3) Store basket for employee");
								System.out.print("Which store basket would you like to choose: ");
								String indexBasket = input.nextLine();
								switch(indexBasket) {
									case "1":
										store.newBasket(user, Integer.parseInt(indexBasket));
										simpleCustomer.setBasket(store.getServingBaskets().get(store.getServingBaskets().size() - 1));
										store.getServingBaskets().get(store.getServingBaskets().size() - 1).setCustomer(simpleCustomer);
										indexChosen = true;
										break;
									case "2":
										store.newBasket(user, Integer.parseInt(indexBasket));
										int rndLoyalCustomer = new Random().nextInt(loyalCustomers.size());
										loyalCustomers.get(rndLoyalCustomer).setBasket(store.getServingBaskets().get(store.getServingBaskets().size() - 1));
										store.getServingBaskets().get(store.getServingBaskets().size() - 1).setCustomer(loyalCustomers.get(rndLoyalCustomer));
										indexChosen = true;
										break;
									case "3":
										store.newBasket(user, Integer.parseInt(indexBasket));
										int rndEmployeeCustomer = new Random().nextInt(eCustomers.size());
										eCustomers.get(rndEmployeeCustomer).setBasket(store.getServingBaskets().get(store.getServingBaskets().size() - 1));
										store.getServingBaskets().get(store.getServingBaskets().size() - 1).setCustomer(eCustomers.get(rndEmployeeCustomer));
										indexChosen = true;
										break;
									default:
										System.out.println("Please, choose one option and write a number");
								}

							}
							break;
						case "2": // Add item (Done)
							System.out.println();
							if (store.getServingBaskets().isEmpty()) {
								System.out.println("You shoud take a basket first");
							} else {
								while( indexChosen == false) {
									sections.stream().forEach(s -> System.out.println(sections.indexOf(s) + 1 + ") " + s));
									System.out.println(sections.size() + 1 + ") Exit");
									System.out.print("Choose the section: ");
									String indexSectionInput = input.nextLine();
									
									if (checkIfTheInputCorrect(indexSectionInput)) {		
										int indexSection = Integer.parseInt(indexSectionInput);
										if (indexSection > 0 && indexSection < sections.size() + 1) {
											indexSection--;
											boolean indexChosenItem = false;		
											while(indexChosenItem == false) {
												System.out.println();
												sections.get(indexSection).printItems();
												System.out.print("Choose an item: ");
												String indexItemFromSectionInput = input.nextLine();
												if (checkIfTheInputCorrect(indexItemFromSectionInput)) {
													int indexItemFromSection = Integer.parseInt(indexItemFromSectionInput);	
													if (indexItemFromSection > 0 && indexItemFromSection <= (sections.get(indexSection).getItems().size())) {
														indexItemFromSection--;		
														while (indexChosenItem == false) {
															System.out.println();
															System.out.print("Choose an amount of this item: ");
															String amountInput = input.nextLine();
															if (checkIfTheInputCorrect(amountInput)) {
																int amount = Integer.parseInt(amountInput);
																if (amount > 0) {
																	if (sections.get(indexSection).getItems().get(indexItemFromSection) instanceof BuyMorePayLessItem && amount > 10) {					
																		System.out.println("We only have 10 of these items in stock");			
																	} else {
																		store.getServingBaskets().get(store.getServingBaskets().size() - 1).putItem(sections.get(indexSection).getItems().get(indexItemFromSection), amount);
																		indexChosenItem = true;
																	}
																}
															}
														}
													}
												}
												System.out.println("Store basket || Amount of items: " + store.getServingBaskets().get(store.getServingBaskets().size() - 1).getNetAmount() + ", Price for all: " + store.getServingBaskets().get(store.getServingBaskets().size() - 1).getTotalAmount() + " €");
												System.out.println();
											}
										} else if (indexSection == sections.size() + 1) {
											indexChosen = true;
										}
									}
			
								}
							}
							break;
						case "3": // Remove item (Done)						
							System.out.println();
							if (store.getServingBaskets().isEmpty()) {
								System.out.println("You shoud take a basket first");
							} else { 
								store.getServingBaskets().get(store.getServingBaskets().size() - 1).printItems();
								System.out.println(store.getServingBaskets().get(store.getServingBaskets().size() - 1).getItems().size() + 1 + ") Exit");
								indexChosen = false;
								while (indexChosen == false) {
									System.out.print("Which item would you like to remove: ");
									String indexOfRemovedItem = input.nextLine();
									if (checkIfTheInputCorrect(indexOfRemovedItem)) {
										int index = Integer.parseInt(indexOfRemovedItem);
										index --;
										if (index >= 0 && index < store.getServingBaskets().get(store.getServingBaskets().size() - 1).getItems().size()) {
											store.getServingBaskets().get(store.getServingBaskets().size() - 1).removeItem(index);
											indexChosen = true;
										} else if (index == store.getServingBaskets().get(store.getServingBaskets().size() - 1).getItems().size()) {
											indexChosen = true;
										}
									} 

								}
							}					
							break;
						case "4": // Show info (Done)							
							System.out.println();
							if (store.getServingBaskets().isEmpty()) {
								System.out.println("You shoud take a basket first");
							} else {
								while (indexChosen == false) {
									if (store.getServingBaskets().isEmpty()) {
										System.out.println("There is no baskets");
									} else {
										int firstId = store.getServingBaskets().get(0).getId();
										int lastId = store.getServingBaskets().get(store.getServingBaskets().size() - 1).getId();
										store.getServingBaskets().stream().forEach(b -> System.out.println(b.getId() + ") Serving by: " + b.getCashierName()));
										System.out.print("Choose basket's ID: ");
										String idBasketInput = input.nextLine();
										if (checkIfTheInputCorrect(idBasketInput)) {
											int idBasket = Integer.parseInt(idBasketInput);
											System.out.println();
											if (idBasket >= firstId && idBasket <= lastId) {
												System.out.println(store.returnBasketWithID(idBasket));
												store.returnBasketWithID(idBasket).printItemsForBasketInfo();
												indexChosen = true;
											}
										}
									}
								}
							}
							break;	
						case "5":  // Christmas promotion (Done)	
							if (store.getServingBaskets().isEmpty()) {
								System.out.println("You shoud take a basket first");
							} else {
								System.out.println("Price before promotion: " + store.getServingBaskets().get(store.getServingBaskets().size() - 1).getTotalAmount());
								store.getServingBaskets().get(store.getServingBaskets().size() - 1).ChristmasPromotion();
								System.out.println("Price after promotion: " + store.getServingBaskets().get(store.getServingBaskets().size() - 1).getTotalAmount());
							}						
							break;
						case "6": // Conduct a payment (Done)
							System.out.println();
							if (store.getServingBaskets().isEmpty()) {
								System.out.println("You shoud take a basket first");
							} else {
								while (indexChosen == false) {				
									store.getServingBaskets().get(store.getServingBaskets().size() - 1).setPoints();
									store.getServingBaskets().get(store.getServingBaskets().size() - 1).getCustomer().calculatePoints();
									store.getServingBaskets().stream().forEach(b -> System.out.println(store.getServingBaskets().indexOf(b) + 1 + ") " + b));					
									System.out.println("Choose basket: ");
									String indexBasketInput = input.nextLine();
									if (checkIfTheInputCorrect(indexBasketInput)) {
										int indexBasket = Integer.parseInt(indexBasketInput);
										if (indexBasket >= 0 && indexBasket <= store.getServingBaskets().size()) {
											indexBasket--;								
											if (store.getServingBaskets().get(indexBasket) instanceof StoreBasketLoyalCustomer) {
												System.out.println("Your bonus money are " + store.getServingBaskets().get(indexBasket).getCustomer().getBonusMoney() + " €, would you like to pay with it: ");
												boolean bonusMoneyChosen = false;
												while (bonusMoneyChosen == false) {
													String yesOrNo = input.nextLine();
													if (yesOrNo.equalsIgnoreCase("Yes")) {
														store.getServingBaskets().get(indexBasket).payWithBonus();
														bonusMoneyChosen = true;
													} else if (yesOrNo.equalsIgnoreCase("No")) {
														bonusMoneyChosen = true;
													} else {
														System.out.println("Please, write \"Yes\" or \"No\" ");
													}
												}
											}
											store.getServedBaskets().add(store.getServingBaskets().get(indexBasket));
											store.getServingBaskets().get(indexBasket).calculatePayment();
											store.getServingBaskets().remove(indexBasket);
											user.calculatePayment();
											indexChosen = true;
										}
									}							
								}
							}
							break;
						case "7": // Change user (Done)			
							isTrue = true;
							break;
						case "8": // Exit (Done)	
							long elapsedTime = System.nanoTime() - startTime;
						    long elapsedTimeHours = TimeUnit.HOURS.convert(elapsedTime, TimeUnit.NANOSECONDS);
						    ((Cashier) user).WorkingHours(elapsedTimeHours);
						    ((Cashier) user).BonusForWorkingHours();
							isTrue = true;
							isFinished = true;
							break;
						default:
							System.out.println("Please, choose one option and write a number");
					}
					
				} else if (user instanceof Manager) {
					switch(option) {
					  case "1": // Put new item in a section (Done)  
						  while (indexChosen == false) {
							  System.out.println();
							  sections.stream().forEach(s -> System.out.println(sections.indexOf(s) + 1 + ") " + s));
								System.out.println(sections.size() + 1 + ") Exit");
								boolean chosenSection = false;
								int indexSection = 0;
								while (chosenSection == false) {
									System.out.print("Choose the section: ");
									String indexSectionInput = input.nextLine();
									if (checkIfTheInputCorrect(indexSectionInput)) {
										indexSection = Integer.parseInt(indexSectionInput);
							 	        indexSection--;
							 	       if (indexSection >= 0 && indexSection <= sections.size()) {
								 	        chosenSection = true;
							 	        } else {
							 	        	 System.out.println("Choose one of these sections");
							 	        }
									}
								}
								if (indexSection == sections.size()) {
									indexChosen = true;
								} else {
									System.out.println();
									sections.get(indexSection).printItems();
									 System.out.println();
									 System.out.print("Write the name of item: ");
									 String itemName = input.nextLine();								 
									 boolean chosenPrice = false;
									 double itemPrice = 0;
										while (chosenPrice == false) {
											System.out.print("Write price of item: ");
										 	String itemPriceInput = input.nextLine();
											if (checkIfTheDoubleInputCorrect(itemPriceInput)) {
												itemPrice = Double.parseDouble(itemPriceInput);
									 	        chosenPrice = true;
											}
										}	
									List<String> itemsTypes = Arrays.asList("Buy more pay less item", "Discount Independent item", "Item" , "Item with discount", "Take it all item");
									System.out.println();
									itemsTypes.stream().forEach(s -> System.out.println(itemsTypes.indexOf(s) + 1 + ") " + s));
									System.out.print("Choose one of types: ");
									String indexType = input.nextLine();
									
									switch(indexType) {
										case "1": // Buy more pay less item 
											BuyMorePayLessItem newBuyMorePayLessItem = new BuyMorePayLessItem(itemName, itemPrice);
											sections.get(indexSection).putItem(newBuyMorePayLessItem);
											break;
										case "2": // Discount Independent item 
											DiscountIndependentItem newDiscountIndependentItem = new DiscountIndependentItem(itemName, itemPrice);
											sections.get(indexSection).putItem(newDiscountIndependentItem);
											break;
										case "3": // Item 
											Item newItem = new Item(itemName, itemPrice);
											sections.get(indexSection).putItem(newItem);
											break;
										case "4": // Item with discount 
											ItemWithDiscount newItemWithDiscount = new ItemWithDiscount(itemName, itemPrice);
											sections.get(indexSection).putItem(newItemWithDiscount);
											break;
										case "5": // Take it all item 
											TakeItAllItem newTakeItAllItem = new TakeItAllItem(itemName, itemPrice);
											sections.get(indexSection).putItem(newTakeItAllItem);
											break;
										default:
											System.out.println("You chose wrong option");
									}
									System.out.println();
									sections.get(indexSection).printItems();
								}
						  }					
						  break;
					  case "2":  // Set discount for items (Done)
						  while (indexChosen == false) {
							  System.out.println();
							  boolean chosenValue = false;
							  int discount = 0;
							  while(chosenValue == false) {
								  System.out.print("Set discount: ");
								  String discountInput = input.nextLine();
								  if (checkIfTheInputCorrect(discountInput)) {
									  discount = Integer.parseInt(discountInput);
									  chosenValue = true;
								  }						  
							  } 
							  for (Section s: sections) {
								  for(Item i: s.getItems()) {
									  if (i instanceof ItemWithDiscount) {
										  ((ItemWithDiscount) i).setDiscount(discount, user);
									  }
								  }
							  }
							  chosenValue = false;
							  int discountIndependence = 0;
							  while(chosenValue == false) {
								  System.out.print("Set discount independence for Discount Independent items: ");
								  String discountIndependenceInput = input.nextLine();
								  if (checkIfTheInputCorrect(discountIndependenceInput)) {
									  discountIndependence = Integer.parseInt(discountIndependenceInput);
									  chosenValue = true;
								  }					  
							  } 
							  for (Section s: sections) {
								  for(Item i: s.getItems()) {
									  if (i instanceof DiscountIndependentItem) {
										  ((DiscountIndependentItem) i).setDiscount(discountIndependence, discount, user);
									  }
								  }
							  }
							  
							  chosenValue = false;
							  int changedAmount = 0;
							  while(chosenValue == false) {
								  System.out.print("Set coefficient for changing amount for Buy More Pay Less Item: ");
								  String changedAmountInput = input.nextLine();
								  if (checkIfTheInputCorrect(changedAmountInput)) {
									  changedAmount = Integer.parseInt(changedAmountInput);
									  chosenValue = true;
								  }							  
							  } 
							  
							  for (Section s: sections) {
								  for(Item i: s.getItems()) {
									  if (i instanceof BuyMorePayLessItem) {
										  ((BuyMorePayLessItem) i).setChangedAmount(user, changedAmount);
									  }
								  }
							  }
							  
							  chosenValue = false;
							  int minAmount = 0;
							  while(chosenValue == false) {
								  System.out.print("Set minimum amount of Take It All Items: ");
								  String minAmountInput = input.nextLine();
								  if (checkIfTheInputCorrect(minAmountInput)) {
									  minAmount = Integer.parseInt(minAmountInput);
									  chosenValue = true;
								  }						  
							  } 
							  
							  for (Section s: sections) {
								  for(Item i: s.getItems()) {
									  if (i instanceof TakeItAllItem) {
										  ((TakeItAllItem) i).setN(minAmount, user);
									  }
								  }
							  }
							  indexChosen = true;
							 
						  }
						  break;
					  case "3": // Check the amount of served baskets (Done)
						  store.getServedBaskets().stream().forEach(b -> System.out.println(store.getServedBaskets().indexOf(b) + 1 + ") " + b + ", Date: " + b.getDate() + ", Time: " + b.getTime()));
						  System.out.println("Amount of served baskets: " + store.getServedBaskets().size() + ", Amount of items sold: " + store.amountOfSoldItems());
						  break;
					  case "4": // Check the amount of money from served baskets (Done)
						  System.out.println("Price for served baskets: " + store.getPriceForAllServedBaskets());
						  break;
					  case "5": // Change User (Done)
						  isTrue = true;
						  break;
					  case "6": //  Exit (Done)
						  isTrue = true;
						  isFinished = true;
						  break;
					  default:
						  
						  System.out.println("Please, choose one option and write a number");
					}
					
				}
				
				
				
			}
		}
		input.close();
		
	}

	public static boolean checkPassword(String password, Manager manager, ArrayList<Cashier> cashiers) {	
		if (password.equals(manager.getPassword())) {
			return true;
		} else {
			for (Cashier c: cashiers) {
				if (password.equals(c.getPassword())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void printMenu(User user, ResourceBundle bundle) {
		if (user instanceof Cashier) {
			System.out.println();
			System.out.println(bundle.getString("menu"));
			System.out.println(bundle.getString("cashier1"));
			System.out.println(bundle.getString("cashier2"));
			System.out.println(bundle.getString("cashier3"));
			System.out.println(bundle.getString("cashier4"));
			System.out.println(bundle.getString("cashier5"));
			System.out.println(bundle.getString("cashier6"));
			System.out.println("7) " + bundle.getString("changeUser"));
			System.out.println("8) " + bundle.getString("exit"));
		} else if (user instanceof Manager) {
			System.out.println();
			System.out.println(bundle.getString("menu"));
			System.out.println(bundle.getString("manager1"));
			System.out.println(bundle.getString("manager2"));
			System.out.println(bundle.getString("manager3"));
			System.out.println(bundle.getString("manager4"));
			System.out.println("5) " + bundle.getString("changeUser"));
			System.out.println("6) " + bundle.getString("exit"));
		}
	}
	
	public static boolean checkIfTheInputCorrect(String string) {
		 try {
			 int number = Integer.parseInt(string);
			 return true;
		  } catch (NumberFormatException e) {
			  System.out.println("Please, write in numbers");
			  return false;
		  }		 
	}
	
	public static boolean checkIfTheDoubleInputCorrect(String string) {
		 try {
			 double number = Double.parseDouble(string);
			 return true;
		  } catch (NumberFormatException e) {
			  System.out.println("Please, write in double");
			  return false;
		  }		 
	}
	
}
