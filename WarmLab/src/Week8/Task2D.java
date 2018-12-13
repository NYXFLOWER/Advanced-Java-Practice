package Week8;import java.util.*;
import java.io.*;

/* 
	HashSetTest.java

	Example class that demonstrates used of HashSet Collection.
 */

public class Task2D {

	public static void main(String args[]) {
		Set<Person> people = new TreeSet<Person>(new AgeComparator());// here we declare people to be the most general
		// type, which makes it possible to swap HashSet for TreeSet.
		StringTokenizer st;
		String firstname, surname, line;
		int age;

		// read data from file
		// (The try/catch construction catches an exception, ie. error,               
		// if the file is not found) 
		try {
			Scanner file = new Scanner(new File ("Person.txt"));
			// assume file has at least one line
			// that specifies the number of records
			int numData = file.nextInt(); 

			// read in each line, and split into tokens
			for (int i=0; i<numData; i++) {
				line = file.next();
				st = new StringTokenizer(line,"|");
				firstname = st.nextToken();
				surname = st.nextToken();
				age = Integer.parseInt(st.nextToken());
				people.add(new Person(firstname, surname, age));
			}
			file.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();return;
		}

		// iterate through hash set
		Iterator<Person> i = people.iterator();
		while (i.hasNext()) {
			Person p = i.next();
			System.out.print(p);System.out.print(", hash code ");System.out.println(p.hashCode());
		}

		System.out.println("Using a comparator of a person class :");
		Person firstPerson = people.iterator().next();//grab the first one
		for(Person p:people)
			System.out.println(firstPerson+" compared to "+p+" returns "+firstPerson.compareTo(p));

		System.out.println("Using AgeComparator :");
		Comparator<Person> comparator = new AgeComparator();
		firstPerson = people.iterator().next();//grab the first one
		for(Person p:people)
			System.out.println(firstPerson+" compared to "+p+" returns "+comparator.compare(firstPerson,p));
	}
}
