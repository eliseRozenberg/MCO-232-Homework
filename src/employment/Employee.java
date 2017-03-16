package employment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import account2.InvalidDataException;

public class Employee extends Person{

	private String office;
	private Double salary;
	private GregorianCalendar dateHired;
	
	public Employee(String first,String last, String add, String email, 
					String num, String office, Double salary, 
						String date)throws InvalidDataException{
		super(first,last, add, email, num); 
		if (office ==null||salary==null||date ==null)throw new InvalidDataException();
		this.office = office;
		if (salary<=0)throw new InvalidDataException();
		this.salary = salary;
		String [] tokens =date.split("/");
		if (tokens.length!= 3) throw new InvalidDataException(); 
		else {
			String[] parts = date.split("/");
			int month = Integer.parseInt(parts[0]);  //convert the String to an Integer
			int day = Integer.parseInt(parts[1]);
			int year = Integer.parseInt(parts[2]);
			dateHired = new GregorianCalendar(year,month,day);
		}
	}
	
	public void setOffice(String office)throws InvalidDataException{
		if (office ==null)throw new InvalidDataException();
		this.office = office;
	}
	
	public void setSalary(Double salary)throws InvalidDataException{
		if (salary ==null)throw new InvalidDataException();
		if (salary <=0)throw new InvalidDataException();
		this.salary = salary;
	}

	public String getOffice() {
		return office;
	}

	public Double getSalary() {
		return salary;
	}

	public GregorianCalendar getDateHired() {
		GregorianCalendar copy = new GregorianCalendar
									(dateHired.get(Calendar.YEAR),
									 dateHired.get(Calendar.MONTH),
									 dateHired.get(Calendar.DAY_OF_MONTH));
		return copy;
	}
	
	public String toString(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append("\tOffice: "+office +"\tSalary: "+ salary+ "\tDate Hired: "+ formatter.format(dateHired.getTime()));
		return buffer.toString();
	}
	
	
}


