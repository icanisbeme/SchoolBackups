import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import org.omg.Messaging.SyncScopeHelper;

public class FrequencyAnalysis {
	static int [] letterCounts = new int[26];
	public static void main(String[] args) throws IOException{
		URL url = new URL("http://www.gutenberg.org/files/11/11-0.txt");
		Scanner input = new Scanner(url.openStream());
		int chars = 0;
		String book = "";	
			while(input.hasNext()){
				book += input.next();
				chars++;
			}    
		System.out.println(book);
		System.out.println("Number of Characters: " + chars);
		count(book, letterCounts);
	}	
	
	public static void count(String line, int [] counts){
		line = line.toUpperCase();
		for(int i = 0; i < line.length(); i++){
			char used = line.charAt(i);
			int letter = used - 'A';
			if(letter <= 25 && letter >= 0){
				counts[letter]++;
			}
		}	
		for(int counter = 0; counter < counts.length; counter++){
			System.out.print(counts[counter] + " ");
		}
	}
}