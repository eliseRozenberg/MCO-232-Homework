package metroCardCombine;

public enum TypeOfCard {SINGLERIDE(3.00,3.00),PAYPERRIDE(2.75,5.50),UNLIMITED30Days(0.0,116.5),REDUCEDFARE(1.35,5.00);
	
//also stores additional info for each type needed
//it can't be changed or else it needs setters and then it is a class
//no one calls the constructor so its private

   private final double chargePerRide;
   private final double minCostOfCard;

   //Automatically takes the two values and puts it into the parameter
   //sets the privates and then it is - 
   
   private TypeOfCard(double charge,double minCostOfCard){
	   this.chargePerRide = charge;
	   this.minCostOfCard = minCostOfCard;
   }
   
   double getCharge(){
	   return chargePerRide;
   }
   
   double getMinimumCost(){
	   return minCostOfCard;
   }
}
