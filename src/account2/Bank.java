package account2;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Bank {

	private ArrayList<Account> accounts;
	private static Integer lastCount =0; 
	
	public Bank(){
		accounts = new ArrayList<Account>();
	}
	
	public void addAccount (Double initialBalance)throws InvalidDataException{
		if (initialBalance ==null)throw new InvalidDataException();
		accounts.add(new Account(lastCount++, initialBalance));
	}
	
	public void depositToAccount(Integer id, Double amount) throws NotFoundException, InvalidDataException {
		if (amount ==null ||id ==null) throw new InvalidDataException();
		boolean found = false;
		for (Account acc: accounts){
			if (acc.getid()==id){
				acc.deposit(amount);
				found =true;
				break;
			}//end if
		}//end for
		if (!found) throw new NotFoundException();
	}//end deposit
	
	
	public void withdrawFromAccount(Integer id, Double amount) throws InvalidDataException, NotFoundException, InsufficientFundsException{
		if (id ==null|| amount ==null)throw new InvalidDataException();
		boolean found = false;
		for (Account acc: accounts){
			if (acc.getid()==id){
				acc.withdraw(amount);
				found = true;
				break;
			}//end if
		}//end for
		if (!found)  throw new NotFoundException();
	}//end withdraw
	
	public Double getCurrentBalance(Integer id) throws InvalidDataException, NotFoundException{
		if (id ==null)throw new InvalidDataException();
		boolean found = false;
		for (Account acc: accounts){
			if (acc.getid()==id){
				found = true;
				return acc.getcurrentBalance();
			}//end if
		}//end for
		if (!found) throw new NotFoundException();
		return null;
	}
	
	public Deposit getLargestDeposit(Integer id) throws InvalidDataException, NotFoundException {
		if (id ==null)throw new InvalidDataException();
			boolean found = false;
			for (Account acc: accounts){
				if (acc.getid()== id){
					found = true;
					return acc.getLargestDeposit(); 
				}
			}
			if (!found) throw new NotFoundException();
			return null;
	}
	
	public Withdrawal getLargestWithdrawal(Integer id) throws InvalidDataException, NotFoundException{
		if (id ==null)throw new InvalidDataException();
		boolean found = false;
		for (Account acc: accounts){
			if (acc.getid()== id){
				found = true;
				return acc.getLargestWithdrawal(); 
			}
		}
		if (!found) throw new NotFoundException();
		return null;
	}
	
	//does it get start date and end date or make an new method statement
	public String getMiniStatement(Integer id, GregorianCalendar startDate, GregorianCalendar endDate) throws InvalidDataException, NotFoundException{
		if (id ==null|| startDate ==null||endDate ==null)throw new InvalidDataException();
		boolean found = false;
		for (Account acc: accounts){
			if (acc.getid()==id){
				found = true;
				return acc.printStatement(startDate,endDate);
			}//end if
		}//end for	
		if (!found) throw new NotFoundException();
		return null;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (Account acc: accounts){
			buffer.append(acc);
		}
		return buffer.toString();
	}
}
