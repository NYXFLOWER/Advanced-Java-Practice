package Week8;
import java.util.*;

public class AgeComparator implements Comparator<Person> {

	public int compare(Person a, Person b) {
		return a.getAge() - b.getAge();
	}
}
