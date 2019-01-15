package main;

import java.util.Scanner;

public class FractionCalculator {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("This program is a fraction calculator\n"+
						   "It will add, subtract, multiply and divide fractions until you type Q to quit.\n" + 
							"Please enter your fractions in the form a/b, where a and be are integers.");
		
		
		while(true) {
			
			String s = getOperation(inp);
			if(s.equals("q") || s.equals("Q")) {
				break;
			}
			
			Fraction f1 = getFraction(inp);
			Fraction f2 = getFraction(inp);
			
			
				if(s.equals("+")) { System.out.println(f1 + " + " + f2 + " = " + (f1.add(f2))); }
				
				if(s.equals("-")) { System.out.println(f1 + " - " + f2 + " = " + (f1.subtract(f2))); }
				
				if(s.equals("*")) { System.out.println(f1 + " * " + f2 + " = " + (f1.multiply(f2))); }
				
				if(s.equals("/")) { System.out.println(f1 + " / " + f2 + " = " + (f1.divide(f2))); }
				
				if(s.equals("=")) { System.out.println(f1 + " = " + f2 + " is " + f1.equals(f2)); }
				
		}	
	}
	
public static String getOperation(Scanner inp) {
	System.out.println("---------------------------------------------------------------------------------------------");
	
	System.out.print("Please enter an operation (+, -, /, *, = or q to quit) : ");
	String s = inp.next();
	while(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("=") || s.equals("Q") || s.equals("q"))) {
		System.out.print("Invalid choice. Please enter an operation (+, -, /, *, = or q to quit) : ");
		s = inp.next();
	}
	return s;
}

public static boolean validFraction(String input) {
	
	if(input.contains("/")) {
		// it has / sign
		int div = input.indexOf("/");
		// check if it starts with -
		if(input.startsWith("-")) {
			try {
				Integer.parseInt(input.substring(1, div));
				Integer.parseInt(input.substring((div +1),input.length()));
				return true;
			}catch(Exception e) {
				return false;
			}
		}
		else {
			try {
				//int n = Integer.parseInt(input.substring(0, div));
				int n2 = Integer.parseInt(input.substring((div +1),input.length()));
				if (n2 <0) {
					return false;
				}
				return true;
			}catch(Exception e) {
				return false;
			}
		}
	}
	else {
		// it doesn't has / sign
		if(input.startsWith("-")) {
			// it starts with - check after it 
			try {
				Integer.parseInt(input.substring(1, input.length()));
				// after - sign is number;
				return true;
			}catch(Exception e){
				// after - sign is not number;
				return false;
			}
		}else {// if it doesn't start with - then check if it is a number
			}
			try {
				// check if it's a number
				Integer.parseInt(input);
				return true;
			}catch(Exception e) {
				return false;
			}
		}
	}
	


public static Fraction getFraction(Scanner input) {
	
	System.out.print("Please enter a fraction as (a/b) or (a) : ");
	String s = input.next();
	// call validFraction and check if a fraction is a validFraction
	while(validFraction(s) == false) {
		System.out.print("Invalid choice. Please enter a fraction as (a/b) or (a) : ");
		s = input.next();
	}
	
	if(validFraction(s) == true) {
		int div = s.indexOf("/");
		int ind = s.length();
		int num; int den;
		
		if(ind == 1) {
			// this is to check if there is only a numerator and so the denominator is 1; 
			num = Integer.parseInt(s);
			den = 1;
		}
		else {
			// this is to tell that there is both num and den, so get them boooy........
			num = Integer.parseInt(s.substring(0, div));
			den = Integer.parseInt(s.substring((div +1),s.length()));
		}
		return new Fraction(num,den);
		
		
	}
	else {
		return null;
	}	
}
}