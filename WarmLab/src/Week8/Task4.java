package Week8;import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task4 {

	public static void main(String[] args) {
		List<String> list0 = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");
		List<String> list1 = Arrays.asList("bravo", "delta", "foxtrot", "hotel", "india", "juliet");
		
		System.out.println("Input 0");
		System.out.println(list0);
		System.out.println();
		System.out.println("Input 1");
		System.out.println(list1);
		
		List<String> test = eitherNotBoth(list0, list1);
		System.out.println();
		System.out.println("In either but not both");
		System.out.println(test);
	}
	
	
	public static <T> List<T> eitherNotBoth(List<T> listA, List<T> listB) {
		Set<T> union = new HashSet<T>(listA);
		union.addAll(listB);
		
		Set<T> intersection = new HashSet<T>(listA);
		intersection.retainAll(listB);
		
		Set<T> result = new HashSet<T>();
		result.addAll(union);
		result.removeAll(intersection);

		return new ArrayList<T>(result);
	}

}
