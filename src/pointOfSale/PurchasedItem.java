 package pointOfSale;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PurchasedItem {
	
	private String itemName; 
	private GregorianCalendar purchaseDate; 
	private Integer quantityPurchased;
	private Double price;
	private String itemType;
	
	//constructor
	public PurchasedItem (String name, Integer quantity,Double amount,
							String type ) throws InvalidDataException{
		
		if (name == null || quantity == null || 
				amount == null || type == null) 
			throw new InvalidDataException();
		if (quantity <1 || amount< 0.0) throw new InvalidDataException();
		
		this.itemName = name;
		this.quantityPurchased = quantity;
		this.price = amount;
		this.itemType = type;
		this.purchaseDate = new GregorianCalendar();
	}
	
	//getters
	public String getitemName(){
		return this.itemName;
	}
	
	//return deep copy
	public GregorianCalendar getpurchaseDate(){
		GregorianCalendar purchaseDateCopy 
						= new GregorianCalendar(
								this.purchaseDate.get(Calendar.YEAR),
								this.purchaseDate.get(Calendar.MONTH),
								this.purchaseDate.get(Calendar.DAY_OF_MONTH));
		return purchaseDateCopy;
	}
	
	public Integer getquantitypurchased(){
		return this.quantityPurchased;
	}
	
	public Double getprice(){
		return this.price;
	}
	
	public String getitemType(){
		return this.itemType;
	}
	
	//compare by item name
	public Integer compareTo (String name) throws InvalidDataException {
		if (name ==null) throw new InvalidDataException();
		return this.itemName.compareToIgnoreCase(name); 
	}
	
	//based on compareTo
	public boolean equals(Object obj) {
		if (obj== null) return false; 
		if (!(obj instanceof PurchasedItem)) return false;
		PurchasedItem other = (PurchasedItem)obj;
		if (this.itemName.compareToIgnoreCase(other.itemName)==0)
			return true;
		else 
			return false;
	}
	
	public String toString(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY"); 
		StringBuffer  buffer = new StringBuffer();
		buffer.append(itemName + "\t");
		buffer.append(quantityPurchased + "\t");
		buffer.append(price + "\t");
		buffer.append(itemType + "\t");
		buffer.append( formatter.format(this.purchaseDate.getTime()) + "\n");
		return buffer.toString();
	}
	
}
