package jukebox_package;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sound.midi.VoiceStatus;

import com.mysql.cj.exceptions.RSAException;

public class PlaylistOpration 
{

	Connection connection;
	public List<Tracks> retriveSongs() throws ClassNotFoundException, SQLException
	{
		List<Tracks>songsadd=new ArrayList<Tracks>();
		
		connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement("select * from Arhan");
		ResultSet rs=prd.executeQuery();
		while(rs.next())
		{
			Tracks tracks=new Tracks(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6));
			songsadd.add(tracks);
		}
		return songsadd;
	}
	
	List<Tracks> allSongs() throws ClassNotFoundException, SQLException
	{
		List<Tracks> trackList=new ArrayList<Tracks>();
		connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement("select songid,SongName,SongDuration,GenreName,URL,artistID"
				+ " from song inner join artist using (artistID)");
		ResultSet rs=prd.executeQuery();
		while(rs.next())
		{
			Tracks tracks=new Tracks(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6));
			
			trackList.add(tracks);
		}
		
		return trackList;
	}

	public List<Tracks> addSongToPlayList(List<Tracks> converSongIntoTrack, int songid)
	{
		List<Tracks>addSongList=new LinkedList<Tracks>();
		addSongList.addAll(converSongIntoTrack.stream().filter(s->s.getSongId()==songid).collect(Collectors.toList()));
		System.out.println("Song Added Successfully");
		return addSongList;
	}

	public void addSongInPlayList(List<Tracks> addedSong, String string) throws ClassNotFoundException, SQLException
	{	
		connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement("insert into "+string+" (songId,songName,songDuration,url,songType,playlistID)values(?,?,?,?,?,?)");
	
		prd.setInt(1, addedSong.stream().collect(Collectors.toList()).get(0).getSongId());
		prd.setString(2, addedSong.stream().collect(Collectors.toList()).get(0).getTrackName());
		prd.setString(3,addedSong.stream().collect(Collectors.toList()).get(0).getDuration());
		prd.setString(4,addedSong.stream().collect(Collectors.toList()).get(0).getUrl());
		prd.setString(5, addedSong.stream().collect(Collectors.toList()).get(0).getTrackType());
		prd.setInt(6,addedSong.stream().collect(Collectors.toList()).get(0).getPlayListId());
		prd.execute();
	}
	
	//----------------------Adding Podcast------------------------\\
	
	List<addPodcastPojo> allPodcast() throws ClassNotFoundException, SQLException
	{
		connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement
	("select podcastID,podcast_name,url,Celebrity_Name from podcast inner join podcastdetail using(podcastID)");
		
				
		ResultSet resultSet=prd.executeQuery();
		List<addPodcastPojo>podcastList=new ArrayList<addPodcastPojo>();
		while(resultSet.next())
		{
			addPodcastPojo podcast=new addPodcastPojo(resultSet.getInt(1),resultSet.getString(2)
					,resultSet.getString(3),resultSet.getString(4));
			
			podcastList.add(podcast);
		}
		return podcastList;
	}

	public List<addPodcastPojo> findPodcastByID(List<addPodcastPojo> convertPodcastIntoTrack, int podcastID)
	{
		List<addPodcastPojo>addPodcastInList=new ArrayList<addPodcastPojo>();
		

		addPodcastInList.addAll(convertPodcastIntoTrack.stream().filter(p->p.getPodcastId()==podcastID).collect(
				Collectors.toList()));
		
		addPodcastInList.forEach(i->System.out.println(i));
		
		return addPodcastInList;
	}

	public void addPodcastInPlayList(List<addPodcastPojo> addedPodcast, String string) throws ClassNotFoundException, SQLException
	{
		connection=Connection_Config.getConnection();
		
	PreparedStatement prd=connection.prepareStatement
			("insert into "+string+" (songId,songName,url,songType)values(?,?,?,?)");
		
		prd.setInt(1, addedPodcast.stream().collect(Collectors.toList()).get(0).getPodcastId());
		prd.setString(2, addedPodcast.stream().collect(Collectors.toList()).get(0).getPodcastName());
		prd.setString(3,addedPodcast.stream().collect(Collectors.toList()).get(0).getUrl());
		prd.setString(4,addedPodcast.stream().collect(Collectors.toList()).get(0).getCelebrity());
		prd.execute();
	}
	
	//Playing Song
		public String playSong(List<Tracks>playList,int id)
		{
			return playList.stream().filter(s->s.getSongId()==id).collect(Collectors.toList()).get(0).getUrl();
		}
		
	//	playing podcast
	
		public String playPodcast(List<addPodcastPojo> allPodcast, int podID) {
			return allPodcast.stream().filter(p->p.getPodcastId()==podID).collect(Collectors.toList()).get(0).getUrl();
		}
		
		public String existingPlay(List<Tracks> list,int id)
		{
			return list.stream().filter(p->p.getSongId()==id).collect(Collectors.toList()).get(0).getUrl();
		}
		
}
