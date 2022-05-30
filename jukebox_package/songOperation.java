package jukebox_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class songOperation
{
	
	Connection connection;
	public List<Song> fetchData() throws ClassNotFoundException, SQLException
	{
		List<Song>songsList=new ArrayList<Song>();
		connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement("select songid,SongName,SongDuration,GenreName,URL,AlbumName,Artistname"
				+ " from song inner join artist using (artistID)");	
		ResultSet rs=prd.executeQuery();
		while(rs.next())
		{
			songsList.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
					,rs.getString(6),rs.getString(7)));
		}
		
		return songsList;
	}
	
	//Method for searching song by Artist Name
	
	public List<Song> songByArtist(List<Song> songDetails, String artistName)
	{		
		return songDetails.stream().filter(s->s.getArtistName().startsWith(artistName.toUpperCase()))
				.collect(Collectors.toList());
	}

	//Method for searching song by Genre Name
	
	public List<Song> songBygenret(List<Song> songDetails, String genre)
	{
		return songDetails.stream().filter(s->s.getGenre().startsWith(genre.toUpperCase()))
				.collect(Collectors.toList());
	}

	//Method for searching song by Album Name
	public List<Song> songByAlbum(List<Song> songDetails, String album)
	{
		return songDetails.stream().filter(s->s.getAlbumName().startsWith(album.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	//Method for displaying the songs
	public  void displaySongs(List<Song> songsList)
	{
		displayHeader();
		
		songsList.forEach(Song::display);
	}
	
	

	
	public  void displayHeader()
	{
		System.out.println("-------------------------------------------------SONGS------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.format("%-15s %-20s\t %-15s %-15s %-15s  %-15s\n",
				"Song ID","Song Name","Duration","Genre","Album Name","Artist Name");
		System.out.println();
System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
	}
}
