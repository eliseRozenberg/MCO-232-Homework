package randomNumGen;



	import java.util.Scanner;
	import java.io.FileNotFoundException;
	import java.io.File;
	public class Ahuva {
	    public static void main(String[]args) 
	    {
	    int[] numbers = new int[100];
	    
	    try
	    {
	     Scanner readFile = new Scanner (new File("./randomNumbers.txt"));
	    
	    int value = readFile.nextInt(); //read the first element of the array and put in the value variable
	    //read all the values in the file into an array
	    while (value != 0) //assuming that the trailer value is 0
	    { 
	        numbers[value - 1] += 1; //add one to the value
	        value = readFile.nextInt(); //read the next number of the file
	    } //end while loop
	    
	    //displaying the elements of the array
	        for (int i = 0; i < numbers.length; i++)
	        {
	            if (numbers[i] == 0) //if the element holds a zero than display that that number does not occur
	            {
	                System.out.println((i+1) + " never occurred.");
	            }
	            else if(numbers[i] == 1)
	            {
	            System.out.println((i+1) + " occurs " + numbers[i] + " time.");
	            }
	            else if (numbers[i] > 1) //if it holds more than zero display how many times it occurs
	            {
	                System.out.println((i+1) + " occurs " + numbers[i] + " times.");
	            }
	           
	        }
	    readFile.close();//close the file    
	    } //end try
	    
	    //catch the Exception that has been thrown - display a message to the end user     
	        catch(FileNotFoundException ex)
	        {
	            System.out.println("data could not be processed - file not found");
	            System.exit(1);
	        } //end catc
	    } //end main
	} //end class

