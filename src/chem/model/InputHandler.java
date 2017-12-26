package chem.model;

/**
 * Intended to handle some bad user input
 * @author anthonyniehuser
 *
 */
public class InputHandler {
	
	public static boolean getElement(CompoundParamContainer element){
		System.out.print("Input Element: ");
		element.setName(Prog.reader.nextLine());
		
		if(!element.getName().matches("[A-Z][a-z]?")){
			System.out.println("Invalid: Incorrect element syntax.");
			return false;
		}
		
		
		return true;
	}
	
	public static boolean getCompound(CompoundParamContainer compound){
		System.out.print("Input Compound: ");
		compound.setName(Prog.reader.nextLine());
		
		if(!checkParens(compound.getName())){
			System.out.println("Invalid: Unbalanced Parenthesis.");
			return false;
		}
		if(compound.getName().matches(".*\\(\\).*|.*\\)|.*\\)\\D.*")){
			System.out.println("Invalid: Extra Parenthesis.");
			return false;
		}
		
		try{
			String[] splitCompound = compound.getName().split(Prog.splitCompound);
			compound.setMass(Calculate.compoundMolarMassHelper(splitCompound));
		} catch(Exception e){
			System.out.println("Invalid: Compound Syntax.");
			return false;
		}
		
		
		return true;
	}
	
	

	/**
	 * Ensures a string contains balanced parenthesis
	 * @param compound string to check
	 * @return true if balanced, false if not
	 */
	private static boolean checkParens(String compound){
		char chars[] = compound.toCharArray();
		int balance = 0;
		for (char c : chars){
			if(c=='(')
				balance++;
			else if(c==')'){
				if(balance<=0)
					return false;
				balance--;
			}
		}
		return balance==0;
	}
	
	

}
