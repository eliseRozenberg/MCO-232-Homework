/* from the book and doesn't account for
 * arrays that aren't completely full!!!
 *  Sort: selection
 *  Search: Binary, Sequential
 *
 */
package practiceSortsSearches; 
import java.util.Scanner;

public class Practice {
	
	public static void main (String [] args) {
		int [] numbers = {5,7,2,8,9,1};
		selectionSort (numbers);
		binarySearch (numbers, 8);
		int [] numbers2 = {5,7,2,8,9,1};
		sequentialSearch(numbers2, 5 );
		
	} //end main
	
	public static void selectionSort (int [] numbers) {
		for (int val: numbers) 
			System.out.print(val + " ");
		int startScan, index,minValue, minIndex;
		System.out.println ("");
		
		for (startScan =0; startScan < (numbers.length -1); startScan++) {
			minIndex = startScan;
			minValue = numbers [startScan];
			for (index = startScan+1; index < numbers.length; index++) {
				if (numbers [index] < minValue) {
				minValue = numbers [index];
				minIndex = index; 
				} //end if 
			} //end inner for
			numbers [minIndex] = numbers [startScan];
			numbers [startScan] = minValue;
			
			for (int val: numbers) 
			System.out.print(val + " ");
			System.out.println("");
		} //end outer for
	
	} //end sequential
	
	public static void binarySearch (int [] numbers2, int value) {
		System.out.println("");
		System.out.println ("0 1 2 3 4 5");
		for (int val: numbers2) 
			System.out.print(val + " ");
		System.out.println ("");
		int first = 0;
		int last = (numbers2.length - 1);
		int mid;
		int position = -1;
		boolean found = false;
		while (!found && first <=last) {
			mid = (first + last) /2;
			System.out.println(first + " " + last + " " + mid);
			if (numbers2 [mid] == value) {
				position = mid;
				found = true;
			} //end if 
			else if (numbers2 [mid] > value )
				last = mid -1;
			else if (numbers2 [mid] < value)
				first = mid + 1;
		} //end while
		System.out.println ("the number "+ value + " was found at  index " + position);
	} //end binary
	
	public static void sequentialSearch (int [] numbers2, int value) {
		boolean found = false; 
		int index = 0, element= -1;
		while (!found && index < numbers2.length) {
			if (numbers2 [index] ==value) {
				found =true;
				element = index;
			} //end if
			else 
				index++;
		} //end while
		System.out.println();
		System.out.println ("the number " + value + " was found at index " + element);
	} //end sequentialSearch
} //end class
		
	