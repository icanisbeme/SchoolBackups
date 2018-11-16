// TODO: Auto-generated Javadoc
/**
 * The Class Media.
 */
public abstract class Media {
	
	/** The title. */
	String title = "sample text";
	
	/** The major artist. */
	String majorArtist;
	
	/** The playing time. */
	Double playingTime;
	
	/** The num plays. */
	int numPlays;
	
	/**
	 * Instantiates a new media.
	 *
	 * @param title the title
	 * @param majorArtist the major artist
	 * @param playingTime the playing time
	 * @param numPlays the num plays
	 */
	public Media(String title, String majorArtist, Double playingTime, int numPlays){}
	
	/**
	 * Play media.
	 *
	 * @return the string
	 */
	public abstract String playMedia();
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Gets the num plays.
	 *
	 * @return the num plays
	 */
	public int getnumPlays(){
		return numPlays;
	}

	/**
	 * Gets the playing time.
	 *
	 * @return the playing time
	 */
	public double getPlayingTime(){
		return playingTime;
	}
	
	/**
	 * Gets the major artist.
	 *
	 * @return the major artist
	 */
	public String getMajorArtist(){
		return majorArtist;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * The to String displays relevant information about the Media
	 * 
	 */
	public String toString(){
		String result;
		result = ("Title: " + title + " MajorArtist" + majorArtist +
				" Playing time" + playingTime + " Number of plays" + numPlays);
	return result;
	}
	
}