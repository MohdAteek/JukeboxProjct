package jukebox_package;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new  Scanner(System.in);
		System.out.print("Enter ID :");
		int id=sc.nextInt();
		System.out.print("Enter Password : ");
		String pass=sc.next();
		if(id==007 && pass.equalsIgnoreCase("bond"));
		{
			System.out.println("\t\t\t|--------------------------------------------------------------------------|");
			System.out.println("\t\t\t ---------------------     WELCOME TO JUKEBOX      ---------------------- ");
			System.out.println("\t\t\t|--------------------------------------------------------------------------|");
			Scanner scanner=new Scanner(System.in);
			System.out.println("\t\t\t\t\tPress 1 For Show All the Songs And Podcasts");
			
			System.out.print("---------Press : ");
			
			int num=scanner.nextInt();
			
			if(num==1)
			{
				DAO_Song_And_Podcast dao_Song=new DAO_Song_And_Podcast();
				dao_Song.songAndPodcast();
			}
		}
	}
	void mainMethod() throws ClassNotFoundException, SQLException
	{
		System.out.println("\t\t\t|--------------------------------------------------------------------------|");
		System.out.println("\t\t\t ---------------------     WELCOME TO JUKEBOX      ---------------------- ");
		System.out.println("\t\t\t|--------------------------------------------------------------------------|");
		Scanner scanner=new Scanner(System.in);
		System.out.println("\t\t\t\t\tPress 1 For Show All the Songs And Podcasts");
		
		System.out.print("---------Press : ");
		
		int num=scanner.nextInt();
		
		if(num==1)
		{
			DAO_Song_And_Podcast dao_Song=new DAO_Song_And_Podcast();
			dao_Song.songAndPodcast();
		}
		
	}
		
	
	
	
	
	//For dry run purpose
	
	
	/*public static void main(String[] args) 
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
					 SimpleAudio SAP = new SimpleAudio(paOpration.play(paOpration.allSongs(),songID));
			            SAP.play();
			            while (true)
			            {
			                SAP.playerOptionsDisplay();
			                SAP.userChoice(SAP.choose(),paOpration.play(paOpration.allSongs(),songID));
			            }
				}
				case 2->
				{
					System.out.print("Enter Podcast ID : ");
					int podID=scanner.nextInt();
					 SimpleAudio SAP = new SimpleAudio(paOpration.play(paOpration.allSongs(),podID));
			            SAP.play();
			            while (true)
			            {
			                SAP.playerOptionsDisplay();
			                SAP.userChoice(SAP.choose(),paOpration.play(paOpration.allSongs(),podID));
			            }
				}
			}
			
           // SimpleAudio SAP = new SimpleAudio(paOpration.play(paOpration.allSongs(),2));
            //SAP.play();
            //while (true)
            //{
              //  SAP.playerOptionsDisplay();
                //SAP.userChoice(SAP.choose(),paOpration.play(paOpration.allSongs(),2));
            //}
        //}
        //catch (Exception ex)
        //{
          //  System.out.println("Error with playing sound.");
            //ex.printStackTrace();
        //}
	}*/
}
