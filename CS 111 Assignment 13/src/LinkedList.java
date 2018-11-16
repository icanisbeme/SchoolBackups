import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;

public class LinkedList<T> implements List<T>{

	private int size = 10;
	T [] array;

	public LinkedList(){
		array =  (T[]) new Array[size];
	}

	@Override
	public boolean add(T e) {
		boolean full = false;
		for(int index = 0; index < size; index++){
			if(array[index] != null){
				full = false;
			}
			else{
				full = true;
				size = size *2;
				array =  (T[]) new Array[size];
			}
		}
		if(full){
			for(int i = 0; i < size; i++){
				if(array[i] == null){
					array[i] = e;
					return true;
				}
			}
		}
		return false;
	}

	public void add(int index, T element){
		boolean full = false;
		for(int loc = 0; loc < size; loc++){
			if(array[loc] != null){
				full = false;
			}
			else{
				full = true;
				size = size *2;
				array =  (T[]) new Array[size];
			}
		}
		if(full){
			array[index] = element;
		}
	}

	public void clear(){
		Arrays.fill(array, null);
	}

	public boolean contains(Object o) {
		for(int i = 0; i <  size; i++){
			if(array[i] == o){
				return true;
			}
		}
		return false;
	}


	public T get(int index){
		if(index > size){
			System.out.println("That index is out of bounds.");
		}
		return array[index];
	}

	public int indexOf(Object o){
		for(int i = 0; i < size; i++){
			if(array[i] == o)
				return i;
		}
		return 0;
	}

	@Override
	public boolean isEmpty() {
		for(int i = 0; i < size; i++){
			if(array[i] != null){
				return false;
			}
		}
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		if(!isEmpty()){
			int oLocation = indexOf(o);
			array[oLocation] = null;
			return true;
		}else{
			return false;
		}

	}

	@Override
	public T remove(int index) {
		if(!isEmpty()){
			array[index] = null;
		}
		return array[index];
	}

	public int size() {
		return size;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
}