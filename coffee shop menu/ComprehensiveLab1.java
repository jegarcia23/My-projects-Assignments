import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ComprehensiveLab1{
	public static void main(String [] args) throws IOException{
		File file = new File( "starbucks-menu.txt");

		Scanner keyboard = new Scanner(System.in);
		Scanner fileReader = new Scanner( new File( "starbucks-menu.txt"));
		int menuSelection = 0;
		String itemName;
		double itemCost;
		boolean isBeverage = false, browsing = true;
		String userItemInput;
		int bevSizeOption;
		double bevCost;
		String bevSize ="";
		double currItemTotal = 0;
		double subTotal = 0;
		String cart = "---------------Cart--------------";
		double tax = 0.0675;
		double totalAfterTax = 0;
		String checkOut = "";
		String empty = "";
		boolean isInFile = false;
		int numberOfPastries;



		System.out.println("Welcome to Papaya's Coffee!");
		while(browsing){ //RUTH COMMENT: Change condition
			System.out.println("Please select an option below to continue." 
				+ "\n1. Display Menu" + "\n2. Add item to order" + "\n3. View Cart" + "\n4. Checkout" 
				+ "\n5. Exit Papaya's Coffee");

			menuSelection = keyboard.nextInt();

			if (menuSelection == 1 ){
				System.out.format("+-------------------------------------------------------+%n");
		        System.out.format("|                   Papaya's Coffee                  |%n");
		        System.out.format("+---------------------------------+-------------+-------+%n");
		        System.out.format("|                        Item Name|  isBeverage?|   Cost|%n");
		        System.out.format("+---------------------------------+-------------+-------+%n");

		        //SKIP header line in the file
		        fileReader.nextLine();

		        //Read file to display menu to user
		        while( fileReader.hasNext() ){
		            itemName = fileReader.next();
		            isBeverage = fileReader.nextBoolean();
		            itemCost = fileReader.nextDouble();


		            System.out.printf( "| %31s | %11b | $%1.2f |\n", itemName, isBeverage, itemCost );
		            System.out.format("+---------------------------------+-------------+-------+%n");
		        }    
	        	
			}// end of if statement
			else if ( menuSelection == 2 ){

				System.out.println("Please enter the name of the item as shown on the menu: ");

				keyboard.nextLine();
				// flushing the scanner

				userItemInput = keyboard.next();

				fileReader = new Scanner( new File( "starbucks-menu.txt"));
				fileReader.nextLine();
				//skip header

				while(fileReader.hasNext()){
					itemName = fileReader.next();
					if( userItemInput.equalsIgnoreCase( itemName )){
						isInFile = true;

						isBeverage = fileReader.nextBoolean();
						itemCost = fileReader.nextDouble();
						if( isBeverage ){
							System.out.println("What size would you like to drink?");
							System.out.println("1.Tall: +(0.00)" +  "\n2.Grande: +(1.50)" + "\n3.Venti: +(2.75)");
							bevSizeOption = keyboard.nextInt();
							//User Input

							if(bevSizeOption == 1){
								bevSize = "Tall";
								currItemTotal = itemCost + 0.00;
								System.out.println("Item added to cart.");
								cart += "\nItem: " + userItemInput + " | Size: " + bevSize
								+ " | Price : $" + currItemTotal;

							}else if(bevSizeOption == 2){
								bevSize = "Grande";
								currItemTotal = itemCost + 1.50;
								System.out.println("Item added to cart.");
								cart += "\nItem: " + userItemInput + " | Size: " + bevSize
								+ " | Price : $" + currItemTotal;


							}else if(bevSizeOption == 3){
								bevSize = "Venti";
								currItemTotal = itemCost + 2.75;
								System.out.println("Item added to cart.");
								cart += "\nItem: " + userItemInput + " | Size: " + bevSize
								+ " | Price : $" + currItemTotal;

							} else{
								System.out.println("Invalid size selection.");
							}

							System.out.println("BEVERAGE Current Item Total: " + currItemTotal);

						}//END isBeverage

						else{
							System.out.println("How many would you like?");
							numberOfPastries = keyboard.nextInt();
							currItemTotal = numberOfPastries * itemCost;
							System.out.println("BAKERY Current Item Total: " + currItemTotal);

							System.out.println("Item added to cart.");
							cart += "\nItem: " + userItemInput + " | Quantity: " 
							+ numberOfPastries + " | Price: $" + currItemTotal;
						} //END if bakery item
						
						//Accumulate currItemTotal to the subTotal of the users menu items
						subTotal += currItemTotal;
					}
					else{
						fileReader.next();
						fileReader.next();
					}
				}//end WHILE
				if(!isInFile){
					System.out.println("Invalid item selection");
				}
			}//END selection == 2 (Add Item)

			else if (menuSelection == 3){
				System.out.println(cart);
				System.out.println("Subtotal: $" + subTotal);


			}//End selection == 3
			else if (menuSelection == 4){
				
				System.out.println(cart);
	
				// subTotal += currItemTotal;
				totalAfterTax = subTotal + tax;

				System.out.printf("\nSubtotal: $%.2f\nTax: $%.2f\nTotal: $%.2f" , subTotal, tax, totalAfterTax);
				

				System.out.println("\nPlease enter CHECKOUT to complete your order.");
				checkOut = keyboard.next();
				

				if(checkOut.equalsIgnoreCase("CHECKOUT")){
					System.out.printf("This is your total: $%.2f" , totalAfterTax);
					System.out.println("\nEnjoy!");
					cart ="";
					subTotal = 0;
					browsing = false;
				}else if (cart.equalsIgnoreCase(empty)){
					
					System.out.println("Please enter an item.");
				}

			}//End selection == 4
			else if (menuSelection == 5){
				System.out.println("Have a nice day!");
				browsing = false;

			}//END selection == 5

			fileReader = new Scanner( new File( "starbucks-menu.txt"));
				fileReader.nextLine();
		}//end while
	}
}