package practiceSortsSearches;
/* from the notes and accounts for arrays that
 * aren't full and adds the bubble sort!!
 */
 
import java.util.Scanner;
import java.io.File;

public class practice2 {

	public static void main (String [] args) {
		int qty = 6;
		int [] numbers = new int [7];
		numbers[0] = 5;
		numbers[1] = 4;
		numbers[2] = 1;
		numbers[3] = 9;
		numbers[4] = 2;
		numbers[5] = 6;
		
		bubbleSort (numbers, qty);
		
		numbers[0] = 5;
		numbers[1] = 4;
		numbers[2] = 1;
		numbers[3] = 9;
		numbers[4] = 2;
		numbers[5] = 6;
		
		selectionSort(numbers, qty);
		
		sequentialSearch(numbers, qty, 9);
		binarySearch(numbers, qty, 1);
	} //end main
	
	public static void bubbleSort (int [] numbers, int qty) {
		int temp;
		boolean swapped;
		do {
		swapped = false;
			for (int start = 0; start < qty-1; start++) {
				if (numbers [start] > numbers [start+1]) {
					temp = numbers [start];
					numbers [start] = numbers [start +1];
					numbers [start+1] = temp;
					swapped = true;
				} //end if
			} //end for
		
		} while (swapped);
	} // end bubbleSort
	
	public static void selectionSort (int [] numbers, int qty) {
		int startScan, index, minIndex, minValue;
		
		for (startScan = 0; startScan < (qty -1); startScan++) {
			minValue = numbers [startScan];
			minIndex = startScan;
			
			for (index = startScan +1; index < qty; index ++) {
				if (numbers [index] < minValue) {
					minValue = numbers [index];
					minIndex = index;
				} //end if
				numbers [minIndex] = numbers [startScan];
				numbers [startScan] = minValue;
			} //end inner for
		} //end inner for
	} //end selectionSort
	
	public static void sequentialSearch( int [] numbers, int qty, int val) {
		int resultIndex;
		for (int index = 0; index < qty; index++) {
			if (numbers [index] == val)
				resultIndex = index; 
		}	
	} //end sequentailSearch
	
	public static void binarySearch(int [] numbers, int qty, int val) {
	
	} //end binarySearch
} //end class