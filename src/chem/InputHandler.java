package chem;

/**
 * Intended to handle some bad user input
 * @author anthonyniehuser
 *
 */
public class InputHandler {
	
	public static boolean getElement(StringContainer element){
		System.out.print("Input Element: ");
		element.fill(Prog.reader.nextLine());
		
		if(!element.get().matches("[A-Z][a-z]?")){
			System.out.println("Invalid: Incorrect element syntax.");
			return false;
		}
		return true;
	}
	
	public static boolean getCompound(StringContainer compound){
		System.out.print("Input Compound: ");
		compound.fill(Prog.reader.nextLine());
		
		if(!checkParens(compound.get())){
			System.out.println("Invalid: Unbalanced Parenthesis.");
			return false;
		}
		if(compound.get().matches(".*\\(\\).*|.*\\)|.*\\)\\D.*")){
			System.out.println("Invalid: Extra Parenthesis.");
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
