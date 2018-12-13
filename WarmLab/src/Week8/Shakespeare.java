/*
	Shakespeare.java

	Reads information from Shakespeare.txt
 */
package Week8;
import java.util.*;
import java.io.*;

public class Shakespeare {

	public static void main(String args[]) {
		String line;
		String wd;
		StringTokenizer st;
		List<String> words=new LinkedList<String>();

		// Read data from file and split into tokens, i.e. words
		// (The try/catch construction catches an exception, ie. error, 
		// if the file is not found)
		try {
			Scanner file = new Scanner(new File ("/Users/nyxfer/Documents/GitHub/Advanced-Java-Practice/WarmLab/src/Week8/Shakespeare.txt"));
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
	}

}
