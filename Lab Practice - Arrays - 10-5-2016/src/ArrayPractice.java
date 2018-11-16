import java.util.Arrays;
import java.util.Scanner;
public class ArrayPractice {
	
	public static void main(String[] args){
	
		int [] intArray; // declaring intArray as the name, int is the data type, [] means array 
		intArray = new int[10]; // initialization
		
	//if you already know the values, this creates an array with all of the values and the proper number
		// of spaces in the array
		//4 elements in this array 
		double  [] array1 = { 4, 1, 3, 2, 7};
		
		System.out.println(array1[3]); //prints the element in the 3 position of array1
		String example = "Hello"; 
		System.out.println(example.length());
		
		//printing elements in an array
		
		System.out.println(array1); //yields gibberish
		//Next one is functional
		for( int pos = 0; pos < array1.length; pos++){
			System.out.println(array1[pos]);
		}
		
		//another way to print arrays
		String printedArray = Arrays.toString(array1);
		System.out.println(printedArray);
		
		Scanner sc = new Scanner(System.in);
		
		//how to take values from a user 
		for ( int pos = 0; pos < array1.length; pos++){
			System.out.println("Enter element: " + pos);
			array1[pos] = sc.nextDouble();
			
		}
		
		//checking to see if an element is bigger than something
		double max = array1[0];
		for (int pos = 0; pos < array1.length; pos++){
			if (array1[pos] > max){
				max = array1[pos];
			}
		}
		
		
	}
}
