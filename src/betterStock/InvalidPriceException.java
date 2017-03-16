package betterStock;

public class InvalidPriceException extends Exception {
  public InvalidPriceException(){
	  super("invalid price");
  }
}
