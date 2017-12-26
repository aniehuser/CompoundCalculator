package chem.model;


@SuppressWarnings("unused")
/**
 * Container Class containing information about a specific element from the periodic table
 * @author anthonyniehuser
 *
 */
public class Element {
	private String atomicNumber;
	private String symbol;
	private String name;
	private String atomicMass;
	//dont use
	private String cpkHexColor;
	private String electronicConfiguration;
	private String electronegativity;
	private String atomicRadius;
	private String ionRadius;
	private String vanDelWaalsRadius;
	private String ionizationEnergy;
	private String electronAffinity;
	private String oxidationStates;
	private String standardState;
	private String bondingType;
	private String meltingPoint;
	private String boilingPoint;
	private String density;
	private String groupBlock;
	private String yearDiscovered;
	
	Element(String atomicNumber,
			String symbol,
			String name,
			String atomicMass,
			String cpkHexColor,
			String electronicConfiguration,
			String electronegativity,
			String atomicRadius,
			String ionRadius,
			String vanDelWaalsRadius,
	 		String ionizationEnergy,
	 		String electronAffinity,
	 		String oxidationStates,
	 		String standardState,
	 		String bondingType,
	 		String meltingPoint,
	 		String boilingPoint,
	 		String density,
	 		String groupBlock,
	 		String yearDiscovered
	){
		this.atomicNumber = atomicNumber;
		this.symbol = symbol;
		this.name = name;
		this.atomicMass = atomicMass;
		this.cpkHexColor = cpkHexColor;
		this.electronicConfiguration = electronicConfiguration;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;
		this.ionRadius = ionRadius;
		this.vanDelWaalsRadius = vanDelWaalsRadius;
 		this.ionizationEnergy = ionizationEnergy;
 		this.electronAffinity = electronAffinity;
 		this.oxidationStates = oxidationStates;
 		this.standardState = standardState;
 		this.bondingType = bondingType;
 		this.meltingPoint = meltingPoint;
 		this.boilingPoint = boilingPoint;
 		this.density = density;
 		this.groupBlock = groupBlock;
 		this.yearDiscovered = yearDiscovered;
		
	}

	public Compound add(Element e){
		Compound c = new Compound(this);
		c.add(e);
		return c;	
	}
	public Compound multiply(double multiplier){
		
		return new Compound(this.symbol + multiplier, Double.parseDouble(atomicMass) * multiplier);
	}
	
	public String getAtomicNumber(){
		return atomicNumber;
	}
	public String getSymbol(){
		return symbol;
	}
	public String getName(){
		return name;
	}
	public String getAtomicMass(){
		return atomicMass;
	}
	public String toString(){
		return "Atomic Number...........: " + atomicNumber
		   + "\nSymbol..................: " + symbol
		   + "\nName....................: " + name
		   + "\nAtomic Mass.............: " + atomicMass
		   + "\ncpkHexColor.............: " + cpkHexColor
		   + "\nElectronic Configuration: " + electronicConfiguration;
		//TODO:: finish toString
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
//		System.out.println("Atomic Number: " + atomicNumber);
	}
	
}
