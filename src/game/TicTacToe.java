package game;

import java.util.Scanner;

public class TicTacToe {

	public static void main (String []args) {
	
		Scanner keyboard = new Scanner (System.in); 
		int k=0; //to show that game over if fill the array
		
		String [][]table = {{"E","E","E"},				
						    {"E","E","E"},				
						    {"E","E","E"}};
		//filled with a random letter to differentiate between what was used and what wasn't
		
		displayTable(table); 		//display empty tale
		
		while( k<= (table[0].length * table.length) ) {		//while there are still  more turns - space in array (no matter the size)
			
			turn(table, "X");		//player x turn
			k++;					//increment for every turn
			displayTable(table);	//display after every turn
			check(table, "X");		//check for a winner after every turn
			
			// because uneven amount of turns - the 9th is after the player x- so need to terminate loop here
			if (k>= (table[0].length * table.length))
				 break;
				
			turn(table, "O");			//same as with x but now with o
			k++;
			displayTable(table);
			check(table, "O");
			
		} //end while
		
		System.out.println("Tie Game - No Winner"); //if all elements complete and still no winner then it's a tie game
		System.out.print("Thank you for playing");

		keyboard.close(); 
		System.exit(0);
		
		
	} //end main
	
	/**
	 * @param table
	 * @param player ("X"/"O")
	 * Check for a winner. If a winner is found display message and end the program.
	 */
	
	public static void check (String [][] table, String player) {
		
		//check all possibilities going across (3 in a row)
		for (int i =0; i < table.length; i++) {
			
			//check first if all are full
			if (!(table[i][0].equals("E")) && !(table[i][1].equals("E")) && !(table[i][2].equals("E"))  ) {
				
				//compare each row
				if ( (table[i][0].equals(table[i][1])) && (table[i][1].equals(table[i][2])) ) {	
					System.out.println("Player " + player + " wins!! Great Job!!");		
					System.out.print("Thank you for playing");
					System.exit(0);	
					//if a winner end game
				} //end inner if
				
			} //end if
		
			//check all possibilities going down (3 in a column) - same as with rows
			for (int j=0; j< table[i].length; j++) {
				
				if (!(table[0][j].equals("E")) && !(table[1][j].equals("E")) && !(table[2][j].equals("E"))  ) {
					
					if ( (table[0][j].equals(table[1][j])) && (table[1][j].equals(table[2][j])) ) {
						System.out.println("\nPlayer " + player + " wins!! Great Job!!");
						System.out.print("Thank you for playing");
						System.exit(0);
					} //end inner if
					
				} //end if
				
			} //end inner for
			
		} //end for
		
		//check diagonal possibility from top left to bottom right - same as with rows
		if (!(table[0][0].equals("E")) && !(table[1][1].equals("E")) && !(table[2][2].equals("E"))  ) {
			if ( (table[0][0].equals(table [1][1])) && (table[1][1].equals(table[2][2])) ) {
				System.out.println("\nPlayer " + player + " wins!! Great Job!!");
				System.out.print("Thank you for playing");

				System.exit(0);
			} //end inner if
		} //end if
		
		//check diagonal possibility from top right to bottom left - same as with rows
		if (!(table[0][2].equals("E")) && !(table[1][1].equals("E")) && !(table[2][0].equals("E"))  ) {
			if ( (table[0][2].equals(table [1][1])) && (table[1][1].equals(table[2][0])) ) {
				System.out.println("\nPlayer " + player + " wins!! Great Job!!");
				System.out.print("Thank you for playing");
				System.exit(0);
			} //end inner if
		} //end if
	} //end check
	
	/**
	 * @param table
	 * @param player ("X"/"O")
	 * complete each players turn
	 */
	
	public static void turn (String[][] table, String player) {
		Scanner keyboard = new Scanner (System.in);
		int row;
		int col;
		
		//do while player enters into a space that has been filled already
		do { 
		
			System.out.print("\nEnter a row for player " + player + " (0, 1, or 2)  ");
			row = keyboard.nextInt();
			
			//input validation if user enters invalid selection
			while (row > 2 || row < 0) {
				System.out.println("Invalid Selection");
				System.out.print("\nEnter a row for player " + player + " (0, 1, or 2)  ");
				row = keyboard.nextInt();
			} //end while
		
			System.out.print("Enter a column for player " + player + " (0, 1, or 2)  ");
			col = keyboard.nextInt(); 
			
			while (col > 2 || col < 0) {
				System.out.println("\nInvalid Selection");
				System.out.print("\nEnter a column for player " + player + " (0, 1, or 2)");
				col = keyboard.nextInt();
			} //end while
		
			//if user enters in space already filled - display message and re-do loop
			if (table[row][col] != "E") { 
				System.out.println("\nPlayer " + table[row][col] + " already went there");
				System.out.println("Enter a different selection");
			} //end if
			
		} while (table[row][col] != "E"); 
		
		//if all is correct - user's selection is processed 
		table[row][col] = player;
		
	} //end turn 
	
	/**
	 * @param table
	 * Display the table after every turn.
	 */
	
	public static void displayTable (String[][] table) {
		int h;
		int g;
		
		//System.out.println();
		System.out.println();

		//indicate rows
		System.out.println("  0   1   2"); 
		System.out.println("-------------");
		
		// to run through every row
		for  (g=0; g< table.length; g++) {	
			
			//to run through every column
			for (h=0; h< table[g].length; h++) {
			
				//if value being evaluated has not been filled yet - insert value
				if (!(table[g][h].equals("E")) )
					System.out.print("| " + table[g][h] + " ");
				
				//if it has been - keep it blank
				else
					System.out.print("|   ");
			
			} //end inner for
			
			// to indicate columns
			System.out.println("| " + g);
			System.out.println("-------------");
			
		} //end for	
		
	} //end displayTable
	
} //end class

