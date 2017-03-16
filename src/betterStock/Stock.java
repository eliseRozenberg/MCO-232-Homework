package betterStock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import stockAns.InvalidPriceException;

public class Stock {
	private String symbol;
	private String company;
	private Double lastRecordedPrice;
	private GregorianCalendar dateRecordedChange;
 
	private ArrayList<PriceRecord> historicalPrices;
 
 
	public Stock(String symbol, String company) throws InvalidPriceException{
		this.symbol = symbol;
		this.company = company;
		this.lastRecordedPrice = null;
		this.dateRecordedChange = null;
  
		//instantiate the ArrayList
		historicalPrices = new ArrayList<PriceRecord>();
	}
 
	public void recordPriceChange(Double newprice) throws InvalidDateException, InvalidPriceException, InvalidPriceException {
		//assume price change is for current date
		GregorianCalendar today = new GregorianCalendar();
  
 
		//add a PriceChange instance to the list of historical prices
		int year, month, day;
		year = today.get(Calendar.YEAR); 
		month = today.get(Calendar.MONTH);
		day = today.get(Calendar.DAY_OF_MONTH);
  
		String date = month +"/" +day +"/" + year;
		PriceRecord aNewRecord = new PriceRecord(date,newprice);
		historicalPrices.add (aNewRecord);
  
		this.lastRecordedPrice = newprice;
		this.dateRecordedChange = today; 
		//modify the lastRecordedPrice stored in this Stock instance
	}
 
	public void recordPriceChange(String date, Double newprice) throws InvalidDateException, InvalidPriceException{
		historicalPrices.add(new PriceRecord(date,newprice));
		this.lastRecordedPrice = newprice;
		
		String [] part = date.split("/");
		int day = Integer.parseInt(part[0]);
		int month = Integer.parseInt(part[1]);
		int year = Integer.parseInt(part[2]);

		this.dateRecordedChange = new GregorianCalendar(day,(month-1),year);
		
		//add a PriceChange instance to the list of historical prices
		//modify the lastRecordedPrice stored in this Stock instance
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
    
    public ArrayList<PriceRecord> getHistoricalPrices() throws InvalidPriceException, InvalidDateException{
    	ArrayList <PriceRecord> copy = new ArrayList<PriceRecord>();
    	for (PriceRecord record: historicalPrices){
    		PriceRecord newRec = new PriceRecord (record.gettransactionDate(), record.getprice());
    		copy.add(newRec);
    	}
    	return  copy;
    }
    
    public Double getLowestPrice() throws NotFoundException{
    	if (historicalPrices.size()==0) throw new NotFoundException();
     return null;
    }
    
    public Double getHighestPrice(){
     return null;
    }
    
    public Double getAveragePrice(){
     return null;
    }
    
    public GregorianCalendar getStartDateHistoricalData(){
     return null;
    }
    
    
}