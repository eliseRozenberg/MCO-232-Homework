package employment;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import realEstateNew.USState;

public class UseEmployee {
	public static void main(String [] args){
		Scanner keyboard = new Scanner (System.in);
		int choice;
		ArrayList<Person>holder = new ArrayList<Person>();
		ArrayList<Person>holder2 = new ArrayList<Person>();

		ArrayList<Person> schoolMembers = new ArrayList<Person>();
		boolean found; 
		String first,last,name, address,email, pnumber,date, status, office, rank, department,title;
		int cnumber, day,month,year;		  
		Double salary;
		Person person;
		do {
		choice = menu();
		switch(choice){
		case 1:	//1.	Add a Student 
			found =false;
			System.out.println("\nEnter data:\nFirst Name:");
			first = keyboard.nextLine();
			System.out.println("\nLast Name:");
			last = keyboard.nextLine();
			do {
			System.out.println("\n10 Digit Phone Number(no dash or spaces)");
			pnumber = keyboard.nextLine();
			if (pnumber.length()!=10){
				System.out.println("phone number should be 10 digits long");
			}
			}while(pnumber.length()!=10);
			for (Person prs: schoolMembers){
				if (prs.getName().equalsIgnoreCase((first+ " "+ last)) && prs.getPhoneNumber().equalsIgnoreCase(pnumber)){
					System.out.println("This person already exists");
					found =true;
					break;
				}
			}
			if (!found){
					System.out.println("\nAddress:");
					address = keyboard.nextLine();
					System.out.println("\nEmail Address:");
					email = keyboard.nextLine();
					System.out.println("\nCredits Earned:");
					cnumber = keyboard.nextInt();
					keyboard.nextLine();
					schoolMembers.add(new Student(first,last,address,email,pnumber,cnumber)); 
					System.out.println("data inputed");
			}

			break;
		case 2:	//Add a Faculty Member
			found =false;
			System.out.println("\nEnter data:\nFirst Name:");
			first = keyboard.nextLine();
			System.out.println("\nLast Name:");
			last = keyboard.nextLine();
			do {
			System.out.println("\n10 Digit Phone Number(no dash or spaces)");
			pnumber = keyboard.nextLine();
			if (pnumber.length()!=10){
				System.out.println("phone number should be 10 digits long");
			}
			}while(pnumber.length()!=10);
			for (Person prs: schoolMembers){
				if (prs.getName().equalsIgnoreCase((first+" "+last)) && prs.getPhoneNumber().equalsIgnoreCase(pnumber)){
					System.out.println("This person already exists");
					found =true;
					break;
				} 
			}
			if (!found){
				System.out.println("\nAddress:");
				address = keyboard.nextLine();
				System.out.println("\nEmail Address:");
				email = keyboard.nextLine();
				System.out.println("\nOffice:");
				office = keyboard.nextLine();
				System.out.println("\nRank (LECTURER, INSTRUCTOR, PROF, ASSOCIATEPROF)");
				rank = keyboard.nextLine();
				System.out.println("\nDepatment:");
				department = keyboard.nextLine();
				System.out.println("\nDate Hired(mm/dd/yyy)Enter with slash");
				date = keyboard.nextLine(); 
				System.out.println("\nSalary:");
				salary = keyboard.nextDouble();
				keyboard.nextLine();
				schoolMembers.add(new Faculty(first,last,address,email,pnumber,office,salary,date,rank,department));
				System.out.println("data inputed");
			}
			break;
			
		case 3:	//Add a Staff Member
			found = false;
			System.out.println("\nEnter data:\nFirst Name:");
			first = keyboard.nextLine();
			System.out.println("\nLast Name:");
			last = keyboard.nextLine();
			do {
			System.out.println("\n10 Digit Phone Number(no dash or spaces)");
			pnumber = keyboard.nextLine();
			if (pnumber.length()!=10){
				System.out.println("phone number should be 10 digits long");
			}
			}while(pnumber.length()!=10);
			for (Person prs: schoolMembers){
				if (prs.getName().equalsIgnoreCase((first+ " "+ last)) && prs.getPhoneNumber().equalsIgnoreCase(pnumber)){
					System.out.println("This person already exists");
					found =true;
					break;
				}
			}
			if (!found){
				System.out.println("\nAddress:");
				address = keyboard.nextLine();
				System.out.println("\nEmail Address:");
				email = keyboard.nextLine();
				System.out.println("\nOffice:");
				office = keyboard.nextLine();
	
				System.out.println("\nTitle:");
				title = keyboard.nextLine();
				System.out.println("\nDate Hired(mm/dd/yyy)Enter with slash");
				date = keyboard.nextLine(); 
				System.out.println("\nSalary:");
				salary = keyboard.nextDouble();
				keyboard.nextLine();

				schoolMembers.add(new Staff(first,last,address,email,pnumber,office,salary,date,title));
				System.out.println("data inputed");
			}
			break;
			
		case 4:	//List data about all members of the school 
			for (Person prs: schoolMembers){
				if (prs instanceof Faculty)
					System.out.println("Faculty:"+prs +"\n");
				else if (prs instanceof Staff)
					holder.add(prs);
				else if (prs instanceof Student)
					holder2.add(prs); 
			}
			if (holder.size()!=0)
				for(Person prs: holder){
					System.out.println("Staff\t"+prs+"\n");
				}
			if (holder2.size()!=0)
				for(Person prs: holder2){
					System.out.println("Student\t"+prs+"\n");
				}
			
			break;
		case 5:	//Modify credits earned of a specific student
			found =false;
			System.out.println("\nEnter data:\nFirst Name:");
			first = keyboard.nextLine();
			System.out.println("\nLast Name:");
			last = keyboard.nextLine();
			do {
			System.out.println("\n10 Digit Phone Number(no dash or spaces)");
			pnumber = keyboard.nextLine();
			if (pnumber.length()!=10){
				System.out.println("phone number should be 10 digits long");
			}
			}while(pnumber.length()!=10);
			for (Person ppl: schoolMembers){
				if (ppl.compareTo(first,last, pnumber)==0){
					found =true;
					if (ppl instanceof Student){
						System.out.println("How many credits would like to add?");
						cnumber = keyboard.nextInt();
						((Student) ppl).setCreditsEarned(cnumber);
						System.out.println("data inputed");

						break;
					}//end inner if	
					else {
						System.out.println("The person identified is not a student");
					}
				}
			}//end for
			if (!found){
				System.out.println("Student doesn't exist in our records");
			}

			break;
			
		case 6:	//Modify the rank of a specific instructor
			found = false;
			System.out.println("\nEnter data:\nFirst Name:");
			first = keyboard.nextLine();
			System.out.println("\nLast Name:");
			last = keyboard.nextLine();
			do {
			System.out.println("\n10 Digit Phone Number(no dash or spaces)");
			pnumber = keyboard.nextLine();
			if (pnumber.length()!=10){
				System.out.println("phone number should be 10 digits long");
			}
			}while(pnumber.length()!=10);
			
			for (Person ppl: schoolMembers){
				if (ppl.compareTo(first,last, pnumber)==0){
					found = true;
					if (ppl instanceof Faculty){
						System.out.println("What is the new rank of the instructor? (LECTURER, INSTRUCTOR, PROF, ASSOCIATEPROF)");
						rank = keyboard.nextLine();
						((Faculty) ppl).setRank(rank);
						System.out.println("data inputed");

					}//end inner if	
					else
						System.out.println("The person identified is not an instructor.");
				}//end outer if
			}//end for
			if (!found)
				System.out.println("Intructor doesn't exist in our databases");
			break;
			
		case 7:	//Modify the job title of a specific staff member
			found = false;
			System.out.println("\nEnter data:\nFirst Name:");
			first = keyboard.nextLine();
			System.out.println("\nLast Name:");
			last = keyboard.nextLine();
			do {
			System.out.println("\n10 Digit Phone Number(no dash or spaces)");
			pnumber = keyboard.nextLine();
			if (pnumber.length()!=10){
				System.out.println("phone number should be 10 digits long");
			}
			}while(pnumber.length()!=10);
			
			for (Person ppl: schoolMembers){
				if (ppl.compareTo(first,last, pnumber)==0){
					found = true;
					if (ppl instanceof Staff){
						System.out.println("What is the new job title of the staff member?");
						title = keyboard.nextLine();
						((Staff) ppl).setJobTitle(title);
						System.out.println("data inputed");

					}//end inner if	
					else
						System.out.println("The person identified is not a staff memeber.");
				}//end outer if
			}//end for
			if (!found)
				System.out.println("Person doesn't exist in our database");
			break;
			
		case 8:	//EXIT
			keyboard.close();
			System.out.println("Have a nice day!");
			break;
		}//end switch

		}while (choice !=8);
	}//end main
	
	private static ClassStatus getClassStatus(String status){
		 for (ClassStatus cst : ClassStatus.values()){
			  if (cst.name().equalsIgnoreCase(status))
				 return cst;
		 }//end for
		 return null;
	}
	

	public static int menu(){
		Scanner keyboard = new Scanner (System.in);
		int choice =1;//so that doesn't trigger if statement the first time
		do {
			//only implement second time if user entered invalid selection
			if (choice<1 || choice >9) System.out.println("invalid selection");
			System.out.println( "\n1. Add a Student"+
					"\n2. Add a Faculty Member"+
					"\n3. Add a Staff Member"+ 
					"\n4. List data about all members of the school"+
					"\n5. Modify credits earned of a specific student"+
					"\n6. Modify the rank of a specific instructor" +
					"\n7. Modify the job title of a specific staff member");
			choice = keyboard.nextInt();
		}while (choice<1 || choice >9);
		return choice;
	}
}


