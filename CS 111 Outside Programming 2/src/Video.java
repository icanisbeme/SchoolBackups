import java.util.Date;

public abstract class Video extends Media{
	private String[] supportingActors;
	private int numActors;
	private String director;
	protected String rating;
	
	Video(String title, String majorArtist, double playingTime, int numPlays, String last, String first, 
			Date birthday, String twitterHandle, String url, String[] supportingActors, int numActors,
			String director, String rating){
		super(title, majorArtist, playingTime, numPlays);
		this.supportingActors = supportingActors;
		this.numActors = numActors;
		this.director = director;
		this.rating = rating;
	}
	
	public abstract String playMedia();
	public String toString(){
		String result;
		result = "Supporting actors: " + supportingActors + "\n" + 
				 " Number of actors: " + numActors + "\n" + 
				 " Director: " + director + "\n" +
				 " Rating: " + rating;
		return result;
				
	}
}
