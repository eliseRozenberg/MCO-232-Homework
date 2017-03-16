package realEstateNew;

//set up specific value and for each value store data
//it general doesn't have other values because it just stores specific values
//values() method USState.values - it checks that the values are valid - sends back all the possible enum values 
	//and then user compares it to  string 
//ordinal() -returns number equiv of value
//name() returns value assigned to instance
//we made getName() - returns what the enum hold - long state name 
//toString() 


public enum USState {
	AL("ALABAMA"),	AK("ALASKA"),	AZ("ARIZONA"),	AR("ARKANSAS"),
	CA("CALIFORNIA"),	CO("COLORADO"),	CT("CONNECTICUT"),
	DE("DELAWARE"),
	FL("FLORIDA"),
	GA("GEORGIA"),
	HI("HAWAII"),
	ID("IDAHO"),	IL("ILLINOIS"),	IN("INDIANA"),	IA("IOWA"),
	KS("KANSAS"),	KY("KENTUCKY"),
	LA("LOUISIANA"),
	ME("MAINE"),	MD("MARYLAND"),	MA("MASSACHUSETTS"),	MI("MICHIGAN"),	MN("MINNESOTA"),	MS("MISSISSIPPI"),	MO("MISSOURI"),	MT("MONTANA"),
	NE("NEBRASKA"),	NV("NEVADA"),	NH("NEW HAMPSHIRE"),	NJ("NEW JERSEY"),	NM("NEW MEXICO"),	NY("NEW YORK"),	NC("NORTH CAROLINA"),	ND("NORTH DAKOTA"),
	OH("OHIO"),	OK("OKLAHOMA"),	OR("OREGON"),
	PA("PENNSYLVANIA"),
	RI("RHODE ISLAND"),
	SC("SOUTH CAROLINA"),	SD("SOUTH DAKOTA"),
	TN("TENNESSEE"),	TX("TEXAS"),
	UT("UTAH"),
	VA("VIRGINIA"),	VT("VERMONT"),
	WA("WASHINGTON"),	WV("WEST VIRGINIA"),	WI("WISCONSIN"),	WY("WYOMING");
	
	//a private field
	private String stateName;
	
	//private constructor - because it is never called it is just so the compiler is happy with it
	private USState(String name){
		this.stateName = name;
	}
	
	//if you want someone to gain access to the info - you must supply a public getter to get the information
	public String getName(){
		return stateName;
	}
}
