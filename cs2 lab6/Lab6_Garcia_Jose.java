public class Lab6_Garcia_Jose {
	
	public static void main(String args[]) {
		
		Person head1 = new Person("bob", 1);
		head1.next = new Person("jose", 2);
		head1.next.next = new Person("hannah", 4);
		head1.next.next.next = new Person("angel", 7);
		head1.next.next.next.next = new Person("eve", 8);
		
		Person head2 = new Person("jose", 2);
		head2.next = new Person("alex", 3);
		head2.next.next = new Person("neven", 5);
		head2.next.next.next = new Person("angel", 7);
		
		Person head = mergeSortedLL(head1, head2);
		System.out.println("---------After merge:---------\n");
		printLL(head);
		
		Person new_node = new Person("sillis",6 );
		head = insertInSortedOrder(head, new_node);
		Person new_node2 = new Person("mateo",0 );
		head = insertInSortedOrder(head, new_node2);
		System.out.println("-----After adding new node in sorted order:----\n");
		printLL(head);
		
		head = deleteDuplicate(head);
		System.out.println("-----After deleting duplicates:-----\n");
		printLL(head);
		
		head = reverseLL(head);
		System.out.println("----------After reverse:----------\n");
		printLL(head);
		
		System.out.println("----------Palindromic Names:----------\n");
		printPalindromicNames(head);
		
	}
	

	
	public static void printLL(Person curr) {
		
		if (curr == null)
            return;
        

 
        System.out.println(curr);
        printLL(curr.next);
	}
	
	/*	Given the two sorted linked list of the person (sorted by id),
	 * Merge the two linked lists of the person into one list where the id is still sorted. */
	
	public static Person mergeSortedLL(Person curr1, Person curr2) {

		Person mergeHead = null;
		if(curr1 == null && curr2 == null)
			return mergeHead;
		//check to see if curr1 is null and curr2 isn't
		else if(curr1 == null && curr2 != null){
			mergeHead = curr2;
			mergeHead.next = mergeSortedLL(curr1,curr2.next);
			return mergeHead;
			//if to see if curr2 is null and curr1 isn't
		}else if(curr2 == null && curr1 != null){
			mergeHead = curr1;
			mergeHead.next = mergeSortedLL(curr1.next,curr2);
			return mergeHead;
		}
		else{
			//recursive call
			if(curr1.getId() < curr2.getId()){
				mergeHead = curr1;
				mergeHead.next = mergeSortedLL(curr1.next,curr2); 
			}
			else{
				mergeHead = curr2;
				mergeHead.next = mergeSortedLL(curr1,curr2.next);
			}
			return mergeHead;
		
		}	
		
	}
	
	/* Given the head of a linked list of the Person Class (sorted by ID), 
	 * insert the given node at a position in the linked list, 
	 * so the list remains sorted by ID. 
	 * Do not choose the position manually. 
	 * Rather compare all the linked list ids with the new id 
	 * and insert at correct position.*/
	
	public static Person insertInSortedOrder(Person curr, Person new_node) {
		
		if(curr == null){
			return new_node;
			//to see if new node is null
		}else if(new_node == null){
			return curr;
		}
		//getting the id and comparing it 
		else if(curr.getId() < new_node.getId() && curr.next == null){
			curr.next = new_node;

			return curr;
		}
		else if(new_node.getId() < curr.getId()){
			new_node.next = curr;
			return new_node;
		}
		else{
			//recursive call
			if(curr.getId() < new_node.getId() && curr.next.getId() < new_node.getId()){
				curr.next = insertInSortedOrder(curr.next,new_node);
				return curr;
			}
			else if(curr.getId() < new_node.getId() && curr.next.getId() > new_node.getId()){
				new_node.next = curr.next;
				curr.next = new_node;
				return curr;
			}
			return curr;
		}
		
		
		//return curr;
	}
	
	/*	Given the head of a linked list of the Person Class (sorted by Id), 
	 * delete any Person that has a duplicate Id. 
	 * Compare the Ids only, not the name. 
	 * Hint: As the linked list is sorted by the Ids 
	 * so duplicate Ids will appear next to each other in the list.*/
	
	public static Person deleteDuplicate(Person curr) {

		if(curr.next == null)
			return curr;
		//recursive call
		if(curr.getId() == curr.next.getId()){
			curr.next = curr.next.next;
			curr.next = deleteDuplicate(curr.next);
			return curr;
		}
		else{
			curr.next = deleteDuplicate(curr.next);
			return curr;
		}
		


		//eturn curr;
		// Write your code here	
		
	}
	
	//	Given the head of a linked list of the Person Class, reverse the linked list. 		
	//	Linked Llist: (head) person1->person2->person3->person4->null
	//	reverseLL(head) â†’ person4->person3->person2->person1->null
	
	public static Person reverseLL(Person curr) {
		//Initializing Person variable 
        Person head = null;
        //to see of curr is null
        if(curr == null){
        	return curr;
        }
        //last node or only one node
        if(curr.next == null){
        	return curr;
        }
        head = reverseLL(curr.next);

        //change references for middle
        curr.next.next = curr;
        curr.next = null;
        // Write your code here
		
        return head;
	}
	
	/* Given the head of a linked list of Person class, 
	 * print all the palindromic names of Person */
	
	public static boolean isPalindrome(String name, int start, int end) {
		//to see if the start is greater than the end
		if(start >= end){
			return true;
		}
		//recursive call
		else{
			if(name.charAt(start) != name.charAt(end)){
				return false;
			}
			return isPalindrome(name, start + 1, end - 1);
		}
		

	}
	
	// Recursively traverse the linked list and call isPalindrome for the name of each Person.
	public static void printPalindromicNames(Person curr) {
		//if to see if curr is null
		if(curr == null){
			return;
		}
		//recursive call
		if(isPalindrome(curr.getName(),0,curr.getName().length()-1)){
			System.out.println(curr.getName() + " is isPalindrome");
			 printPalindromicNames(curr.next);
		}
		else{
			 printPalindromicNames(curr.next);
		}
		
	}
	
	
}