package Week1;/*
 * QuadraticSolver.java  	1.1 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */

import Tools.Sheffield.EasyReader;

import java.math.*;
 
/** 
* QuadraticSolver.java
* solves quadratic equations for x given a*x*x + b*x + c = 0
* the code should be modified so that a, b, and c are input by the user
* 
* @version 1.1 26 August 2011
* 
* @author Mark Stevenson (mark.stevenson@sheffield.ac.uk) 
* @author (based on code written by Richard Clayton)
*/

public class QuadraticSolver {	
	public static void main( String[] arg){
			
		// default values for coefficients a, b, and c
		// initially, these are stored as both integers and float.
//		 int    aInt =    1,    bInt = 2, cInt =    1;
		// double a = 1, b = 2, c = 1;

        // step 1, create a new EasyReader object to model the keyboard
        EasyReader keyboard = new EasyReader();

        // step 2, prompt the user to input values for a, b, and c and
        // store these as doubles
        double a = keyboard.readDouble("Input a value for a: ");
        double b = keyboard.readDouble("Input a value for b: ");
        double c = keyboard.readDouble("Input a value for c: ");

        // declare variables to store the two values of x that satisfy the equation
		double x1, x2;

		// work out the solution with int types
		//aInt -= 1/2;
//		System.out.println("aINT: " + aInt);
//		x1 = (-1 * bInt + Math.sqrt(bInt*bInt - 4 * aInt * cInt)) / (2 * aInt);
//		x2 = (-1 * bInt - Math.sqrt(bInt*bInt - 4 * aInt * cInt)) / (2 * aInt);
//		System.out.println("Solution with integer types is x1 = " + x1 + ", and x2 = " + x2 );

        // step 3, display the values that hae been entered
        System.out.println("You entered a="+a+", b="+b+", c="+c);

		// work out the solution with double types
		//aFloat -= 0.5;
		// System.out.println("aFloat: " + aFloat);
		x1 = (-1 * b + Math.sqrt(b*b - 4 * a * c)) / (2 * a);
		x2 = (-1 * b - Math.sqrt(b*b - 4 * a * c)) / (2 * a);
		System.out.println("Solution with double types is  x1 = " + x1 + ", and x2 = " + x2 );

		// insert the solutions
        double y1 = a * Math.pow(x1, 2) + b * x1 + c;
        double y2 = a * Math.pow(x2, 2) + b * x2 + c;
        System.out.println(y1 + "  " + y2);

	} //main
} // class QuadraticSolver