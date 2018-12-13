package Week8;import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task1 {

	
	public static void main(String[] args) {
		// The List returned by Arrays.asList cannot be modified
		List<String> fixedList = Arrays.asList("elephant", "lion", "leopard", "tiger");
		System.out.println(fixedList);
		System.out.println();
		
		// Copy it to a modifiable list and replace each item
		// with upper case
		List<String> myList = new LinkedList<String>(fixedList);
		ListIterator<String> listIterator = myList.listIterator();
		while (listIterator.hasNext()) {
			String animal = listIterator.next();
			String upperCaseAnimal = animal.toUpperCase();
			// These 2 lines replace the current list item
			listIterator.remove();
			listIterator.add(upperCaseAnimal);
		}
		
		for (String animal : myList) {
			System.out.println(animal);
		}
		System.out.println();

		// Create a new list by adding upper case items converted from the fixed list
		List<String> newList = new LinkedList<String>();
		for (String animal : fixedList) {
			newList.add(animal.toUpperCase());
		}
		
		for (String animal : newList) {
			System.out.println(animal);
		}
		System.out.println();


	}

}
