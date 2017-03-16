
package game;
import java.util.Scanner;
public class ahuvatic
{
    public static void main (String args[])
    {
    Scanner keyboard = new Scanner(System.in);
    String[][] ticTacToe = new String[3][3]; //an array to hold the user's input
    
    System.out.println("Rules of the Game: ");
    System.out.println("Two players take turns entering either an 'X' or an 'O', if you get "
                        + "3 in a row, you win! Good Luck!!");
    String player1 = "X";
    String player2 = "O";
    int i = 0;
    
    
    
    //make all elements of the array "a" inorder not to have any nulls
    
    for (int j = 0; j < 3; j++)
    {
        for(int k = 0; k < 3; k++)
        {
        ticTacToe[j][k] = "a";
        }
    }
    
    printBoard(ticTacToe);    
    while (i != 9) //this is the max amount of turns before it is a draw
    {
        turn(player1,ticTacToe);
        i++;
        printBoard(ticTacToe);
        checkBoard(ticTacToe);
    
        if (i <= 9) //total amount of turns
        {
            turn(player2, ticTacToe);
            i++;
            printBoard(ticTacToe);
            checkBoard(ticTacToe);
        }
        else
        break;
    } //end while
    
    System.out.println("Tie game! Thanks for playing!");
    keyboard.close();
    System.exit(0);
    }//end main
    
    public static void printBoard (String[][] ticTacToe)
    {
    int p;
    int q;
    //display the 3x3 board to the user
    System.out.println("-------------");
    
    for (p = 0; p < ticTacToe.length; p++)
    {
        for (q = 0; q < ticTacToe[p].length; q++)
        {
            if (!(ticTacToe[p][q]).equals("a"))
            {
                System.out.print("| " + ticTacToe[p][q]+ " ");
            }
            else
            {
            System.out.print("| ");
            }
        } //end inner loop
        System.out.println("| ");
        System.out.println("-------------");
    } //end outer loop
    }
    
    public static void turn(String player, String[][] ticTacToe)
    {
    Scanner keyboard = new Scanner(System.in);
    int row;
    int column;
    
    do
    {
    System.out.print("Enter a row (0, 1, 2) for Player " + player + " : ");
    row = keyboard.nextInt();
    while (row < 0 || row > 2)
    {
        System.out.print("You did not enter a valid number. Please enter again: ");
        row = keyboard.nextInt();
    }
    
    System.out.print("Enter a column (0, 1, 2) for Player " + player + " : ");
    column = keyboard.nextInt();
    while (column < 0 || column > 2)
    {
        System.out.print("You did not enter a valid number. Please enter again: ");
        column = keyboard.nextInt();
    }
    
    if (!(ticTacToe[row][column]).equals("a"))
    {
        System.out.println("Player " + ticTacToe[row][column] + " already took that space. Choose again: ");
    }
}    
    while (!(ticTacToe[row][column].equals("a")));
    
    //otherwise place it in the array
    ticTacToe[row][column] = player;
    }
    
    
    
    public static void checkBoard (String[][] ticTacToe)
    {
    for (int row = 0; row < 3; row++)
    {
        if ((!(ticTacToe[row][0]).equals("a"))&&(!(ticTacToe[row][1]).equals("a")) && (!(ticTacToe[row][1]).equals("a"))&&(!(ticTacToe[row][2]).equals("a")))
        {
            if ((ticTacToe[row][0]).equals(ticTacToe[row][1]) && (ticTacToe[row][1]).equals(ticTacToe[row][2]))
            {
            System.out.println("Player " + ticTacToe[row][0] + " won!!");
            System.exit(0);
            }
        }
        for (int column = 0; column < 3; column++)
        {
        if ((!(ticTacToe[0][column]).equals("a"))&&(!(ticTacToe[1][column]).equals("a")) && (!(ticTacToe[1][column]).equals("a"))&&(!(ticTacToe[2][column]).equals("a")))
        {
            if ((ticTacToe[0][column]).equals(ticTacToe[1][column]) && (ticTacToe[1][column]).equals(ticTacToe[2][column]))
            {
            System.out.println("Player " + ticTacToe[0][column] + " won!!");
            System.exit(0);
            }
        }
        }
    }
    if ((!(ticTacToe[0][0]).equals("a"))&&(!(ticTacToe[1][1]).equals("a"))&& (!(ticTacToe[1][1]).equals("a"))&&(!(ticTacToe[2][2]).equals("a")))
    {
        if ((ticTacToe[0][0]).equals(ticTacToe[1][1])&& (ticTacToe[1][1]).equals(ticTacToe[2][2]))
        {
        System.out.println("Player " + ticTacToe[0][0] + " won!!");
        System.exit(0);
        }
    }
    
    if ((!(ticTacToe[0][2]).equals("a"))&&(!(ticTacToe[1][1]).equals("a")) && (!(ticTacToe[1][1]).equals("a"))&&(!(ticTacToe[2][0]).equals("a")))
    {
        if ((ticTacToe[0][2]).equals(ticTacToe[1][1]) && (ticTacToe[1][1]).equals(ticTacToe[2][0]))
        {
        System.out.println("Player " + ticTacToe[0][2] + " won!!");
        System.exit(0);
        }
    
    }
    }
    
}