package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Errors:  1. readData() method should not be catching the exception since the method should only do
//            what it was designed to do, namely read the names from the file and place them in RAM in an array
//            if it determines that it can't complete the job because file can't be found it should throw FileNotFoundException
//            to let main() 'know' that something went wrong.      -2
//         2. case 1:  since readData() might throw a FileNotFoundException the try catch clause should be included
//               in this case statement and main() should display the error message to the end user    -2
//         3. findShortestName() - sorting the data was one way of determining the shortest name however 
//              the sort would have to be based on a comparison of String.length() , not the actual values of the names
//              You actually did neither , you compared the index values which unfortunately makes no sense (sorry!)  -5
public class quiz1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String [] names = new String [100] ; 
		
		int place = -1;
		int values=0;
		String shortName;
		
		int choice;
		while (true){
			choice = menu();
			switch (choice){
			case 1:
				try {
					values  =readData(names); //file notfound? need try catch
				   	System.out.println("File read\n");
				}
				catch(FileNotFoundException ex) {
					System.out.println("data couldnt be read");
					System.exit(1);
				}

			      	break;
		//throw it to main which interacts with the user and displays the message - dont do try catch in the method
			case 2:
				    System.out.println("which name are you looking for?");
			        String name = keyboard.next();
			        place =findName(name, names, values);
			        if (place != -1) 
			        	System.out.println("you are on the list");
			        else 
			        	System.out.println("you are not on the list");
			        break;
			case 3: 
				    System.out.println("this feature has not yet been implemented - stay tuned....");
				     break;
			case 4:  
				shortName=findShortestName(names, values);
				if (shortName == null)

		/* can never if somethin == null
		 * but with string can bec wasnt doing anything pointing anywhere so can here
		 * in a database - thers its own - if it is null not equals
		 * name.equals (null) cant do because cant send nothing an instruction equals cuz pointing to what 
		 * should be holding but now its not
		 * but with = null - only looking at name
		 * can do name ="" that is okay and do .equals because it has something so pointing to something even though its blank space
		 */			
					System.out.println("");
				else 
					System.out.println("the shortest name is " + shortName);
				break;
			case 0:  System.out.println("end application");
			         keyboard.close();
			         System.exit(0);
			         break;
			}
		} //end while
		
		
		
	}
		
		/**
		 *   Read data from file and store the data in the array names[]
		 *   @return  the number of values that were read in from the file
		 */
		
		public static  int readData(String[] names) throws FileNotFoundException{
			int qty=0;
			
				Scanner input = new Scanner( new File ("./students.txt"));
				while (input.hasNext() && qty < names.length) {
					names[qty] = input.nextLine();
					qty++;
				}
			
			
//better to do if because it gives you more info as to the problem
//but if there would be an if - need an else break; 
//or else keep on reading and if big file = inefficient
//next reads till white space and lines read a whole line (for first name last name)
// but any is really fine

			return qty;
		}
		
		/**
		 * name - name to find in the list
		 * names[] - list of names that must be searched
		 * qty - how many elements of names[] contain significant data
		 * @return - position in the array in which the first instance of the name was found
		 *           return -1 if name can't be found in the list  names[]
		 */
		public static int findName(String name, String[] names, int qty){
			for (int i =0; i <qty; i++) {
				if (names[i].equalsIgnoreCase(name)) {
					return i;
				} //end if
			} //end for
			
			return -1;
		}
//or can make a boolean and break from the loop if you get to the if... if not the loop continues until boolean changed to false
		
		
/**
 * 
 * @param names  - list of names
 * @param qty   - how many names are stored in the names[] array
 * @return  -  the name that has the smallest length
 */
	   public static String findShortestName(String[] names, int qty){ //i did completely the wrong thing
		//sort with the .length 
		//lol there is know shortest name
		
		if (qty>0) {	//if qty need bc what if there is know data- mabey sent empty array
				//bc if didnt do th efirst case the nthe data wouldnt have been read and then crashed so good to have
			String shortest = names[0];
			for (int i=0;i<qty;i++) {
				if (shortest.length() > names[i].length())
					shortest= names[i];
			}
			return shortest;
		}
		else 
			return null;
	   }
	

		
	
	public static int menu(){
		int choice;
		Scanner input = new Scanner(System.in);
		do{
		        System.out.println("1. Read in Student Data "
				+ "\n2. Find Name in Student List"
				+ "\n3. How may times does each name appear in the List" 
				+ "\n4. Which is the shortest name"
				+ "\n0. EXIT"
				);
		        
		        
		        choice = input.nextInt();
		       // System.out.println("choice entered was " + choice);
		
		}while(choice > 4 || choice < 0);
		
		
		
		return choice;
	}

}


//go home and try to make all the short list in an array and display
//also try to do case 3 !
