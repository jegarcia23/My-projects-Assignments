import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.lang.Math; 

public class Lab4_Garcia_Jose{ 

	/** 
	 * Do not change the main method.
	 * you can only change the "input.txt" to the location of your input file.
	 * Before submitting change it back to "input.txt"
	 */ 
	public static void main(String[] args){ 

		Person head = null;
		head = getPersonFromDataFile("input.txt"); 
		System.out.println("--------------------------------------");
		System.out.println("Printing the Linked List");
		printLL(head);

		Person newPerson = new Person("newPerson_1", 888, 8.8, 8, 8);
		head = addPerson(head, newPerson, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new person at position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		Person newPerson2 = new Person("newPerson_2", 666, 6.6, 6, 6);
		head = addPerson(head, newPerson2, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new person at position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		head = deletePerson(head, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting a person from position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		head = deletePerson(head, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting a person from position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe person worked most years: ");
		workedMostYears(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe person worked least years: ");
		workedLeastYears(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nAverage hours worked in the last week: ");
		averageHoursWorked(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nTotal payment amount for each person based on hoursWorked and hourlyWage: ");
		totalPaymentToEachPerson(head);

		// Extra Credit
		System.out.println("\n\n--------------------------------------");
		Person newPerson3 = new Person("newPerson_3", 102, 8.8, 8, 8);
		head = addPersonByCheckingId(head, newPerson3, 4);
		System.out.println("Printing the Linked List\n");
		printLL(head);

		System.out.println("\n\n--------------------------------------");
		Person newPerson4 = new Person("newPerson_4", 103, 8.8, 8, 8);
		head = addPersonByCheckingId(head, newPerson4, 4);
		System.out.println("Printing the Linked List\n");
		printLL(head);

	} 

	/** 
	 * Complete this method to print the Person Linkedlist
	 * given the head of the Person LinkedList
	 * @param head of the Person LinkedList 
	 */ 
	public static void printLL (Person head) { 
	// You are not allowed to change the header. 
	// Change the body of this method. 
		Person current = head;
		while ( current != null ){
			System.out.print(current + " ");
			current = current.next;

		}
		
	} 

    /** 
	 * Change the body of this method to add a person to the linkedlist
	 * @param head
	 * @param newPerson 
	 * @param position
	 * @return head of the linked list which is a object of Person class 
	 */   
	public static Person addPerson (Person head, Person toAdd, int position) { 
		// You are not allowed to change the header. 
		// Change the body of this method. 

		//Person current = head;\
		//if statement to check if head is null
		if( head == null )
			return toAdd;
		if( position == 0){
			toAdd.next = head;
			return toAdd;

		}
		Person prev = head;
		Person curr = head.next;
		int i = 1;
		//while to itirate and add the new person on the position
		while (curr != null){
			if(i == position ){
				prev.next = toAdd;
				toAdd.next = curr;
				return head;
			}
			prev = curr;
			curr = curr.next;
			//adding 1 to the counter
			i++;
		}
		prev.next = toAdd;
		return head;

		
	} 

    /** 
	 * Change the body of this method to delete a person from the linkedlist
	 * @param head
	 * @param position
	 * @return head
	 */
	public static Person deletePerson (Person head, int position) { 
		// You are not allowed to change the header. 
		// Change the body of this method. 

		//if statement to check if head is null
		if(head == null)
			return null;
		if(position == 0){
			head = head.next;
			return head;
		}
		//Initiating the variables
		Person current = head;
		int i = 1;
		//while to itirate and delete the new person on the position
		while(current.next != null && i < position){
			current = current.next;
			i++;
		}
		//if statement to check if head is not null and going to the next next head
		if(current.next != null){
			current.next = current.next.next;
		}


		
		return head;
		
	}    

	/**
	 * Change the body of this method to find out who worked most years from the linkedlist
	 * @param head
	 */ 
	public static void workedMostYears(Person head) { 
		// You are not allowed to change the header. 
		// Change the body of this method.
		//Initiating variables 
		 Person current = head;
		 int mostYears = 0;
		 String name = "";
		 //while loop to find the most years worked
		 while(current != null){
		 	if(current.years > mostYears){
		 		mostYears = current.years;
		 		name = current.getName(); 
		 	}
		 	current = current.next;

		}
		 //System.out.println("The most years worked is " + name +" " + mostYears);
		System.out.println("Name: " + name + " " + " years: "+ mostYears);

	} 


	/**  
	 * Change the body of this method to find out who worked least years from the linkedlist
	 * @param head
	 */ 
	public static void workedLeastYears(Person head) { 
		// You are not allowed to change the header. 
		// Change the body of this method. 
		//Initiating variables 
		Person current = head;
		int leastYears = head.years;
		String name = "";
		//while loop to find the least worked years
		while(current != null){
			if( leastYears > current.years){
				//equaling the lestYears variable to the current 
				leastYears = current.years;
				//equaling the name variable to the name of the leastYears
				name = current.getName();
			}
			//setting current to the next node
			current = current.next;
			
		} 
		System.out.println("Name: " + name + " " +" years: "+ leastYears);

	} 

	/**  
	 * Change the body of this method to find out the average hours all employees worked from the linkedlist
	 * @param head
	 */ 
	public static void averageHoursWorked(Person head) {
		// You are not allowed to change the header. 
		// Change the body of this method. 
		//Initiating variables
		Person current = head;
		 double avg = 0;
		 int count = 0; 
		 String name = "";
		 // while loop to sum all the nodes
		 while(current != null){
		 	avg += current.hoursWorked;
 			
 			//going to the next node
		 	current = current.next;
		 	//incrementing counter 
		 	count ++;

		}
		//dividing the sum by the count of nodes
		avg /= count;
		System.out.println(avg);
	}

	/**  
	  * Change the body of this method to find the total payment each person gets from the linkedlist. 
	  * If a person worked<= 40 hours then he/she will get the hourlyWage for the hours worked. 
	  * If a person worked > 40 hours then he/she will get double the hourlyWage for the overtime. 
	 * @param head
	 */ 
	public static void totalPaymentToEachPerson(Person head) {
		// You are not allowed to change the header. 
		// Change the body of this method. 

		//Initiating variables
		Person current = head;
		double paymentPerson = 0;
		int count = 0;

		//while loop to get get the payment of each person
		while( current != null){
			//if statement to get the payment of each person of 40 hours and under
			if(current.hoursWorked <= 40){
				paymentPerson = current.hoursWorked * current.wage;
				System.out.println("Name: " + current.getName());
				System.out.println("Hours Worked: " +current.hoursWorked);
				System.out.println("Payment: " +paymentPerson);
				System.out.println();
				//resetting the variable for the next node
				paymentPerson = 0;

			}
			//if statement to get the payment of each person of hours higher than 40 
			else if (current.hoursWorked > 40 ){
				paymentPerson = 40 * current.hourlyWage;
				//Initiating variable for the overtime 
				double overtime = current.hoursWorked - 40;
				//variable to get the final payment including the overtime 
				double finalPayment = ((overtime * current.hourlyWage ) * 2 ) + paymentPerson;
				System.out.println("Name: " + current.getName());
				System.out.println("Hours Worked: " + current.hoursWorked);
				System.out.println("Payment: " + finalPayment);
				System.out.println();
				//resetting the variables for the next node
				paymentPerson = 0;
				finalPayment = 0;
				overtime = 0;




			}
			current = current.next;
			//adding 1 to the counter
			count ++;
		}

		
	}

	/**  
	 * Change the body of this method to add person by checking id if aleady present in the linkedlist
	 * @param head
	 * @param newPerson 
	 * @param position
	 * @return head
	 */ 
	// Extra Credit
	public static Person addPersonByCheckingId(Person head, Person newPerson, int position) {
		// You are not allowed to change the header. 
		// Change the body of this method.
	
		//Initiating the variables
		Person current = head.next;
		Person prev = head;
		int counter = 0;
		//while loop to see if head is not null
		while( current != null){
			//if statement to see if head id is equal the new person id
			if(current.getId() == newPerson.getId()){
				System.out.println("Adding Failed. Id already exist in the link list.");
				return head;
			}
			//else statement for it to add the new person if the head id is not equal to the new person id
			else{
				if(counter == position -1){
					prev.next = newPerson;
					newPerson.next = current;
					System.out.println("Succesful adding a person in position " + position);
					return head;
				}
			}
			//setting the prev person to the current person 
			prev = current;
			//setting the current to the next node
			current = current.next;
			//incrementing the counter 
			counter++;
			
		}
		
	
		return head;
	}

	/** 
	 * Change the body of this method to add persons from the data file to a linkedlist
	 * Change the body of this method to return   
	 * the head of linkedlist of Person, created after reading the file. 
	 * @param filename 
	 * @return head of the created Linked List  
	 */     
	static Person getPersonFromDataFile (String fileName){ 
		// You are not allowed to change the header. 
		// Change the body of this method.

		//initiating variables and creating scanner
		Scanner fileReader = null;
		int row = 0;
		Person head = null;
		Person current = null;
		Person dataPerson = null;
		//try catch for the file reader
		try{
			File file = new File (fileName);
			fileReader = new Scanner(file);
			//while loop to read the file 
			while ( fileReader.hasNextLine()){
				String line = fileReader.nextLine();
				//splitting by tab 
				String [] splitLine = line.split("\t");

				//equaling the varialbes to the position of the link list
				String name = splitLine [0];
				int id = Integer.parseInt(splitLine[1]);
				double hoursWorked = Double.parseDouble(splitLine[2]);
				double wage = Double.parseDouble(splitLine[3]);
				int years = Integer.parseInt(splitLine[4]);
				System.out.print(splitLine[0] + " " + splitLine[1] + " " + splitLine[2] + " "
				+ splitLine[3] + " " + splitLine[4] + "\n");
				
				//getting the data from the person class
				dataPerson = new Person (name,id, hoursWorked,wage,years);
				//if statement to make the file into a linklist
				if(row == 0){

					head = dataPerson;
					current = head;
					 
				}
				//else statement to go to the next node
				else {
					current.next = dataPerson;
					current = current.next; 
				}
			System.out.println();	//return dataPerson; 
			//incrementing row
			row++;
			}

			fileReader.close();
		}
		catch(FileNotFoundException errMsg){
			System.out.println("Error reading the file.");
		}

		
		return head;
	}  

	 
	
} 
