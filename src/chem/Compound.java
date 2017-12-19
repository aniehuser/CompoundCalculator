package chem;

import java.util.Arrays;

public class Compound {
	private String formula;
	private double molarMass;
	
	Compound(String formula){
		this.formula = formula.toString();
	
		try{
			this.molarMass = compoundMolarMassHelper(formula.split(Prog.splitCompound));
		} catch(Exception e){
			System.out.println("Something went wrong! " + e.getMessage());
			this.molarMass = -1;
		}
	}
	
	Compound(Element e){
		this.formula = e.getSymbol();
		this.molarMass = Double.parseDouble(e.getAtomicMass());
	}
	
	public Compound multiply(String multiplier){	
		return new Compound("(" + this.formula + ")" +  multiplier);
	}
	public Compound add(Element e){
		return new Compound(this.formula += e.getSymbol());
	}
	public Compound add(Compound c){
		return new Compound(this.formula += c.formula);
	}
	
	public String getFormula(){
		return formula;
	}
	public double getMolarMass(){
		return molarMass;
	}
	
	/**
	 * takes string array of compound and converts to appropriate molar mass
	 * @param str	string array input
	 * @return molar mass value
	 * @throws Exception 	some syntax is wrong
	 */
	private double compoundMolarMassHelper(String[] str) throws Exception {
		int l = str.length;
		
		// should not happen
		if(l==0)
			throw new Exception("Helper Method Error");
			
		double sum = 0;
		
		for (int i=0; i<l; i++){
			if(str[i].equals("(")){
				//index of matching ")" for str[i]
				int endGroup = findEndGroupIndex(str, i, l);
				
				sum += compoundMolarMassHelper(Arrays.copyOfRange(str, i+1, endGroup+2));
				
				//set index i equal to index of first element after grouping.
				// NOTE:: if the compound ends with "\\)\\d+" then the for loop should be complete
				i = endGroup + 1;
			} else if(str[i].equals(")")){
				// returns group molar mass * number of groups
				return sum * Double.parseDouble(str[i+1]);
				
			} else if(str[i].matches("[A-Z][a-z]?\\d*")) {
				sum += elementGroupMolarMass(str[i]);
			} else{
				//some sort of undefined syntax
				throw new Exception("Invalid Compound Syntax.");
			}
		}
		return sum;
	}
	
	/** 
	 * returns index of an element of parameter str with ")" that closes a compound group
	 * @param str	String[] representation of compound
	 * @param start	 Index of "(" that starts the group
	 * @param length	Length of compound
	 * @return
	 */
	private int findEndGroupIndex(String[] str, int start, int length){
		//if 0 there are no unclosed nested groups to account for
		int endGroup = 0; 
		
		for(int i=start; i<length; i++){
			if(str[i].equals("("))
				endGroup++;
			else if(str[i].equals(")")){
				endGroup--;
				//found matching closing parenthesis
				if(endGroup==0)
					return i;
			}
		}
		//This case should not occur
		return -1;
	}
	
	/**
	 * Calculates molarmass of group of element
	 * @param value in the form of "^[A-Z][a-z]?\\d*$"
	 * @return molarmass value of group of elements
	 */
	private double elementGroupMolarMass(String value) throws Exception{
		//Split into string array with first element containing element and second containing
		String[] str = (value.matches("[A-Z][a-z]\\d*")) ? value.split("(?<=[a-z])") : value.split("(?<=[A-Z])");
	
		//Check if valid element
		if(!Prog.elements.containsKey(str[0]))
			throw new Exception("Invalid Element Input: " + str[0]);
		
		//check if element has a molarmass
		String atomicMass = Prog.elements.get(str[0]).getAtomicMass();
		if(atomicMass.equals(Prog.empty))
			throw new Exception("Element:::" + str[0] + "::: has an undetermined molar mass. ");
		
		return Double.parseDouble(atomicMass) * ((str.length==1) ? 1 : Double.parseDouble(str[1])); 
	}
	
	public String toString(){
		return "Formula.....: "+formula +
			 "\nMolar Mass..: "+molarMass;
	}
	
}
