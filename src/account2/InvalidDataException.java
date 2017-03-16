package account2;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException(){
		super("invalid data");
	}
}
