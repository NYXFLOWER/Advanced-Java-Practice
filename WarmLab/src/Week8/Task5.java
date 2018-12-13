package Week8;import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task5 {

	public static void main(String[] args) {
		List<String> listA = new LinkedList<String>(Arrays.asList("alpha", "bravo", "charlie", "delta", 
				"echo", "foxtrot", "golf", "hotel"));
		List<String> listB = new LinkedList<String>(Arrays.asList("india", "juliet", "kilo", "lima", 
				"mike", "november", "oscar", "papa", "quebec"));

		System.out.println("A:");
		System.out.println(listA);
		System.out.println();

		System.out.println("B:");
		System.out.println(listB);
		System.out.println();
		
		ListIterator<String> i0 = listA.listIterator();
		ListIterator<String> i1 = listB.listIterator();
		
		while (i0.hasNext()) {
			i0.next();
			if (i1.hasNext()) {
				i0.add(i1.next());
				i0.next();
			}
		}
		while (i1.hasNext()) {
			i0.add(i1.next());
		}
		
		System.out.println("(1) A:");
		System.out.println(listA);
		System.out.println();
		
		ListIterator<String> i2 = listB.listIterator();
		while (i2.hasNext()) {
			i2.next();
			if (i2.hasNext()) {
				i2.next();
				i2.remove();
			}
		}
		
		System.out.println("(2) B:");
		System.out.println(listB);
		System.out.println();
		
		ListIterator<String> i3 = listA.listIterator();
		while (i3.hasNext()) {
			String aItem = i3.next();
			if (listB.contains(aItem)) {
				i3.remove();
			}
		}
		
		System.out.println("(3) A:");
		System.out.println(listA);
		System.out.println();
	
	}

}
