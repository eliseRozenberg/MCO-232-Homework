package accountHW;

public class InsufficientFundsException extends Exception {

		public InsufficientFundsException(){
			super("insufficient funds");
		}

	}