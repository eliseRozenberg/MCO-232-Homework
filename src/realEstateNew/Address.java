package realEstateNew;

public class Address {
  private String street;
  private String city;
  private USState state; //enum-used USState because the words state is a key word (1 to 1 relationship between the adders and the state)
  private String zipCode;
 
  public Address(String street, String state,String zipCode){
	 this(street,null, state,zipCode); 
  }
  
  public Address(String street, String city,String state,String zipCode){
	  //perform validation here......throw exceptions if 
	  //data provided is invalid or missing
	  //didn't validate street because too many of them
	
	  //static method are in Italics
	  //only use static method if it doesn't relate to any specific instance of an address
	  USState stateCode = getStateCode(state);
	  //send in a state as a String
	  
	  if (stateCode == null) {  //no corresponding state code could be found
		  throw new InvalidDataException();
	  }
	  
	  
	  if (!isZipCodeValid(zipCode)){
		  throw new InvalidDataException();
	  }
	  
	  //assume passed validation
	
	  this.street =street;
	  this.city =city;
	  this.state = stateCode;
	  this.zipCode = zipCode;
  }
  
  //setters 
  public void setStreet(String street){
	  this.street = street;
  }
  
  public void setCity (String city){
	  this.city =city;
  }
  
  public void setState(String state){
	  this.state = getStateCode(state);
	  if (this.state == null){
		  throw new InvalidDataException();
	  }
	
  }
  
  public void setZipCode(String zipCode){
	  if (!isZipCodeValid(zipCode)){
		  throw new InvalidDataException();
	  }
	  this.zipCode = zipCode;
  }
  //getters

public String getStreet() {
	return street;
}

public String getCity() {
	return city;
}

public String getState() {
	return state.getName();
}

public String getZipCode() {
	return zipCode;
}
  

//these are static methods because they are generic

//validates that send a state that exists
//and has values method that sends back a list of all the states in enum and then checks for every state if name is equal to the string
//could have done getName - to compare the state name if you don't know the 2 letters 
private static USState getStateCode(String state){
	 for (USState theState : USState.values()){
		  if (theState.name().equalsIgnoreCase(state)){
			 return theState;
			
	  }
	 }
	 return null;   //couldn't find the state
}

//all zipcodes are verified same way, regardless of the instance
private static boolean isZipCodeValid(String zipCode){
	if (zipCode.length()==5 || zipCode.length()==9){
		 return true;
	  }
	else{
		return false;
	}
}
  //toString
  public String toString(){
	  StringBuffer info = new StringBuffer();
	  info.append("\nAddress: ");
	  info.append(" Street: " + street);
	  if (city != null){
	  info.append(" City: " + city);
	  }
	  info.append(" State: " + state.name());
	  info.append(" ZipCode: " + zipCode);
	  return info.toString();
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())   //the two objects are instances of different Classes
		return false;
	Address other = (Address) obj;
	if (street == null) {
		if (other.street != null)
			return false;
	} else if (!street.equals(other.street))
		return false;
	if (zipCode == null) {
		if (other.zipCode != null)
			return false;
	} else if (!zipCode.equals(other.zipCode))
		return false;
	return true;  //all fields contain equivalent data so the instances are deemed "equal"
}



  //compareTo
  public int compareTo(Address address){
	  if (this.zipCode.equals(address.zipCode)){
	  return this.street.compareTo(address.street);
	  }
	  else
	  {
		  return this.zipCode.compareTo(address.zipCode);  //sort the data according to zipcode
	  }
  }
 
}
