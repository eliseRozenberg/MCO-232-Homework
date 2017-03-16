package quiz;

public class CellPhone1 {
		//first name  - x necesarily nned nickname can change last name and phone number but not first naem
		//last name  
		//nick name
		//main w menu to make options
	
	private String first;
	private String last;
	private String nickName; 
	private String number;
	
	public CellPhone1 (String f, String l, String name, String num){
		this.first = f;
		this.last = l;
		this.nickName = name;
		this.number = num;
	}
	
	public CellPhone1 ( String l, String name, String num){
		this.first = null;
		this.last = l;
		this.nickName = name;
		this.number = num;
	}
	
	public void setlast(String l) {
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

	
	
	
}
