package jukebox_package;

import java.sql.Date;

public class Podcast 
{
	int id;
	String episodeName;
	String Celebrity_Name;
	String url;
	Date DateofPublish;
	String podcast_name;
	
	//Getter And Setter Methods
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEpisodeName() {
		return episodeName;
	}
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	public String getCelebrity_Name() {
		return Celebrity_Name;
	}
	public void setCelebrity_Name(String celebrity_Name) {
		Celebrity_Name = celebrity_Name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDateofPublish() {
		return DateofPublish;
	}
	public void setDateofPublish(Date dateofPublish) {
		DateofPublish = dateofPublish;
	}
	public String getPodcast_name() {
		return podcast_name;
	}
	public void setPodcast_name(String podcast_name) {
		this.podcast_name = podcast_name;
	}
	
	//Constructor
	
	public Podcast(int id, String episodeName, String celebrity_Name, String url, Date dateofPublish,
			String podcast_name) {
		super();
		this.id = id;
		this.episodeName = episodeName;
		Celebrity_Name = celebrity_Name;
		this.url = url;
		DateofPublish = dateofPublish;
		this.podcast_name = podcast_name;
	}
	
	//default Constructor
	
	public Podcast()
	{
		
	}
	//Display method for podcast
	
	public void  displayPodcast()
	{
		System.out.format(" %-10s  %-15s\t %-15s \t%-15s  %-15s\n",
				this.getId(),this.getEpisodeName(),this.getCelebrity_Name(),this.getDateofPublish()
				,this.getPodcast_name());		
	}
}
