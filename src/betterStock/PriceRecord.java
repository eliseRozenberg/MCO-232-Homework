package betterStock;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import stockAns.InvalidPriceException;
	public class PriceRecord {
		private GregorianCalendar transactionDate;
		private Double currentPrice;
 
 
		public PriceRecord(String date, Double currentPrice) throws InvalidPriceException, InvalidDateException{ 
			//invoke the String / method
			//string vlass comes with a split method that will split it based on a regular character
			//picked a slash bc thats how they are usually seperated
			//it will put into array of three elements and each element will be another part of it
			//then use part int to convert to int values and use it to create a gregorian calendar
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
 
		public int compareTo(PriceRecord otherPrice){
			return this.transactionDate.compareTo(otherPrice.transactionDate);
			//on what should the comparison be based, price or date or both
			//let us choose date
		}
 
		public boolean equals(Object obj){
			//must be synchronized with compareTo method
			if (obj == null) return false;
			if  ( !(obj instanceof PriceRecord)) return false;
			else{
				PriceRecord otherPrice  =              (PriceRecord) obj;  //typecast obj
				if (transactionDate.compareTo(otherPrice.transactionDate)==0)
				{ return true;
				}
     
				else{
					return false;
				}
			}
  
		}
		public Double getprice (){
			return this.currentPrice;
		}
		
		public GregorianCalendar gettransactionDate(){
			GregorianCalendar copy = new GregorianCalendar(
					this.transactionDate.get(Calendar.YEAR),
					this.transactionDate.get(Calendar.MONTH),
					this.transactionDate.get(Calendar.DAY_OF_WEEK)
					); 
			return copy;
		}

		public String toString(){
			StringBuffer buffer = new StringBuffer();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			String date = formatter.format(transactionDate.getTime());
			buffer.append("Date: " + date);
			buffer.append("Price: "+ currentPrice);
			return buffer.toString();
		}
		/*public String toString(){
			SimpleDateFormat formatter = new SimpleDateFormat("mm/DD/yyyy");
			String date = formatter.format(transactionDate);
			return "\nPriceChange " + date + " Price: " + currentPrice;
		}*/
	}
