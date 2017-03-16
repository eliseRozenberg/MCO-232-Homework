package employment;

import java.util.GregorianCalendar;

import account2.InvalidDataException;

public class Staff extends Employee{
	
	private String jobTitle;
	
	public Staff(String first,String last, String add, String email, 
					String num, String office, Double salary, 
						String date, String title)throws InvalidDataException{
		super(first,last, add, email, num, office, salary, date);
		if (title ==null)
			throw new InvalidDataException();
		jobTitle = title;
	}
	
	public void setJobTitle(String title) throws InvalidDataException{
		if (title ==null) throw new InvalidDataException();
		jobTitle = title;
	}

	public String getJobTitle(){
		return jobTitle; 
	}
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append("\tJob Title: "+ jobTitle);
		return buffer.toString();
	}
}
