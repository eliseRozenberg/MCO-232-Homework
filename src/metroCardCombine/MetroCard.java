package metroCardCombine;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MetroCard {
   private long metroCardID;	
   private Double balance; 
   private GregorianCalendar expDate;
   private TypeOfCard typeOfCard;
   private ArrayList<Station> stationSwipes;
   //list of stations you passed through
   //keeps track of everyones movements
   
   private static long lastMetroCardID=0;   //class variable
   private static double bonusRate = .11;   //bonus that is applied when a card is replenished
   private static double bonusRateMinimum =5.50;  //minimum amount of money that must be added to card to qualify for bonus
   
   //when user wants to create a new card - the commuter class calls the metro card and passes the type and amount
   public MetroCard(TypeOfCard typeOfCard, Double amount)throws InvalidDataException{
	   if (amount <= 0 || amount < typeOfCard.getMinimumCost())throw new InvalidDataException();
	   
	   this.balance = amount ;
	   if (amount >= bonusRateMinimum) this.balance += amount * bonusRate;
	  
	   this.expDate = (GregorianCalendar)GregorianCalendar.getInstance();  //one method that can be used to initialize  today's date
	   if (typeOfCard.equals(TypeOfCard.SINGLERIDE))
	   {
		   this.expDate.add(Calendar.HOUR, 2); //good for two hours
	   }
	   else if (typeOfCard.equals(TypeOfCard.UNLIMITED30Days)){
		   this.expDate.add(Calendar.DAY_OF_MONTH, 30);  //good for 30 days
		  
	   }
	   else{
	       this.expDate.add(Calendar.YEAR, 1);  //another year
	   }
	   this.typeOfCard = typeOfCard;
	   this.metroCardID = ++lastMetroCardID;
	   //instantiate the ArrayList
	   stationSwipes = new ArrayList<Station>();
	      
   }
   
   public boolean expired(){
	   GregorianCalendar today = new GregorianCalendar();
	   if (today.compareTo(this.expDate)>0)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }
   public void add(Double amount)throws CardExpiredException, InvalidDataException{
	   if (typeOfCard.equals(TypeOfCard.SINGLERIDE)) throw new CardExpiredException(); //cant add money to single ride card
	   if (expired()) throw new CardExpiredException();
	   if (amount <=0 ) throw new InvalidDataException ();
	  
	   this.balance += amount ;
	   if (amount >= bonusRateMinimum) this.balance += amount * bonusRate;
   }
   
   public void swipe (Station aStation)throws CardExpiredException,InsufficientBalanceException{
	   if (expired()) throw new CardExpiredException();
	   
	   //business rules:
	   //a. SINGLERIDECARD is always charged a flat fee for the single swipe
	   //b. Different stations may have different fees 
	   //     PATH - 2.75
	   //     BUS, SUBWAY  2.75 
	   //c. Some cards provide discounts for their riders
	   //     REDUCEDFARE - half fare
	   //     UNLIMITED30Days - free rides for 30 days
	  
	   double chargeForStation = aStation.getStationCharge();
	   double typeOfCardCharge = this.typeOfCard.getCharge();
	   
	   double currentCharge;
	   if (this.typeOfCard.equals(TypeOfCard.SINGLERIDE)){
		   currentCharge = typeOfCardCharge;  //charge this amount - regardless of charge on the station
	   }
	   else{
		  currentCharge =  (typeOfCardCharge < chargeForStation ) ?  typeOfCardCharge : chargeForStation;
	   }
	   
	   if (this.balance >= currentCharge){
		   balance -= currentCharge;  //reduce balance by cost of one trip
		   
	   }
	   else 
		   {
		     throw new InsufficientBalanceException ();  //don't have enough money on the card
		   }
	   
		//now add the Station to the list of Stations at which this card was swiped
	   stationSwipes.add(aStation);
	   
   }
   
   public void merge(MetroCard aCard)throws InvalidDataException{
	   //take the balance that is left on aCard and add that money to the 
	   //balance of 'this' card, then set the balance of aCard to zero
	   double amount = aCard.getBalance();
	   this.balance += amount;
	  
	   aCard.setBalance(0.0);  //since InvalidDataException is a checked exception it must be handled
	                               //in this case, it is being handled by being thrown further down the line
	   
   }
   
   
   public void setBalance(Double balance)throws InvalidDataException {
	  if (balance < 0 )throw new InvalidDataException (); 
	this.balance = balance;
}

public Double getBalance() {
	return balance;
}

public GregorianCalendar getExpDate() {
	GregorianCalendar copyexpDate = new GregorianCalendar();
	copyexpDate.set(Calendar.YEAR,expDate.get(Calendar.YEAR));
	copyexpDate.set(Calendar.MONTH,expDate.get(Calendar.MONTH));
	copyexpDate.set(Calendar.DAY_OF_MONTH, expDate.get(Calendar.DAY_OF_MONTH));
	
	return copyexpDate;
}

public String toString(){
	   DecimalFormat dec_formatter = new DecimalFormat("###.00");
	   StringBuffer info=new StringBuffer();
	   info.append("\nMetroCard");
	   SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
 	   String  formattedDate = date_format.format(expDate.getTime());
		info.append(" Expiration : " +  formattedDate);
	    info.append(  " Balance " + dec_formatter.format(balance));
	    info.append( " Type of Card:" + typeOfCard.toString());
	    info.append(" Stations: [");
	    for (Station t : stationSwipes){
	    	info.append(" " + t.getName());
	    }
	    info.append("]");
	    return info.toString();
   }
   
	


}
