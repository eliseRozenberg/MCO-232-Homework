package employment;

import pointOfSale.PurchasedItem;
import account2.InvalidDataException;

public class Person {

	private String name; 
	private String address;	
	private String emailAddress ;
	private String phoneNumber;

	public Person(String first,String last, String add, String email, String num)
											throws InvalidDataException{
		if (first ==null||last==null|| add==null||email==null||num==null) 
								throw new InvalidDataException();
		if (num.length() !=10)throw new InvalidDataException();
		this.name = first + " " + last; 
		address = add;
		emailAddress = email;
		phoneNumber =  num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String first,String last) throws InvalidDataException{
		if (first==null||last ==null) throw new InvalidDataException(); 
		this.name = first +" " + last;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) throws InvalidDataException{
		if (address ==null)throw new InvalidDataException();
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)throws InvalidDataException {
		if (emailAddress ==null)throw new InvalidDataException();
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)throws InvalidDataException {
		if (phoneNumber ==null)throw new InvalidDataException();
		if (phoneNumber.length() !=10)throw new InvalidDataException();
		this.phoneNumber = phoneNumber;
	}
	
	public int compareTo(String first, String last, String num)throws InvalidDataException{
		if (first ==null||last==null||num ==null)throw new InvalidDataException();
		String name= first + " "+ last; 
		if (this.name.compareTo(name)==0)
			return this.phoneNumber.compareTo(num);
		else 
			return this.name.compareTo(name);
	}
	
	public boolean equals(Object obj)  {
		if (obj ==null) return false;
		if (!(obj instanceof  Person)) return false;
		Person other = (Person)obj;
		if (this.name.compareToIgnoreCase(other.getName())==0)
			if (this.phoneNumber.compareTo(other.getPhoneNumber())==0)
				return true;
			else 				
				return false;	
		else return false;
	}
		
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Name: "+this.name);
		buffer.append("\tAddress: "+ address);
		buffer.append("\tPhone Number: "+ phoneNumber);
		buffer.append("\tEmail: "+ emailAddress);

		return buffer.toString();
	}
}
