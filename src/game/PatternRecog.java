package game;

import java.util.Scanner;
 
public class PatternRecog {
	
	public static void main (String [] args) {
		Scanner keyboard = new Scanner (System.in); 
		int choice;					//to hold the choice from menu
		int [][] table;			
		boolean isConsecutive;		//true if 4 in a row
		int maxRow;					//user inputs how many row and columns
		int maxCol;
		
		while (true) {
			choice = menu();		// call menu
			
			switch (choice) {
				
				case 1:				//compare table
					
					//do while there arent enough rows and columns to check for 4 - need for 4 in either
					do {			
						System.out.print("You will now enter a list of numbers into a table.");
						System.out.println("The numbers will be evaluated to find 4 of the same in a row"); 		
						System.out.print("(1) Vertically	(2) horizontally	(3) diagonally \n"); 

						System.out.print("\nYou will now enter in the size of the table.\n");
						System.out.print("How many rows are there: "); 
						maxRow = keyboard.nextInt();
						System.out.print("How many columns are there: ");
						maxCol = keyboard.nextInt();
					
						if (maxCol <4 && maxRow <4) {
							System.out.println("\nYou entered either to few rows or columns.");
							System.out.println("4 rows or 4 columns are needed. ");
							System.out.println("Would you like to enter new data?\n");
							
							//if to either row or column dont have at least 4- then user asked if want to exit or try with new values
							choice = menu();						
							if (choice == 2) {
								keyboard.close();
								System.out.println("Program ending");
								System.exit(0);
							} //end if
						} //end if
						
						System.out.println("");
						
					} while (maxCol <4 && maxRow <4);

					table = createTable(maxCol, maxRow);  					//call method to enter values
					displayTable(table);									//call method to display the array
					isConsecutive = isConsecutiveFour(table); 				//call method to check  for 4
					
					System.out.println();
					if (isConsecutive) 										//if there are 4...
						System.out.println("\nThere are 4 in a row.");
					else 													//if not...
						System.out.println("\nThere aren't 4 in a row.");
					break;
					
					
				case 2:			//exit program
					keyboard.close();
					System.out.print("\n Program Ending");
					System.exit(0);
					
			} //end switch
		} //end while
	} //end main
	
	
	
	/**
	 * @param maxCol
	 * @param maxRow
	 * @return the table of values the user entered
	 */
	
	public static int[][] createTable(int maxCol, int maxRow) {
		
		Scanner keyboard = new Scanner (System.in); 
		
		//create table based on size user wants
		int [][] table = new int [maxRow][maxCol];
		System.out.println("\nYou will now enter the values into the table \n(Hit enter after every value)");	
		
		//run through all in array to fill values
		for (int i=0; i< table.length; i++) {
			for (int j=0; j<table[i].length; j++) {
				System.out.print("(row " + (i+1) + " column " + (j+1) + ") ");
				table[i][j] = keyboard.nextInt(); 
			} //end inner for
		} //end for
		
		return table;
		
	} //end createTable
	
	
	/**
	 * @param table
	 * Display the array in the format of a chart.
	 */
		
	public static void displayTable (int[][] table) {	
		for (int i=0; i< table.length; i++) {			//run through all the values
			System.out.println(" ");						//after every row go to next line
			for (int j=0; j<table[i].length; j++) {
				System.out.print( table[i][j] );
				if (table [i][j] >9 ) 
					System.out.print ("  ");
				else if (table [i][j] <= 9)
					System.out.print("   ");
			} //end inner for
		} //end for

	} //end display
	
	
	/**
	 * @param table
	 * @return isConsecutive -  True or false that 4 in a row
	 */
	
	
	public static boolean isConsecutiveFour (int [][] table) {
		boolean isConsecutive = true;				//default if no 4 in a row
		
		for (int i=0; i<table.length; i++) {		//check every value
			for (int j=0; j<table[i].length; j++) {
				
				if ((j+3) < table[i].length) {		//only check for values if there is room for there to be 4 in a row
					if ( (table[i][j]==table[i][j+1]) && (table[i][j+1] == table[i][j+2]) && (table[i][j+2] == table[i][j+3]) )		//check vertical
						return isConsecutive;
				} //end if	
					
				if  ((i+3) < table.length) {
				
					if ( (table[i][j] == table[i+1][j]) && (table[i+1][j] == table[i+2][j]) && (table[i+2][j] == table[i+3][j]) )	//check horizontal
						return isConsecutive;
				} //end if
					
				if ( (i+3) < table.length && (j+3) < table[i].length)  {
					
					if ( (table[i][j] == table[i+1][j+1]) && (table[i+1][j+1] == table[i+2][j+2]) && (table[i+2][j+2] == table[i+3][j+3]) )	//check diagonal 
						return isConsecutive; 
				} //end if
				
				if ((i+3) < table.length && (j-3)>= 0) {					//only check for diagnol going down if there is room for 4 in a row
					if ( (table[i][j] == table[i+1][j-1]) && (table[i+1][j-1] == table[i+2][j-2]) && (table[i+2][j-2] == table[i+3][j-3]) )	//check other diagonal 
						return isConsecutive; 
				} //end if
					
			} //end inner for
		} //end for
		isConsecutive = false;
		return isConsecutive;		//if no 4 in row return false
	} //end is consec.
		
	
	/**
	 * @return menu choice to be implemented 
	 */
	
	public static int menu () {
		int choice;
		Scanner input = new Scanner(System.in);
		do{
		        System.out.println("Enter (1) or (2): \n" 
		        		+ "1. Read in New Data"
		        					+ "\n2. EXIT");
		        choice = input.nextInt();
		       
		}while(choice > 2 || choice < 1);		//do while value entered is not 1 or 2 
		
		return choice; 
		
	} //end menu

		

} //end class
