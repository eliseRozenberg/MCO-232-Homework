package account2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AccountUse {
	
	public static void main (String [] args)  {
		Account account1 = new Account (1122, 20000.0);  //create a new account with parameters 
	
		Account.setannuelIntrestRate(4.5); 	//set rate 
		
		//try - withdraw - catch if balance is less than withdrawal amount
		System.out.println("Balance: " + account1.getcurrentBalance());


		account1.deposit(3000.0);	//deposit money
		account1.deposit(3000.0);	//deposit money
		account1.deposit(3000.0);	//deposit money
		account1.deposit(3000.0);	//deposit money
		try{
			account1.withdraw(3.0);
		} catch(InsufficientFundsException ex1){System.out.println("not enough");}
	
		System.out.println("Balance: " + account1.getinitialBalance());
		System.out.println("Monthly Intrest: " + account1.getmonthlyIntrest());
		System.out.println("current: " + account1.getcurrentBalance());

		account1.deposit(30.0);	//deposit money

		
		SimpleDateFormat newDate = new SimpleDateFormat("MM/dd/YYYY"); //format Gregorian Calendar
		System.out.println("Date Created: " + newDate.format(account1.getdateCreated().getTime()));
		System.out.println(account1.printStatement(new GregorianCalendar(2015,5,2), new GregorianCalendar(2015,5,2)));

	} //end main
} //end class