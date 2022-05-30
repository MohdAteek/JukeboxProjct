package jukebox_package;

public class Tracks
{
	int songId;
	String trackName;
	String duration;
	String trackType;
	String url;
	int playListId;
	
	//Getter And Setter Methods
	
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTrackType() {
		return trackType;
	}
	public void setTrackType(String trackType) {
		this.trackType = trackType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPlayListId() {
		return playListId;
	}
	public void setPlayListId(int playListId) {
		this.playListId = playListId;
	}
	
	//parameterized constructor
	public Tracks(int songId, String trackName, String duration, String trackType, String url, int playListId) {
		super();
		this.songId = songId;
		this.trackName = trackName;
		this.duration = duration;
		this.trackType = trackType;
		this.url = url;
		this.playListId = playListId;
	}
	
	//Default Constructor
	public Tracks()
	{
		
	}
	@Override
	public String toString() {
		return "Tracks [songId=" + songId + ", trackName=" + trackName + ", duration=" + duration + ", trackType="
				+ trackType + ", url=" + url + ", playListId=" + playListId + "]";
	}
	
	
	
	
}
