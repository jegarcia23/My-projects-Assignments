import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Please change the file and class name to  Lab2_(your last name)_(your first name)
public class Lab2_Garcia_Jose {

	public static void main(String[] args) {

		// The following input is for testing
		// Please make sure to comment this hard-coded input and 
		// write code for the file input
	/*	int[][] data = {

				{15, 50, 62, 72, 73, 74, 80, 55, 46, 43, 34, 19},

				{58, 60, 70, 73, 76, 82, 87, 65, 51, 42, 26, 19},

				{43, 59, 65, 72, 82, 65, 64, 53, 51, 41, 27, 22},

				{18, 42, 63, 69, 73, 85, 84, 65, 44, 38, 27, 14},

				{19, 46, 50, 77, 82, 95, 98, 93, 84, 74, 17, 10},

		};
		*/

		
		// Please uncomment and complete the below code of file input before final submission.
		
		//initialized variables
		int[][] data = new int[5][12];
		String [] fileData = null;
		Scanner fileReader = null;
		// int row_i=0;
		// int col_i=0;
		//try catch for reading the file
		try {
			// get the file from the directory to the File object
			
			
			// scan the File object
				File input_file = new File("input_2.txt");
				fileReader = new Scanner(input_file);

		}catch(FileNotFoundException errMsg){
			System.out.println("Error with the file");
			System.out.println("File couldn't be read");
		}// End of try catch

			// while loop to loop over each line in the file
				int row = 0;
				while (fileReader.hasNextLine()) {
				
				// line store the whole line
					String line = fileReader.nextLine();
					fileData = line.split(", ");

					//for loop for [][] data
					for(int col = 0; col < fileData.length; col++){
						data[row][col] = Integer.parseInt(fileData[col]);

					}
					row++;

				//----------- Write your code here -----------//
				
				}

			//close the scanFile
			fileReader.close();

		//for loop to print the 2d array data
		for(int i = 0; i < data.length; i++){
			System.out.println();
			for(int j =0; j < data[i].length; j++){
				System.out.print(data[i][j] + " ");
			
			}
		}
	
	
		
		System.out.println();

		farm_avg(data);

		System.out.println();

		month_avg(data);

		System.out.println();

		top_farms(data);

		System.out.println();

		top_months(data);

	}//End main 
	
	public static void farm_avg(int[][] data){

			//for loop to add the values and get the average 
			for (int row = 0; row < data.length; row++){
				double sum = 0.0;
				for (int col = 0; col < data[row].length; col++){
					sum += data[row][col];
				}	
				

				//dividing by the number of months to get the average
				double avg = sum / 12;
				System.out.println("The sums of farm " + row + " is: " + sum);
				System.out.println("The average of farm  " + row + " is " + avg );
			}		

			
		//----------- Write your code here -----------//

	}// End farm average 

	public static void month_avg(int[][] data ){
		double avg = 0.0;

		//for loop to add the values and get the average
		for(int i = 0; i < data[0].length;i++){
			avg = 0;
			for (int j = 0; j < data.length; j++){
				avg += data[j][i];
				//avg /=  data.length;
			}
			//dividing by the length of the farms
			avg /=  data.length;
			System.out.println("The average production for " + i + " is " + avg);
		}

		//----------- Write your code here -----------//

	}// month average 

	public static void top_farms (int[][] data){

		//declared variables 
		int [] topFarms = new int[data.length];
		int max;
		int maxIndx;
		//for loop to equal the data array to the topfarms array 
		for(int row = 0; row < data.length; row++){
			for (int col = 0; col < data[row].length; col++){
				topFarms[row] += data[row][col];
			}
		}
		//for loop for the three highest
		for(int i = 0; i < 3; i++){
			max = 0;
			maxIndx = 0;
			for(int j = 0; j < topFarms.length; j++){
				//finding the max for the three highest 
				if(topFarms[j] > max){
					max = topFarms[j];
					maxIndx = j;
				}	

			}
			//if statement for the 3 highest at each position & reseetting the topFarm[maxIndx] every time
			if (i == 0){
				System.out.println( "Farms with the highest production is  " + maxIndx + " with the production of " + max );
				topFarms[maxIndx] = 0;

			}else if(i == 1){
				System.out.println ("Farms with the highest production is  " + maxIndx + " with the production of " + max);
				topFarms[maxIndx] = 0;
			}else{
				System.out.println( "Farms with the highest production is  " + maxIndx + " with the production of " + max);
				topFarms[maxIndx] = 0;

			}

		}

		//----------- Write your code here -----------//
		

	}

	public static void top_months (int[][] data){

		//declared variables
		 int[] topMonths = new int[data[0].length];
		
		double max;
		int maxIndex;

		 for(int row = 0; row < data.length; row++){
			for (int col = 0; col < data[row].length; col++){
		 		topMonths[col] += data[row][col];
		 	}
		}
		//for loop for the 3 highest
		for (int i = 0; i<3;i++){
			max = 0;
			maxIndex = 0;
			//for loop for data for the months
			for(int j = 0; j<topMonths.length;j++){
				//if statement to get max numbers
				if(topMonths[j]> max){
					max = topMonths[j];
					maxIndex = j;
				}
			}
			//If statement for the 3 highest at each position & reseting the topMonths[maxIndex] every time
			if(i==0){
				System.out.println("Months with the highest production: " + maxIndex + " with production: " + max);
				topMonths[maxIndex]=0;
			}else if(i==1){
				System.out.println("Months with the second  highest production: " + maxIndex + " with production: " + max);
				topMonths[maxIndex]=0;
			}else{
				System.out.println("Months with the third highest production: " + maxIndex + " with production: " + max);
				topMonths[maxIndex]=0;
			}	
		}		

		
		//----------- Write your code here -----------//
		
	}

		

}
//quest 1 you add and divide by 12
//method 2 divide by 5