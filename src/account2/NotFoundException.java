package account2;

public class NotFoundException extends Exception {
	public NotFoundException(){
		super("data not found");
	}
}
