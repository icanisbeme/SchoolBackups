import java.util.Date;

public class DVD extends Video{
	DVD(String title, String majorArtist, double playingTime, int numPlays, String last, 
			String first, Date birthday,
			String twitterHandle, String url, String[] supportingActors, int numActors, String director,
			String rating) {
		super(title, majorArtist, playingTime, numPlays, last, first, birthday,
				twitterHandle, url, supportingActors, numActors,
				director, rating); 
	}

	private String[] specialFeatures;
	private int numFeatures;
	private String widescreenFormat;
	private String TVFormat;
	private String[] soundOptions;
	private int numSoundOptions;
	
	@Override
	public String playMedia() {
		String result;
		result = "Now Playing: " + title + " With a play time of: " + playingTime + 
				" With a rating of: " + rating; 
		numPlays++;
		return result;
	}

	
	private String printSpecialFeatures(){
		String features = "";
		for(int i = 0; i < specialFeatures.length; i++){
			features += specialFeatures[i];
		}
		return features;
	}
	
	private String printSoundOptions(){
		String options = "";
		for(int i = 0; i < soundOptions.length; i++){
			options += soundOptions[i];
		}
		return options;
	}
	
	@Override
	public String toString() {
		String information;
		
		information = "Special Features: " + printSpecialFeatures() + "\n" + 
		"Number of features: " + numFeatures + "\n" + 
		"Widescreen Format: " + widescreenFormat + "\n" +
		"TV Format: " + TVFormat + "\n" +
		"Sound Options: " + printSoundOptions() + "\n" +
		"Number of sound options: " + numSoundOptions;
		
		return information;
	}

}
