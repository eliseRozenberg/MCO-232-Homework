package testScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScores 
{
	
	public static void main(String[] args) 
		{
		Scanner gradeFile;		//will reference the text file that records the test scores
		int[] grades;			//will reference the array that stores the test scores that were read in
		int numberOfScores;		//how many scores are in the file
		try
			{  
		    //if file can't be found on the disk , the OS will send back a message to the JVM
		    //java will throw an exception to alert the application that an error condition has occurred
		    //Note: this will work if the testScores.txt file is stored in the same folder as this
			//program is executing  -  you can specify a specific path if you are unsure as to where to
			//store the file
			gradeFile = new Scanner (new File ("./testScores.txt"));
			numberOfScores = gradeFile.nextInt();						//input the first number(the number of scores) into the file 
			grades = new int [numberOfScores];							//instantiate the array and make it the size of the amount of scores
			for (int i=0; i<numberOfScores; i++)						//for every slot in the array...
				{
				grades[i] = gradeFile.nextInt();						//read the next grade and store it in the array
				}
			int topScore = bestScore(grades);								//call the bestScore method to return the best score
			System.out.println("The highest score is " + topScore + "\n");
			for (int i=0; i<grades.length; i++)								//for every grade...
				{
				//print the student number, score (numeric), and grade (alphabetic)
				//to get the grade, getGrade method is called for every score
				System.out.println("Student " + (i+1) + " scored " + grades[i] + " and the grade is " + getGrade (grades[i],topScore));
				}
			}	
		
		//catch the Exception that has been thrown - display a message to the end user 		
		catch(FileNotFoundException ex)
			{
			System.out.println("data could not be processed - file not found");
			}
		}
	
	
	/**
	 * 
	 * @param scores   array of test scores
	 * @return         the value of the best score that appears in the array, scores
	 */
	public static int bestScore(int[] scores)
		{
		int bestScore=0;											
		for (int i=0; i<scores.length; i++)						//for every score...
			{
			if (bestScore < scores[i])							//if the score is greater than the top score...
				bestScore= scores[i];							//it becomes the top score
			}
		return bestScore;										
		}
	
	/**
	 * 
	 * @param score     
	 * @param bestScore    value of the best score achieved on this particular test/exercise
	 * @return             letter grade awarded to the score
	 */
	public static Character getGrade(int score,int bestScore)
		{
		char grade;												//to hold the grade 
																//if the score is greater than or equals to...
		if (score >= (bestScore - 10))							//ten points less than the top score...
			grade = 'A';												//student receives an A
		else if (score >= (bestScore - 20))						//twenty points less than the top score...
			grade = 'B';												//student receives an B
		else if (score >= (bestScore - 30))						//thirty points less than the top score...
			grade = 'C';												//student receives an C
		else if (score >= (bestScore - 40))						//forty points less than the top score...
			grade = 'D';												//student receives an D
		else 													//any score lower than the best score-40...
			grade = 'F';												//student receives an F
		return grade;	
		}
}