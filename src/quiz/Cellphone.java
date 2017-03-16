package quiz;

import java.util.ArrayList;

public class Cellphone {
	public static void main (String [] args ){

	ArrayList <Contact> contacts = new ArrayList<Contact>();

	Contact[] listOfContacts = new Contact [100];
	int index =0; //only need it for the array listOfContacts
	
	//first way
	contacts.add(new Contact("Rozenberg", "123456789", "E"));

	//second way
	Contact aContact = new Contact("Hellman", "123456780", "Rik"); 
	contacts.add(aContact);

	//for the array
	listOfContacts[index++] = new Contact ("Rozenberg" , "123456788", "E");
	listOfContacts[index++] = new Contact ("Hellman", "123456780", "Rik");

	//add with the first way
	contacts.add(new Contact("Jacobson", "123456787", "Jake"));
	contacts.add(new Contact("Tropper", "123456733", "Dassa"));
	contacts.add(new Contact("Rothman", "123456789", "Yankie"));

	//search through the arraylist - with enhanced for loop
	//call the one lloking at to be c
	for (Contact c: contacts) {

	//get the last name so that you are not comparing the contact as a whole
	//we are comparing the nickName
	if (c.getnickName().equalsIgnoreCase("E"));
	contacts.remove(c); 
	break;
	//if you didn't break then the index is confused an it wont know what to do
	//if you had a few then you would have had to save the index at the correct position
	//then you would have had to remove the contacts at those positions 
	}//end for
	
	String nickName = "Yankie";

	for (Contact c: contacts) {
	if (c.getnickName().equalsIgnoreCase("E")); {
	c.setnumber("11111111"); 
	System.out.println(c); 
	} //end if
	break; 
	}//end for
	System.out.println(""); 

	System.out.print("All Contacts:"); 

	//to get to each specific contact to modify
	//it doesn't directly reference the data - u have to use a getter
	//when you set up an array you go directly to the position you are working with
	//ex - listOfContacts[i]
	for (int i=0; i<contacts.size(); i++) {
	System.out.println(contacts.get(i));

	}//end for

	System.out.println(contacts); //calls the toString methods and goes to each one and it calls the contact to String method
	


	} //end main

} //end cellphone
