package metroCardCombine;

public class UseTypeOfCard {

	public static void main(String[] args) {
		TypeOfCard typeOfCard = TypeOfCard.PAYPERRIDE;
		
		System.out.println(typeOfCard.name() + " numric value " + typeOfCard.ordinal());
		
		for (TypeOfCard t : TypeOfCard.values()){
			System.out.println("value " + t.ordinal() + " " + t.toString());
		}
	}

}
