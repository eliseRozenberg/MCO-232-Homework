package cellPhoneSpring2015;

public class InvalidPhoneNumberException extends RuntimeException{
	public InvalidPhoneNumberException(){
		super("invalid phone number");
	}

}
