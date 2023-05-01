public class Playlist{
	//Attributes
	private String name;
	private Song [] songList;

	//Constructor
	public Playlist(String name, Song[] songList){
		this.name = name;
		this.songList = songList;

	}
	public void viewPlaylist(){
		System.out.format("+---------------------------------+---------------------------+------+%n");
		System.out.format("|" + this.name + "%n");
		System.out.format("+---------------------------------+---------------------------+------+%n");
		System.out.format("| # | TITLE                       | ALBUM                     | TIME |%n");
		System.out.format("+---------------------------------+---------------------------+------+%n");
		for(int i = 0; i < this.songList.length; i++){
        	System.out.printf("| %-2d| %-28s| %-26s| %-5s|\n", i + 1, this.songList[i].getName(), this.songList[i].getAlbum(), this.songList[i].getLength() );
			System.out.printf("| %-2s| %-28s| %-26s| %-5s|\n", "", this.songList[i].getArtist(), "", "", "" );
			System.out.format("+---------------------------------+---------------------------+------+%n");
		

		}
	}
}