package sortLists;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class mergedList
{
    public static void main(String[] args)
    {
    int[] numberListOne = new int[100];
    int count1 = 0;
    int[] numberListTwo= new int[100];
    int count2 = 0;
    
    try{
    
    
    Scanner readOne = new Scanner(new File ("./list1.txt"));
    
    //read the first list into an array and display it
    System.out.println("This is the first list unsorted: ");
    while (readOne.hasNext())
    {
        if (count1 < numberListOne.length)
        {
            numberListOne[count1] = readOne.nextInt();
            System.out.print(numberListOne[count1] + " ");
            count1++;
        }
        else
        {
            System.out.println("There is insufficient space in RAM.");
        }
    }
    System.out.println(); //to create an empty line
    
    Scanner readTwo = new Scanner(new File ("./list2.txt"));
    
    //read the second list into an array and display it
    System.out.println("This is the second list unsorted: ");
    while (readTwo.hasNext())
    {
        if (count2 < numberListTwo.length)
        {
            numberListTwo[count2] = readTwo.nextInt();
            System.out.print(numberListTwo[count2] + " ");
            count2++;
        }
        else
        {
            System.out.println("There is insufficient space in RAM.");
        }
    }
    
    System.out.println(); //to create an empty line
    
    
    readOne.close(); //closing the first file 
    readTwo.close(); //closing the second file
    } //end try
    catch(FileNotFoundException ex)
        {
            System.out.println("data file not found");
            System.exit(1);
        } //end catch
        
    
    
    //call the method to sort the lists to be in order using the bubble sort
    int[] sortedList1 = bubbleSort(numberListOne,count1);
    int[] sortedList2 = bubbleSort(numberListTwo,count2);
    
    //display the two sorted lists
    System.out.println("This is the first list sorted: ");
    for (int i = 0; i < count1; i++)
    {
        System.out.print(numberListOne[i] + " ");
    }
    
    System.out.println(); //display empty line
    
    System.out.println("This is the second list sorted: ");
    for (int i = 0; i < count2; i++)
    {
    System.out.print(numberListTwo[i] + " ");
    }
    
    System.out.println();
    
    //call a method to see what is the intersect list
    int[] intersect = intersectSet(sortedList1, count1, sortedList2, count2);
    
    System.out.println("This is the intersect of the two lists: ");
    for (int i = 0; i < intersect.length; i++)
    {
        if (intersect[i] != 0)
        System.out.print(intersect[i] + " ");
    }
    System.out.println();
    
    int[] combinedList = new int[100];
    //call the method that will merge the lists together
    combinedList = mergeLists(sortedList1, count1, sortedList2, count2);
        //display the combined list
    System.out.println("This is the merged list of the 2 lists: ");
    
     for (int i = 0; i < combinedList.length; i++)
     {
        if (combinedList[i] != 0)
     System.out.print(combinedList[i] + " ");
     }
     
     System.out.println();
     
    }//end main
    public static int[] bubbleSort(int[] values, int qty)
    {
        int temp;
        //sort values in the array by repeating the process n*n times
        for (int outer = 0 ;outer< qty;outer ++)//this is how many times the inner loop gets repeated
        {   
            for (int inner = 0 ;inner < qty-1;inner++)//the inner loop performs the comparisons and swapping
                                                         //and goes through the array one time
            {  
                if (values[inner] > values[inner+1])
                {
                    //have to swap the values
                    temp = values [inner];
                    values[inner] = values [inner+1];
                    values [inner+1] = temp;
                }
            }
        }
        return values;
    }
        
    public static int[] intersectSet( int[] numberListOne, int count1, int[] numberListTwo, int count2)
    {
    
    //this is a method that will merge the two arrays, making a new array that will be the overlap of the two arrays.
    boolean listOneEmpty;
    boolean listTwoEmpty;
    int i = 0; //subscript for first list
    int k = 0; //subscript for second list
    int valueOne = 0;
    int valueTwo = 0;
    int[] intersect = new int[100];
    int m = 0; //subscript for intersect;
    
    //take the first value out of each array to compare them
    if (i < count1)
    {
        valueOne = numberListOne[i];
        listOneEmpty = false;
        i++;
    }
    else
    {
        listOneEmpty = true;
    }
    
    if (k < count2)
    {
        valueTwo = numberListTwo[k];
        listTwoEmpty = false;
        k++;
        
    }
    else
    {
        listTwoEmpty = true;
    }
    
        while (!listOneEmpty && !listTwoEmpty)
        {
            if (valueOne == valueTwo)
            {
            intersect[m] = valueOne;
            m++;
            
                if (i < count1)
                {
                    
                    valueOne =  numberListOne[i];
                    listOneEmpty = false;
                    i++;
                    
                }
                else
                    listOneEmpty = true;
                
                if  (k < count2)
                {
                    
                    valueTwo = numberListTwo[k];
                    listTwoEmpty = false;
                    k++;
                }
                else
                    listTwoEmpty = true;
            }
            
            if (valueOne < valueTwo)
            {
                if (i < count1)
                {
                    
                    valueOne = numberListOne[i];
                    i++;
                    
                }
                else
                listOneEmpty = true;
            }
            
            if (valueTwo < valueOne)
            {    
                if (k < count2)
                {
                
                valueTwo = numberListTwo[k];
                k++;
                
                }
                else
                listTwoEmpty = true;
            }
        }
        
    return intersect;
    }
    
    //this method will combine the two sorted lists into one but not having two of the same number
    public static int[] mergeLists(int[] listA, int qtyA, int[] listB, int qtyB)
    {
    boolean listAEmpty;
    boolean listBEmpty;
    int valueA = 0;
    int valueB = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    int[] mergedList = new int[100];
    
    
        if (i < qtyA)
        {
            valueA = listA[i];
            listAEmpty = false;
            i++;
        }
        else
            listAEmpty= true;
        
        if (k < qtyB)
        {
            valueB = listB[k];
            listBEmpty = false;
            k++;
        }
        else
        listBEmpty = true;
        
    while (!listAEmpty && !listBEmpty)
    {
        if (valueA == valueB)
        {
        mergedList[m] = valueA;
        m++;
        
            if (i < qtyA)
            {
                valueA = listA[i];
                i++;
            }
            else
            listAEmpty = true;
        
            if (k < qtyB)
            {
            valueB = listB[k];
            k++;
            }
            else
            listBEmpty = true;
        }
        
        else;
        
        if (valueA < valueB)
        {
            mergedList[m] = valueA;
            m++;
                
            if (i < qtyA)
            {
                valueA = listA[i];
                i++;
            }
            else
                listAEmpty = true;
        }
        
        else;
        
        if (valueB < valueA)
        {
            mergedList[m] = valueB;
            m++;
            
            if (k < qtyB)
                {
                valueB = listB[k];
                k++;
                }
                else
                listBEmpty = true;
        }
        
        else;
        } //end loop
        
        while (!listAEmpty)
        {
        
            if (i < qtyA)
            {
            mergedList[m] = valueA;
            m++;
            valueA = listA[i];
            i++;
            }
            else 
            	listAEmpty= true;
        }
        
        while (!listBEmpty)
        {
            if (k < qtyB)
            {
        mergedList[m] = valueB;
        m++;
        valueB = listB[k];
        k++;
            }
            else
            	listBEmpty= true;
        } //end loop
        
        return mergedList;
        
    
    
    } //end method
} //end class