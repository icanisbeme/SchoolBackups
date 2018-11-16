import java.util.Date;

public abstract class Artist extends Media{
	private String last;
	private String first;
	private Date birthDay;
	private String twitterHandle;
	private String url;
	public Artist(String last, String first, Date birthDay, String twitterHandle, String url, String title,
			String majorArtist, Double playingTime, int numPlays){
		super(title, majorArtist, playingTime, numPlays);
		this.last = last;
		this.first = first;
		this.birthDay = birthDay;
		this.twitterHandle = twitterHandle;
		this.url = url;
	}
	public String getLast(){
		return last;
	}
	public String getFirst(){
		return first;
	}
	public Date getBirthDay(){
		return birthDay;
	}
	public String getTwitter(){
		return twitterHandle;
	}
	public String getUrl(){
		return url;
	}
	public String toString(){
		String ArtistInfo = "Artist Name: " + first + " " + last + " Artist Birthday: " + birthDay
				+ " Artist Twitter Handle: " + twitterHandle + "Artist Website: " + url;
		return ArtistInfo;
	}
}