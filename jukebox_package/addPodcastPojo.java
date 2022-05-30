package jukebox_package;

public class addPodcastPojo
{
	int podcastId;
	String podcastName;
	String url;
	String celebrity;
	public int getPodcastId() {
		return podcastId;
	}
	public void setPodcastId(int podcastId) {
		this.podcastId = podcastId;
	}
	public String getPodcastName() {
		return podcastName;
	}
	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCelebrity() {
		return celebrity;
	}
	public void setCelebrity(String celebrity) {
		this.celebrity = celebrity;
	}
	public addPodcastPojo(int podcastId, String podcastName, String url, String celebrity) {
		super();
		this.podcastId = podcastId;
		this.podcastName = podcastName;
		this.url = url;
		this.celebrity = celebrity;
	}
	

	public addPodcastPojo()
	{
		
	}
	@Override
	public String toString() {
		return "addPodcastPojo [podcastId=" + podcastId + ", podcastName=" + podcastName + ", url=" + url
				+ ", celebrity=" + celebrity + "]";
	}
}
