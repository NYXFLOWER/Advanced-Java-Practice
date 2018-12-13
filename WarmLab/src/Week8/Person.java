package Week8;/*

	Person.java

	Example class that stores data relating to a person.
	Includes CompareTo method required to implement Comparable
	interface. Also includes hashCode and equals methods, so
	can be used with HashSet Collection.

	There is also a main method, so this class can be tested
	easily

 */

import java.util.*;

public class Person implements Comparable<Person> {

	/**
	 * Creates a new <code>Person</code> instance.
	 *
	 * @param fname Person's first name
	 * @param lname Person's surname
	 * @param yrs Persons age in years (<code>int</code>)
	 */
	public Person(String fname, String lname, int yrs) {
		firstName = fname;
		surname = lname;
		age = yrs;
	}

	public int getAge() {
		return age;
	}

	public String getSurname() {
		return surname;
	} 

	public String getFirstname() {
		return firstName;
	} 

	/**
	 * <code>hashCode</code> method for Person.
	 *
	 * @return the hash code for the object based on firstName, surname and age
	 */
	public int hashCode() {
		return 13*surname.hashCode() + 17*firstName.hashCode() + 11*age;
	}


	/**
	 * <code>equals</code> method for Person.
	 *
	 * @param obj Object to compare with
	 * @return true if objects are equal (firstName, surname and age of two objects are equal)
	 */
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Person)) // if obj is null, the part after || will not be evaluated
			return false;
		Person p = (Person) obj;
		return surname.equals(p.surname) && firstName.equals(p.firstName) && age == p.age;
	}

	/**
	 * <code>compareTo</code> method for Person.
	 *
	 * @param obj Object to compare with
	 * @return &gt;1, 0 or &lt;1
	 */
	public int compareTo(Person p) {
		int comparedSurnames = surname.compareTo(p.surname);
		if (comparedSurnames == 0) {// if surnames are the same
			int comparedFirstNames = firstName.compareTo(p.firstName);
			if (comparedFirstNames == 0)
				return age - p.age;// if both surnames and first names are the same, compare ages.
			else
				return comparedFirstNames;
		} 
		return comparedSurnames;
	}

	/**
	 * <code>toString</code> method for Person.
	 *
	 * @return <code>String</code> representation of Person
	 */
	public String toString() {
		return getClass().getName() + "[firstName=\"" + firstName + "\",surname=\"" + surname + "\",age=" + age + "]";
	}


	private String firstName;
	private String surname;
	private int age;


	/**
	 * Test program for Person (using a TreeSet)
	 *
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		Set<Person> people = new TreeSet<Person>();
		people.add(new Person("Jo", "Aaaaa", 28));
		people.add(new Person("James", "Bbbbb", 38));
		people.add(new Person("John", "Sssss", 26));
		people.add(new Person("Jaz", "Bbbbb", 34));
		people.add(new Person("Jill", "Wwwww", 26));
		people.add(new Person("Jack", "Ggg", 32));
		people.add(new Person("Jack", "Ggg", 31));
		people.add(new Person("Jack", "Ggg", 32));
		people.add(new Person("Joseph", "Ggg", 32));
		people.add(new Person("Jo", "Aaaaa", 23));

		System.out.println(people);
	}


}// Person
