package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingLists {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);
		String [] students = new String [20];
		String [][] booklist = new String [20][];
		int qtyStudents=0; 
		
		
		students[0] = "Adina";
		students[1]= "Batya"; 
		students[2] = "Chana";
		students[3] = "Dina";
		students[4] = "Esther";
		students[5] = "Freidy";
		
		for (int i=0; i<students.length; i++) {
			if ( students[i] ==(null) ) 
				break; 
			else
				qtyStudents++; 
		}
		
		booklist[0] = new String [] {"Frog and Toad", "Goose and Duck"}; 
		booklist[1] = new String [] {"Ramona the Pest", "See Me Run", "Penny and her Song"};
		booklist[3] = new String [] {"Odd Duck", "Ramona the Pest", "Penguin Troubles", "Penny and her Marbles"};
		booklist[4] = new String [] {"Frog and Toad"};
		
		displayNames(students, qtyStudents);		
		displayNamesAndBooksRead(students, qtyStudents, booklist);

		
		System.out.println("Wich students reading list would you like to review?");
		String name = keyboard.next(); 
		
		String [] list = getReadingList(name, students, booklist, qtyStudents);
		
		
		if (list == null)
			System.out.print("'student didnt read any book'");
		else
			for ( int k=0; k< list.length; k++) {
				System.out.println(list[k]);
			}// end for
		
		keyboard.close();
		System.out.println("Have a Nice Day");
		System.exit(0);
		

	} //end main

	
	/**
	 * @param names - array that contains a list of names
	 * @param qty - how many values are in the array names[]
	 */
	
	public static void displayNames (String[] names, int qty) {
		for (int i=0; i<qty; i++) {
			System.out.println(names[i]); 
		} //end for
	}//displayNames
	
	/**
	 * @param names - list of name of students
	 * @param qty - how many are in the list of names[]
	 * @param books - the titles of each book read  each student who read a book or books
	 */
	
	public static void displayNamesAndBooksRead (String [] names, int qty, String [][] books) {
		
		for (int i=0; i < qty; i++){
			System.out.print(names[i] + "\t");
			if (books[i] != null) {
				for (int j= 0; j<books[i].length; j++) {
					System.out.print(books[i][j] + "\t");
				} //end inner for
			} //end if
			System.out.println(); 
		} //end for
	} //displayNamesAndBooksRead
	
	/**
	 * @param name		references the name of the student whose data will be processed
	 * @param names		references the list of names of students
	 * @param bookList	list of books read by each student
	 * @param qty		the number of students for which data has been stored 
	 * @return			list of book titles read by student with names stored in parameter, 'name' return null if student didn't read any books 
	 */
	
	public static String[] getReadingList (String name, String [] names, String [][] booklist, int qty) {
		
		String []list = new String [20]; 
		int count = 0; 
		int i;
		
		while (true) {
			for (i=0; i <qty; i++) {
				if (name.equalsIgnoreCase(names[i]))  {
					if (booklist[i] != null) {
						for (int j=0; j< booklist[i].length; j++) {
							list[j] = booklist[i][j];
							count++; 
						} //end for
						String [] finalList = new String [count];
						for (int k=0; k<count; k++) {
							finalList[k] = list[k];
						} //end for
						return finalList; 
					} //end if
					return null;	//if none read by the specific student
				}//end if
			}//end for
			System.out.println("name doesnt exist on the list \tplease enter a new name");
			Scanner keyboard = new Scanner (System.in);
			name = keyboard.nextLine(); 
		}// end while
		
	} // getReadingList
	
} //end class
