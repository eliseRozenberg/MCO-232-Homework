package compareLists;

public class SameSupplies {
	
	 /**
		 * 
		 * @param suppliesOne  -first list of supplies
		 * @param oneQty       -quantity of significant values in the first list of supplies
		 * @param suppliesTwo  -second list of supplies
		 * @param twoQty       -quantity of significant values in second list of supplies
		 * @return             -list that includes only those values that appear in both lists 
		 */
		public static String[] sameSupplies(String[] suppliesOne,int oneQty, String[] suppliesTwo, int twoQty ) {
			String[] sameSuppliesList = new String [20];
			int n=0;														// counter for the sameSuppliesList array
			
			for (int i=0; i < oneQty; i++ ){								//run through the entire first list
				for (int r=0; r<twoQty; r++){								//for each of the first compare to all of the second
					if (suppliesOne[i].equalsIgnoreCase(suppliesTwo[r])){	//if the elements are the same
					sameSuppliesList[n] = suppliesOne [i];					//assign it to the array
						n++;
					
						}	//end if
					}	//end inner for
				}	//end outer for
			
			return sameSuppliesList;
			
			}	//end sameSupplies method 

		

}
