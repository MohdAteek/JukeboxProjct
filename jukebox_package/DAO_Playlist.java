package jukebox_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DAO_Playlist
{
	Connection connection;
	public void createPlaylist(String tableName) throws ClassNotFoundException, SQLException
	{
		String tablename=tableName;
		Connection connection=Connection_Config.getConnection();
		PreparedStatement prd=connection.prepareStatement("insert into playlist(PlaylistName) values (?)");
		prd.setString(1, tableName);
		prd.execute();
		System.out.println(tablename+" PlayList Create Successfully !");
		prd.close();
		//connection.close();
		//ResultSet resultSet=prd.executeQuery();
		
		
		PreparedStatement preparedStatement=connection.prepareStatement("use jukeBox");
		preparedStatement.execute();
		
		String playlistQuery="create table "+tablename+"(songId int primary key auto_increment,\r \n"
				+ "songName varchar(30) not null, songDuration time,url tinytext,\r \n"
				+ "songtype tinytext,playlistID int ,\r \n"
				+ "foreign key(playlistID)references playlist(playlistID))auto_increment=101";
		
		PreparedStatement preparedStatement2=connection.prepareStatement(playlistQuery);
		preparedStatement2.execute();
		System.out.println(tablename+"PlayList Structure Create Successfully ! ");
		
		
		String x;
		do {
			
		
		
			
			
		System.out.println("1 for add song");
		System.out.println("2 for add podcasts");
		System.out.println("4 for show Existating Table");
		System.out.println("3 for Play the Song");
		System.out.println("-------press : ");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		switch(choice)
		{
			case 1->
			{
				PlaylistOpration playlistOpration=new PlaylistOpration();
				List<Tracks> songList=playlistOpration.retriveSongs();
				List<Tracks> converSongIntoTrack=playlistOpration.allSongs();
				
				
				
				System.out.print("Enter Song id : ");
				int songid=scanner.nextInt();
				List<Tracks> addedSong=playlistOpration.addSongToPlayList(converSongIntoTrack,songid);
				playlistOpration.addSongInPlayList(addedSong,tablename);
			}
			case 2->
			{
				PlaylistOpration playlistOpration=new PlaylistOpration();
				List<Tracks> songList=playlistOpration.retriveSongs();
				List<addPodcastPojo> convertPodcastIntoTrack=playlistOpration.allPodcast();
				
				System.out.print("Enter Podcast id : ");
				int podcastid=scanner.nextInt();
				List<addPodcastPojo> addedPodcast=playlistOpration.findPodcastByID(convertPodcastIntoTrack,podcastid);
				playlistOpration.addPodcastInPlayList(addedPodcast,tablename);
			}
			
			case 3->
			{
				playMusic();
			}
			case 4->showExistingTables();
			
		}
		
		System.out.print("want to add more Song or Podcast (yes/No) : ");
    	x=scanner.next();
    	if(x.equalsIgnoreCase("no"))
    	{
    		DAO_Song_And_Podcast d=new DAO_Song_And_Podcast();
    		d.songAndPodcast();
    	}
		
		} while (x.equalsIgnoreCase("yes"));
		preparedStatement2.close();
	}
	
	//Show Contant in Existing tables 
	
	private void showExistingTables() throws ClassNotFoundException, SQLException
	{
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
			while(rs.next())
			{
				System.out.format(" %-10s  %-15s\t %-15s \t%-15s  %-15s\n",
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6));
			}
		}	
	}
	
	//Foe Playing Music

	public void playMusic()
	{
		PlaylistOpration paOpration=new PlaylistOpration();
		try
        {
			Scanner scanner=new Scanner(System.in);
			System.out.print("Enter Song ID : ");
			int songID =scanner.nextInt();
            SimpleAudio SAP = new SimpleAudio(paOpration.playSong(paOpration.allSongs(),songID));
            SAP.play();
            while (true)
            {
                SAP.playerOptionsDisplay();
                SAP.userChoice(SAP.choose(),paOpration.playSong(paOpration.allSongs(),songID));
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
	}	
}
