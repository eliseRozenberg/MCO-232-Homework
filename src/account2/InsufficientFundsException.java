package account2;

public class InsufficientFundsException extends Exception {

		public InsufficientFundsException(){
			super("insufficient funds");
		}

	}