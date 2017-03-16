//2d ragged to hold 10 rows and diff amnt collumns
//method to read data into ragged array
//will need to know how many in each line
//do split w space but will need to ocnvert to numeric 

package quiz;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;


public class notQuiz {

	public static void main (String [] args) {
		
		int total=0;
		int qty=0;
		int place;
		String [] token;
		String values; 
		int [][] num = new int [10][];
		
		try {
			Scanner input = new Scanner (new File ("./num.txt"));
			
			while (input.hasNext() && qty< num.length) {
				values = input.nextLine(); 
				token = values.split(" ");
				num[qty] = new int [token.length];
				for (int i=0; i<token.length; i++)
					num [qty][i]= Integer.parseInt(token[i]);
				//convert form the string to the int- needed the string. split 
				qty++;
			} //end while
			
			input.close();
		} //end try
		
		catch (FileNotFoundException ex) {
			System.out.println("file not found"); 
			System.exit(1); 
		} //end catch
		
		//in every array do qty bc maby x fill
		//but in a 2d- ragged only do first qty for row
		//in a not raggd need for both
		int [] ten = new int [qty];
		int r=0;
		for (int h=0; h<qty; h++) {
			for (int g=0; g< num[h].length; g++) {
				System.out.print(num[h][g] + "\t");
				total += num[h][g];
					if (num[h][g] == 10) {
						ten [r] = h;
						r++;
					} //end if
					
			} //end inner for
			System.out.println("");
		} //end for
		
		System.out.println("");
		System.out.println(total); 
		
		
		for (int h=0; h<qty; h++) {
			System.out.println(ten[h]);
			
		}
		
		
	} //end main
} //end class
