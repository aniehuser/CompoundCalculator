package chem;

/**
 * Container class for passing strings by reference
 * @author anthonyniehuser
 *
 */
public class CompoundParamContainer {
	private String name;
	private double mass;
	
	
	public CompoundParamContainer(){
		name = "";
		mass = 0;
	}
	public CompoundParamContainer(String name, double mass){
		this.name = name;
		this.mass = mass;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setMass(double mass){
		this.mass = mass;
	}
	public double getMass(){
		return mass;
	}
}
