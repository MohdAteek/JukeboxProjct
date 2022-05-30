package jukebox_package;

public class Song 
{
	int songId;
	String songName;
	String SongDuration;
	String genre;
	String url;
	String albumName;
	String artistName;
	
	
	//Getter And Setter Methods
	
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongDuration() {
		return SongDuration;
	}
	public void setSongDuration(String songDuration) {
		SongDuration = songDuration;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	//constructor
	
	public Song(int songId, String songName, String songDuration, String genre, String url, String albumName,
			String artistName) {
		
		this.songId = songId;
		this.songName = songName;
		this.SongDuration = songDuration;
		this.genre = genre;
		this.url = url;
		this.albumName = albumName;
		this.artistName = artistName;
	}
	
//Default Constructor
	public Song()
	{
		
	}
	
	
	//Display Methods For Songs
	
	public void display()
	{
		System.out.format("%-15s %-20s\t %-15s %-15s %-15s  %-15s\n",this.getSongId(),
				this.getSongName(),this.getSongDuration(),this.getGenre(),this.getAlbumName(),this.getArtistName());
		
		
	}
}
