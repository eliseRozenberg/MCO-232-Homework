 package stocks;

public class UseStock {
	public static void main (String [] args) {

		//new instance of the class  
		Stock stock1 = new Stock ("ORCL", "Oracle Corperation"); 
		System.out.printf("Name: %S (%S)", stock1.getname(), stock1.getsymbol());
		System.out.println(); 
		
		//set the price
		stock1.setpreviousClosingPrice(34.5);
		System.out.println("Previous Closing Price: $" + stock1.getpreviousClosingPrice());
		
		//set the price
		stock1.setCurrentPrice(34.35);
		System.out.println("Current Price: $" + stock1.getcurrentPrice());

		//print the price change percentage 
		System.out.printf("Price-change Percentage: %.3f percent" , stock1.getChangePercent());
		
	} //end main

} //end use stock
