import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//C:/Users/User/Downloads/Counting.txt
public class readingText {
	public static void main (String [] args){
		int numSentences = 0;
		int numSpaces = 0;
		int numWords = 0;
		int numNumbers = 0;
		int numLetters = 0;
		int numOthers = 0;
		Scanner keyboard = new Scanner (System.in);
		Boolean validInput = false;
		//This prompts and checks the user for a valid input file
		while (!validInput){
			System.out.println("Input the file path: ");
			String location = keyboard.nextLine();
			File f = new File(location);
			try{
				Scanner sc = new Scanner (f); 
				validInput = true;
				while ( sc.hasNext()){
					String line = sc.nextLine();
					char last = line.charAt(line.length() - 1);
					if (last != '.'){
						numWords++;
					}
					//These lines count the different things, like spaces and words
					for (int i = 0; i < line.length(); i++){
						char c = line.charAt(i);
						if (c=='.'){
							numSentences++;
						}
						if (c==' '){
							numSpaces++;
						}
						if (c==',' || c=='.' || c==';'|| c==':' || c==' '){
							numWords++;
						}
						if (Character.isDigit(c)){
							numNumbers++;
						}
						if (Character.isLetter(c)){
							numLetters++;
						}
						if (c=='.' || c==',' || c==';'){
							numOthers++;
						}
					}

				}
				//This rejects invalid files
			}
			catch(FileNotFoundException e){
				System.out.println("Incorrect File Location");
			}
		}
		System.out.println("The number of sentences was: " + numSentences);
		System.out.println("The number of words was: " + numWords);
		System.out.println("The number of spaces was: " + numSpaces);
		System.out.println("The number of letters was: " + numLetters);
		System.out.println("The number of digits was: " + numNumbers);
		System.out.println("The number of other characters was: " + numOthers);
	}	
}