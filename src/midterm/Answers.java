package midterm;

public class Answers {
 
 /*
  * question 1 - to check max values
  *     remember to check that the array has values
  *     then make sure set max as first and compare to all and send max
  * question 2 - make sure to check if the arrayList
  *     if (values.size()==0) throw new ListEmptyException
  *     if (values==null) throw new ListEmptyException 
  *      - there is no arrayList instantiated
  *      - make a new exception but used listEmpty for this case
  * question 3 - (-1) didn't write the exception or didn't code it into the method
  *     good to check if fits in that row - to check for a ragged array
  *     if(col< array[0].length && col>=0) throw new InvalidColumnException
  *     ***never change the index in the loop- DUH!!!
  * question 4 - (-2) make exception after exhausted the list - put it to soon :( :(
  *      - Careful that don't do this - 
  *      - maybe put on next test and more points off
  *     ***never code specific name b/c not reusable -  DUH!!!
  * question 5 - (-5) for not knowing the amount it goes through
  *       n^2 (or nXn comparisons)
  * question 6 - (-4) what if no side effects or no such thing
  *       -make constructor without side effects
  *       -make arrayList so can make side effects bigger if more
  *      make a deep copy with the arrayList method - COOL!!
  *       - ArrayList sideEffects = new ArrayList<String> (effects)
  *  question 7 - (-1) can invoke arraList to string method
  *       - did a for loop and then called it each time 
  *       - maximum reuse should have just called the camper
  *      (-1) don't set the arrayList to null
  *     addCamper method :
  *      - if did .contain to see if it has the camper you want to add -
  *      - but that only works if had an equals to method in the class
  *      -  if not then it will check the address 
  *     removeCamper
  *      - two types of remove  
  *        1.  excepts the object 
  *        2.  excepts the index
  *     
  */     
}
