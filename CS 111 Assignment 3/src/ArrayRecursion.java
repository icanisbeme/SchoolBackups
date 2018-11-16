public class ArrayRecursion {
	static int [] array = {4, 2, 3, 9, 4, 2, 99, 6, 89, 12, 11};
	static int counter = 0;
	public static void main (String[] args){
		System.out.println(countElements(array, 0));
	}
	public static int countElements(int [] array, int position){
		if(array[position] % 3 == 0){
			counter++;
			if(position+1 < array.length){
				countElements(array, position+1);
			}
		}else{
			if(position+1 < array.length){
				countElements(array, position+1);
			}
		}
		return counter;
	}
}