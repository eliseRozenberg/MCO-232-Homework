package game;

import java.util.Scanner;
public class PatternAhuva
{
    public static void main(String[] args)
    {
    //instructions of the game
    System.out.println("You will enter as many values as you decide. If there are four in a row " 
                    + "horizontally, vertically, or diagonally, the computer will tell you.");
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("Enter how many rows you want: ");
    int row = keyboard.nextInt();
    
    System.out.print("Enter how many columns you want: ");
    int column = keyboard.nextInt();
    
    //instantiate a 2 dimensional array based on the user's input
    int[][] numbers = new int[row][column];
    
    //call the method that will put the values into the array
    int quantity = placeValues(numbers,row,column);
    
    //call the method that will display the board
    displayBoard(numbers);
    //call the method that will perform the logic and see if there are four in a row in any way.
    boolean result = check(numbers);
    if (result)
    System.out.println("There are four in a row.");
    else 
    System.out.println("There is not four in a row.");
    keyboard.close();
    }
    
    
    public static int placeValues (int[][] numbers, int amtRows, int amtCol)
    {
    
    Scanner keyboard = new Scanner(System.in);
    
    int value;
    int qty = 0;
    System.out.println("Enter in " + (amtRows * amtCol) + " values: ");
    for (int row = 0; row < amtRows; row++)
    {
        for(int col = 0; col < amtCol; col++)
        {
        
        //while (qty < (amtRows*amtCol))
        //{
        System.out.print("Enter in number " + (qty + 1) + " : ");
        value = keyboard.nextInt();
        numbers[row][col] = value;
        qty++;
        //}
        
        }
    }
    keyboard.close();
    return qty;
    }
    
    public static void displayBoard(int[][] numbers)
    {
    for (int row = 0; row < numbers.length; row++)
    {
        System.out.println();
        for (int col = 0; col < numbers[row].length; col++)
        if (numbers[row][col] <= 9)
        {
        System.out.print(" " + numbers[row][col] + " ");
        }
        else
        System.out.print(numbers[row][col] + " ");
    }
    System.out.println(); //display an empty line
    }
    
    public static boolean check (int[][] numbers)
    {
    
    //go by rows and see if there are 4 in a row horizontally
    
    for (int row = 0; row < numbers.length; row++)
    {
        for (int col = 0; col < numbers[row].length; col++)
        {
        
        //try
        //{
        if ((col + 3) < numbers[row].length)
        {
        if ((numbers[row][col] == numbers[row][col + 1]) && (numbers[row][col] == numbers[row][col + 2]) && (numbers[row][col] == numbers[row][col + 3]))
            {
                return true;
            }
        }
         
        if ((row + 3) < numbers.length)
        {
        if ((numbers[row][col] == numbers[row + 1][col]) && (numbers[row][col] == numbers[row + 2][col]) && (numbers[row][col] == numbers[row + 3][col]))
            {
            return true;
            }
        }
        if ((row + 3) < numbers.length && (col + 3) < numbers[row].length)
        {        
        if ((numbers[row][col] == numbers[row + 1][col + 1]) && (numbers[row][col] == numbers[row + 2][col + 2]) && (numbers[row][col] == numbers[row + 3][col + 3]))
            {
            return true;
            }
        }
        
        if ((row + 3) < numbers.length && (col - 3) >= 0)
        {
        if ((numbers[row][col] == numbers[row + 1][col - 1]) && (numbers[row][col] == numbers[row + 2][col - 2]) && (numbers[row][col] == numbers[row + 3][col - 3]))
            {
            return true;
            }
        }
        
        }//end inner for
    } //end outer for
    return false;
    
    }
}
    