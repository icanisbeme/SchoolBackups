import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
//C:/Users/User/Downloads/SortMyFile.txt
public class Assignment10Practice {
	public static void main(String[] args){
		String [] words = new String [100];
		Scanner sc = new Scanner(System.in);
		String location = sc.next();
		try{
			File wordList = new File(location);
			Scanner fileReader = new Scanner(wordList);
			int counter = 0;
			while (fileReader.hasNextLine()){
				words[counter] = fileReader.nextLine();
				counter++;
			}
			//This is where i comment out the selection method i do not want to use
			bubbleSort(words);
			System.out.println(Arrays.toString(words));
			//selectionSort(words);
			//System.out.println(Arrays.toString(words));
//This line reads invalid location if the user does not input an appropriate file 
		}catch(FileNotFoundException e){
			System.out.println("Invalid location.");
		}
	}
//The bubble sort method
	public static void bubbleSort(String [] words){
		boolean unsorted = true;
		while (unsorted){
			unsorted =false;
			for(int i = 0; i + 1 < Array.getLength(words); i++){
				if (words[i].compareTo(words[i+1]) > 0){
					String temp = words[i];
					words[i] = words[i+1];
					words[i+1] = temp;
					unsorted = true;
				}
			}
		}
	}
	//The selection sort method 
	  public static void selectionSort(String[] words)
	  {
	    for (int i = 0; i < words.length - 1; ++i)
	    {
	      int minIndex = i;
	      for (int j = i + 1; j < words.length; ++j)
	      {
	        if (words[j].compareTo(words[minIndex]) < 0){
	          minIndex = j;
	        }
	      }
	      String temp = words[i];
	      words[i] = words[minIndex];
	      words[minIndex] = temp;
	    }
	  }
}