package jukebox_package;

import java.awt.Choice;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DAO_Song_And_Podcast 
{
	Connection connection;
	public void songAndPodcast() throws ClassNotFoundException, SQLException
	{
		Scanner scanner=new Scanner(System.in);
		songOperation operation=new songOperation();
	
		List<Song> songDetails=new ArrayList<Song>();
	    songDetails=operation.fetchData();
	    operation.displaySongs(songDetails);
	    
	    Podcast_Operation podcast_Operation=new Podcast_Operation();
		 
		 List<Podcast>podcastDetails=new ArrayList<Podcast>();
		    podcastDetails=podcast_Operation.fetchPodcastDetails();
		    podcast_Operation.displayPodcastDetails(podcastDetails);
		    
	    String x;
	   do{
		   System.out.println();
		    System.out.println("1) Search song by Artist");
		    System.out.println("2) Search song by Genre");
		    System.out.println("3) Search song by Album");
		    System.out.println("4) Search Podcast by Episode Name");
		    System.out.println("5) Search Podcast by celebrities");
		    System.out.println("6) Search Podcast by  Podcast Name ");
		    System.out.println("10 for create a playList ");
		    System.out.println("11 for show Existing PlayList ");
		    System.out.println("12 for Live Streaming");
		    System.out.print("---------Press : ");
		    
		    int choice=scanner.nextInt();
		    
		 
		    switch(choice)
		    {
	    	case 1->
		    	{
		    			scanner.nextLine();
			    		System.out.print("Enter Artist Name : ");
			    		String artistName=scanner.nextLine();
			    		List<Song> artistList=operation.songByArtist(songDetails,artistName);
			    		operation.displaySongs(artistList);
		    	}
		    	case 2->
		    	{
		    		
		    			scanner.nextLine();
			    		System.out.print("Enter Genree Type : ");
			    		String genre=scanner.nextLine();
			    		List<Song>genreList=operation.songBygenret(songDetails,genre);
			    		operation.displaySongs(genreList);
			    
		    	}
		    	case 3->
		    	{
		    		scanner.nextLine();
		    		System.out.print("Enter Album Name : ");
		    		String album=scanner.nextLine();
		    		List<Song>albumList=operation.songByAlbum(songDetails,album);
		    		operation.displaySongs(albumList);
		    	}
		    	case 4->
		    	{
		    		scanner.nextLine();
		    		System.out.print("Enter Episode Name : ");
		    		String episodeName=scanner.nextLine();
		    		List<Podcast>nameList=podcast_Operation.searchByEpisodeName(podcastDetails,episodeName);
		    		podcast_Operation.displayPodcastDetails(nameList);		    		
		    	}
		    	case 5->
		    	{
		    		scanner.nextLine();
		    		System.out.print("Enter Celebritie Name : ");
		    		String celebritieName=scanner.nextLine();
		    		List<Podcast>celebritieList=podcast_Operation.searchByCelebrities(podcastDetails,celebritieName);
		    		podcast_Operation.displayPodcastDetails(celebritieList);
		    	}
		    	case 6->
		    	{
		    		scanner.nextLine();
		    		System.out.print("Enter Podcast Name : ");
		    		String podcastName=scanner.nextLine();
		    		List<Podcast>podcastNameList=podcast_Operation.searchByPodcastName(podcastDetails,podcastName);
		    		podcast_Operation.displayPodcastDetails(podcastNameList);
		    	}
		    	case 10->makePlayList();
		    	case 11->showExistingTables();
		    	case 12->liveStreaming();
		    	
		    }  
		    	System.out.print("want to continue type (Y/N) : ");
		    	x=scanner.next();
		    	if(x.equalsIgnoreCase("N"))
		    	{
		    		Driver driver=new Driver();
		    		driver.mainMethod();
		    	}
		    	 System.out.print("Type : ");
	    }while(x.equalsIgnoreCase("Y"));  
	  }
	
	//Make a new PlayList
	public void makePlayList() throws ClassNotFoundException, SQLException
	{
		Scanner scanner=new Scanner(System.in);
   		DAO_Playlist dao_Playlist=new DAO_Playlist();
   		System.out.println("Enter Playlist name : ");
		String playlistName=scanner.next();
		dao_Playlist.createPlaylist(playlistName);
   	}
	
	//Oper List of Existing PlayList
	
	private List<playingMusicPojo> showExistingTables() throws ClassNotFoundException, SQLException
	{
		List <playingMusicPojo>existingList =new LinkedList<playingMusicPojo>();
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("Want to show the Details Of Any PlayList : (yes/no)");
		String choiString=scanner.next();
		if(choiString.equalsIgnoreCase("yes"))
		{
			System.out.print("Enter Play list Name :");
			String playListName=scanner.next();
			connection=Connection_Config.getConnection();
			PreparedStatement prd2=connection.prepareStatement("select * from ("+playListName+")" );
			
			ResultSet rs=prd2.executeQuery();
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.format(" %-10s  %-15s\t %-15s \t%-15s  %-15s\n",
					"Song ID","Song Name","Duration","Genre","Album");
			System.out.println("-------------------------------------------------------------------------------------------------");
			
			while(rs.next())
			{
				System.out.format(" %-10s  %-15s\t %-15s \t%-15s  %-15s\n",
						rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(5),rs.getString(6));
				
				existingList.add(new playingMusicPojo(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5), rs.getInt(6)) );
			}
			
/*----------------------------------Progress on Working--------------------------------------*/
			System.out.println("Want to play Songs to This Playlist (yes/no)");
			Driver driver=new Driver();
			String x=scanner.next();
			System.out.print("------Press");
			
			
			switch(x)
			{
				case "yes"->existingPlay();
				case "no"->driver.mainMethod();
			}
			
			
		}
		return existingList;	
	}
	//For Live Straming
	void liveStreaming()
	{
		PlaylistOpration paOpration=new PlaylistOpration();
		try
        {
			Scanner scanner=new Scanner(System.in);
			System.out.println("1 for Song");
			System.out.println("2 for Podcast");
			int choice=scanner.nextInt();
			switch(choice)
			{
				case 1->
				{
					System.out.print("Enter Song ID : ");
					int songID=scanner.nextInt();
					 SimpleAudio SAP = new SimpleAudio(paOpration.playSong(paOpration.allSongs(),songID));
			            SAP.play();
			            while (true)
			            {
			                SAP.playerOptionsDisplay();
			                SAP.userChoice(SAP.choose(),paOpration.playSong(paOpration.allSongs(),songID));
			            }
				}
				case 2->
				{
					System.out.print("Enter Podcast ID : ");
					int podID=scanner.nextInt();
					 SimpleAudio SAP = new SimpleAudio(paOpration.playPodcast(paOpration.allPodcast(),podID));
			            SAP.play();
			            while (true)
			            {
			                SAP.playerOptionsDisplay();
			                SAP.userChoice(SAP.choose(),paOpration.playPodcast(paOpration.allPodcast(),podID));
			            }
				}
			}
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
	}
	
	
	//User choice playList that is used for only user required
	
	void existingPlay()
	{
		PlaylistOpration playlistOpration=new PlaylistOpration(); 
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Song Id");
			int id=sc.nextInt();
			SimpleAudio SAP = new SimpleAudio(playlistOpration.existingPlay(playlistOpration.allSongs(),id));
            SAP.play();
            while (true)
            {
                SAP.playerOptionsDisplay();
                SAP.userChoice(SAP.choose(),playlistOpration.existingPlay(playlistOpration.allSongs(),id));
            }
		}
		catch(Exception ex)
		{
			 System.out.println("Error with playing sound.");
	            ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
