package accountHW;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Account {
	
	private Integer id; 
	private Double balance; 
	private static Double annuelIntrestRate; 
	private GregorianCalendar dateCreated; 
	
	//constructor - no args
	//default settings
	public Account (){
		this.id = 0;
		this.balance = 0.0; 
		this.annuelIntrestRate = 0.0; 
		this.dateCreated = new GregorianCalendar();
	} //end Account
	
	//constructor - except id and balance
	public Account (Integer id, Double balance) throws InvalidDataException{
		if (id<=0)
			throw new InvalidDataException(); //if user accidently inputs incorrect info
		else 
			this.id =id; 
		if (balance < 0)
			throw new InvalidDataException();
		else 
			this.balance = balance;
		this.annuelIntrestRate = 0.0;
		this.dateCreated = new GregorianCalendar();	//do i pass a deep copy and not a shallow one
	}//end Account
	
	
	
	// setters/mutators
	
	public void setid(Integer newID) throws InvalidDataException {
		if (newID >0) //id cant be zero or neg
			this.id = newID;
		else 
			throw new InvalidDataException(); //if invalid info entered
	} 
	
	public void setbalance(Double newBalance) throws InvalidDataException {
		if (newBalance >= 0)
			this.balance = newBalance; 
		else 
			throw new InvalidDataException(); //if invalid info entered
	}

	public static void setannuelIntrestRate(Double newRate) {
		annuelIntrestRate = newRate; 
	}
	
	
	//getters/ accessors 
	public Integer getid() {
		return this.id;
	}
	
	public Double getbalance() {
		return this.balance;
	}

	public Double getannuelIntrestRate() {
		return this.annuelIntrestRate; 
	}
	
	//return a copy of the calendar 
	public GregorianCalendar getdateCreated () {
		GregorianCalendar dateCreatedCopy = new GregorianCalendar(
				 dateCreated.get(Calendar.YEAR),
	    	     dateCreated.get(Calendar.MONTH),
	             dateCreated.get(Calendar.DAY_OF_MONTH)	);
		return dateCreatedCopy;
	}
	
	public Double getmonthlyIntrestRate (){
		Double monthlyIntrestRate = this.annuelIntrestRate/100/12;
		return monthlyIntrestRate;
	}
	
	public Double getmonthlyIntrest (){
		Double monthlyIntrest = this.balance * getmonthlyIntrestRate() ; //call get monthly interest rate
		return monthlyIntrest;
	}
	
	/**
	 * subtract amount withdrawn from balance
	 * @param amount -  amount to be withdrawn
	 */
	public void withdraw (Double amount) throws InsufficientFundsException, InvalidDataException {
		if (amount < 0)
			throw new InvalidDataException();
		else if (amount > this.balance)
			throw new InsufficientFundsException();  //if withdraw more than you have 
		else 
			this.balance -= amount;

	}
	
	/**
	 * add amount deposited to balance 
	 * @param amount - amount to be deposited
	 */
	public void deposit(Double amount) throws InvalidDataException{
		if (amount >= 0)
			this.balance += amount;	
		else 
			throw new InvalidDataException(); //if input invalid info
		
	}
	
	
} //end class


