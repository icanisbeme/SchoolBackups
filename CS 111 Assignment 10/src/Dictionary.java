import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class Dictionary {
	LinkedList<Entry> dictionary = new LinkedList<Entry>();
	int totalWords = 0;

	public class Entry{
		String word = " ";
		int numOccurances = 0;
		int wordSize = 0;
		public Entry(String word){
			this.word = word;
			numOccurances = 1;
			wordSize = word.length();
		}
		public int getOccurances(){
			return numOccurances;
		}
		public void increase(){
			numOccurances++;
		}

		public String toString(){
			String result = word + " " + numOccurances;
			return result;
		}
	}

	public Dictionary(){
		LinkedList<Entry> dictionary = new LinkedList<Entry>();
	}

	public void put(String word){
		Entry entry = new Entry(word);
		if(!dictionary.contains(entry)){
			dictionary.add(entry);
			totalWords++;
		}else{
			entry.increase();
			totalWords++;	
		}
	}

	public double get(String word){
		Entry entry = new Entry(word);
		if(dictionary.contains(entry)){
			return entry.getOccurances();
		}else{
			return 0;
		}
	}

	public double remove(String word){
		Entry entry = new Entry(word);
		if(!dictionary.contains(entry)){
			System.out.println("Error: Word not found");
			return 0;
		}
		else if(entry.getOccurances() >= 1) {
			totalWords--;
			return entry.numOccurances;
		
		}
		else {
			return 0;
		}
	}
	
	double getAverageLength(){
		int numerator = 0;
		int totalSize = 0;
		for(int i = 0; i <= dictionary.size(); i++){
			int size = (dictionary.get(i).wordSize);
			totalSize += size;
		}
		double average =  totalSize/totalWords;
		return average;
	}

	double getAverageFreq(){
		int totalOccurances = 0;
		for(int i = 0; i <= dictionary.size(); i++){
			int occurances = dictionary.get(i).numOccurances;
			totalOccurances += occurances;
		}
		return totalOccurances/totalWords;
	}

	String [] getTopWords(int top){
		String [] list = new String [dictionary.size()];
		Entry [] topWords = new Entry [dictionary.size()];
		
		for(int i = 0; i <= dictionary.size() - 1; i++){
			topWords[i] = dictionary.get(i);
		}
		
		for(int i = 0; i < topWords.length; i++){
			int index = i;
			for(int j = index + 1; j <= topWords.length - 1; j++){
				if(topWords[j].numOccurances < topWords[index].numOccurances){
					Entry temp = topWords[index];
					topWords[index] = topWords[j];
					topWords[j] = temp;
				}	
			}
		}
		
		for(int i = 0; i <= topWords.length-1; i++){
			list[i] = topWords[i].word;
		}
		return list;
	}

	String toString ( String [] array){
		String result = " ";
		for(int i = 0; i<=array.length-1; i++){
			result+= array[i];
		}
		return result;
	}

	public static void main (String [] args) throws Exception{
		URL bookURL = new URL("http://www.gutenberg.org/files/11/11-h/11-h.htm");
		Scanner in = new Scanner(bookURL.openStream());
		String book = "";
		while (in.nextLine() != null){
			book += in.nextLine();
			book += book.replaceAll("[^a-zA-Z]", " ");
		}
		Dictionary Dictionary = new Dictionary();
		Dictionary.getTopWords(100);
		System.out.println(Dictionary.get("bookURL"));
	}
}