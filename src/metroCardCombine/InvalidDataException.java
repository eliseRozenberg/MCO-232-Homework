package metroCardCombine;

//checked exception - machine should check that all data has been provided
//properly before proceeding - the end user might not be expected to verify this.
public class InvalidDataException extends Exception{
	public InvalidDataException(){
		super("invalid data");
	}

}
