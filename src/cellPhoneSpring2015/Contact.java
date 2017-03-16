package cellPhoneSpring2015;

public class Contact implements Comparable<Contact>{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String nickName;
	
	public Contact(String lastName, String phoneNumber, String nickName)throws InvalidPhoneNumberException, InvalidDataException{
		this(null,lastName,phoneNumber,nickName);
	}
	
	public Contact(String firstName, String lastName, String phoneNumber, String nickName)throws InvalidPhoneNumberException, InvalidDataException{
		if (!isValidPhoneNumber(phoneNumber)) throw new InvalidPhoneNumberException();
		if (lastName == null || phoneNumber  == null || nickName == null){
			throw new InvalidDataException();
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.nickName = nickName;
	}
	
	public void setFirstName (String firstName){
		if (this.firstName == null){   //only set the first name if it hasn't already been set
			this.firstName = firstName;
		}
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
		if (!isValidPhoneNumber(phoneNumber)){
		      throw new InvalidPhoneNumberException();
		      }
		else{
			this.phoneNumber = phoneNumber;
			}
	}
	
	
	public String getLastName() {
		return lastName;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public String getNickName() {
		return nickName;
	}

	private boolean isValidPhoneNumber(String phoneNumber){
		if (phoneNumber.length()!= 10)return false;
		for (int i=0;i<phoneNumber.length();i++){
			if (!Character.isDigit(phoneNumber.charAt(i))){
				return false;
			}
		}
		return true;   //passed the tests - it is valid
		
	}
	
	
	//compareTo method will be used to sort a set of Contact instances
	//will be invoked by Collections.sort()
	public int compareTo(Contact other){
		return this.lastName.compareTo(other.lastName);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())   //same as using instanceof
			return false;
		Contact other = (Contact) obj;
		return lastName.equals(other.lastName);
			
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nContact: ");
		buffer.append("First Name: ");
		if (firstName == null)
		buffer.append(" N/A");
		buffer.append (" Last Name: ");
		buffer.append(lastName);
		buffer.append(" PhoneNumber ");
		buffer.append(phoneNumber);
		buffer.append(" NickName: ");
		buffer.append(nickName);
		return buffer.toString();   //convert StringBuffer to a String
	}
	

}
