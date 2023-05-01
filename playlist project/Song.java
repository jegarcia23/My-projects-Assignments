public class Song{
	//Attributes
	private String name;
	private String artist;
	private String album;
	private String length;

	//Constructor
	public Song(String name, String artist,String album, String length){
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.length = length;

	}
	public String getName(){
		return this.name;
	}
	public String getArtist(){
		return this.artist;
	}	 
	public String getAlbum(){
		return this.album;
	}
	public String getLength(){
		return this.length;
	}

}	