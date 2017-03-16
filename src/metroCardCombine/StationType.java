package metroCardCombine;

//3 types of stations

public enum StationType { PATH(2.75),BUS(2.75),SUBWAY(2.75);

   private double charge;
   
   /**
    * private constructor - for java
    * @param charge
    */
   private StationType(double charge){
	   this.charge = charge;
   }

   public double getCharge(){
	   return charge;
   }
}


