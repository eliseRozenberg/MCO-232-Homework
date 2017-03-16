package realEstateNew;

//is a relation ship - because it inherits real estate
//has an owner

//inherits all the fields but it can only access the protected value
public class OwnedRealEstate extends RealEstate{
	private Owner theOwner;	//can reference a private owner or a corporate owner because both of these are implementing owner
	//good to make code generic
	//and then will use the right constructor when sees what type of owner iti is or the info it accepts
	//runtime binding
	
	//foundation - block and lot is from the real estate
	public OwnedRealEstate(Integer blockNumber, Integer lotNumber,
			String firstName, String lastName,
			String street, String state, String zipCode
			){
		//first you must set up the foundation
		//parents provide the foundation upon which you continue to build
		
		//calls the constructor of the parent super and send information that it will use from the parent class
		//setting self up and not calling the other class constructor
		super(blockNumber,lotNumber);
		theOwner = new PrivateOwner(firstName,lastName,street,state,zipCode);
		//then will deal with the rest of the information
		
		
	}
	
	public OwnedRealEstate(
			String corporateName, String street,  String state,String zipCode,
			String phoneNumber,Integer blockNumber, Integer lotNumber
			){
		super(blockNumber,lotNumber);
		theOwner= new CorporateOwner(corporateName,street,state,zipCode,phoneNumber);
		
		
	}
	
	public OwnedRealEstate (Integer block, Integer lot, String street, 
			String state, String zip, String first,String last, String ownerstreet, String ownerstate, String ownerzip){
		super(block, lot,street, state,zip);
		theOwner = new PrivateOwner (first,last,ownerstreet, ownerstate, ownerzip); 
	}
	
	//if you don't care which type of owner it is and don't wanmt to type in all the details
	public OwnedRealEstate (Integer block, Integer lot, Owner owner){
		super(block, lot);
		if (owner instanceof PrivateOwner)
		theOwner = owner; 
	}
	
	//best too make more constructors so that there are many ways to add in the info
	

	
	public String toString(){
		StringBuffer info = new StringBuffer();
		info.append(super.toString()); //calls the parent toString() and the format will be of realEstate
		info.append(theOwner.toString());//add in the info it is composed of - it extends to add the owner which also has a toString()
		//it can even see what the owner is in this program and then will get the toString of the type of owner - polymorphism
		//acts as different things dependent on the situation 
		if (price != null){
			info.append("Current Price: " + price);
		}
		return info.toString();
	}
	
	//protected so it doesn't call the parent class
	public void setCurrentPrice(Double price){
		this.price = price;   
	}
	
	public Double  getCurrentPrice(){
		return price;
	}
	

	public Owner getOwner (){
		if (theOwner instanceof PrivateOwner){
			PrivateOwner typecast = (PrivateOwner)theOwner;
			Address theAddress = typecast.getAddress();
			return new PrivateOwner(typecast.getFirstName(),typecast.getLastName(),theAddress.getStreet(),theAddress.getState(),theAddress.getZipCode());
		}
		else{
			CorporateOwner typecast = (CorporateOwner)theOwner;
			Address anAddress = typecast.getAddress();
			return new CorporateOwner(typecast.getName(),anAddress.getStreet(),anAddress.getState(),anAddress.getZipCode(),typecast.getPhoneNumber());
		}
		
	}
	
	public void setOwner(OwnerType type, String name, String nameOrPhone,String street, String state, String zipCode){
		if (type == OwnerType.INDIVIDUAL){
		theOwner = new PrivateOwner(name,nameOrPhone,street,state,zipCode);
		}
		else{
			theOwner = new CorporateOwner(name, street,state,zipCode,nameOrPhone);
		}
	}
	
	//because it is not in the 
	public void setOwnerPhoneNumber(String phoneNumber){
		if (theOwner instanceof PrivateOwner){
		((PrivateOwner)theOwner).setPhoneNumber (phoneNumber);
		}
		else{
			//assume it must be CorporateOwner
			((CorporateOwner)theOwner).setPhoneNumber(phoneNumber);
		}
	}
	
	public void setAddress(String street, String state, String zipCode){
		super.setAddress(street, state, zipCode);
		//need to go to the super because it is private and not protected 
		//but price doesn't have to because it is protected
	}
	

	
	
}
