package main;

import java.lang.IllegalArgumentException;

public class Fraction {
	
	
	//create fileds
	private int numtor; 
	private int dentor;
	
	//create constructor for handling issues of negative and zero values
	
	public Fraction(int numerator , int denominator) {

		this.numtor = numerator; 
		this.dentor = denominator; 
		
		// if the denomator is zero throw an exception
		if (this.dentor == 0) {
			throw new IllegalArgumentException();
		}
		
		// if denominator has a negative sign; 
		if (this.dentor < 0) {
			// numerator also negative ex: -5/-3
			if (this.numtor < 0) {
				 this.numtor *= -1;
				 this.dentor *= -1;
				 // 5/3
			}
			// only the denominator is negatvie  ex : 5/-3
			if (this.dentor < 0) {
				this.dentor *= -1;
				this.numtor *= -1;
				// -5/3
				}
		}
	}
	
	
	// Only input is numerator ex:3
	public Fraction(int OnlyNumerator) {
		
		this.numtor = OnlyNumerator;
		this.dentor = 1;
		// 3/1
	}
	
	
	// Only input is numertaor is and it is always 0   
	public Fraction() {
		// Numerator Zero
		this.numtor = 0; 
		this.dentor = 1;
	}
	
	
	
public int getNumerator() {
	return this.numtor;
}

public int getDenominator() {
	return this.dentor;
}

public String toString() {
	return (getNumerator() + "/" + getDenominator());
}

public Double toDouble() {
	return((double)getNumerator() / (double)getDenominator());
}


public Fraction add(Fraction other) {
		int a, b;
		
		if(this.dentor == other.dentor) {
			a = this.numtor + other.numtor;
			b = this.dentor;
		}else {
			//toLowerTerms();
			
			b = this.getDenominator() * other.getDenominator();
			a = ((b /this.getDenominator()) * this.getNumerator()) + (b /other.getDenominator()) * other.getNumerator();
		}	
		int gcd = gcd(a,b);
		a /= gcd;
		b /= gcd;
		return new Fraction(a,b);
}

public Fraction subtract(Fraction other) {
	int a, b;
	
	if(this.dentor == other.dentor) {
		a = this.numtor - other.numtor;
		b = this.dentor;
		
	}else {
		//toLowerTerms();
		
		b = this.getDenominator() * other.getDenominator();
		a = (b /this.getDenominator()) * this.getNumerator() - (b /other.getDenominator()) * other.getNumerator();
		
	}
	
	if ((this.getNumerator() - other.getNumerator()) == 0) {
		System.out.println("Subtracting will result in a zero, which is undefined!!");
		return null;
	}
	int gcd = gcd(a,b);
	a /= gcd;
	b /= gcd;
	//  to here myfrien we would like to show onlt the nume if the den is 1..... To continued
	return new Fraction(a,b);
}

public Fraction multiply(Fraction other) {
	int a, b;
	
	a = this.numtor * other.numtor;
	b = this.dentor * other.dentor;
	
	int gcd = gcd(a,b);
	a/= gcd;
	b/=gcd;
	
	return new Fraction(a,b);
}

public Fraction divide(Fraction other) {
	int a, b;
	
	a = this.numtor * other.dentor;
	b = this.dentor * other.numtor;
	
	int gcd = gcd(a,b);
	a/= gcd;
	b/=gcd;
	
	return new Fraction(a,b);
}



// understanding how equals work
// there is a difference bteween == and equals 
// == will compare the reference, in other words the value
// equals will compare the object
/*
 what you should do is checking if the other object 
 is an instance of the fraction class /line 96/
 */
public boolean equals(Object other) {
	
	if (other == this) {return true;}
	if (other == null) {return false;}
	
	// casting the other to fraction.. same idea of casting double to int 
	Fraction o = (Fraction)other;
	
	// this is the only I could do to check if two fractions are equal.
	if ((this.getNumerator() / this.getDenominator()) == (o.getNumerator() / o.getDenominator())) {
		return true;
	}else {
		return false;
	}
}

// converts the current fraction to the lowest terms
public void toLowerTerms() {
	int a=this.getNumerator(), b = this.getDenominator();
	
	int gcd = gcd(a,b);
	
	a = this.getNumerator() / gcd;
	b = this.getDenominator() / gcd;
	
	System.out.println(a + "/" + b);
	
	
	
	
}

public static int gcd(int nume , int deno) {
	
	int rem, getDeno;
	while(nume != 0 && deno != 0) {
		
	rem = nume % deno;
	
	getDeno = deno;
	nume = getDeno;
	
	deno = rem;	
	}
	
	return nume;
}

}
