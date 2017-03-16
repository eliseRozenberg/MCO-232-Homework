package metroCardCombine;

//checked exception - the machine should check that card hasn't expired before
//letting the MetroCard through.  It is quite likely that a commuter will
//try to use an expired card without realizing it.
public class CardExpiredException extends Exception{
	public CardExpiredException(){
		super("card expired");
	}

}
