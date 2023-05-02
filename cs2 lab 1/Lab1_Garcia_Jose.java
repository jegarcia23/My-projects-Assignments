import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab1_Garcia_Jose{
	public static void main(String [] args)throws IOException{
		
		// double array for data from file
		double [][] weatherData = new double [12][3];

		//Initiating variables, and month array
		double avgRainFall;
		double avgWindSpeed;
		int index = 0;
		String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

		//try catch for reading the file
		try{
			
			File inputFile = new File ("input.txt");
			Scanner fileReader = new Scanner(inputFile);
			//Test case 2 testing the new average of wind speed and rainfall with new numbers
			//File testFile = new File("testcase.txt");
			//Scanner fileReader = new Scanner(testFile);
			while(fileReader.hasNextLine()){
				weatherData[index][0] = fileReader.nextDouble();
				weatherData[index][1] = fileReader.nextDouble();
				weatherData[index][2] = fileReader.nextDouble();
				index++;
				if(index == 12 ){
					index = 0;
					break;
				}
			}
			fileReader.close();
		}catch(IOException errMsg){
			System.out.println("Error reading the file");
		}//End of try catch
		
		//Method calling to get average for wind speed
		avgWindSpeed = windSpeedAverage(weatherData);

		System.out.println("The average windspeed for the year is: "+ avgWindSpeed );
		//Space
		System.out.println();
		//method calling to get months that are above wind speed average
		monthsAboveAverageWind(weatherData,months,avgWindSpeed);
		//Space
		System.out.println();
		//method calling to ge average for rain fall
		avgRainFall = rainfallAverage(weatherData);
		System.out.println("The average rainfall for the year is: " + avgRainFall );
		//space
		System.out.println();
		//method calling to get months above rainfall average
		monthsAboveAverageRain(weatherData,months,avgRainFall);
		
	}// End of Main

	public static double windSpeedAverage(double [][] data ){
		double windAvg =0.0;
		
		//for loop to add all the values and get the average
		for (double[] datum : data) {
			//adding all the values in column one
			windAvg += datum[1];


		}
		//dividing by the number of months
		windAvg /= 12;
		return windAvg;

	}//End of windSpeedAverage

	public static double rainfallAverage(double [][] array ){
		double rainAvg =0.0;
		
		//for loop to add all the values and get the average
		for (double[] doubles : array) {
			//adding all the values in column one
			rainAvg += doubles[2];

		}
		//dividing by the number of months
		rainAvg /= 12;
		return rainAvg;

	}//End of rainfallAverage

	public static void monthsAboveAverageWind(double [][] array,String []months,double avgWindSpeed){
		System.out.println("Months that had more than the average windspeed:\nIndex Month Name");
		//For loop to compare all the values from column 1 and comparing if they are above average
		 for(int row = 0; row<array.length;row++){
		 	//if statement comparing avg windspeed to the values fo column 1
		 	if( avgWindSpeed < array[row][1]){
		 		//printing values that are above average
		 		System.out.println((row+1)+"\t"+months[row]);
		 	}

		 }

	}//End of monthsaboveaveragewind

	public static void monthsAboveAverageRain(double [][] array,String [] months,double avgRainFall){
		System.out.println("Months that had more than the average rainfall:\nIndex Month Name");
		//For loop to compare all the values from column 2 and comparing if they are above average
		 for(int row = 0; row<array.length;row++){
		//if statement comparing avg rainfall to the values fo column 2
		 	if( avgRainFall < array[row][2]){
		 	//printing values that are above average
		 		System.out.println((row+1)+"\t"+months[row]);
		 	}

		 }

	}//End of monthsAboveAverageRain
}
