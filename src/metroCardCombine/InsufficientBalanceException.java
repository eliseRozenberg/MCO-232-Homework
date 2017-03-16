package metroCardCombine;

//runtime exception  - the user can check that the MetroCard has sufficient
//balance before using the MetroCard
public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException(){
		super("insufficient balance");
	}

}
