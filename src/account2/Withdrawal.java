package account2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pointOfSale.InvalidDataException;

public class Withdrawal {
	
	private GregorianCalendar dateOfWithdrawal;
	private  Double amount;
	
	public Withdrawal(Double amount){
		this.dateOfWithdrawal = new GregorianCalendar();
		this.amount = amount;
	}
	
	public Double getamount(){
		return amount;
		
	}
	public GregorianCalendar getdateOfWithdrawal(){
		GregorianCalendar copy = new GregorianCalendar(dateOfWithdrawal.get(Calendar.YEAR),
													   dateOfWithdrawal.get(Calendar.MONTH),
													   dateOfWithdrawal.get(Calendar.DAY_OF_MONTH));
		return copy;
		
	}
	

	public Integer compareTo(Withdrawal other) throws InvalidDataException{
		if (other ==null) throw new InvalidDataException();
		return this.amount.compareTo(other.amount);
	}
	
	public boolean equals(Object obj) throws InvalidDataException {
		if (obj== null) return false; 
		if (!(obj instanceof Withdrawal)) return false;
		Withdrawal other = (Withdrawal)obj;
		if (this.amount.compareTo(other.amount)==0)
			return true;
		else 
			return false;
	}
	
	public String toString (){
		StringBuffer buffer = new StringBuffer();
		SimpleDateFormat formater = new SimpleDateFormat("MM/dd/YY");
		buffer.append("\n" + formater.format(this.getdateOfWithdrawal().getTime()));
		buffer.append("\t" + amount );
		return buffer.toString();
	}
}
