import java.util.Scanner;

public class LinkedList <T>{
	private Node head;
	private int index;

	public class Node{
		private T data;
		private Node next;
		Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		public String toString(){
			return data.toString();
		}
	}

	public LinkedList(){
		head = new Node(null, null);
		index = 0;
	}

	public void add(T object){
		Node node1 = null;
		Node newNode = new Node(object, null);
		Node node2 = null;
		if(head.next!= null){
			node1 = head.next;
			while(node1 != null){
				node2 = node1;
				node1 = node1.next;
			}
			node2.next = newNode;
		}
		else{
			head.next = newNode;
		}
		index++;
	}

	public void add(int index, T object){
		Node node1 = null;
		Node newNode = new Node(object, null);
		Node node2 = null;
		if(head.next== null){
			System.out.println("Its empty...");
		}
		else if(index > size()){
			System.out.println("That index is out of bounds");
		}
		else{
			node1 = head.next;
			int location = 0;
			while(location <= index){
				if( index == 0){
					head.next = newNode;
					newNode.next = node1;
					location = index++;
				}
				else if(location == index){
					node2.next = newNode;
					newNode.next = node1;
					location = index+1;
				}
				else{
					node2 = node1;
					node1 = node1.next;
					location++;
				}
			}
		}
		this.index++;
	}

	public void clear(){
		head.next=null;
	}

	public boolean constains(T object){
		if(indexOf(object)!= -1)
			return true;
		else
			return false;
	}

	public T get(int index){
		if(index >= this.index || head.next == null){
			System.out.println("That value is not within the index");
		}
		else{
			int num = 0;
			Node node = head.next;
			while(num <=index)
			{
				if(num == index){
					return node.data;
				}
				else{
					node = node.next;
					num++;
				}
			}
		}
		return null;
	}

	public int indexOf(T object){
		Node node = null;
		if(head.next == null){
			System.out.println("Its empty...");
		}
		else{
			node = head.next;
			int index = 0;
			while(index<size()|| node ==null){
				if(node.data.equals(object)){
					return index;
				}
				else{
					node = node.next;
					index++;
				}
			}
		}
		return -1;
	}

	public boolean isEmpty(){
		if(head.next == null)
			return true;
		else
			return false;
	}
	public void remove(int index){
		Node node1 = null;
		Node node2 = null;
		int num = 0;
		if(head.next == null){
			System.out.println("The list is empty.");
		}
		else if(index> size()){
			System.out.println("That position is out of bounds.");
		}
		else if(index == 0){
			node2 = head.next;
			node2 = node2.next;
			head.next = node2;
		}
		else{
			node2 = head.next;
			node1 = node2;
			while(num <= index){
				if(num == index-1){
					node1.next = node2.next;
					num = index+1;
				}
				else{
					node1 = node2;
					node2 = node2.next;
					num++;
				}
			}
		}
	}

	public String toString(){
		String result = "";
		Node node = head.next;
		int index = 0;
		while(node != null){
			result += index + "  " + node.data + "\n";
			node = node.next;
			index++;
		}
		return result;
	}

	public int size(){
		return index;
	}

	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		LinkedList<String> list= new LinkedList<String>();
		do{
			System.out.println("Make a selection");
			System.out.println("1. Add item");
			System.out.println("2. Add in a certain spot");
			System.out.println("3. Remove a certain index");
			System.out.println("4. Get the index of an item");
			System.out.println("5. Get an item");
			System.out.println("6. Display the list");
			System.out.println("7. Exit");
			String choice = sc.nextLine();
			if(choice.equals("1")){
				System.out.println("Input your element");
				String userInput = sc.nextLine();
				list.add(userInput);
			}
			else if(choice.equals("2")){
				System.out.println("Input your element");
				String userInput = sc.next();
				System.out.println("Input the index where you would like to add it");
				int index = sc.nextInt();
				list.add(index, userInput);
			}
			else if(choice.equals("3")){
				System.out.println("Enter the index of the object you would like to remove");
				int index = sc.nextInt();
				list.remove(index++);
				list.toString();
			}
			else if(choice.equals("4")){
				System.out.println("Enter what you would like to search for");
				String input = sc.nextLine();
				System.out.println(list.indexOf(input));
			}
			else if(choice.equals("5")){
				System.out.println("Input the index of the object you would like to retrieve");
				int index = sc.nextInt();
				System.out.println(list.get(index));
			}
			else if(choice.equals("6")){
				System.out.println(list.toString());
			}
			else if(choice.equals("7")){
				System.out.println("Thank you for using the LinkedList program");
				loop = 0;
			}
			else{
				System.out.println("Invalid Input");
			}
		}
		while(loop == 1);
	}
}