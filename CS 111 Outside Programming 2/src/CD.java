public class CD extends Audio{
	private String[] tracks;
	private int numTracks;
	
	public String playMedia(){
		String playingMedia = "Now playing " + title + "With a playtime of: " + playingTime;
		numPlays++;
		return playingMedia;
	}
	
	public CD(String[] tracks, int numTracks, String producer, String title, String majorArtist, 
			Double playingTime, int numPlays, String[] groupMembers, int numMembers){
		super(groupMembers, numMembers, producer, title, majorArtist, numPlays, playingTime);
		this.tracks = tracks;
		this.numTracks = numTracks;
		
	}
	
	public String toString(){
		String result;
		result = "Tracklist: " + tracks + "\n" + "Number of tracks: " + numTracks;
		return result;
	}	
}