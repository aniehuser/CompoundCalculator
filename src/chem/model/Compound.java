package chem.model;

/**
 * Calculates and holds information about a chemical compound
 * @author anthonyniehuser
 *
 */
public class Compound {
	private String formula;
	private double molarMass;
	
	public Compound(String formula, double mass){
		this.formula = formula;
		this.molarMass = mass;
		
	}
	public Compound(CompoundParamContainer c){
		formula = c.getName();
		molarMass = c.getMass();
	}
	
	public Compound(Element e){
		this.formula = e.getSymbol();
		this.molarMass = Double.parseDouble(e.getAtomicMass());
	}
	
	public Compound multiply(double multiplier){	
		return new Compound("(" + this.formula + ")" +  multiplier, molarMass*multiplier);
	}
	public Compound add(Element e){
		return new Compound(formula + e.getSymbol(),
							molarMass + Double.parseDouble(e.getAtomicMass()));
	}
	public Compound add(Compound c){
		return new Compound(this.formula + c.formula,
							this.molarMass + c.molarMass);
	}
	
	public String getFormula(){
		return formula;
	}
	public double getMolarMass(){
		return molarMass;
	}
	
	
	public String toString(){
		return "Formula.....: "+formula +
			 "\nMolar Mass..: "+molarMass;
	}
	
}
