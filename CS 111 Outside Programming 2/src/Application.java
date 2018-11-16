import java.util.Scanner;
import java.util.Date;
public class Application {
	public Media media;
	public Artist artist;
	public Audio audio;
	public CD cd = new CD(null, 0, null, null, null, null, 0, null, 0);
	public Video video;
	public DVD dvd;
	public Media[] mediaArray;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1 - create new media 2 - Display number of plays 3 - Play a particular media "
				+ "");
		int choice = 0;
		
		switch(choice){
			case 1: System.out.println("Create a new DVD or CD.");
						System.out.println("CD or DVD? (1 for CD, 2 for DVD)");
						int formatChoice;
						formatChoice = in.nextInt();
						if(formatChoice == 1){
							System.out.println("Please input the following information:");
							System.out.println("What is the title of the CD?");
							String title = in.nextLine();
							System.out.println("Who is the major artist?");
							String majorArtist = in.nextLine();
							System.out.println("What is the playing time of the film? (In mins)");
							Double playingTime = in.nextDouble();
							int numPlays = 0;
							System.out.println("What is the first name of the artist?");
							String first = in.nextLine();
							System.out.println("Waht is the last name of the artist?");
							String last = in.nextLine();
							System.out.println("What is the birth date of the artist?");
							Date birthday = in.nextLine();
							System.out.println("What is their twitter handle?");
							String twitterHandle = in.nextLine();
							System.out.println("What is their website?");
							String url = in.nextLine();
							System.out.println("How many supporting actors are there?");
							int numSuppActors = in.nextInt();
							String[] supportingActors = new String[numSuppActors];
								for(int i = 0; i <= numSuppActors; i++){
									System.out.println("Input the actor's name: ");
									supportingActors[i] = in.nextLine();
								}
							int numActors = numSuppActors;
							System.out.println("Enter the name of director: ");
							String director = in.nextLine();
							System.out.println("What is the movie rated?");
							String rating = in.nextLine();
							mediaArray[cd(title, majorArtist, playingTime, numPlays, last, first, birthday,
									twitterHandle, url, supportingActors, numActors, director, rating)];
							
						}else{
							System.out.println("Please input the following information:");
							System.out.println("What is the title of the DVD?");
							String title = in.nextLine();
							System.out.println("Who is the major artist?");
							String majorArtist = in.nextLine();
							System.out.println("What is the playing time of the film? (In mins)");
							Double playingTime = in.nextDouble();
							int numPlays = 0;
							System.out.println("What is the first name of the artist?");
							String first = in.nextLine();
							System.out.println("Waht is the last name of the artist?");
							String last = in.nextLine();
							System.out.println("What is the birth date of the artist?");
							Date birthday = in.nextLine();
							System.out.println("What is their twitter handle?");
							String twitterHandle = in.nextLine();
							System.out.println("What is their website?");
							String url = in.nextLine();
							System.out.println("How many supporting actors are there?");
							int numSuppActors = in.nextInt();
							String[] supportingActors = new String[numSuppActors];
								for(int i = 0; i <= numSuppActors; i++){
									System.out.println("Input the actor's name: ");
									supportingActors[i] = in.nextLine();
								}
							int numActors = numSuppActors;
							System.out.println("Enter the name of director: ");
							String director = in.nextLine();
							System.out.println("What is the movie rated?");
							String rating = in.nextLine();
							mediaArray[dvd(title, majorArtist, playingTime, numPlays, last, first, birthday,
									twitterHandle, url, supportingActors, numActors, director, rating)];
						}
			case 2: System.out.println(numPlays);
			case 3: System.out.println("Which track would you like to play?");
					int mediaChoice = in.nextInt();
					mediaArray[mediaChoice];
					playMedia();
					
			
				
		}
	}
}