package jukebox_package;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class DAO_Podcast
{
	 public void podcast() throws ClassNotFoundException, SQLException
	 {
		 Scanner scanner=new Scanner(System.in);
		 
		 Podcast_Operation podcast_Operation=new Podcast_Operation();
		 
		 List<Podcast>podcastDetails=new ArrayList<Podcast>();
		    podcastDetails=podcast_Operation.fetchPodcastDetails();
		    podcast_Operation.displayPodcastDetails(podcastDetails);
		    
		    
		    System.out.println("4) Search Podcast by Episode Name");
		    System.out.println("5) Search Podcast by celebrities");
		    System.out.println("6) Search Podcast by  Podcast Name ");
		    
		    int choice=0;
		    switch(choice)
		    {
		    	case 4:
		    		scanner.nextLine();
		    		System.out.print("Enter Episode Name : ");
		    		String episodeName=scanner.nextLine();
		    		List<Podcast>nameList=podcast_Operation.searchByEpisodeName(podcastDetails,episodeName);
		    		podcast_Operation.displayPodcastDetails(podcastDetails);
		    		break;
		    		
		    	case 5:
		    		scanner.nextLine();
		    		System.out.print("Enter Celebritie Name : ");
		    		String celebritieName=scanner.nextLine();
		    		List<Podcast>celebritieList=podcast_Operation.searchByCelebrities(podcastDetails,celebritieName);
		    		podcast_Operation.displayPodcastDetails(podcastDetails);
		    		break;
		    	case 6:
		    		scanner.nextLine();
		    		System.out.print("Enter Podcast Name : ");
		    		String podcastName=scanner.nextLine();
		    		List<Podcast>podcastNameList=podcast_Operation.searchByPodcastName(podcastDetails,podcastName);
		    		podcast_Operation.displayPodcastDetails(podcastDetails);
		    		break;
		    }
	 }
}