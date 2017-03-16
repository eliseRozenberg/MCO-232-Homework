package stocks;

public class Stock {

	private String symbol;					//stock's symbol
	private String name;					//stock's name
	private double previousClosingPrice;	//stock price for the previous day
	private double currentPrice;			//stock price for the current time
	

	/**
	 * 
	 * @param sym - stock symbol 
	 * @param stockName - stock name
	 */
	public Stock (String sym, String stockName) {
		this.symbol = sym;
		this.name = stockName; 
		this.previousClosingPrice = 0;
		this.currentPrice = 0; 
	}
	
	
	
	// getter - current price
	public double getcurrentPrice() {
		return this.currentPrice; 
	} //end getCurrentPrice
	
	
	
	//getter-previous closing price
	public double getpreviousClosingPrice(){
		return this.previousClosingPrice; 
	} //end getPrevious
	
	
	
	//set the current price
	public void setCurrentPrice( double newPrice) {
		this.currentPrice = newPrice;  
	} //end setCurrent
	
	
	
	//set the previous price
	public void setpreviousClosingPrice( double newPrice) {
		this.previousClosingPrice = newPrice;  
	} //end setpreviousClosing
	
	
	
	//get company symbol
	public String getsymbol() {
		return this.symbol;
	} //end getSymbol
	
	
	
	//get company name
	public String getname () {
		return this.name; 
	}// end getName
	
	
	
	//calculate % of change		
	public double getChangePercent() {
		double change =
				( (this.currentPrice - this.previousClosingPrice)/ this.currentPrice)* 100 ;
		return change; 
	} //end getChange
	
	
}
