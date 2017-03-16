package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class UseContact1 {
	
	public static void main (String [] args) {
		Scanner keyboard = new Scanner (System.in);
		//for one contact
		
		//1. this was nearly correct:  ArrayList<CellPhone> contacts = new ArrayList<Contact>(); would make it perfect
		//ArrayList <CellPhone> contacts = new ArrayList ();
		CellPhone1 contact1; 
		String last, first, nickName, number;
		int selection;
		while (true) {
		
			do {
				System.out.println("Enter a selection");
			
		System.out.println("1 - add contact");
		System.out.println("2 - remove a specific contact");
		System.out.println("3 - view a specific contact");
		System.out.println("4 - display all");
		System.out.println("5 - modify contact phone numbers");
		System.out.println("6 - EXIT");
		
		
		 selection = keyboard.nextInt();
		
			}while (selection >6 || selection <1);
		
				int choice=0; 
		String removeName;
		String viewName;
		String changeNum;
		
		switch (selection) {
		
		case 1:
			System.out.println("would you like to adda first name \n i- yes \n 2=no");
			do {
			choice = keyboard.nextInt();
			if (choice !=1 || choice != 2)
				System.out.println(" INVALID SLECTION \nwould you like to adda first name \n i- yes \n 2=no");
				choice = keyboard.nextInt();
			}
			while (choice != 1 || choice != 0);
			
			if (choice ==1) {
			
			System.out.println ("last name ");
			last = keyboard.nextLine();
			System.out.println ("first name ");
			first = keyboard.nextLine();
			System.out.println ("nick  name ");
			nickName = keyboard.nextLine();
			System.out.println ("number ");
			number = keyboard.nextLine();
			contact1 = new CellPhone1 (first, last, nickName, number);
			// for 1
			
			
			
			}
			
			if (choice ==2) {
				
				System.out.println ("last name ");
				last = keyboard.nextLine();
				System.out.println ("nick  name ");
				nickName = keyboard.nextLine();
				System.out.println ("number ");
				number = keyboard.nextLine();
				contact1 = new CellPhone1 (last, nickName, number);
				// for 1
				
				

			}
			break;
			
			
		case 2:
			
			System.out.println("wich contact would you remove? - give nickname");
			removeName = keyboard.nextLine();
			
			
			
			break;
			
		case 3:
			System.out.println("wich contact would you view - give nickname");
			viewName = keyboard.nextLine();
			//System.out.println(contact1.getfirst() + contact1.getnickName() +contact1.getlast() + contact1.getnumber());
			break;
			
		case 4:
			//System.out.println(contact1.getfirst() + contact1.getnickName() +contact1.getlast() + contact1.getnumber()); //only if user did first option
			break;
			
			
		case 5:
			//System.out.println("wich number would you change - give nickname");
			//changeNum = keyboard.nextLine();
			
			System.out.println("wwhat would you like to change the number to?");
			changeNum = keyboard.nextLine();
			
			//contact1.setnumber(changeNum); //only works if the viewer did the first option
			
			break;
		case 6: 
			System.exit(0);
			
		}

	}
	}

}