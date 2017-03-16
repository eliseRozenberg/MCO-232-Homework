package metroCardCombine;

public class UseStation {

   	 public static void main (String [] args) {
   	  
   	 	StationType aStationType = StationType.BUS;
   	 		aStationType = StationType.SUBWAY;
   	 		System.out.println(aStationType);
   	    	System.out.println(aStationType.ordinal() + " " + aStationType.name()); 
   	    	//get the value internally (0 = path , 1 = bus , 2 = subway)
   	    	//if you want it to be alphabetically compared then set it up in order 
   	    	
	    	System.out.println();

	    	System.out.println("Station types: ");
   	    	for (StationType type : StationType.values()) {
   	    		
   	    		//creates an array - with all the different values in the enumerated type
   	    		System.out.println(type);
   	    	}
   	 
   	    	
	    	System.out.println("Type of cards");
	    	for (TypeOfCard cardType : TypeOfCard.values()) {
   	    		System.out.println(cardType);
   	    		System.out.println(cardType.getCharge() + " " + cardType.getMinimumCost());

   	    	}
   	 
   	  }
   	 

}