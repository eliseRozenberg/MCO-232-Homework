package game;
import java.util.Scanner;

public class PatternRecognitionLibby {
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Enter the number of rows");
		int rows = keyboard.nextInt();
		System.out.println("Enter the number of columns");
		int columns = keyboard.nextInt();
		
		int[][] board = new int[rows][columns];
		
		for (int i = 0; i < rows; i++)
		{
			System.out.println("Enter the values for row " + (i + 1));
			for (int j = 0; j < columns; j++)
			{
				board[i][j] = keyboard.nextInt();
			}
		}
		
		display(board, rows, columns);
		isConsecutiveFour(board, rows, columns);
		
	}
	
	public static void display(int[][] board, int rows, int columns)
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void isConsecutiveFour(int[][] board, int rows, int columns)
	{
		boolean consecutive = false;
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < columns; j++)
		{
			if ((i + 3) < rows && (j + 3) < columns)
			{
				if (board[i][j]==(board[i+1][j+1]) && board[i+1][j+1]==(board[i+2][j+2]) && board[i+2][j+2]==(board[i+3][j+3])
						|| board[i][j]==(board[i][j+1]) && board[i][j+1]==(board[i][j+2]) && board[i][j+2]==(board[i][j+3])
						|| board[i][j]==(board[i+1][j]) && board[i+1][j]==(board[i+2][j]) && board[i+2][j]==(board[i+3][j]))
					{
						consecutive = true;
						break;
					}
			}
			else 
			{
				break;
			}
		}
	}
	
	if (consecutive)
	{
	System.out.println(consecutive + ", four in a row");
	}
	else
	{
		System.out.println(consecutive + ", you do not have four in a row");
	}

}
	
}

