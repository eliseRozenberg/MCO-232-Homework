package stockAns;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Stock {
	private String symbol;
	private String company;
	private Double lastRecordedPrice;
	private GregorianCalendar dateRecordedChange;
	
	private ArrayList<PriceRecord> historicalPrices;

	
	
	public Stock(String symbol, String company){
		this.symbol = symbol;
		this.company = company;
		this.lastRecordedPrice = null;
		this.dateRecordedChange = null;
		
		//instantiate the ArrayList
		historicalPrices = new ArrayList<PriceRecord>();
	}
	
	public void recordPriceChange(Double newprice)throws InvalidDateException,InvalidPriceException{
		//assume price change is for current date , retrieve the current system date
		GregorianCalendar today = new GregorianCalendar();
		
		
		
		//add a PriceRecord instance to the list of historical prices
		PriceRecord aNewPriceRecord = new PriceRecord(today,newprice);
		
		
		
		historicalPrices.add(aNewPriceRecord);
		//modify the lastRecordedPrice stored in this Stock instance, assuming it was set up correctly
		this.dateRecordedChange = today;
		this.lastRecordedPrice = newprice;
		
	}
	
    public void recordPriceChange(String date, Double newprice)throws InvalidDateException, InvalidPriceException{
    	
    	PriceRecord aNewPriceRecord = new PriceRecord(date,newprice);
    	//add a PriceRecord instance to the list of historical prices
    	historicalPrices.add(aNewPriceRecord);
    	//modify the lastRecordedPrice stored in this Stock instance
    	
    	
    	this.dateRecordedChange = convertStringtoDate (date);
		this.lastRecordedPrice = newprice;
    	
    }
    
    public String getSymbol(){
    	return symbol;
    }
    
    public String getCompany(){
    	return company;
    }
    
    
    public Double getCurrentPrice(){
    	return lastRecordedPrice;
    }
    
    public ArrayList<PriceRecord> getHistoricalPrices()throws InvalidPriceException,InvalidDateException{
    	//return a deep copy
    	
    	//set up another ArrayList
    	ArrayList<PriceRecord> prices = new ArrayList<PriceRecord>();
    	
    	for (PriceRecord record : historicalPrices){  //retrieve each record stored in the historicalPrices list
    	  
    		prices.add(new PriceRecord(record.getDateAsString(),record.getPrice()));
    	   
    		
    	}
    	return prices;
    }
    
    public Double getLowestPrice()throws NotFoundException{
    	//if there are no prices throw exception
    	if (historicalPrices.size()==0) throw new NotFoundException();
    	//iterate through the ArrayList, determine which was the lowest price of this particular stock
    	
    	Double lowest = historicalPrices.get(0).getPrice();  //assume first price is the lowest one
    	
    	for (PriceRecord record : historicalPrices){
    		if (record.getPrice().compareTo(lowest)<0){
    			//found one that is less
    			lowest = record.getPrice();
    		}
    	}
       	
    	return lowest;
    }
    
    
    public Double getHighestPrice()throws NotFoundException{
    	//if there are no prices throw exception
    	if (historicalPrices.size()==0) throw new NotFoundException();
    	//iterate through the ArrayList, determine which was the highest price of this particular stock
    	
    	Double highest = historicalPrices.get(0).getPrice();  //assume first price is the highest one
    	
    	for (PriceRecord record : historicalPrices){
    		if (record.getPrice().compareTo(highest)>0){
    			//found one that is less
    			highest = record.getPrice();
    		}
    	}
       	
    	return highest;
    }
    
    public Double getAveragePrice()throws NotFoundException{
    	
    	//if there are no prices throw exception
    	if (historicalPrices.size()==0) throw new NotFoundException();
    	//iterate through the ArrayList, calculate the sum total of all prices
       
    	Double sum = 0.0;
    	
    	for (PriceRecord record : historicalPrices){
    		sum += record.getPrice();
    		
    	}
       	
    	return sum / historicalPrices.size();
    }
    
    public String getStartDateHistoricalData()throws NotFoundException{
    	//return the date from which data has been recorded
    	
    	//if there are no prices throw exception
    	if (historicalPrices.size()==0) throw new NotFoundException();
    	return historicalPrices.get(0).getDateAsString();
    }
    
    
    public String toString(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("\nStock: Symbol ");
    	buffer.append(this.symbol);
    	buffer.append(" Company: ");
    	buffer.append(this.company);
    	buffer.append(" Historical Prices" );
    	for (PriceRecord record : historicalPrices){
    		buffer.append(record.toString());
    	}
    	return buffer.toString();
    }
    
    private GregorianCalendar convertStringtoDate(String date)throws InvalidDateException{
    	//invoke the String / method
    			String[] parts = date.split("/");
    			if (parts.length !=3)throw new InvalidDateException();
    			
    			int month = Integer.parseInt(parts[0]);  //convert the String to an Integer
    			int day = Integer.parseInt(parts[1]);
    			int year = Integer.parseInt(parts[2]);
    			
    			//validate the month and day if you wish
    			
    			return new GregorianCalendar(year, month-1, day);
    }
    
}
