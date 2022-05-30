package jukebox_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import com.mysql.cj.exceptions.RSAException;

public class Playlist
{
	String playlistName;

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public Playlist()
	{
		
	}		
}
