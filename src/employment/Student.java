package employment;

import accountHW.InvalidDataException;

public class Student extends Person{
	
	private  ClassStatus status;
	private Integer numberOfCreditsEarned;
	
	public Student( String first,String last,String address,String email,String pnumber, Integer cnumber)throws InvalidDataException{
		super(first,last, address, email, pnumber);
		if (cnumber ==null)throw new InvalidDataException();
		if (cnumber <0)throw new InvalidDataException(); 
		numberOfCreditsEarned = cnumber;
		this.status = setStatus(cnumber);
	}
	
	private  ClassStatus setStatus(Integer credits){
		if (credits ==null)throw new InvalidDataException();
		if (credits >-1 && credits <30) return ClassStatus.FRESHMAN;
		if (credits >29 && credits <60) return ClassStatus.SOPHOMORE; 
		if (credits >59 && credits <90) return ClassStatus.JUNIOR; 
		if (credits >89) return ClassStatus.SENIOR;
		return null;
	}
	
	public void setCreditsEarned(Integer credits){
		if (credits==null||credits <0)throw new InvalidDataException(); 
		numberOfCreditsEarned= numberOfCreditsEarned+credits; 
		setStatus(credits);
	}
	
	public Integer getCreditsEarned(){
		return this.numberOfCreditsEarned;
	}
	
	public ClassStatus getStatus(){
		return this.status; 
	}
	
	public String toString(){
		StringBuffer buffer= new StringBuffer();
		buffer.append(super.toString());
		buffer.append("\t"+this.status);
		buffer.append("\t"+this.numberOfCreditsEarned+ " credits");
		
		return buffer.toString();
	}
}
