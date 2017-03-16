package quiz;

public class UseCompare {

	public static void main (String [] args) {
		Contact me = new Contact ("Elise","Rozenberg","E" ,"1234567890" );
		Contact you = new Contact ("Riqki","Hellman", "Rik" ,"2345678901" );

		if (me.compareTo(you)==0) 
			System.out.println("we have the same last name");
		if (me.compareTo(you)< 0) 
			System.out.println("my name is first");
		if (me.compareTo(you)>0) 
			System.out.println("yours is first");

		boolean result = me.equals(you);

		if (result == true)
			System.out.println("we have the same last name");
		else if (result == false)
			System.out.println("we have the same last name");
	}
}