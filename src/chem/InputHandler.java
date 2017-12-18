package chem;

import java.util.Scanner;

public class InputHandler {
	
	public static String getElement(){
		Scanner s = new Scanner(System.in);
		System.out.print("Input Element: ");
		String element = s.nextLine();
		s.close();
		
		if(!element.matches("[A-Z][a-z]?")){
			System.out.println("Invalid element syntax.");
			return "";
		}
		
		return element;
	}
	
	public static String getCompound(){
		Scanner s = new Scanner(System.in);
		System.out.print("Input Compound: ");
		String compound = s.nextLine();
		s.close();
		
		if(!checkParens(compound)){
			System.out.println("Invalid: Unbalanced Parenthesis.");
			return "";
		}
		if(compound.matches(".*\\(\\).*|.*\\)$|.*\\)\\D.*")){
			System.out.println("Invalid: Extra Parenthesis.");
			return "";
		}
		
		return compound;
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
