package compareLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapsackCompare {
	
	public static void main(String[] args) {
		
		int adinaSupplyQty =0;  				 	// how many supplies Adina has in her knapsack
		int brachaSupplyQty=0;    					// how many supplies Bracha has in her knapsack
		String[] adinaSupplies = new String[20];	// list of Adina’s supplies
		String[] brachaSupplies = new String[20];	// list of Bracha’s supplies
		
		//read in and store each student’s list of supplies
		try {										
			Scanner input = new Scanner (new File ("./AdinaSupplies.txt"));
			//file has been found, connection made
			
			System.out.println("Adina's Supply List:\n");
			
			while (input.hasNext()) {									//while there are more supplies listed in the file
				
				if (adinaSupplyQty < adinaSupplies.length) {			//if there is room in the array
					adinaSupplies[adinaSupplyQty] = input.nextLine();	//read in supply and store it into the array
					System.out.println(adinaSupplies[adinaSupplyQty]);	//display the list to show file has been read
					adinaSupplyQty++;									//increase counter
					}	//end if
				else {													//if there is no more room in the array
					System.out.println("sufficient data");
					break;
					}	//end else
				
				}	//end while
			
			input = new Scanner (new File ("./BrachaSupplies.txt"));
			//file has been found, connection made
			
			System.out.println("\nBracha's Supply List:\n");
			while (input.hasNext()){									//while there are more supplies listed in the file
				
				if (brachaSupplyQty < brachaSupplies.length){			//if there is room in the array
					brachaSupplies[brachaSupplyQty] = input.nextLine();	//read in the supply and store it in the array
					System.out.println(brachaSupplies[brachaSupplyQty]);//display the list to show file has been read
					brachaSupplyQty++;  								//increase counter
					}	//end if
				
				}	//end while
			
			input.close();//close file									//close the files
			
			}	//end try
		
		//if files not found
		catch (FileNotFoundException ex) {	
			System.out.println("missing data");
			System.exit(1);
			}	//end catch

         // find out which supplies both students have in their knapsacks
		 String[] matchingSupplies = SameSupplies.sameSupplies (adinaSupplies, adinaSupplyQty, brachaSupplies, brachaSupplyQty);
		
		 System.out.println("\nAdina and Bracha both have:\n");
        
		 int s=0;														//counter for array element
         while (matchingSupplies[s] != null) {							//while the element in the array has a string in it
        	System.out.println(matchingSupplies[s]);					//display the content
        	s++;														//increase the counter to go to next element
         	}	//end while
		  
		System.out.println("\nThe supplies Adina has that Bracha doesn't:\n");
		String [] adinaSuppliesOnly = MySuppliesOnly.mySpecialSupplies (adinaSupplies, adinaSupplyQty, brachaSupplies, brachaSupplyQty);
		
		 for (int i =0; i <adinaSuppliesOnly.length; i++) {					//for every element in the array
	        	if (adinaSuppliesOnly[i] != null) 							//if there is a string in the element
	        	System.out.println(adinaSuppliesOnly[i]);					//display the content															
	         	}	//end for
		
		 System.out.println("\nThe supplies Bracha has that Adina doesn't:\n");
		 String [] brachaSuppliesOnly = MySuppliesOnly.mySpecialSupplies (brachaSupplies, brachaSupplyQty, adinaSupplies, adinaSupplyQty);
			
		 for (int i =0; i <brachaSuppliesOnly.length; i++) {				//for every element in the array			
			 if (brachaSuppliesOnly[i] != null)								//if there is a string the element
			 System.out.println(brachaSuppliesOnly[i]);						//display the content											
	         	}	//end for
		
	}	//end main
	
}	//end class