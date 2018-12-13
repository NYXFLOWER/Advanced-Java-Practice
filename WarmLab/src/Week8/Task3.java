/*
	Shakespeare.java

	Reads information from Shakespeare.txt
 */
package Week8;
import java.util.*;
import java.io.*;

public class Task3 {

	public static void main(String args[]) {
		String line;
		String wd;
		StringTokenizer st;
		List<String> words=new LinkedList<String>();

		// Read data from file and split into tokens, i.e. words
		// (The try/catch construction catches an exception, ie. error, 
		// if the file is not found)
		try {
			Scanner file = new Scanner(new File ("Shakespeare.txt"));
			// read in each line, and split into tokens
			while (file.hasNext()){
				line = file.next();
				st = new StringTokenizer(line," .,:?'");
				// space, full stop, comma, etc.
				// are included as token delimiters
				// and are thus not tokens themselves
				while (st.hasMoreTokens()) {
					wd = st.nextToken();
					words.add(wd);
				}
			}
			file.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();return;
		}
		System.out.println("words: "+words);
		
		System.out.println();
		System.out.println("Words starting with a:");
		Iterator<String> i = words.iterator();
		while (i.hasNext()) {
			String word = i.next();
			if (word.startsWith("a")) {
				System.out.println(word);
			}
		}

		System.out.println();
		System.out.println("Words sorted case-insensitively:");
		words.sort(new CaseInsensitiveComparator());
		System.out.println(words);
		
		
		System.out.println();
		System.out.println("Word count");

		Iterator<String> i1 = words.iterator();
		String previous = null;
		String current;
		int counter = 0;
		
		while (i1.hasNext()) {
			current = i1.next();
			if (current.equals(previous)) {
				counter +=1;
			}
			else {
				if (previous != null) {
					System.out.println(previous + "  count = " + counter);
				}
				previous = current;
				counter = 1;
			}
		}
	}

}


class CaseInsensitiveComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.toLowerCase().compareToIgnoreCase(o2.toLowerCase());
	}

}
