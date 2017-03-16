package metroCardCombine;
import java.util.GregorianCalendar;



public class Commuter {
	private MetroCard[] cards;  
	//not so likely that a Commuter will purchase an unlimited number of MetroCards, use array instead of ArrayList
	private int numCards;
	
	public Commuter(int qty){
		//instantiate instance variables
		cards = new MetroCard[qty];
		numCards = 0;
	}
	
	public Commuter(){
		this(1);  //invoke the other constructor and set up for one card
	}
	public void buyCard(double amount, TypeOfCard typeOfCard)throws ArrayIndexOutOfBoundsException, InvalidDataException{
		if(numCards == cards.length){
			//room to have another metro card
			throw new ArrayIndexOutOfBoundsException();
		}
		else{
			
				//instantiate a new card and add it to the array
				//the Commuter can check the data provided to MetroCard to instantiate a MetroCard
				//or , as in this case, it can rely on the MetroCard to verify the data and throw
				//an exception if all is not well....
			    
				cards[numCards]= new MetroCard(typeOfCard,amount);
				//goes to the metro card class
				numCards++;  //all is well , add another card to number of cards
			
			
		}
	}
	
	public void swipe(Station station)throws ArrayIndexOutOfBoundsException, CardExpiredException, InsufficientBalanceException{
	   	int cardNo;
	   	boolean swiped = false;
	   	
		try{
	   		cardNo = findFirstToExpire();
	   		cards[cardNo].swipe(station);
	   		//send message to the Metro card to swipe
	   		//Metro-card has to check a lot of info
	   	
	   	}
		
		//there are a few types of exceptions that might be thrown
		catch (ArrayIndexOutOfBoundsException ex1){
			//there are no available MetroCards
			throw ex1;
		}
		// note - following syntax is only legal in  versions  Java 7 and subsequent versions
		catch (CardExpiredException  | InsufficientBalanceException ex3){
			//the card that is first to expire has already expired  and wasn't removed
			//from the set of MetroCards that the Commuter has 
			//or the card that is first to expire doesn't have enough money to pay for the ride
			
			//Commuter must search for a different card
		
			
				//use any card
				for (int i =0;i< numCards;i++ ){
					try {
						cards[i].swipe(station);
						swiped = true;
						return;  //out of loop and method because managed to swipe a card
					}
					catch(CardExpiredException  | InsufficientBalanceException ex4){
						if (i == numCards -1){
							//this is the last available card
							throw ex4;
						}
						
					}
				}
				
				//if you are still in the method at this point
				//something is wrong
				if (!swiped){
					throw new ArrayIndexOutOfBoundsException(); //don't have a MetroCard that can be used
				}
				else{
					return;  //all is well
				}
				
			}
		}

	
	
	public void merge()throws ArrayIndexOutOfBoundsException,InvalidDataException{
		//first find the card with the latest expiration date
		//that will be the card to which you merge all other card balances
		int posOfLast ;
		
		   posOfLast = findLastToExpire();  //don't need try catch , planning to throw the exception in any case
		    
	    //loop through cards , ignore the card that has the latest expiration date
		//merge balances of all other cards to card
		//that has the latest expiration date
	
		for (int i =0; i< numCards;i++){
			if (i == posOfLast) continue;
			cards[posOfLast].merge(cards[i]);  //take the balance of cards[i] and add it to balance of cards[posOfLast]
		}
		
		//remove all cards that have zero balance
		removeEmptyCards();
		
		
	}
	public int findFirstToExpire()throws ArrayIndexOutOfBoundsException{
		if (numCards ==0 ) throw new ArrayIndexOutOfBoundsException();    //no cards
		int posOfLeast =0;
		GregorianCalendar leastDate =cards[0].getExpDate();
		for(int index=1;index<numCards;index++){
			if(cards[index].getExpDate().compareTo(leastDate)<0){
				leastDate = cards[index].getExpDate();
				posOfLeast = index;
			}
		}
		return posOfLeast;
		
	}
	
	public int findLastToExpire()throws ArrayIndexOutOfBoundsException{
		if (numCards ==0) throw new ArrayIndexOutOfBoundsException();
		int posOfLast =0;
		GregorianCalendar lastDate = cards[0].getExpDate();
		for (int index =1 ; index < numCards; index++){
			if (cards[index].getExpDate().compareTo(lastDate)>0){
				//this card has later expiration date
				posOfLast = index;
				lastDate = cards[index].getExpDate();
			}
		}
		return posOfLast;
	}
	public void removeEmptyCards(){
		//do i have any cards to remove
		
		//set up another array  of size 
		MetroCard [] tempCards = new MetroCard[numCards];
		int numRemainingCards =0;
		for (int i=0;i<numCards;i++){
			if (cards[i].getBalance()==0){
				cards[i] = null;
			}
			else{
				//add reference to that MetroCard to the tempCards array
				tempCards[numRemainingCards++] = cards[i];
			}
		}
		
		//reset the fields
		numCards = numRemainingCards;
		cards = tempCards;   //now points to the new array which doesn't reference any MetroCards with 0 balance
		
		
		  
		       
		   }//ends method
		   
			
	public void addMoney(double amount)throws ArrayIndexOutOfBoundsException,InvalidDataException,CardExpiredException{
		int cardNo;
		
	   		cardNo = findFirstToExpire();
	   		cards[cardNo].add(amount);
	   	
	   	
	}

	public String toString(){
        StringBuffer info = new StringBuffer();
        info.append("\nCommuter - numCards = " + numCards);
		for (int i =0 ; i<numCards; i++){
			info.append( cards[i].toString()); //calls the tosTring method from metroCard
			
		}
		return info.toString();
	}

}
