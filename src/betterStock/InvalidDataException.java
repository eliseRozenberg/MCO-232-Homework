package betterStock;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException(){
		super("invalid date");
	}

}
