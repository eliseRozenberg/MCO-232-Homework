package realEstateNew;

//implements owner interface so guarantee that the specified methods will be there
//she could have made one field be an owner type enum
//aggregation - private owner has an address and need to call the address getters to get the information because it is private 


public class PrivateOwner implements Owner{
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;
    
    public PrivateOwner(String firstName,String lastName,String street,
    		String state,String zipCode
    		){
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.address =new Address(street,state,zipCode);
    	this.phoneNumber = null;
    	
    }
    
    public void setPhoneNumber (String phoneNumber){
    	this.phoneNumber = phoneNumber;
    }
    public void setAddress (String street,String state,String zipCode ){
    	//owner has moved , replace his address
    	this.address = new Address(street,state,zipCode);
    }
     
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}

	@Override
	public Address getAddress() {
		//make a deep copy - so can't change the information
		return new Address(this.address.getStreet(),
				this.address.getCity(),this.address.getState(),
				this.address.getZipCode()
				
				);
	}
	
	public String toString(){
		StringBuffer info = new StringBuffer();
		info.append (" \nPrivate Owner ");
		info.append(" FirstName: " + firstName);
		info.append(" LastName: " + lastName);
		if (address == null){
			info.append(" Address N/A ");
		}
		else{
		info.append(address.toString());	//code re-use and delegation
		}
		//remember that if the possibility for it too be null- make sure to check if its is null before you display
		if (phoneNumber == null){
			info.append( " PhoneNumber N/A ");
		}
		else {
			info.append(" PhoneNumber: " + phoneNumber);
		}
		
		return info.toString();
		
	}
	
	//corp owner will not have 
	//this differentiates the interface types
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}

}
