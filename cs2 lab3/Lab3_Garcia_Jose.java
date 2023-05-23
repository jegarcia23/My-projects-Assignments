import java.io.File;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;

class Lab3_Garcia_Jose {
	public static void main(String[] args){


		Box[] boxes;

		boxes = getBoxArrayFromDataFile("input.txt");
	

		printAllBoxes(boxes);

		//randomly generate the diameter of the ball to be shipped. 
		int range = 20;  
		int diameter = (int) (Math.random() * range) + 2;

		canContain(boxes, diameter);

		smallestBox(boxes, diameter);

		int l_index = largestBox(boxes, diameter);
		if(l_index >= 0){
			int count = shipHowMany (diameter, boxes[l_index]);
			System.out.println(count+" ball(s) can be shipped in the largest box.");
			System.out.println("--------------------------------------\n");
		}
	}

	/**
	 * Complete this method to print the Box
	 * objects in the array parameter theBoxes
	 * @param theBoxes is the array of Box objects
	 */

	public static void printAllBoxes (Box[] theBoxes){
		System.out.println("--------------------------------------");
		System.out.println("Printing box dimensions.");

		// You are not allowed to change the header.
		// Change the body of this method.
		//System.out.println("I have not yet implemented the printBoxes method.");
		
		//for loop to print the box array
		for (int i = 0; i < theBoxes.length; i++){
			System.out.println("Box " + i + theBoxes[i]);
		}
	}

	/**
	 * Change the body of this method to print the box
	 * objects in the array parameter that can hold/store
	 * the ball whose diameter is given in the parameter. 
	 * @param theBoxes is the array of Box objects
	 * @param diameter of the ball
	 */  


	public static void canContain(Box[] theBoxes, int diameter){
		//variable initialized
		int count = 0;
		System.out.println("--------------------------------------");
		System.out.println("Checking for boxes that can hold the ball.");
		System.out.println("The diameter of the ball: "+diameter);

		//for loop to see how many boxes can contain the ball
		for(int i = 0; i < theBoxes.length; i++){
			if(diameter <= theBoxes[i].getWidth() && diameter <= theBoxes[i].getHeight() && diameter <= theBoxes[i].getLength()){
				System.out.println("Index: " + i + " width: " + theBoxes[i].getWidth() + "\t" +
				"height: " + theBoxes[i].getHeight() + "\t" + "length: " + theBoxes[i].getLength() + "\t" +
				 "Volume: " + theBoxes[i].getVolume());
				 count++;	
			}
		}
		System.out.println("The number of boxes that can hold the ball is " + count );
		// You are not allowed to change the header.
		// Change the body of this method.

		//System.out.println("I have not yet implemented the canContain method.");

	}

	/**
	 * Change the body of this method to print the information 
	 * of the smallest Box object that can hold the ball of 
	 * the given diameter	
	 * @param theBoxes is the array of Box objects
	 * @param diameter of the ball
	 */    


	public static void smallestBox (Box[] theBoxes, int diameter){
		
		System.out.println("--------------------------------------");
		System.out.println("Finding the smallest box to ship the ball.");

		int index = 0;
		double smallestB = theBoxes[0].getVolume();
		//for loop to find the smallest box
		for (int i = 1; i < theBoxes.length; i++) {
			if(diameter <= theBoxes[i].getWidth() && diameter <= theBoxes[i].getHeight() && diameter <= theBoxes[i].getLength()){
				if (theBoxes[i].getVolume() < smallestB) {
					index = i;
					smallestB = theBoxes[i].getVolume();
				}	
			}	
		}
		System.out.println(" index: " + index + " width:" + theBoxes[index].getWidth() + "\t" +
		"height: " + theBoxes[index].getHeight() + "\t" + "length: " + theBoxes[index].getLength());


		// You are not allowed to change the header.
		// Change the body of this method.

		//System.out.println("I have not yet implemented the smallestBox method.");    
	}

	/**
	 * Change the body of this method to (a) print the information 
	 * of the largest Box object that can hold the ball of 
	 * the given diameter, and (b) return the index of that object.	
	 * @param theBoxes is the array of Box objects
	 * @param diameter of the ball
	 * @return index of the largest box, -1 if no such box is found. 
	 */    

	public static int largestBox (Box[] theBoxes, int diameter){

		System.out.println("----------------------------------------------");
		System.out.println("Finding the largest box to ship the ball.");
		//Initialied variables
		int index = 0;
		double largestB = theBoxes[0].getVolume();
		//for loop to find the largest box
		for (int i = 0; i < theBoxes.length; i++) {
			if(diameter <= theBoxes[i].getWidth() && diameter <= theBoxes[i].getHeight() && diameter <= theBoxes[i].getLength()){
				if (theBoxes[i].getVolume() > largestB) {
					index = i;
					largestB = theBoxes[i].getVolume();
				}
			}		
		}
		System.out.println("Largest box that can hold the ball is in index " + index + " with volume " + theBoxes[index].getVolume());
		return index;


	}

	/**
	 * Change the body of this method to return â€œthe number of  
	 * ballsâ€ with the given diameter that can be shipped in the largest box
	 * @param diameter of the ball to be shipped
	 * @param largestBox is the box Object with largest volume
	 * @return the number of ball(s) that can be shipped in the
	 * largest Box object 
	 */


	public static int shipHowMany(int diameter, Box largestBox){
		System.out.println("--------------------------------------------");
		// You are not allowed to change the header.
		// Change the body of this method.
		//initialied variables and made the math to find how many balls will ship in the largest box
		int shipSizeLength = (int)((largestBox.getLength()  )/ diameter);
		int shipSizeWidth = (int)(largestBox.getWidth() / diameter);
		int shipSizeHeight = (int)(largestBox.getHeight() / diameter);
		int total = shipSizeLength * shipSizeWidth * shipSizeHeight;
		System.out.println("Finding how many ball(s) can be shipped in the largest box.");
		return total;



		//System.out.println("I have not yet implemented the shipHowMany method.");
		//return -1;

	}

	/**
	 * Change the body of this method to return an array 
	 * of Box objects, created after reading the file.
	 * @param filename
	 * @return the array of Box objects created from the fileName file 
	 */    

	static Box[] getBoxArrayFromDataFile (String fileName ){
		//varialbles initialized
		Box[] boxData = new Box[10];
		Scanner fileReader = null;

		try{
			File input = new File(fileName);
			fileReader = new Scanner(input);

		}catch(IOException e ){
			System.out.println("Error with the file.");
			return null;
		}//end of try catch 
		int idx = 0;
		//while loop to read the the file and split it by a space
		while(fileReader.hasNextLine()){
			String line = fileReader.nextLine();

			String[] file = line.split(" ",3);

			boxData[idx] = new Box(Double.parseDouble(file[0]),Double.parseDouble(file[1]),Double.parseDouble(file[2]));
			idx++;

		}
		fileReader.close();
		return boxData;

		// You are not allowed to change the header.
		// Change the body of this method. 
		


		
		
	}  
}