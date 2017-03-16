package randomNumGen;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class RandomNumbers {

	public static void main(String[] args) {
		
		int tempVal;							// temporarily holds value read from file
		int [] numbers = new int [100];			// to store the occurrences of numbers from 1-100
		
		try {
			
			Scanner input = new Scanner (new File ("./randomNumbers.txt"));
			//file has been found 
				
			/*while there are more values in the file
			 * and the value is not 0 (assuming input ends with 0)
			 */
			
			while (input.hasNext()){
			
				tempVal = input.nextInt();	// input the value into the temporary variable	
				
				if (tempVal==0)				// then file is finished 
					break;					// leave the loop and close the file
				
				numbers [tempVal - 1] +=  1; 	//add 1 to the value of the array at the correct index 
				
			}	//end while
			
			
			input.close();	// close the file 
			System.out.println("file successfully scanned and closed");
			
		} //end try
		
		//file has not been found 
		catch (FileNotFoundException ex) {
			System.out.println("File cannot be found - missing data");
			System.exit(1);
		}	//end catch
		
		System.out.println("\n*************************");
		System.out.println ("The occurence of each \n number is listed: ");
		System.out.println("*************************\n");
		
		
		for (int n=0; n<100; n++) {
			if (numbers [n] == 0 )
				System.out.println( (n+1) + " never occurs");
			else if (numbers [n] == 1)
				System.out.println( (n+1) + " occurs 1 time");
			else if (numbers [n] > 1)
				System.out.println( (n+1) + " occurs " + numbers[n] + " times" );
		}	//end for 
		
	
	}	// end main

}	//end class
