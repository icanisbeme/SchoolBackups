import java.util.ArrayList;
import java.util.Random;

public class Set {
	Random rand = new Random();
	private ArrayList<Integer> set = new ArrayList<Integer>();
	
	public Set(int n){
		for(int i = 0; i < n; i++){
			int x = rand.nextInt(999);
			set.add(x);
		}
	}
	
	public Set(int [] array){
		int arrayLength = array.length;
		for(int i = 0; i < arrayLength; i++){
			int arrayValue = array[i];
			set.add(arrayValue);
		}
	}
	
	public void remove(int value){
		set.remove(value);
	}
	
	public void add(int value){
		set.add(value);
	}
	
	public Set union(Set B){
		for(int i = 0; i < B.Size(); i++){
			B.add(set.get(i));
		}
		return B;
	}
	
	public Set intersection(Set B){
		union(B);
		for(int i = 0; i < B.Size(); i++){
			for(int z = 0; z < set.size(); z++){
				if( B.getValue(i) == set.get(z)){
					remove(set.get(z));
				}
			}
		}
		return B;
	}
	
	public Set difference(Set B){
		union(B);
		for(int i = 0; i < B.Size(); i++){
			for(int z = 0; z < set.size(); z++){
				if( B.getValue(i) != set.get(z)){
					remove(set.get(z));
				}
			}
		}
		return B;
	}
	
	public int Size(){
		return set.size();
	}
	
	public int getValue(int position){
		return set.get(position);
	}
	
	public Boolean contains(int value){
		Boolean isContained = false;
		for(int i = 0; i < set.size(); i++){
			if(set.get(i) == value){
				isContained = true;
			}
		}
		return isContained;
	}
	
	public String toString(){
		return "" + set;
	}
	
	public void subSetSum(int desiredSum){
		System.out.println("The sum to calculate is " + desiredSum);
		subSetSumHelper(desiredSum, 0, 0, new Set(0));
	}
	
	private void subSetSumHelper(int desiredSum, int sum, int position, Set subset){
		if (sum == desiredSum){
			System.out.println(set);
		} else{
			for(int firstNum = 0; firstNum < set.size(); firstNum++){
				if(sum + set.get(firstNum) <= desiredSum && set.contains(firstNum) != true){
					subset.set.add(set.get(firstNum));
					subSetSumHelper(desiredSum, sum += set.get(firstNum), position, subset);
					subset.set.remove(subset.Size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args){
		int array[] = {1, 2, 3, 4, 5, 6, 9};
		Set newSet = new Set(array);
		System.out.println("The set includes: " + newSet);
		newSet.subSetSum(7);
	}
}