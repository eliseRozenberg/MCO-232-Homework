package pointOfSale;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CustomerInfo {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		ArrayList <Customer> customers = new ArrayList<Customer>(); //hold customer list
		int choice; 	//for customer selection
		do {			//do until select EXIT
			choice =0;	
			ArrayList <PurchasedItem> list = new ArrayList<PurchasedItem>(); //hold customer purchase of type (case 8)
			int quantityPurchased;	
			Double price;
			GregorianCalendar date;
			String first, last, number, itemName,itemType;	//customer and item info
			int day,month,year;
			choice = menu();
			boolean found;		//verify found info - false every case
			
			//verify/identify customer by phone number 
			switch(choice) {
			case 1:
				found = false; 
				System.out.println("Enter 10 digit phone-number (no slash or space)");
				number = keyboard.nextLine();
				while (number.length()!=10){		//verify - 10 digit number only
					System.out.println("Number needs to have 10 digits");
					System.out.println("Enter 10 digit phone-number (no slash or space)");
					number = keyboard.nextLine();
				}
				for (Customer cust: customers){	//run through customers 
					if (cust.getphoneNumber().equalsIgnoreCase(number)){	//if found -doesnt add
						System.out.println("Customer already exists");
						found = true;
						break;
					}//end if
				}//end for
				if (!found) { //if customer not found - add it
					System.out.println("Enter first name");
					first = keyboard.nextLine();
					System.out.println("Enter last name");
					last = keyboard.nextLine();
					customers.add(new Customer(first, last, number)); //add new contact to contact arrayList
					System.out.println("Customer stored");
					}//end if
				break; //end case1
				
			case 2:
				found = false;
				System.out.println("Enter 10 digit phone number of the customer you would "
						+ "like to remove (no slash or space)");
				number = keyboard.nextLine();
				while (number.length()!=10){
					System.out.println("Number needs to have 10 digits");
					System.out.println("Enter 10 digit phone-number (no slash or space)");
					number = keyboard.nextLine();
				}
				for (Customer cust: customers){
					if (cust.getphoneNumber().equalsIgnoreCase(number)){
							customers.remove(cust);   //remove customer if found
							System.out.println("Customer removed");
							found = true;
							break;
					}//end if
				}//end for
				if (!found) System.out.println("Customer doesn't exist in our data base.");
				break;
				
			case 3: 
				found = false;
				System.out.println("Enter 10 digit phone number of the customer (no slash or space)");
				number = keyboard.nextLine();
				while (number.length()!=10){
					System.out.println("Number needs to have 10 digits");
					System.out.println("Enter 10 digit phone-number (no slash or space)");
					number = keyboard.nextLine();
				}
				for (Customer cust : customers) {
					if (cust.getphoneNumber().equalsIgnoreCase(number)){  //if customer found 
							System.out.println("Enter item information:");
							System.out.println("Item name:");
							itemName = keyboard.nextLine(); 
							System.out.println("Quantity Purchased:");
							quantityPurchased = keyboard.nextInt(); 
							System.out.println("Price: (per item)");
							price = keyboard.nextDouble();
							keyboard.nextLine();
							System.out.println("Item Type:");
							itemType = keyboard.nextLine(); 
							cust.makePurchase(itemName, quantityPurchased, price, itemType); //in customer add to arayList of purchases
							System.out.println("Purchase made");
							found = true;
						break;
					}//end if
				}//end for
				if (!found) System.out.println("Customer doesn't exist in our database");
				break;
				
			case 4: 
				found = false;
				System.out.println("Enter 10 digit phone number of the customer (no slash or space)");
				number = keyboard.nextLine();
				while (number.length()!=10){
					System.out.println("Number needs to have 10 digits");
					System.out.println("Enter 10 digit phone-number (no slash or space)");
					number = keyboard.nextLine();
				}
							
				for (Customer cust : customers) { //fix date
					if (cust.getphoneNumber().equalsIgnoreCase(number)){
						found =true;
							if (cust.getpurchasedItems().size()==0) {	//check if any purchases made - if not end case
								System.out.println("no purchases made");	
								
							}
							else{
								System.out.println("What item would you like to remove?"); //if purchases were made - 
								System.out.println("Purchase History:");

								for (PurchasedItem item: cust.getpurchasedItems()){
									System.out.print(item);								//display purchases so can see info
								}//end for
								itemName = keyboard.nextLine();
								System.out.println("When did you purchase that item:");	//input info and create gregorian calendar
								System.out.println("Date: ");
								day = keyboard.nextInt();
								System.out.println("Month:");
								month = keyboard.nextInt();
								System.out.println("Year(XXXX):");
								year = keyboard.nextInt();
						
								date = new GregorianCalendar(year,month-1,day); 
								try{			//try to remove
									cust.returnPurchase(itemName, date);
									System.out.println("Item returned");
								} catch(NotFoundException ex1){	System.out.println("Item not found");}
							}
							break;
					}//end if
				}//end for
				if (!found)System.out.println("Customer not found."); //if customer  not found
				break;
				
			case 5:
				found = false;
				System.out.println("Enter 10 digit phone number of the customer (no slash or space)");
				number = keyboard.nextLine();
				while (number.length()!=10){
					System.out.println("Number needs to have 10 digits");
					System.out.println("Enter 10 digit phone-number (no slash or space)");
					number = keyboard.nextLine();
				}
							
				for (Customer cust : customers) { 
					if (cust.getphoneNumber().equalsIgnoreCase(number)){
						if (cust.getpurchasedItems().size()==0) System.out.println("No purchases saved"); //check if purchases made
						else{
							for (PurchasedItem item: cust.getpurchasedItems()){	//get purchases
								System.out.print(item);
								found =true;
							}//end for
						}
					}//end if
				}//end outer for
				if (!found)System.out.println("Customer doesn't exist in databases");
				break;
				
			case 6:
				
				System.out.println("What item are you searching for?");
				itemName =keyboard.nextLine();
				found =false;			//validate for every customer if found
				boolean foundOne= false; //validate if any customers purchased items
				System.out.println("List of customers that purchased this item:");
				for (Customer cust: customers){
					found = cust.hasPurchasedItems(itemName); //check if purchased that item
					if (found){	//if so print it
						System.out.print(cust.getfirstName() + " " + cust.getlastName()+"\n");
						foundOne =true;
					}
				}//end for
				if (!foundOne) System.out.println("No customers purchased this item.");	//if no customers purchased it
				break;
				
			case 7:
				System.out.println("What item are you searching for?");
				itemName =keyboard.nextLine();
				System.out.println("Name:		Times Purchased:");
				for (Customer cust: customers){
					quantityPurchased =cust.timesPurchased(itemName); //amount of times purchased
					System.out.println(cust.getfirstName() + " " + cust.getlastName() + "			" + quantityPurchased);
				}
			break;
			
			case 8:
				found =false;
				System.out.println("What item type are you searching for?");
				itemName =keyboard.nextLine();
				System.out.println("Customers that purchased "+ itemName + ":");
				for (Customer cust: customers){
					list = cust.purchasesOfType(itemName);  //return list of items of the type for customer 
					if (list.size()>0){			//if purchases made of the type
						System.out.println(cust.getfirstName()+ " " + cust.getlastName());	
						found =true;
					}
				}
				if (!found) System.out.println("No customers purchased the item type."); //if none >0 no purchases of type
				break;
				
			case 9:
				System.out.println("Have a great day!");
				keyboard.close();
				System.exit(0);
			}//end switch
		 } while (true);
	}//end main
	
	public static int menu(){
		int choice = -1;
		do {
			System.out.println();
			System.out.println( "Enter your selection (1-9)\n" + 			
							"1.Add a new Customer\n" +
							"2.Remove a new Customer\n"+
							"3.Add a Customer Purchase\n" +
							"4.Return a Customer purchase\n" +
							"5.View Customer purchases\n" +
							"6.List Names of Customers who have purchased a particular Item name\n" +
							"7.For each Customer, list how many times the Customer has purchased a particular item name\n" +
							"8.List which customers have purchased at least one item of a given item type\n" +
							"9.EXIT");
		Scanner keyboard = new Scanner (System.in); 
		choice= keyboard.nextInt();
		if (choice < 1 || choice >9) System.out.println("Invalid choice");
		} while (choice < 1 || choice >9);
		System.out.println();
		return choice;
	} 
}
