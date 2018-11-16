import java.util.Arrays;
public class Assignment7 {
	//This is the main method, where the methods are called on, and the parameters 
	//declared so the methods know what to work with
	public static void main(String[] args){
		int [] array1 = {6, 12, 18, 9, 3, 27, 4, 21, 8};
		double [] array2 = {1, 2, 3, 4, 5};
		double [] array3 = {2, 1, 4, 7, 1, 2};
		countDivisibleByThree(array1);
		normalizeArray(array2);
		cumulativeSum(array3);
	}
	//This creates a loop where every value in the array is checked if there is a remainder after
	//dividing by 3, and if not it adds to the counter
	public static int countDivisibleByThree(int [] array){	
	int divByThree = 0;
	for (int pos = 0; pos < array.length; pos++){
		if(array[pos] % 3 == 0){
		divByThree++;
			}	
		}	
	System.out.println("The number of values divisible by three is: " + divByThree);
	return divByThree;
	}
	//The first loop makes the sum equal to the sum of all of the values in the array,
	//and the second loop creates the new arrays values based on the average
	public static double[] normalizeArray(double [] array){
		int sum = 0;
		double average;
		for (int pos = 0; pos < array.length; pos++){
			sum += array[pos];
		}
		average = (sum)/(array.length);
		double [] newArray = new double[array.length];
			for (int pos = 0; pos < array.length; pos++){
				newArray[pos] = (array[pos] - average);
			}
		String printedArray = Arrays.toString(newArray);
		System.out.println(printedArray);
		return newArray;	
	}
	//The loop creates the sum based on the different values in the first array, and then makes 
	//the corresponding value in the new array equal to the sum at that moment
	public static double[] cumulativeSum(double[] array){
		double sum = 0;
		double [] newArray = new double[array.length];
		for (int i = 0; i < array.length; i++){
			sum += array[i];
			newArray[i] = sum;
		}
		String printedArray = Arrays.toString(newArray);
		System.out.println(printedArray);
		return newArray;
	}
}