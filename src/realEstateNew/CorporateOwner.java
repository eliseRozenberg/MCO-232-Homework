package realEstateNew;


//also implements owner so needs the specific methods
public class CorporateOwner implements Owner{
    private String nameOfCompany;
    private Address address;
    private String phoneNumber;
    
    public CorporateOwner(String companyName,String street,
    		String state,String zipCode,String phoneNumber){
    	this.nameOfCompany = companyName;
    	this.phoneNumber = phoneNumber;
    	
    	this.address = new Address(street,state,zipCode);
    	
    }
    
	//in the private owner it is a first name and last name but the corp owner just has the comp name 
	//so you choose how to implements the needed methods
	public String getName() {
		// TODO Auto-generated method stub
		return this.nameOfCompany;
	}

	@Override
	public Address getAddress() {
		// TODO Auto-generated method stub
		//deep copy
		return new Address (address.getStreet(),
				address.getState(),
				address.getZipCode()
						);
	}

	@Override
	public void setAddress(String street, String state, String zipCode) {
		// TODO Auto-generated method stub
		this.address = new Address(street,state,zipCode);
	}

	public String toString(){
		StringBuffer info =new StringBuffer();
		info.append("\nCorporate Owner " );
		info.append (this.nameOfCompany + " ");
		info.append (address.toString());
		info.append(" PhoneNumber " + phoneNumber);
		return info.toString();
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber =phoneNumber;
	}
}
