public class Page233 {
	static int [] array = {1, 2, 3, 4};
	public static void main (String[] args){	
		System.out.println(addArray(array, 0));
	}
	public static int addArray(int [] array, int position){
		int total = 0;
		if(array[position] < array.length){
			total += array[position];
					if(array[position + 1] < array.length){
						total += addArray(array, position+1);
					}
			}	
		return total;
	}
}