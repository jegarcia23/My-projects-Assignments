
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
// ----------------------------------- 

public class CL2_Garcia{
	public static void main(String [] args){
		Scanner scnr = new Scanner(System.in);

		boolean isCommand = true;
		String commandOption = "";
		String [] requestList = null;
		int length = 0;
		welcomeHeader("blabber-header.txt");
		//traversing while loop for the command.
		while (isCommand){

			System.out.println("Give a command, or type [quit] to exit, or type [help] to see all commands and their descriptions");
			commandOption = scnr.nextLine();
			requestList = commandOption.split(" ",3);
			length = requestList.length;
			if(length == 1 ){
				if (requestList[0].equals("help")){
					commandList();

				}else if (requestList[0].equalsIgnoreCase("quit")){
					isCommand = false;
				}else if (requestList[0].equalsIgnoreCase("CreateAccount")){
					System.out.println("CreateAccount missing arguments.");
				}else if (requestList[0].equalsIgnoreCase("FollowAccount")){
					System.out.println("FollowAccount missing arguments");
				}else if (requestList[0].equalsIgnoreCase("PostBlab")){
					System.out.println("PostBlab missing arguments");
				}else if(requestList[0].equalsIgnoreCase("ViewTimeline")){
					System.out.println("ViewTimeline missing arguments.");
				}else{
					System.out.println(commandOption + "doesn't exist.");
				}




			}else if (length == 2){
				if(requestList[0].equalsIgnoreCase("CreateAccount")){
					if (createAccount(requestList[1]) == 0){
						System.out.println("Success: " + requestList [1] + " account created.");
					}else if (createAccount(requestList[1]) == 1){
						System.out.println("Error: " + requestList[1] + " account already exist.");
					}else if (createAccount(requestList[1]) == 2){
						System.out.println("Error: " + requestList[1] + " is not alphanumeric.");
					}else {
						System.out.println("Invalid Entry:");
					}
				}else if(requestList[0].equalsIgnoreCase("ViewTimeline")){
					if(viewTimeline(requestList[1]) == 0){
						System.out.println("Success ViewTimeline");
					}else if(viewTimeline(requestList[1]) == 1){
						System.out.println("Username doesn't exist or it's invalid.");
					}else if(viewTimeline(requestList[1]) == 2){
						System.out.println("You may want to consider following someone to view a timeline.");	
					}else{
						System.out.println("Invalid Entry");
					}
				}else{
					System.out.println(commandOption + "doesn't exist");
				}



			}else if (length >= 3){
				if(requestList[0].equalsIgnoreCase("FollowAccount")){
					if(followAccount(requestList [1],requestList[2]) == 0){
						System.out.println("Success: " + requestList [1] + " account has started following " + requestList[2]);
					}else if(followAccount(requestList[1],requestList[2]) == 1){
						System.out.println("Error: " + requestList[1] + " or " + requestList[2] + " is invalid or doesn't exist.");
					}else if(followAccount(requestList[1],requestList[2]) == 2){
						System.out.println("Error: " + requestList[1] + " is trying to follow themselves.");
					}else if(followAccount(requestList[1],requestList[2]) == 3){
						System.out.println(requestList[1] + " is already following " + requestList[2]);
					}else{
						System.out.println("Invalid entry");
					}


				}else if(requestList[0].equalsIgnoreCase("PostBlab")){
					int blab = postBlab(requestList[1],requestList[2]);
				 	
					 if(blab == 0){
					 	System.out.println("Success blab has posted");
					}else if(blab == 1){
						System.out.println(requestList[1] + " or " + requestList[2] + " doesn't exist or is invalid");
					}else{
						System.out.println("Blab couldn't be posted");
					}

				}


			}
		}
	}//END main
	/*
	 -------------------------------------------------------------------------------- FILE EXISTS  
	   This method will take a fileName as a parameter, and
	   return true if it exists, false otherwise.
	*/
	public static boolean fileExists( String fileName ){
		File file = new File (fileName + ".txt");
		if( file.exists()){
			return true;
		}
		return false;
	}//END fileExists

	/*	
	 -------------------------------------------------------------------------------- NUM LINES 
	   	This method will take a fileName as a parameter and return
	   	the number of lines this file has.
	   	** This method will make use of the following method:
	   		- fileExists()
	 */
	public static int numLines( String fileName ){
		int count = 0;
		if(fileExists(fileName)){

		 	try{
		 		File file = new File(fileName + ".txt");
		 		 Scanner scnr = new Scanner(file);
		 		while(scnr.hasNext()){
		 			scnr.nextLine();
		 			count ++;
		 		}

		 	}catch (IOException msg) {
		 		System.out.println("Error" + msg.getMessage());
		 	}
		 }
		 return count;

	}//END numLines
	/*
	 -------------------------------------------------------------------------------- READ FILE
	   	This method will take a fileName as a parameter and return an 
	   	array of Strings that stores each line in the file onto the array. 
	   	** This method will make use of the following methods:
		  	- fileExists()
		  	- numLines()
		Note: If the string array has a length of 0, simply return
		an empty array, as shown in the method.
	*/
	public static String [] readFile( String fileName ){
		int arrayCount = 0;
		String [] contents = new String[numLines(fileName)];
		if (fileExists(fileName)){

			try {
				File file = new File(fileName + ".txt");
				Scanner scnr = new Scanner (file);
				while (scnr.hasNextLine()){
					contents [arrayCount] = scnr.nextLine();
					arrayCount ++;
				}
			}catch (Exception errMsg){
				System.out.println("Error " + errMsg);
			}
		}
		return contents;

	}//END readFile
	/*
	 -------------------------------------------------------------------------------- ACCOUNT EXISTS
		This method will take a username as a parameter and return true if
		the username text file exists, false otherwise.
		** This method will make use of the following method:
		   	- fileExists()
	*/
	public static boolean accountExists(String username){
		File file = new File (username + ".txt");
		//checking to see if file exists
		if(file.exists()){
			return true;
		}else{
			return false;
		}
	}//END accountExists
	/*
      -------------------------------------------------------------------------------- IS ALPHANUMERIC
        This method will take a username as a parameter and check if it is
        alphanumeric. A phrase is alphanumeric if it only contains uppercase
        letters, lowercase letters, and numbers.
       Return true if the phrase is alphanumeric, false otherwise.

       Hint: You will use the following to help you:
           - Character.isUpperCase(char)
           - Character.isLowerCase(char)
           - Character.isDigit(char)
  */
	public static boolean isAlphanumeric( String username ) {
		char currentCharacter = ' ';
		boolean hasUpper = false, hasLower = false, hasDigit = false;
		//traversing loop for the alphanumeric 
		for(int i = 0; i < username.length(); i++){
			currentCharacter = username.charAt(i);

			if(Character.isUpperCase(currentCharacter)){
				hasUpper = true;
			}else if(Character.isLowerCase(currentCharacter)){
				hasLower = true;
			}else if(Character.isDigit(currentCharacter)){
				hasDigit = true;
			}else {
				return false;
			}
		}// END for loop
		if (hasUpper && hasLower && hasDigit){
			return true;
		}
		return false;
	}//END isAlphanumeric
	/*
  	 -------------------------------------------------------------------------------- CREATE ACCOUNT  
		This method will take a username as a parameter and either:
			- return 0 if the account is successfully created.
			- return 1 if an account already exists with the given username
			- return 2 if the username entered is invalid (not alphanumeric)
		This method will make use of the following methods:
			- accountExists()
			- isAlphanumeric()

		Hint: You will use the following to help you:
	 		- .createNewFile()

	 	************* DO NOT FORGET TO .close() PRINTWRITER!
	*/
	public static int createAccount(String username){
		//checking to see it account exist
		if (accountExists(username)){
			return 1;
		}
		//checking to see if is alphanumeric
		if (!isAlphanumeric(username)){
			return 2;

		}
		try{
			File file = new File (username + ".txt");
			file.createNewFile();
		}catch (IOException errMsg) {
			System.out.println("Couldn't create the file at this time.");
		}
		return 0;
	}//END createAccount
	/*
	 -------------------------------------------------------------------------------- FOLLOW ACCOUNT  
		This method will take username1 and username2. It will make 
		username1 follow username2.
			- Return 0 upon success.
	   		- Return 1 if either username doesnt exist or is invalid
	   		- Return 2 if a user is	trying to follow themselves
	   		- Return 3 if the user already follows the other user 

	   	This method will make use of the following methods:
	   		- accountExists()
	   		- readFile()

	   	NOTE: You must use the following class to append onto a file:
	   		- PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter (nameOfFile, true) ) )

	   	************* DO NOT FORGET TO .close() PRINTWRITER!
	*/
	public static int followAccount(String username, String usernameToFollow){
		if(!accountExists(username) || !accountExists(usernameToFollow)){
			return 1;
		}
		if(username.equals(usernameToFollow)){
			return 2;
		}
		Scanner scnr = null;
		File file = null;
		try{

			file = new File(username + ".txt");
			scnr = new Scanner (file);

			while(scnr.hasNext()){
				if(usernameToFollow.equals(scnr.nextLine())){
					return 3;
				}
			}	
			PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			pWriter.println(usernameToFollow);
			pWriter.close();
			scnr.close();
			return 0;
			
		
		}catch(IOException errMsg) {
			System.out.println("Their was an issue with the file");
			return -1;
		}
		//return -1;


	}//END followAccount
	/*
	-------------------------------------------------------------------------------- POST BLAB  
		This method will take a username and a blabMessage as a parameter
		and append the blabMessage into the blabs.txt file.
			- Return 0 upon success
	 		- Return 1 if the username doesn't exist or is invalid

	 	This method will make use of the following methods:
	 		- isAlphanumeric(),accountExist() 

	 	NOTE: You must use the following class to append onto a file:
	   		- PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter (nameOfFile, true) ) )

	   	//************* DO NOT FORGET TO .close() PRINTWRITER!
	*/
	public static int postBlab(String username, String blab){
		if(!accountExists(username) || !isAlphanumeric(username)){
			return 1;
		}
		File file = null;
		try{
			//file = new File (username + ".txt");
			file = new File("blabs.txt");
			PrintWriter pWriter = new PrintWriter( new BufferedWriter( new FileWriter(file, true)));
			pWriter.println(username + "-" + blab);
			//bSystem.out.println("------------------------------");
			pWriter.close();
			return 0;

		}catch(IOException errMsg){
			System.out.println("Issue in the file.");
			return -1;
		}
	}//END postBlab

	/*
	 -------------------------------------------------------------------------------- DISPLAY ARRAY 
		This method will take an array of strings containing the blabs
		from the blabs.txt file and an array of strings containing the
		names of the accounts a specific user follows.
		It will print out each element in the given array on it's own 
		line as shown on the assignment for viewTimeline.
	*/
	public static void displayArray(String[] blabs, String[] followedAccounts){
		//traversing blabs array
		for(int i = 0; i < blabs.length; i++){
			String [] divBlab = blabs[i].split("-");
			//traversing followedAccounts loop
			for(int j = 0; j < followedAccounts.length; j++){
				if(divBlab[0].equals(followedAccounts[j])){
					System.out.println(blabs[i]);
				}
			}

		}

	}//END displayArray
	/*
   -------------------------------------------------------------------------------- VIEW TIMELINE
      This method will take a username as a parameter and will display
      all the blabs this user follows in a timeline.
          - Return 0 upon success OR if the user is not following anyone (as it is still successfull)
              - if the user is not following anyone, display a message as such:
              >> You may want to consider following someone to view a timeline.
          - Return 1 if the username doesn't exist or is invalid

      This method will make use of the following methods:
          - accountExists()
          - readFile()
          - displayArray()
  */
	public static int viewTimeline(String username) {
		if(!accountExists(username)){
			return 1;
		}
		//if(username.equals("blabs.txt")){
			//return 2;
		//}
		welcomeHeader("timeline.txt");

		String[] blabs = readFile("blabs");

		String [] followedAccounts = readFile(username);

		displayArray(blabs,followedAccounts);

		return 0;
	}//END viewTimeline
	/*
 	----------------------------------------------- DO **NOT** DELETE OR
  	MODIFY THE CODE BELOW THIS LINE 
 	----------------------------------------------- */

	/*-------------------- APPEND BLAB */
	public static String [] appendBlab( String userInput){
		userInput = userInput.replace("\"", ""); //gets rid of quotations
		String [] blab = userInput.split(" ");

		String [] request = new String[3];
		request[0] = blab[0]; //store command in first position of request
		request[1] = blab[1]; //stores username in second position of request
		request[2] = "";

		//Ignore first position as that contains the command
		for( int i = 2; i < blab.length; i++ ){
			request[2] += blab[i] + " "; //appends message in third position
		}

		return request;
	}//END appendBlab

	/* -------------------- WELCOME HEADER  */
	public static void welcomeHeader( String fileName ){
		try{
			 Scanner blabberHeader = new Scanner(new File("blabber-header.txt"));
			 Scanner timelineHeader = new Scanner(new File("timeline.txt"));
			 if(fileName == "timeline.txt"){
			 	while(timelineHeader.hasNext()){
			 		System.out.println(timelineHeader.nextLine());
			 	}
			 }else{
			 	while(blabberHeader.hasNext()){
			 		System.out.println(blabberHeader.nextLine());
			 	}
			 }
		}
		catch(FileNotFoundException msg){
			System.out.println(msg);
		}
	}//END welcomeHeader

	/* -------------------- COMMAND LIST  */
	public static void commandList(){
		System.out.println(
				"\t[CreateAccount username]\n\n\tThis command expects you to enter"
						+"\n\ta unique username. Your username must contain the following alpha-"
						+"\n\tnumeric values: a-z, A-Z, and 0-9 and must be greater than 4 in length."
						+"\n\n\n"
						+"\t[FollowAccount username username_to_follow]\n\n\tThis command expects you to"
						+"\n\tto enter the name of the user you would like to follow. This will allow"
						+"\n\tyou to see their blabs on your feed. You may NOT follow yourself."
						+"\n\n\n"
						+"\t[PostBlab username \"your message in quotations\"]\n\n\tThis command will allow you to"
						+"\n\tpost a blab."
						+"\n\n\n"
						+"\t[ViewTimeline userName]\n\n\tThis command will allow the current logged in user to view"
						+"\n\tall of the blabs of the user's they follow. By default they will view the"
						+"\n\tblabs in chronological order, unless specified."
						+"\n\n\n"
						+"\t[quit]\n\n\tThis command will end the program\n"
		);
	}//END commandList
}