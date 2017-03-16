package stockAns;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PriceRecord {
	private GregorianCalendar transactionDate;
	private Double currentPrice;
	
	
	public PriceRecord(String date, Double currentPrice)throws InvalidDateException, InvalidPriceException{
		//invoke the String / method
		String[] parts = date.split("/");
		int month = Integer.parseInt(parts[0]);  //convert the String to an Integer
		int day = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		
		//validate the month and day if you wish
		
		transactionDate = new GregorianCalendar(year, month-1, day);
		if (currentPrice < 0){
			throw new InvalidPriceException();
		}
		
		else{
		   this.currentPrice = currentPrice;
		}
		
	}
	
	public PriceRecord(GregorianCalendar date, Double currentPrice)throws InvalidPriceException{
		this.transactionDate = date;
		if (currentPrice < 0){
			throw new InvalidPriceException();
		}
		else{
		   this.currentPrice = currentPrice;
		}
		
		
		
		
	}
	
	
	public String getDateAsString(){
		int month, day, year;
		month = this.transactionDate.get(Calendar.MONTH)+1;
		day = this.transactionDate.get(Calendar.DAY_OF_MONTH);
		year = this.transactionDate.get(Calendar.YEAR);
		
		return month + "/" + day +"/" + year;
	}
	
	public Double getPrice(){
		return this.currentPrice;
	}
	
	public int compareTo(PriceRecord otherPrice){
		//on what should the comparison be based, price or date or both
		//let us choose date
		return this.transactionDate.compareTo(otherPrice.transactionDate);
	}
	
	public boolean equals(Object obj){
		//must be synchronized with compareTo method
		if (obj == null) return false;
		if  ( !(obj instanceof PriceRecord)) return false;
		else{
			PriceRecord otherPrice  =    (PriceRecord) obj;  //typecast obj
		    if (transactionDate.compareTo(otherPrice.transactionDate)==0)
		    { return true;
		    }
		   
		    else{
		    	return false;
		    }
		}
		
	}
	
	public String toString(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String date = formatter.format(transactionDate.getTime());
		return "\nPriceChange " + date + " Price: " + currentPrice;
	}

}
