package accountHW;

import java.text.SimpleDateFormat;

public class AccountUse {
	
	public static void main (String [] args)  {
		Account account1 = new Account (1122, 20000.0);  //create a new account with parameters 
	
		account1.setannuelIntrestRate(4.5); 	//set rate 
		
		//try - withdraw - catch if balance is less than withdrawal amount
		try {
			account1.withdraw(2500.0); 			
		}catch(InsufficientFundsException ex1){
			System.out.println(ex1 .getMessage() + " - add money to balance");
			System.exit(1);
		} //end catch

		account1.deposit(3000.0);	//deposit money
	
		System.out.println("Balance: " + account1.getbalance());
		System.out.println("Monthly Intrest: " + account1.getmonthlyIntrest());
		
		
		SimpleDateFormat newDate = new SimpleDateFormat("MM/dd/YYYY"); //format Gregorian Calendar
		System.out.println("Date Created: " + newDate.format(account1.getdateCreated().getTime()));

	} //end main
} //end class