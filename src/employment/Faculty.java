package employment;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import accountHW.InvalidDataException;

public class Faculty extends Employee{
	
	private FacultyRank rank;
	private String department;

	
	public Faculty (String first,String last, String add, String email, 
					String num, String office, Double salary, 
					String date, String rank, String department)throws InvalidDataException{
		super(first,last, add, email, num, office, salary, date);
		if (rank ==null||department ==null)throw new InvalidDataException();
		this.rank = setRank(rank);
		this.department = department; 
	}
	
//Methods: constructor, setRank, getRank, setDepartment, getDepartment
	
	public FacultyRank setRank(String rank)throws InvalidDataException{
		if (rank ==null)throw new InvalidDataException();
		for (FacultyRank rnk: FacultyRank.values()){
			if (rnk.toString().equalsIgnoreCase(rank)) return rnk;
		}
		return null;
	}
	
	public void setDepartment(String department)throws InvalidDataException{
		if (department ==null)throw new InvalidDataException();
		this.department = department;
	}

	public FacultyRank getRank() {
		return rank;
	}

	public String getDepartment() {
		return department;
	}
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append("\tDepartment: "+ department);
		buffer.append("\tRank: "+ rank);

		return buffer.toString();
	}
}

