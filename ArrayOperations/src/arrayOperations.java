import java.util.Arrays;
public class arrayOperations {
	//These are all of the different arrays I made to try and test my code
		static int [] array1 = {1, 3, 13, 4, 10, 6, 8, 87, 9};
		static int [] array2 = {2, 4, 6, 8, 1, 0, 3, 9, 5};
		static int [] array3 = {4, 15, 23, 31, 20, 88, 6, 17}; 
		static int [] array4 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		static int [] array5 = {2, 12, 6, 19, 1, 3, 5, 7, 9};
		static int [] array6 = {2, 4, 8, 7, 9, 6}; 
		static int [] arrayNew = new int[9];
		static int temp = 0;
		static int num = 0;
		static int low = 5;
		static int high = 20;
		//This is the main method where I ran the operations and printed the results
		public static void main (String[] args){
			reverse(array1);
			reverseInPlace(array5);
			filterRange(array3, 5, 20);
			swap(array6);
			System.out.println("Reversed method > " + Arrays.toString(arrayNew));
			System.out.println("Reversed in place method > " + Arrays.toString(array5));
			System.out.println("Filtered Range > " + Arrays.toString(array4));
			System.out.println("Swap method > " + Arrays.toString(array6));
		}
		//This method is meant to reverse an array and output the reverse into a new array
		//It doesnt do this successfully however, and only gets the later half
		public static int [] reverse(int [] array){
		for(int i = 0; i < array.length / 2; i++){
			int arrayData = array[i];
			array[i] = array[array.length-i-1];
			arrayNew[array.length - i - 1] = arrayData;
		}
		return arrayNew;
		}
		
//This method reverses a string without creating a new one
		public static void reverseInPlace(int [] array){
			for (int i = 0; i < array.length/2 ; i++){
			int num = array[i];
			array[i] = array[array.length-i-1];
			array[array.length - i - 1] = num;
			}
		}
//This method selects values within a given range to store
		public static int [] filterRange(int [] array, int low, int high){
			for (int pos=0; pos<array.length; pos++){
				if (array[pos] > low && array[pos] < high){
					array4[pos] = array[pos];
				}
			}
			return array4;
	}
		
//This method is meant to swap the values of an array with the adjacent one, but doesn't work properly
		public static void swap(int [] array){
			int temp = 1;
			for (int i=0; i<array.length; i = i + 2){
				int number = array[temp];
				array[temp] = array[i];
				array[i] = number;
				temp = temp + 2;
				if (temp >= array.length){
					break;
				}
			}
		}
}