package account2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Account {
	
	private Integer id; 
	private Double initialBalance; //doesn't change
	private Double currentBalance;
	private static Double annuelIntrestRate=null; 
	private GregorianCalendar dateCreated; 
	private ArrayList<Deposit> deposits;
	private ArrayList<Withdrawal> withdrawals;
	
	//constructor - except id and balance
	public Account (Integer id, Double balance) throws InvalidDataException{
		if (id ==null||balance ==null) throw new InvalidDataException();
		if (id<0)
			throw new InvalidDataException(); //if user accidently inputs incorrect info
		else 
			this.id =id; 
		if (balance < 0)
			throw new InvalidDataException();
		else {
			this.initialBalance = balance;	//both are same when constructed
			this.currentBalance = balance;
		}
		this.dateCreated = new GregorianCalendar();	//do i pass a deep copy and not a shallow one
		deposits=new ArrayList <Deposit> ();
		withdrawals=new ArrayList <Withdrawal> ();
	}//end Account
	
	
	
	// setters/mutators
	
	public void setid(Integer newID) throws InvalidDataException {
		if (newID==null) throw new InvalidDataException();
		if (newID >0) //id cant be zero or neg
			this.id = newID;
		else 
			throw new InvalidDataException(); //if invalid info entered
	} 

	public static void setannuelIntrestRate(Double newRate) throws InvalidDataException{
		if (newRate==null) throw new InvalidDataException();
		annuelIntrestRate = newRate; 
	}
	
	
	//getters/ accessors 
	public Integer getid() {
		return this.id;
	}
	public Double getinitialBalance() {
		return this.initialBalance;
	}
	
	public Double getcurrentBalance() {
		currentBalance = initialBalance; //put initial balance into current and then calculate deposits and withdrawals
		for (Deposit depo: deposits){
			currentBalance =currentBalance+depo.getamount(); 
		}
		for (Withdrawal with: withdrawals){
			currentBalance =currentBalance- with.getamount(); 
		}
		return this.currentBalance;
	}
	
	public Double getbalanceAsOf(GregorianCalendar date) throws InvalidDataException {
		if (date==null) throw new InvalidDataException();
		currentBalance = initialBalance;//get initial balance then add/sub deposits/withdrawals as of a date
		for (Deposit depo: deposits){
			if ( (  depo.getdateOfDeposit().get(Calendar.YEAR)< date.get(Calendar.YEAR)   )	||			//verify if earlier year 
				 (  depo.getdateOfDeposit().get(Calendar.YEAR)== date.get(Calendar.YEAR)&&				//verify if same year earlier month
				    depo.getdateOfDeposit().get(Calendar.MONTH)< date.get(Calendar.MONTH)  ) ||
				 (  depo.getdateOfDeposit().get(Calendar.YEAR)== date.get(Calendar.YEAR) &&				//verify if same year and same month but earlier or same date
				depo.getdateOfDeposit().get(Calendar.MONTH)== date.get(Calendar.MONTH) &&
				depo.getdateOfDeposit().get(Calendar.DAY_OF_MONTH)<= date.get(Calendar.DAY_OF_MONTH)  ) ){
				currentBalance =currentBalance +depo.getamount();
			}
		}
		for (Withdrawal with: withdrawals){
			if  ( (  with.getdateOfWithdrawal().get(Calendar.YEAR)< date.get(Calendar.YEAR)   )		||			//same as deposit
				  (  with.getdateOfWithdrawal().get(Calendar.YEAR)== date.get(Calendar.YEAR)&&
					 with.getdateOfWithdrawal().get(Calendar.MONTH)< date.get(Calendar.MONTH)   )	||
				  (  with.getdateOfWithdrawal().get(Calendar.YEAR)== date.get(Calendar.YEAR) &&
					 with.getdateOfWithdrawal().get(Calendar.MONTH)== date.get(Calendar.MONTH) &&
					 with.getdateOfWithdrawal().get(Calendar.DAY_OF_MONTH)<= date.get(Calendar.DAY_OF_MONTH)  ) ){
				currentBalance = currentBalance- with.getamount(); 	
			}
		}
		return currentBalance;
	} 

	public static Double getannuelIntrestRate() {
		return annuelIntrestRate; 
	}
	
	//return a copy of the calendar 
	public GregorianCalendar getdateCreated () {
		GregorianCalendar dateCreatedCopy = new GregorianCalendar(
				 dateCreated.get(Calendar.YEAR),
	    	     dateCreated.get(Calendar.MONTH),
	             dateCreated.get(Calendar.DAY_OF_MONTH)	);
		return dateCreatedCopy;
	}
	
	//static method because not dependent single user account
	public static Double getmonthlyIntrestRate (){
		Double monthlyIntrestRate = annuelIntrestRate/100/12;
		return monthlyIntrestRate;
	}
	
	public Double getmonthlyIntrest (){
		Double monthlyIntrest = this.getcurrentBalance() * getmonthlyIntrestRate() ; //call get monthly interest rate and currentBalance
		return monthlyIntrest;
	}
	
	/**
	 * subtract amount withdrawn from balance
	 * @param amount -  amount to be withdrawn
	 */
	public void withdraw (Double amount) throws InsufficientFundsException, InvalidDataException {
		if (amount==null) throw new InvalidDataException();
		if (amount < 0)
			throw new InvalidDataException();
		if (amount > getcurrentBalance())
			throw new InsufficientFundsException();  //if withdraw more than you have 
		else{ 
			withdrawals.add(new Withdrawal(amount)); 
		}

	}
	
	/**
	 * add amount deposited to balance 
	 * @param amount - amount to be deposited
	 */
	public void deposit(Double amount) throws InvalidDataException{
		if (amount==null) throw new InvalidDataException();
		if (amount >= 0){
			deposits.add(new Deposit (amount));
		}
		else 
			throw new InvalidDataException(); //if input invalid info
	}
	
	public ArrayList<Deposit> getdeposits(){
		ArrayList<Deposit> depositCopy = new ArrayList<Deposit>();
		for (Deposit depo: deposits){
			depositCopy.add(depo);
		}
		return depositCopy;
	}
	
	public ArrayList<Withdrawal> getwithdrawal(){
		ArrayList <Withdrawal> withdrawalCopy = new ArrayList<Withdrawal>();
		for (Withdrawal with: withdrawals){
			withdrawalCopy.add(with);
		}
		return withdrawalCopy;
	}
	
	public Deposit getLargestDeposit(){
		Deposit largest = deposits.get(0);
		for (Deposit depo: deposits){
			if (depo.compareTo(largest)>0) //call deposit compare to method
				largest = depo;
		}
		return largest;
	}

	public Withdrawal getLargestWithdrawal(){
		Withdrawal largest = withdrawals.get(0);
		for (Withdrawal depo: withdrawals){
			if (depo.compareTo(largest)>0) largest = depo;
		}
		
		return largest;
	}
	
	public String printStatement(GregorianCalendar startDate, GregorianCalendar endDate) throws InvalidDataException{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		if (endDate ==null|| startDate ==null) throw new InvalidDataException();
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nAccount Statement for Account #" + this.id + " As of "+ formatter.format(endDate.getTime())); 
		buffer.append("\nStart Balance: " + getbalanceAsOf(startDate));
		buffer.append("\n");
		buffer.append("\nDepoits:");
		for (Deposit depo: deposits){ 
			if( ( ( depo.getdateOfDeposit().get(Calendar.YEAR)> startDate.get(Calendar.YEAR)   )	||	//check that greater /equal to startDate (same as previous)
				  ( depo.getdateOfDeposit().get(Calendar.YEAR)== startDate.get(Calendar.YEAR)&&
					depo.getdateOfDeposit().get(Calendar.MONTH)> startDate.get(Calendar.MONTH) 	  )	||
				  ( depo.getdateOfDeposit().get(Calendar.YEAR)== startDate.get(Calendar.YEAR) &&
					depo.getdateOfDeposit().get(Calendar.MONTH)== startDate.get(Calendar.MONTH) &&
					depo.getdateOfDeposit().get(Calendar.DAY_OF_MONTH)>= startDate.get(Calendar.DAY_OF_MONTH)  ) )
					&&
			    ( ( depo.getdateOfDeposit().get(Calendar.YEAR)< endDate.get(Calendar.YEAR)   )	||		//check that less than /equal to end date
				  ( depo.getdateOfDeposit().get(Calendar.YEAR)== endDate.get(Calendar.YEAR)&&
					depo.getdateOfDeposit().get(Calendar.MONTH)< endDate.get(Calendar.MONTH) )	||
				  ( depo.getdateOfDeposit().get(Calendar.YEAR)== endDate.get(Calendar.YEAR) &&
					depo.getdateOfDeposit().get(Calendar.MONTH)== endDate.get(Calendar.MONTH) &&
					depo.getdateOfDeposit().get(Calendar.DAY_OF_MONTH) <= endDate.get(Calendar.DAY_OF_MONTH)  ) ) )
					{
				buffer.append(depo);
			}
		}
		buffer.append("\n");
		buffer.append("\nWithdrawals:");
		for (Withdrawal with: withdrawals){
			if( ( (  with.getdateOfWithdrawal().get(Calendar.YEAR) > startDate.get(Calendar.YEAR)   )		||			//same as deposit
			      ( with.getdateOfWithdrawal().get(Calendar.YEAR)== startDate.get(Calendar.YEAR)&&
				    with.getdateOfWithdrawal().get(Calendar.MONTH)> startDate.get(Calendar.MONTH)  )	||
				  ( with.getdateOfWithdrawal().get(Calendar.YEAR)== startDate.get(Calendar.YEAR) &&
					with.getdateOfWithdrawal().get(Calendar.MONTH)== startDate.get(Calendar.MONTH) &&
					with.getdateOfWithdrawal().get(Calendar.DAY_OF_MONTH)>= startDate.get(Calendar.DAY_OF_MONTH) ) )
					&&
				( ( with.getdateOfWithdrawal().get(Calendar.YEAR)< endDate.get(Calendar.YEAR)   )		||
				  ( with.getdateOfWithdrawal().get(Calendar.YEAR)== endDate.get(Calendar.YEAR)&&
					with.getdateOfWithdrawal().get(Calendar.MONTH)< endDate.get(Calendar.MONTH)   )	||
				  ( with.getdateOfWithdrawal().get(Calendar.YEAR)== endDate.get(Calendar.YEAR) &&
					with.getdateOfWithdrawal().get(Calendar.MONTH)== endDate.get(Calendar.MONTH) &&
					with.getdateOfWithdrawal().get(Calendar.DAY_OF_MONTH)<= endDate.get(Calendar.DAY_OF_MONTH)  ) ) ){
				buffer.append(with);
			}
		}
		buffer.append("\n");
		buffer.append("\nEndBalance: " + getbalanceAsOf(endDate));
		return buffer.toString();	
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		SimpleDateFormat formmater = new SimpleDateFormat("MM/dd/YY");
		buffer.append("\nAccount #" + id);
		buffer.append("\tDate Created: " + formmater.format(dateCreated.getTime()));
		buffer.append("\tInitial Balance: " + initialBalance);
		buffer.append("    Current Balance: " + currentBalance);
		return buffer.toString();
		}
	
} //end class


