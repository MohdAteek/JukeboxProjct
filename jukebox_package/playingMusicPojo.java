package jukebox_package;

public class playingMusicPojo
{
	int id;
	String songNameS;
	String songDuration;
	String url;
	String songType;
	int playlistID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongNameS() {
		return songNameS;
	}
	public void setSongNameS(String songNameS) {
		this.songNameS = songNameS;
	}
	public String getSongDuration() {
		return songDuration;
	}
	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSongType() {
		return songType;
	}
	public void setSongType(String songType) {
		this.songType = songType;
	}
	public int getPlaylistID() {
		return playlistID;
	}
	public void setPlaylistID(int playlistID) {
		this.playlistID = playlistID;
	}
	public playingMusicPojo(int id, String songNameS, String songDuration, String url, String songType,
			int playlistID) {
		super();
		this.id = id;
		this.songNameS = songNameS;
		this.songDuration = songDuration;
		this.url = url;
		this.songType = songType;
		this.playlistID = playlistID;
	}
	@Override
	public String toString() {
		return "playingMusicPojo [id=" + id + ", songNameS=" + songNameS + ", songDuration=" + songDuration + ", url="
				+ url + ", songType=" + songType + ", playlistID=" + playlistID + "]";
	}
	
	

}
