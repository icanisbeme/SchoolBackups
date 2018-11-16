
public class Lab13Practice {
	public static void main (String [] args){
		int [] arr = new int[5];
		int [] [] arr1 = new int [5] [5];
		int [] [] arr2 = { {1,2},{3,4}};
		int firstElement = arr2[0][0];
		System.out.println(firstElement);
		
		for ( int row = 0; row < arr2.length; row++){
			for (int col = 0; col < arr2[0].length; col++){
				System.out.println(arr2[row][col]);
			}
		}	
	}
}
