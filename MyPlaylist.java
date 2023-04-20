
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class MyPlaylist{
	public static void main(String[] args)throws IOException{
	// Instatiate the scanner
	Scanner keyboard = new Scanner(System.in);
	//Instance created for FileReader class
	FileReader songReader = new FileReader();
	//Initializing the variables
	boolean isOption = true;
	int  menuSelection = 0;
	String playlistName ="";
	String deletePlaylist ="";
	int userOption = 0;
	//menuSelection = keyboard.nextInt();
	// keyboard.nextLine();
	

		while(isOption){
			displayMenu();
			menuSelection = keyboard.nextInt();
			//menuSelection = keyboard.nextInt();
			// options for the playlist
			if(menuSelection == 1){
				System.out.println("Enter the name of the playlist.");
				keyboard = new Scanner(System.in);
				playlistName = keyboard.nextLine();
				songReader.createPlaylist(playlistName);

			}else if(menuSelection == 2){
				//flushing the scanner
				keyboard.nextLine();
				System.out.println("Enter name of the playlist in order to add song.");
				playlistName = keyboard.nextLine();
				//boolean for the songReader
				boolean playlistExist = songReader.checkPlaylistExistance(playlistName);
				if(!playlistExist){
					System.out.println("Playlist does not exist.");
				}else{
					System.out.println("Please look for the song you want to add to " + playlistName + " in the song directory.");
					songReader.displaySongDirectory();
					System.out.println("Please enter the song number.");
					userOption = keyboard.nextInt();
					songReader.addSongToPlaylist(playlistName,userOption);


				}
			}else if(menuSelection == 5 ){
				//flushing the scanner
				keyboard.nextLine();
				System.out.println("Closing playlist...." + "Beep Boop Beep..." +"\nHave a nice day!" + "\nBye Bye!");
				isOption = false;

			}else if (menuSelection == 3 ){
				//flushing the scanner
				keyboard.nextLine();
				System.out.println("Enter the name of the playlist to view.");
				//keyboard.nextLine();
				String user = keyboard.nextLine();
				boolean playExist = songReader.checkPlaylistExistance(user);
				if(playExist){
					Song [] songList = songReader.readPlaylist(playlistName);
					Playlist playlistsReader = new Playlist(playlistName, songList);
					playlistsReader.viewPlaylist();
				}else{
					System.out.println(playlistName + "doesn't exist");
				}

			}else if(menuSelection == 4){
				//flushing the scanner
				keyboard.nextLine();
				System.out.println("Enter the name of the playlist you wish to delete.");
				playlistName = keyboard.nextLine();
				System.out.println("Are youu sure you want to delete " + playlistName + " ?" + " This can't be undone." + " Enter YES if you wish to continue.");
				deletePlaylist = keyboard.nextLine();
				if(deletePlaylist.equals("yes")){
					songReader.deletePlaylist(playlistName);
				}
			}
		}	
		//keyboard.close();		

	}//END Main
	public static void displayMenu(){
		

		System.out.println("What would you like to do today?"+ "\n1.Create a new playlist" 
		+ "\n2.Add a song to playlist" + "\n3.View playlist" + "\n4.Delete Playlist" 
		+ "\n5.Close application");
		
	}//END Display Menu 
}