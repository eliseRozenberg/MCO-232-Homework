package sortLists;

import java.io.File;
import java.io.FileNotFoundException;
//import java.lang.reflect.Array;        //i commented out this import because eclipse kept on warning me that it wasnt used... 
										// i didnt want to remove it because it was put there
import java.util.Scanner;

public class Merge {

	public static void main(String[] args) {
		int[] firstList = new int[20];  //estimate maximum list size
		int[] secondList = new int[20];	//to read in both lists
		
		int qtyListA =0;	//trace how many values were placed in first list
		int qtyListB =0;	//trace how many values were placed in second list
		Scanner input;		//to read the lists from the file
		
		try{
			System.out.println("inputing file 1...");
			input = new Scanner(new File("./list1.txt"));				//input the first list
			while (input.hasNext()) {
				
				if (qtyListA < firstList.length) {						//while there are more values and room in the array
					firstList[qtyListA] = input.nextInt();				//input the number in the next available place in the array
					qtyListA++;	
				} //end if
				else {
					System.out.println("insufficent space in RAM for further values - file closing... ");
					break;
				} //end else
				
		    } //end while
			
			input.close();
			System.out.println ("file 1 inputed");

			System.out.println("inputing file 2...");
			input = new Scanner(new File("./list2.txt"));				//input the second list
		    while (input.hasNext()) {
		    	
		    	if (qtyListB< secondList.length) {						//while there are more values and room in the array
		    		secondList[qtyListB] = input.nextInt();				//input the next number
		    		qtyListB++;	
		    	} //end if
		    	else {
					System.out.println("insufficent space in RAM for further values\n file closing... ");
		    		break;
		    	} //end else
		    	
		    } //end while
	
		input.close();													
		System.out.println ("file 2 inputed");
		
		} //end try
		catch(FileNotFoundException ex){								//if file is not found
			System.out.println("data file not found");
			System.exit(1);												//end program
		} //end catch
		
		System.out.print("\nThe first list:\n");
		for (int i=0; i < qtyListA; i++){								//display the first list - unsorted
			System.out.print(firstList[i] +"  ");
		} //end for
		
		System.out.print("\n\nThe second list:\n");						//display the second list - unsorted
		for (int i=0; i< qtyListB; i++) {
			System.out.print(secondList[i]+ "  ");
		} //end for
		

		sort(firstList,qtyListA);										//call the sort method
		sort(secondList,qtyListB);
		
		System.out.print("\n\nThe first list: (sorted)\n");				//display first sorted numbers
		for (int i=0; i < qtyListA; i++) {
			System.out.print(firstList[i] + "  ");
		} //end for
		System.out.print("\n\nThe second list: (sorted)\n");				//display second sorted numbers
		for (int i=0; i < qtyListB; i++) {
			System.out.print(secondList[i] + "  ");
		} //end for
		
		//get the list of same numbers and display
		int [] sameSet = intersectSet(firstList, qtyListA, secondList, qtyListB); 
		System.out.print("\n\nThe Same in both lists:\n");				//display the list of same numbers
		for (int i=0; i < sameSet.length; i++) {
				System.out.print(sameSet[i] + "  ");
		} //end for

		//get the merged list and display
		int [] merged =mergeLists (firstList, qtyListA, secondList, qtyListB);
		System.out.print("\n\nBoth lists merged:\n");						//display merged list 
		for (int i=0; i < merged.length; i++) {
				System.out.print(merged[i] + "  ");
		} //end for
		
		
		System.out.println("\n\nEnding Application ---- Have a good day");
	}
	
	
 	/**
	   * @param int[]values	- list that contains set of values
	   * @param qtyInList	- quantity of values in the list 
	   */
	
	public static void sort(int[] values, int qtyInList){
		
		int startScan;	//to trace where to begin each set
		int index;		//to trace what to compare to
		int minValue;	//to hold smallest value
		int minIndex;	//to hold smallest value index
		for (startScan = 0; startScan < (qtyInList-1); startScan++) {
			minIndex = startScan;										//place variable in beginning of scan as the lowest
			minValue = values[startScan];								//place variable index in beginning of scan as the lowest
			for (index = startScan+1; index < qtyInList; index++) {		//while more values to compare to first (startScan) in scan
				if (values[index] < minValue)  {						//if the value being compared is less then startScan
					minValue = values[index];							//it becomes the smallest value
					minIndex = index;									//it becomes the smallest index
				} //end if
			} //end inner for
			values [minIndex] = values[startScan];						//switch the values of lowest and first
			values[startScan] = minValue; 								//switch the values of index of lowest and first
		} //end outer for
	}//end sortMethod
	
	
	/**
	   * @param int[] listA	- first list that contains set of values
	   * @param qtyA		- quantity of values in the first list
	   * @param int[] listB	- second list that contains set of values
	   * @param qtyB		- quantity of values in the second list
	   * @return			-list that contains only those values that appear in both lists
	   */
	
	
	public static int[] intersectSet(int[] listA, int qtyA, int[] listB, int qtyB){

		int i=0;								//read through the listA array
		int j=0;								//read through the listB array
		int r=0;								//read through the merged array
		int valueA=0;							//hold next vale from listA
		int valueB=0;							//hold next value from listB
		Boolean listAEmpty, listBEmpty;			//trace if more values in the list
		int [] sameSet= new int [20]; 			//new array to hole list of same numbers
		
		if (i<qtyA) {							//if values in the array
			valueA = listA[i];					//place it in the variable
			listAEmpty = false;					//make false to continue
		} //end if
		else 
			listAEmpty = true;					//make true to end 
		
		if (j<qtyB) {							//if values in the second array
			valueB = listB[j];					//place it in the variable
			listBEmpty = false;					//make false to continue
		} //end if	
		else
			listBEmpty = true;					//make true to end
		
		if (!listAEmpty && !listBEmpty) {		//if values in both arrays...
			do {								//run through the loop
				
				if (valueA == valueB) {			//if the  value is in both lists...
					sameSet[r] = valueA; 		//place it in the array holding same numbers list
					r++;						//increment to go to next in all of the arrays
					i++;
					j++;
				
					if (i< qtyA)				//if more values...
						 valueA = listA[i]; 	//place next value in variable
					else
						listAEmpty = true;		//don't continue
					
					if (j< qtyB)				//if more values in second array
						valueB = listB[j];		//place next value in variable
					else
						listBEmpty = true;		//don't continue
					
				} //end outer if
			
				else 
					
					if (valueA < valueB) {		//if value a is less then b
						i++;					//increment to next value to compare
						
						if (i<qtyA)				//if more values
							valueA = listA[i];	//place next in array in variable
						else
							listAEmpty = true;	//don't continue
						
					} //end if	
				
				else 
					
					if (valueB < valueA) {		//do same as before but with second list if second variable is smaller
						j++;
						
						if (j<qtyB) 
							valueB = listB[j]; 
						else
							listBEmpty = true;
						
					} //end if
				
			} //end do
			while (!listAEmpty && !listBEmpty);	//continue while more values remain in both arrays
		} //end if
		
		int [] sameSet2 = new int [r];			//create a new array to hold the correct qty of numbers
		for (int b=0; b<r; b++) {
			sameSet2[b] = sameSet[b]; 			//move each element from the first to the second
		} //end for
		
		return sameSet2;
	} //end intersectSetMethod
	
	/**
	   * @param int[] listA	- first list that contains set of values
	   * @param qtyA		- quantity of values in the first list
	   * @param int[] listB	- second list that contains set of values
	   * @param qtyB		- quantity of values in the second list
	   * @return			-list that contains only those values of both lists merged
	   */

	public static int[] mergeLists(int[] listA, int qtyA, int[] listB, int qtyB){

		int [] mergedList = new int [(qtyA+qtyB)];		//to hold merged list
		int i = 0;										//run through first array
		int j = 0;										//run through second array
		int r = 0;										//run through merged list array
		int valueA=0;									//to hold values from both arrays...
		int valueB=0;
		Boolean listAEmpty;								//trace if arrays are empty
		Boolean listBEmpty;
		
		if (i< qtyA) {									//if values in left in the array
			valueA = listA[i];							//place next value in the variable
			listAEmpty = false;							//continue
		} //end if
		else
			listAEmpty = true;							//end
		
		if (j< qtyB) {									//same as above but with list b
			valueB = listB[j];
			listBEmpty = false;
		} //end if
		else 
			listBEmpty = true;

		if (!listAEmpty && !listBEmpty) {				//if both have values
			
			do {
				
				if (valueA == valueB) {					//if both are equal
					mergedList[r] = valueA;				//place the value once inside the array
					i++;								//increment all arrays
					j++;
					r++;
					
					if (i<qtyA) 						//if more in first array 	
						valueA = listA[i];				//place next value in variable
					else 
						listAEmpty = true;				//end
					
					if (j< qtyB) 						//if more in second array do same as with A
						valueB = listB[j];
					else
						listBEmpty = true;
				} //end if
				
				else if (valueA < valueB) {				//if a<b		
						mergedList[r] =  valueA;		//add to the merged array 
						r++;							//increment a and merged
						i++;
						
						if (i<qtyA) 					//if more values...
							valueA = listA[i];
						else
							listAEmpty = true;
						
				} //end else if
				
				else if (valueB < valueA) {				//same as with a<b but now with b<a
					mergedList[r] = valueB;
					r++;
					j++;
					
					if (j < qtyB)						
						valueB = listB[j];
					else 
						listBEmpty = true; 
					
				} //end else if
				
			} //end do while
			while (!listAEmpty && !listBEmpty);
		}// end if
		
		/* 
		 * while there is one list with more values
		 * add left over value to list
		 * increment leftover array and merged array
		 * if more values in the list, place it in value_
		 * if not end
		 */
		
		
			while (!listAEmpty) {				//if list a has more values			
				mergedList[r] = valueA;
				r++;
				i++;
				
				if (i<qtyA) {
				valueA = listA[i];
				} //end if
			else
				listAEmpty = true;
		
			} //end while
		
		while (!listBEmpty) {				// if list b has more values
			mergedList[r] = valueB;
			r++;
			j++;
			
			if (j<qtyB) {
				 
				valueB = listB[j];
			} //end if
			else 
				listBEmpty = true;
			
		} //end while
		
		
		int [] mergedList2 = new int [r];		//rewrite the array to only hold correct set of qty
		for (int b=0; b<r; b++) {
			mergedList2[b]= mergedList[b];		//transfer the values from the first array to the second while there are more
		} //end for
		
		return mergedList2;
	} //end mergeListMethod
		 
 } //end class
