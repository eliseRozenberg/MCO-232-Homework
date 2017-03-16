package metroCardCombine;

public class Station {
	private String name;
	private StationType stationType;
	
	public Station(String name, StationType stationType){
		this.name = name;
		this.stationType =stationType;
	}

	public String getName() {
		return name;
	}

	public StationType getStationType() {
		return stationType;
	}
	
	public double getStationCharge(){
		return this.stationType.getCharge();  //delegation
	}

}
