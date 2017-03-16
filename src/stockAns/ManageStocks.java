package stockAns;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageStocks {

	public static void main(String[] args) {
		ArrayList<Stock> ourStocks = new ArrayList<Stock>();
		Scanner keyboard = new Scanner(System.in);
		String symbol;
        int choice=0;
        do{
        	choice = menu();
        	switch(choice){
        	
        	case 1:   //add a stock to list
        		ourStocks.add(enterStockData());
        		break;
        	case 2:  //remove a stock from list
        		System.out.println("Enter stock symbol");
        		symbol = keyboard.next();
        		Stock found = findStock(symbol, ourStocks);
        		if (found == null){
        			System.out.println("cant find the stock with symbol " + symbol + " in the collection");
        		}
        		else {
        			ourStocks.remove(found);
        		}
        		
        		break;
        	case 3://record a price change of a stock
        		System.out.println("Enter stock symbol");
        		symbol = keyboard.next();
        		found = findStock(symbol, ourStocks);
        		if (found == null){
        			System.out.println("cant find the stock with symbol " + symbol + " in the collection");
        		}
        		else{
        		   System.out.println("enter new price");
        		   Double price = keyboard.nextDouble();
        		   System.out.println("change is being recorded for today? enter Y or N");    
        		   char response = keyboard.next().charAt(0);
        		   if (response == 'Y' || response == 'y'){
        			   try{
        		           found.recordPriceChange(price);
        			   }
        			   catch(InvalidPriceException ex){
        				   System.out.println("price entered was invalid, change not processed ");
        			   }
        			   catch (InvalidDateException ex2){
        				   System.out.println("invalid date provided , change not processed ");
        			   }
        		   }
        		   else{
        			   //price change being recorded for a specific date....
        			   System.out.println("Enter date in mm/dd/yyyy format");
        			   String date = keyboard.next();
        			   
        			   try{
        		           found.recordPriceChange(date, price);
        			   }
        			   catch(InvalidPriceException ex2){
        				   System.out.println("price entered was invalid, change not processed ");
        			   }
        			   catch(InvalidDateException ex3){
        				   System.out.println("invalid date provided , change not processed ");
        			   }
        		
        			         			   
        		   }
        		}
        		break;
        	case 4:  //list historical prices of a stock
        		System.out.println("Enter stock symbol");
        		symbol = keyboard.next();
        		found = findStock(symbol, ourStocks);
        		System.out.println(" Historical Prices for Stock " + found.getSymbol());
        		try{
        		System.out.println(found.getHistoricalPrices());
        		}
        		catch(InvalidDateException ex){
        			System.out.println("data has date errors see IT");
        		}
        		catch(InvalidPriceException ex1){
        			System.out.println("data has price errors see IT");
        		}
        		break;
        	case 5: //view highest price of a stock
        		System.out.println("Enter stock symbol");
        		symbol = keyboard.next();
        		found = findStock(symbol, ourStocks);
        		System.out.println("Highest Price for Stock " + found.getSymbol());
        		System.out.println(found.getHighestPrice());
        		
        		break;
        	case 6: //view lowest price of a stock
        		System.out.println("Enter stock symbol");
        		symbol = keyboard.next();
        		found = findStock(symbol, ourStocks);
        		System.out.println("Lowest Price for Stock " + found.getSymbol());
        		System.out.println(found.getLowestPrice());
        		break;
        	case 7: //view current price of a stock
        		System.out.println("Enter stock symbol");
        		symbol = keyboard.next();
        		found = findStock(symbol, ourStocks);
        		System.out.println("Current Price of Stock " + found.getSymbol());
        		System.out.println(found.getCurrentPrice());
        		break;
        	case 8:
        		System.out.println(ourStocks);
        		break;
        	
        	case 0:
        		System.out.println("have a nice day....shutting down......");
        		System.exit(0);
        		break;
        	
        	}
        }while (choice != 0);

	}
	
	
	private static Stock findStock(String symbol,ArrayList<Stock> stocks){
		//return the Stock with a specific symbol
		for (Stock s : stocks){  //check each Stock in the collection of Stocks
			if (s.getSymbol().equalsIgnoreCase(symbol))
				return s;   //return direct reference to a specific Stock in the collection
		}
		return null;
	}
	
	private static Stock enterStockData(){
		Scanner keyboard = new Scanner (System.in);
		String symbol, company;
		
		System.out.println("Stock SYMBOL ");
		symbol = keyboard.next();
		System.out.println("Company Name: ");
	    keyboard.nextLine();
		company = keyboard.nextLine();
		
		
		return new Stock(symbol,company);
		
		
		
		
		
	}
	
	public static int menu(){
		int choice;
		Scanner keyboard = new Scanner(System.in);
			do{
				System.out.println("\n1. Record new stock\n2. Remove a stock\n3. Add price change of a Stock\n4. Get Historical Prices of a Stock\n5.Get Highest Price of a Stock\n6. Get Lowest Price of Stock\n7. Get Current Price of Stock\n8. List all Stock data\n0. EXIT");
	
			    choice = keyboard.nextInt();
		   } while (choice > 8);
			return choice;
	}

}
