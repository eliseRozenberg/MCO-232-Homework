package cellPhoneSpring2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageContacts {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Contact aContact;
		int choice;
		boolean found;
		do{
			choice = menu();
			switch (choice){
			case 1://add a new contact to list of contacts
				aContact = getContactData();
				contacts.add(aContact);
				break;
			case 2: //remove a contact
				System.out.println(" enter nickname of contact to remove: ");
				String nicknm = keyboard.next();
				//now search for the Contact with that nickname
				found = false;
				for( Contact c: contacts){
					if (c.getNickName().equalsIgnoreCase(nicknm)){
						//found it remove it from list of Contact
						contacts.remove(c);
						System.out.println("removed Contact " + c);
						found = true;
						break;    //leave the loop
					}
				}
				if (!found){
					System.out.println("can't find contact with nickname " + nicknm);
				}
				break;
			case 3://list all contacts
				System.out.println("Contact List");
				System.out.println(contacts);
				break;
			case 4: //find Contact information
				System.out.println(" enter nickname of contact to view: ");
				String nick = keyboard.next();
				//now search for the Contact with that nickname
				found = false;
				for( Contact c: contacts){
					if (c.getNickName().equalsIgnoreCase(nick)){
						//found it , display the information
						System.out.println("Contact Information: " + c);
						found = true;
						break;    //leave the loop
					}
				}
				if (!found){
					System.out.println("can't find contact with nickname " + nick);
				}
				break;
			case 5: //sort contacts
				Collections.sort(contacts); //will be sorted by using the Contact.compareTo() method
				                            //must declare Contact to be a Comparable so that the 
				                            //sort () method is ensured that Contact has implemented the compareTo
				                            //method it needs to execute the sort()
				System.out.println("Sorted List of Contacts");
				System.out.println(contacts);
				break;
			case 6: //modify phonenumber
				System.out.println(" enter nickname of contact whose phonenumber has changed: ");
				String nickName = keyboard.next();
				//now search for the Contact with that nickname
				found = false;
				for( Contact c: contacts){
					if (c.getNickName().equalsIgnoreCase(nickName)){
						//found it, modify the phonenumber
						System.out.println("New Phone Number: ");
						String phoneNumber = keyboard.next();
						c.setPhoneNumber(phoneNumber);
						System.out.println("phone number changed");   //provide user with confirmation
						found = true;
						break;    //leave the loop
					}
				}
				if (!found){
					System.out.println("can't find contact with nickname " + nickName);
				}
				break;
			case 0:  //exit
				System.out.println("Shutting down.......");
				System.exit(0);
				break;
			} //end switch
			
		}while (choice != 0);

	}
	
	private static  Contact getContactData(){
		Scanner keyboard = new Scanner(System.in);
		char choice;
		String firstname,lastname, nickname, phonenumber;
		System.out.println("firstname Y or N");
		choice = keyboard.next().charAt(0);   //retrieve the first character of the string value 
		if (choice == 'Y' || choice == 'y'){
			System.out.println("enter firstname: ");
			firstname = keyboard.next();
			
		}
		else {
			firstname = null;
		}
		System.out.println("Enter last name: ");
		lastname = keyboard.next();
		
		System.out.println("Enter phone number ");
		phonenumber = keyboard.next();
		
		System.out.println("Enter nickname: ");
		nickname = keyboard.next();
		return new Contact(firstname,lastname, phonenumber, nickname);
		
		
		
	}
	
	
	public static int menu(){
		Scanner keyboard = new Scanner(System.in);
		int choice;
		do{
		  System.out.println("\n1. Add Contact\n2. Remove Contact\n3. List Contacts\n4. Find Contact\n5. Sort Contacts\n6.Modify PhoneNumber\n0.Exit");
		  choice = keyboard.nextInt();
		}while(choice > 6);
		return choice;
	}

}
