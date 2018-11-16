/**
 * 
 * @author Bond Ragsdale
 * Outside Programming 4
 *
 */
//cs111 specification for a circular doubly linked list with a dummy header
//node

class ListEmptyException extends Exception{
	public ListEmptyException(String errorMessage){
		super(errorMessage);
	}
}

class NotInListException extends Exception{
	public NotInListException(String errorMessage){
		super(errorMessage);
	}
}

public class DoublyLinkedList<T extends Comparable<T>>{
	private class Node{
		private T data;
		private Node next;
		private Node prev;
		private Node (T data){
			this.data = data;
		}
		private Node (T data, Node previousReference, Node nextReference){
			this.data = data;
			this.prev = previousReference;
			this.next = nextReference;
		}
	}

	private Node head;
	private Node current;
	private int size;

	public DoublyLinkedList(){
		head = new Node(null, head, head);
		size = 0;
	}

	public DoublyLinkedList(DoublyLinkedList<T> list){
		Node dummyNode = new Node(null);
		dummyNode.prev = dummyNode;
		dummyNode.next = dummyNode;
		head = dummyNode;
		current = dummyNode;
		Node next = list.head.next;
		while(next != list.head){
			insert(next.data);
			next = next.next;
		}
	}

	//insert's the new value into its proper ordered position in the list
	public void insert (T d){
		Node temp;
		if(isEmpty()){
			current = new Node(d, head, head);
			head.next = current;
			head.prev = current;
			size++;
		}else{
			temp = head.next;
			boolean done = false;
			while(!done){
				if(temp == head || temp.data.compareTo(d) >= 0){
					done = true;
				}else{
					temp = temp.next;
				}
			}
			Node node = new Node(d, temp.prev, temp);
			temp.prev.next = node;
			temp.prev = node;
			size++;
		}
	}
	//removes an existing value from the list
	public void remove (T data) throws ListEmptyException, NotInListException{
		if(head == null){
			throw new ListEmptyException("The List is empty.");
		}
		Node temp = head;
		Boolean done = false;
		while(temp != null){
			if(temp.data != data){
				temp = temp.next;
			}if(temp.next == null){
				throw new NotInListException("Item is not in list.");
			}	
		}

		Node prev = null;
		while(temp != null && !temp.data.equals(data)){
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
	//positions the list at the beginning of the list
	public void begin(){
		current = head.next;
	}
	//advances to the next element in the list
	public void advance(){
		current = current.next;
	}
	//retreats to the previous item in the list
	public void retreat(){
		current = current.prev;
	}
	//returns the value at the current point of the list
	public T current() throws ListEmptyException{
		if(!isEmpty()){
			return current.data;
		}else{
			throw new ListEmptyException("The list is empty.");
		}

	}
	//determines if we are at the end of the list
	public boolean end(){
		if(current.next == null){
			return true;
		}else{
			return false;
		}
	}
	//determines if empty
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}else{
			return false;
		}
	}
	//returns the number of elements in the list
	public int size(){
		return size;
	}

	public String toString(){
		String result = "";
		Node node = head.next;
		do{
			result += node.data + " ";
			node = node.next;
		}
		while(node != head);
		return result;
	}
} 