package quiz;

public class Contact {
	private String first;
	private String last;
	private String nickName; 
	private String number;



	public Contact ( String l, String num, String name){
	this (null, l,num, name ); 
	//referencing the constructor with more information
	//never make it a "" blank space - make it a null
	}

	//didnt need to throw it to the second constructor because we didn't make it a checked exception
	public Contact (String f, String l, String num, String name) throws InvalidDataException{
	if (l == null || num ==null || name ==null)
	throw new InvalidDataException(); 
	else {
	this.first = f;
	this.last = l;
	this.nickName = name;
	this.number = num;
	}//end else
	}

	public void setlast(String l) throws InvalidDataException {
	if (l ==null)
	throw new InvalidDataException();
	else 
	this.last = l;
}

	public void setnumber (String num) {
	this.number = num;
}





	public String getfirst () {
	return this.first; 
}

	public String getlast() {
	return this.last;
}

	public String getnickName() {
	return this.nickName;
}

	public String getnumber() {
	return this.number; 
}

	//these methods aren't for the quiz but for practice sake
	
	//can only have one compare to method so picked the best way and most likly to do it
	
	public int compareTo (Contact other) {
	return last.compareTo(other.last);

}

	//how we determine that two instances of the contact is the same
	//if didn't predefine it - then only judged by the location number in memory
	//it should be synchronized with compare to
	

	//gets an instance of object and not like compare to wich gets an instenece of a class
	public boolean equals(Object obj) {
	//first make sure - its getting something
	if (obj ==null) return false; 
	//its getting an object - so first make sure it is referencing a contact
	if (!(obj instanceof Contact)) return false; 
	//type cast obj into being a contact
	//we already checked that it was a contact so now we can assign it to a contact
	Contact other = (Contact)obj;

	if (last.compareTo(other.last) ==0)
	return true;
	else 
	return false;
}

	//every time the programmer wants a general display
	//we don't need it because of the getters
	
	public String toString(){
	StringBuffer buffer = new StringBuffer();
	buffer.append("\nContact ");
	buffer.append("First Name: ");
	if (first == null)
	buffer.append("N/A");
	else 
	buffer.append(this.first); 
	buffer.append(" Last Name: "); 
	buffer.append(this.last);
	buffer.append(" Nickname: ");
	buffer.append(this.nickName);
	buffer.append(" Number: ");
	buffer.append(this.number);

	//buffer class has a toString method and 
	//takes what it has inside it and returns it as a string
	
	//if you use this it is more inefficient bc then it is getting the string each time and then dumping and then redone
	//return "Contact [ firstName " + firstName +.....
	
	return buffer.toString();

}
}

