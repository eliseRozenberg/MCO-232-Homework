
package metroCardCombine;

import java.util.Scanner;

public class Commuting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Commuter aCommuter= null;
		int choice;
		final int  EXIT =8;
		MetroCard aCard;
		Scanner input = new Scanner(System.in);
		choice = menu();
		while (choice != EXIT){
			switch (choice){
			case 1: 
				  System.out.println("How many cards will this commuter keep?");
				  int numCards;
				  numCards = input.nextInt();
				  if (numCards < 0 || numCards > 5){
					  System.out.println("not valid amount of cards");
				  }
				  else{
				     aCommuter = new Commuter(numCards); //set up a new one and passing in the number of cards
				     //in real life dont have a limit on how many cards
				  }
				break;
			//only deals with one commuter- can make the main more complicated to deal with many commuters
			case 2:
				TypeOfCard cardType;
				System.out.println("Enter Card Type Number: 1. SingleRide 2.PAYPERRIDE 3.UNLIMITED 4.REDUCEDFARE ");
			    int type = input.nextInt();
			    
				switch (type){
				case 1:
					cardType = TypeOfCard.SINGLERIDE;
					//shoud'nt ask for an amount - can improve
					break;
				case 2:
					cardType = TypeOfCard.PAYPERRIDE;
					break;
				case 3:
					cardType = TypeOfCard.UNLIMITED30Days;
					break;
				case 4:
					cardType = TypeOfCard.REDUCEDFARE;
					break;
				default:
					cardType =TypeOfCard.PAYPERRIDE;
					break;
				}
				System.out.println("How much money is deposited on card?");
				double amount = input.nextDouble();
				try{
				   aCommuter.buyCard(amount,cardType);	
				   //method buy card - send type and money - its in the commuter class
				}
				catch(InvalidDataException e){
					System.out.println("data you provided is invalid, please reenter");
				}
				catch(ArrayIndexOutOfBoundsException e1){
					System.out.println("insufficient memory - can't add another MetroCard");
				}
				catch(NullPointerException e3){
					System.out.println("cant buy a card without a commuter");
				}
				break;
			case 3:  //commuter add money to a card
				System.out.println("How much money do you wish to add?");
				amount = input.nextDouble();
				try{
					aCommuter.addMoney(amount);
				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println("money wasn't added " + e.getMessage());
				}
				catch (InvalidDataException e1){
					System.out.println("money wasn't added - invalid data provided");
				}
				catch (CardExpiredException e2){
					System.out.println("card expired can't add money");
				}
				break;
			case 4:
				System.out.println("enter name of station");
				input.nextLine();  //flush the newline from  buffer  from previous input
				String name = input.nextLine();
				System.out.println("Enter type of station:  PATH   BUS   SUBWAY");
				String stationtype;
				stationtype = input.next();
				Station aStation = new Station(name,StationType.valueOf(stationtype));
				try{
					aCommuter.swipe(aStation);
				}
				catch(CardExpiredException e){
					System.out.println("Cant swipe card - it expired" + e.getMessage());
				}
				catch(ArrayIndexOutOfBoundsException e1){
					System.out.println("no card available to swipe");
				}
				catch(InsufficientBalanceException e2){
					System.out.println("insufficient funds on cards - can't ride the transit");
				}
				break;
			case 5: //display data
				System.out.println(aCommuter);
				break;
			case 6:
				break;
			case 7:  //merge all card balances to one card
				try{
				aCommuter.merge();
				}
				catch(InvalidDataException ex1){
					System.out.println("couldn't complete merge - invalid data");
				}
				
				break;
			case 8:
				System.out.println("Have a nice day");
				break;
			
			}  //end switch statement
			choice = menu();
			
		}//end while
		System.out.println("Have a nice day!");
	}
	
	
	
	static public int menu(){
		int choice;
		do{
		System.out.println("\n1.Set up Commuter" +
		   "\n2.Buy MetroCard" +
				"\n3.Add Money to Card" +
		   "\n4.Swipe Card" + 
				"\n5.Display Card Data" +
		   "\n6.Display Card Balance" +
				"\n7.Merge all Card Balances" +
				"\n8 EXIT"
				
				);
		
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		}while (choice < 0 || choice > 8);
		return choice;
	}

}
