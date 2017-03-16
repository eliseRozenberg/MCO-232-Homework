package compareLists;

public class MySuppliesOnly {
	

	 /**
	   * 
	   * @param mySupplies  - list that contains set of values
	   * @param myQty       - quantity of values in the list 
	   * @param yourSupplies  - another list that contains a set of values
	   * @param yourQty     - quantity of significant values in the second list
	   * @return  -list that contains only those values that appear in first list but not in second
	   */
	public static String[] mySpecialSupplies(String[] mySupplies, int myQty, String[] yourSupplies, int yourQty) {
		
		String[] mySuppliesOnly = new String[myQty];						//to hold the supplies that are different
		int r, n=0;	
		//int r declared outside loop to retain it's value
		//int n counter for mySuppliesOnly array
		
		for (int i=0; i< myQty; i++) {										//to run through the entire first list
			for (r=0;r< yourQty; r++){										//and compare to every line in the second list
				if (mySupplies[i].equalsIgnoreCase(yourSupplies[r]))		//if any are the same 
					break;													//go to the next line on the first list
				}	//end inner for
			
			if (r==yourQty) {												//once every iteration is complete 
				mySuppliesOnly[n] = mySupplies[i];							//assign it to the array
				n++;
			}//end if 
				 
		
	        }	//end outer for

	        //return the list of supplies that appear in the first list but not in the second 
		    return mySuppliesOnly;

		}	//end mySpecialSuppplies method



}
