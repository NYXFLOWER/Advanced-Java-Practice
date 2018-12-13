package Week8;import java.util.*;

public class ReverseAgeComparator implements Comparator<Person> {

	public int compare(Person a, Person b) {
		return b.getAge() - a.getAge();
	}
}
