package randomNumGen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberOccurence{
	public static void main (String[] args){
		try{
			Scanner input = new Scanner (new File ("./randomNumbers.txt"));
			int[] number = new int [100];
			
			for (int i = 0; i < number.length; i++)
				number[i] = input.nextInt(); // assigns each next int to the next element of the array
			
			/** create a new array to count occurence */
			int[] count = new int[101];
			int i = 0, j = 0;
			
			// For each number between 1 and 100 in the array, count it
			for (j = 0; j < count.length; j++){
				i = 0; // starts from the beginning of the numbers array each time the loop reiterates
				while (i < number.length){
					if (j == number[i])
						count[j]++;
					i++;
				} 
			}
			
					
			// displays the occurence for each number
			for (j = 1; j < count.length; j++){ // 0 is not included in the count so i started from 1
				if (count[j] == 1) // proper english
				System.out.println(j + " occurs " + count[j] + " time.");
				else
				System.out.println(j + " occurs " + count[j] + " times.");
			}
			input.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("missing data");
			System.exit(1);
		}
	}
}