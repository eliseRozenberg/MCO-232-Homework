package account2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pointOfSale.InvalidDataException;
import pointOfSale.PurchasedItem;

public class Deposit {
	
	private GregorianCalendar dateOfDeposit;
	private  Double amount;
	
	public Deposit(Double amount){
		this.dateOfDeposit = new GregorianCalendar();
		this.amount = amount;
	}
	
	public Double getamount(){
		return amount;
		
	}
	public GregorianCalendar getdateOfDeposit(){
		GregorianCalendar copy = new GregorianCalendar(dateOfDeposit.get(Calendar.YEAR),
													  dateOfDeposit.get(Calendar.MONTH),
													  dateOfDeposit.get(Calendar.DAY_OF_MONTH));
		return copy;
		
	}
	
	public Integer compareTo(Deposit other) throws InvalidDataException{
		if (other ==null) throw new InvalidDataException();
		return this.amount.compareTo(other.amount);
	}
	
	public boolean equals(Object obj) throws InvalidDataException {
		if (obj== null) return false; 
		if (!(obj instanceof Deposit)) return false;
		Deposit other = (Deposit)obj;
		if (this.amount.compareTo(other.amount)==0)
			return true;
		else 
			return false;
	}
		
	public String toString (){
		StringBuffer buffer = new StringBuffer();
		SimpleDateFormat formater = new SimpleDateFormat("MM/dd/YY");
		buffer.append("\n"+formater.format(this.getdateOfDeposit().getTime()));
		buffer.append("\t" + amount );
		return buffer.toString();
	}
}
