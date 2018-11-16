
public abstract class Audio extends Media{
	private String[] groupMembers;
	private int numMembers;
	private String producer;
	
	public Audio(String[] groupMembers, int numMembers, String producer, String title, 
			String majorArtist, int numPlays, Double playingTime){
		super(title, majorArtist, playingTime, numPlays);
		this.groupMembers = groupMembers;
		this.numMembers = numMembers;
		this.producer = producer;
	}
	
	public abstract String playMedia();
	
	public String[] getGroupMembers(){
		return groupMembers;
	}
	public int getNumMembers(){
		return numMembers;
	}
	public String getProducer(){
		return producer;
	}
	
	public String toString(){
		String result;
		result = "Group Members: " + groupMembers + "\n" +
				 "Number of Members: " + numMembers + "\n" +
				 "Producer: " + producer + "\n";
		return result;
	}
	
}
