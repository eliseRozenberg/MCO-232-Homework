package pointOfSale;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Customer {
	
	private Integer customerID;
	private String firstName;
	private String lastName;
	private String phoneNumber; //validate for 10 digits //string or integer 
	private String creditCardID;
	
	private static Integer lastID = 1;	//static for every customer - changes for every customer
	
	private ArrayList <PurchasedItem> purchasedItems; 
	private Double totalPurchasedAmnt;
	
	
	//constructor
	public Customer(String first, String last, String number) 
												throws InvalidDataException{
		if (first ==null|| last==null||number==null) throw new InvalidDataException();
		if (number.length() != 10) throw new InvalidDataException();
		//check if static is done that way
		this.customerID = lastID++; 
		this.firstName = first;
		this.lastName = last;
		this.phoneNumber = number; 
		this.creditCardID = null; 
		this.purchasedItems = new ArrayList<PurchasedItem>(); 
		this.totalPurchasedAmnt = 0.0; //shud it be null or 0?
	}
	
	
	//getters
	public Integer getcustomerID() {
		return this.customerID;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
	public String getphoneNumber() {
		return this.phoneNumber;
	}

	public String getcreditCardID() {
		return this.creditCardID;
	}
	
	//improve the deep copy
	public ArrayList<PurchasedItem> getpurchasedItems() {
		ArrayList<PurchasedItem> copy = new ArrayList<PurchasedItem>();
		for (PurchasedItem item : purchasedItems) {
			copy.add(item); 
		}
		return copy;
	}
	
	public Double gettotalPurchasedAmnt() {
		return this.totalPurchasedAmnt;
	}
	
	//setters
	public void setlastName(String last) throws InvalidDataException {
		if (last ==null) throw new InvalidDataException();
		this.lastName = last;
	}
	
	public void setphoneNumber (String number) throws InvalidDataException {
		if (number ==null) throw new InvalidDataException();
		if (number.length() != 10) throw new InvalidDataException();
		this.phoneNumber = number;
	}
	
	public void setcreditCardID (String card) throws InvalidDataException{
		if (card ==null) throw new InvalidDataException();
		if (card.length()!=16) throw new InvalidDataException();
		this.creditCardID = card;
	}
	
	/**
	 * 
	 * @param name
	 * @param quantity
	 * @param amount
	 * @param type
	 */
	public void makePurchase (String name, Integer quantity,
										Double amount, String type ) throws InvalidDataException {
		if (name ==null|| quantity == null|| amount ==null|| type ==null) throw new InvalidDataException();
		if (quantity <1) throw new InvalidDataException();
		if (amount < 0.0) throw new InvalidDataException();
		Double amountOwed = (quantity*amount); 
		this.totalPurchasedAmnt =+ amountOwed; //combine to one statement
		this.purchasedItems.add(new PurchasedItem(name,quantity, amount,type ));
	}
	
	/**
	 * 
	 * @param name
	 * @param date
	 * @throws NotFoundException
	 */
	//fix this
	public void returnPurchase(String name, GregorianCalendar date ) throws NotFoundException {
		if (name ==null || date ==null) throw new InvalidDataException(); 
		boolean found = false;
		double amount;
			for (PurchasedItem item : this.purchasedItems) {	//go through purchase list
				if (item.getitemName().equalsIgnoreCase(name)){	//if item and date matches
					if (item.getpurchaseDate().get(Calendar.MONTH)==(date.get(Calendar.MONTH)) &&
							item.getpurchaseDate().get(Calendar.YEAR)== (date.get(Calendar.YEAR)) &&
							item.getpurchaseDate().get(Calendar.DAY_OF_MONTH)==(date.get(Calendar.DAY_OF_MONTH)) ){
						amount=item.getprice()*item.getquantitypurchased();	//calculate amount
						totalPurchasedAmnt =- amount;	//subtract from total
						this.purchasedItems.remove(item); 	//remove from arrayList
						found = true;	//verify item found
						break;
					}//end if
				}//end if
			}//end for
			if (!found){
				throw new NotFoundException(); 
			}//end if
		
	} //end returnPurchase
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws NotFoundException
	 */
	public int timesPurchased(String name)throws InvalidDataException {
		if (name ==null) throw new InvalidDataException();
		int times=0;
		for (PurchasedItem item: this.purchasedItems) {
			if (item.getitemName().equalsIgnoreCase(name)){
				times++;
			}//end if
		}//end for
			return times;	//return amount of times purchased
	}
	
	public ArrayList <PurchasedItem> purchasesOfType (String type)throws InvalidDataException{
		if (type ==null)throw new InvalidDataException();
		ArrayList <PurchasedItem> newList = new ArrayList<PurchasedItem>(); 
		for (PurchasedItem item: this.purchasedItems) {
			if (item.getitemType().equalsIgnoreCase(type)){
				newList.add(item);
				//deep enough of a copy
				//confirm this is what i have to do
			}//end if
		}//end for
		return newList;	//returns list of items that are of the type
	}
	
	public boolean hasPurchasedItems (String name) throws InvalidDataException{
		if (name ==null) throw new InvalidDataException();
		for (PurchasedItem item: this.purchasedItems) {
			if (item.getitemName().equalsIgnoreCase(name)){
				return true; //if purchased 
			}//end if
		}//end for
		return false;
	}
	
	
}//end class
