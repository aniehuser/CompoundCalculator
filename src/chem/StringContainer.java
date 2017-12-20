package chem;

/**
 * Container class for passing strings by reference
 * @author anthonyniehuser
 *
 */
public class StringContainer {
	private String value;
	
	
	public StringContainer(){
		this.value = "";
	}
	public StringContainer(String value){
		this.value = value;
	}
	public void fill(String value){
		this.value = value;
	}
	public String get(){
		return value;
	}
}
