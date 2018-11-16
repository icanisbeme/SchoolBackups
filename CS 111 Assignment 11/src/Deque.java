import java.util.Scanner;
public class Deque<X> {
	Node head;
	Node tail;
	int numItems;

	public Deque(){
		numItems = 0;
		tail = null;
		head = null;
	}

	public void addFirst(X item){
		head.data = item;
	}

	public void addLast(X item){
		tail.data = item;
	}

	public X removeFirst(){
		X temp = head.data;
		head.data = null;
		return temp;
	}

	public X removeLast(){
		X temp = tail.data;
		tail.data = null;
		return temp;
	}

	public X getFirst(){
		return head.data;
	}

	public X getLast(){
		return tail.data;
	}

	public int size(){
		return numItems;
	}

	public boolean isEmpty(){
		if(numItems <= 0){
			return true;
		}else{
			return false;
		}
	}

	class Node{
		X data;
		Node next;
	}

	public String toString(){
		String result = "";
		while(!isEmpty()){
			result += removeFirst();
			numItems--;
		}
		return result;
	}

	public void clear(){
		while(numItems > 0){
			removeFirst();
		}
	}

	public static void main(String [] args){
		Deque<Integer> deque = new Deque<Integer>();
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 20; i++){
			int sample = (int) Math.random();
			if(sample >= 0 && sample <= 100){
				deque.addFirst(sample);
			}
		}
		deque.toString();
		System.out.println("Input your integer: ");
		Integer userItem = input.nextInt();
		System.out.println("Choose an option");
		System.out.println("1. Add at beginning");
		System.out.println("2. Add at end");
		System.out.println("3. Remove at beginning");
		System.out.println("4. Remove at end");
		System.out.println("5. Display beginning");
		System.out.println("6. Display end");
		System.out.println("7. Display all");
		System.out.println("8. Clear");
		System.out.println("9. Exit");
		Boolean repeat = true;
		while(repeat){
			System.out.println("Make a selection.");
			int choice = input.nextInt();
			switch(choice){
			case 1: deque.addFirst(userItem);
			break;
			case 2: deque.addLast(userItem);
			break;
			case 3: deque.removeFirst();
			break;
			case 4: deque.removeLast();
			break;
			case 5: System.out.println(deque.getFirst());
			break;
			case 6: System.out.println(deque.getLast());
			break;
			case 7: System.out.println(deque.toString());
			break;
			case 8: deque.clear();
			System.out.println("Deque cleared");
			break;
			case 9: System.out.println("Thank you for using the program");
			repeat = false;
			break;
			}
		}
	}
}