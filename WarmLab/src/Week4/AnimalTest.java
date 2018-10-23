/*
 * AnimalTest.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* AnimalTest.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
* @author Mark Stevenson (mark.stevenson@sheffield.ac.uk)
* Original code written by Guy Brown and Richard Clayton
*
*/
package Week4;

public class AnimalTest {
    public static void main(String[] args) {
	Cow daisy = new Cow();
	Pig wilbur = new Pig();
	// Animal animal = new Animal();

	Animal[] farm = new Animal[4];
	// farm[0] = animal;
	farm[1] = daisy;
	farm[2] = wilbur;

	for(int i = 0; i < 3; i++) {
	    farm[i].talk();
	} // for
    } // main
}
