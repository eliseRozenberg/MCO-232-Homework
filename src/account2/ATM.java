package account2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ATM {

	public static void main (String [] args){
		
		int choice,ID;
		Scanner keyboard = new Scanner (System.in);
		
		//instance of bank with 10 dummy accounts
		Bank bank = new Bank();
			bank.addAccount(2000.0);
			bank.addAccount(400.0);
			bank.addAccount(2345.0);
			bank.addAccount(4343.0);
			bank.addAccount(23000.0);
			bank.addAccount(1200.0);
			bank.addAccount(3040.0);
			bank.addAccount(5430.0);
			bank.addAccount(10000.0);
			bank.addAccount(2000.0);
		
		//keep the program looping to calculate new ID
		do{
			System.out.println("Enter an ID:");
			ID = keyboard.nextInt();
			double amount,balance;
			
			//keep program loop until user finished and allows for a new ID 
			do {				 
				choice = menu();
				switch(choice){
			
					case 1://view current balance
						try{
							balance =bank.getCurrentBalance(ID);
							System.out.println(balance);
						}catch(NotFoundException ex1){	//if ID doesn't exist
							System.out.println(ex1);
						}
						break;
						
					case 2://deposit money
						System.out.println("How much money would you like to deposit?");
						amount = keyboard.nextDouble();
						try{
							bank.depositToAccount(ID, amount);
							System.out.println("money deposited");
						}catch(NotFoundException ex2){ //if id doesn't exist
							System.out.println(ex2);
						}
						break;
						
					case 3://withdraw money
						System.out.println("How much money would you like to withdraw?");
						amount = keyboard.nextDouble();
						try{
							bank.withdrawFromAccount(ID, amount);
							System.out.println("money withdrawn");
						}catch(NotFoundException ex2){ 	//if id doesn't exist
							System.out.println(ex2);
						}
						catch(InsufficientFundsException ex3){	//if withdrawal is more than currentBalance
							System.out.println(ex3);
						}
						break;
						
					case 4://view mini statement
						
						//user inputs the dates of witch they want to see - from start date to end date
						GregorianCalendar startDate, endDate;	
						int day,month,year;
						System.out.print("From what date would you like to see the deposits?"+
											"\nDate:(XX) ");
						day = keyboard.nextInt();
						System.out.print("Month:(XX) ");
						month = keyboard.nextInt();
						System.out.print("Year:(XXXX) ");
						year = keyboard.nextInt();
						startDate = new GregorianCalendar(year,(month-1),day);
						System.out.print("Until what date would you like to see the deposits?"+
											"\nDate:(XX) ");
						day = keyboard.nextInt();
						System.out.print("Month:(XX) ");
						month = keyboard.nextInt();
						System.out.print("Year:(XXXX) ");
						year = keyboard.nextInt();
						endDate = new GregorianCalendar(year,(month-1),day);
						
						try{
							System.out.println(bank.getMiniStatement(ID, startDate, endDate));
						}catch(NotFoundException ex4){	//if id doesn't exist
							System.out.println(ex4);
						}
						break;
						
					case 5://view largest deposit
						try{
							System.out.println("Largest Deposit: " + bank.getLargestDeposit(ID));
						} catch(NotFoundException ex4){	//if id doesn't exist
							System.out.println(ex4);
						}
						break;
					case 6://view largest withdrawal
						try{
							System.out.println("Largest Withdrawal: " + bank.getLargestWithdrawal(ID));
						} catch(NotFoundException ex4){		//if id doesn't exist
							System.out.println(ex4);
						}
						break;
				
					
				}//end switch
			}while(choice !=7);
		}while(true);
	}//end main
	
	public static int menu(){
		Scanner keyboard = new Scanner (System.in);
		int choice=0;
		System.out.println("Select an option from the menu:"+
							"\n1. view current balance"+
							"\n2. deposit money"+
							"\n3. withdraw money"+
							"\n4. view mini statement"+
							"\n5. view largest deposit"+
							"\n6. view largest withdrawal"+
							"\n7. EXIT");
		choice = keyboard.nextInt();
		if (choice > 7 ||choice <1){
			do {
				System.out.println("Invalid selection");
				System.out.println("Select an option from the menu:"+
						"\n1. view current balance"+
						"\n2. deposit money"+
						"\n3. withdraw money"+
						"\n5. view mini statement"+
						"\n6. view largest deposit"+
						"\n7. view largest withdrawal"+
						"\n8. EXIT\n");
				choice = keyboard.nextInt();
			
			}while(choice >7 ||choice <1 );
		}//end if
		return choice;
	}
	
}
