import java.util.ArrayList;
import java.util.Random;

public class DoublyLinkedListTester {

	public static void main(String[] args) throws ListEmptyException {
		Random random = new Random();
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>(); 
		final int NR_ELEMENTS = 10;
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

		if (list.isEmpty()) {
			System.out.println("isEmpty works correct");
		} else {
			System.out.println("isEmpty should return true");
		}

		if (list.size() == 0) {
			System.out.println("Size works correct");
		} else {
			System.out.println("Size should return 0");
		}

		// Testing insert
		for (int i = 0; i < NR_ELEMENTS; i++) {
			int temp = random.nextInt(100);
			list.insert(temp);
			// make a copy of the random numbers to use later when removing elements
			randomNumbers.add(temp);
		}

		// For this to work you need to have a toString method
		System.out.println("The list should be printed in sorted order");
		System.out.println(list);

		// Test the forward iterator
		// Should print the whole list just like the toString method above
		// If you get an error here the problem might be in the insert method
		list.begin();
		while (!list.end()) {
			try {
				System.out.print(list.current() + " ");
			} catch (ListEmptyException e) {
				System.out.println("This should not happen here");
			}
			list.advance();
		}
		System.out.println();

		// Test the backward iterator
		// Should print the whole list just in reverse order
		// If you get an error here the problem might be in the insert method.
		// For example incorrectly updating the prev pointer or forgetting to update it,

		// First retreat one step back from the end 
		list.retreat();
		do {
			try {
				System.out.print(list.current() + " ");
			} catch (ListEmptyException e) {
				System.out.println("This should not happen here");
			}
			list.retreat();
		} while (!list.end());
		System.out.println();

		// Test the remove method by removing three values that are in the list. 

		for (int i = 0; i < 3; i++) {
			try {
				list.remove(randomNumbers.remove(random.nextInt(randomNumbers.size())));
			} catch (ListEmptyException e) {
				System.out.println("This should not happen");
			} catch (NotInListException e) {
				System.out.println("This should not happen");
			}
		}

		if (list.size() != 7) {
			System.out.println("The list has " + list.size() + " elements now and should have 7");
			System.out.println("Check that you are decrement size in the remove method");
		}

		// Print the list
		System.out.println(list);
	}
}