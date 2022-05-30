package jukebox_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Podcast_Operation 
{
	Connection connection;
	public List<Podcast> fetchPodcastDetails() throws ClassNotFoundException, SQLException
	{
		List<Podcast> podcastDetails=new ArrayList<Podcast>();
		connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement("select podcastID,episode_Name,Celebrity_Name,URL,DateofPublish,"
				+ "podcast_name from podcastdetail inner join podcast using (podcastID)");
		
		
		ResultSet rs=prd.executeQuery();
		while(rs.next())
		{
			podcastDetails.add(new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getDate(5),rs.getString(6)));
		}
		return podcastDetails;
	}


	//Method for searching Podcast by Episode Name
	
	public List<Podcast> searchByEpisodeName(List<Podcast> podcastDetails, String episodeName)
	{
		return podcastDetails.stream().filter(p->p.getEpisodeName().startsWith(episodeName.toUpperCase()))
				.collect(Collectors.toList());
	}

	//Method for searching Podcast by Celebrities Name
	
	public List<Podcast> searchByCelebrities(List<Podcast> podcastDetails, String celebritieName)
	{
		return podcastDetails.stream().filter(p->p.getCelebrity_Name().startsWith(celebritieName.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	//Method for searching Podcast by Podcast Name
	
	public List<Podcast> searchByPodcastName(List<Podcast> podcastDetails, String podcastName)
	{	
		return podcastDetails.stream().filter(p->p.getPodcast_name().startsWith(podcastName.toUpperCase()))
				.collect(Collectors.toList());
	}

	//Method for display Podcast
	
	public void displayPodcastDetails(List<Podcast> podcastDetails)
	{
		displayHeaderPodcast();
		
		podcastDetails.forEach(Podcast::displayPodcast);
	}


	private void displayHeaderPodcast() {
		// TODO Auto-generated method stub
		
	}
 
	}

