class Lab5_Garcia_Jose{
	public static void main(String[] args){
		System.out.println(camelCaseIterative("Hello World"));
		System.out.println(camelCaseRecursive("Hello World"));
		
		System.out.println(powerNIterative(3, 1));
		System.out.println(powerNRecursive(3, 1));
		
		System.out.println(stringCleanIterative("abbbcdd"));
		System.out.println(stringCleanRecursive("abbbcdd"));
		
		System.out.println(allStarIterative("hello"));
		System.out.println(allStarRecursive("hello"));
		
		System.out.println(countHiIterative("xxhixx"));
		System.out.println(countHiRecursive("xxhixx"));

		System.out.println(camelCaseIterative("Difficult Method"));
		System.out.println(camelCaseRecursive("Difficult Method"));

		System.out.println(powerNIterative(5,2));
		System.out.println(powerNRecursive(5,2));

		System.out.println(stringCleanIterative("aaabbbzzzcccddd"));
		System.out.println(stringCleanRecursive("aaabbbzzzcccddd"));

		System.out.println(allStarIterative("hippopotamus"));
		System.out.println(allStarRecursive("hippopotamus"));

		System.out.println(countHiIterative("xhixxhix"));
		System.out.println(countHiRecursive("xhixxhix"));
		// Add more cases with additional strings and numbers
		
	}
	
	public static String camelCaseIterative(String w){
		//Initializing variable
		String str = "";
		//for used to itirate through the word
        for(int i = 0; i < w.length(); i++){
        	//assigning letter variable
        	char letter = w.charAt(i);
        	//if used to change the letter to lowercase
            if(i%2==0){
                letter = Character.toLowerCase(letter);
                str = str + letter;
            }
            //else used to change the letter to uppercase
            else{
                letter = Character.toUpperCase(letter);
                str = str + letter;
            }
        }
	
		
		return str;
	}
	public static String camelCaseRecursive(String w){
		//start of the recurssion
		if(w.length()==1){
           return w.toLowerCase();
		}
		else{
			//Initializing variables
			int startIndex = 0;
			String newString = "";
			//for used to find start of the word
			for(int i = 0; i < w.length();i++){
				if(Character.isSpaceChar(w.charAt(i))){
					startIndex = i + 1;
				}
			}
			//handles the letters, spaces and other characters
			int index = w.length() -1;
			if(Character.isLetter(w.charAt(w.length()-1))){
				//if even  character is lower case, even is upper case
				newString += (((w.length()-1)-startIndex) %2 ) == 0 ? Character.toLowerCase(w.charAt(w.length()-1)) : Character.toUpperCase(w.charAt(w.length()-1));
			}else if(Character.isSpaceChar(w.charAt(w.length() - 1))){
				newString += w.charAt(w.length() -1);
			}
			else{
				newString += w.charAt(w.length() -1);
			}
			return camelCaseRecursive(w.substring(0,w.length()-1)) + newString;
		}
       
	}
	public static int powerNIterative(int n, int b){
		//Initializing variable 
		int value = 1;
		//while loop to calculate the power
        while(b != 0){
            value = value * n;
            b--;
        }
		return value;
	}
	public static int powerNRecursive(int n, int b){
		//base case
		if(b ==0)
			return 1;
		//recurssion to calculate the powerN
		return n * powerNRecursive(n, b-1);

		
		//return 0;
	}
	public static String stringCleanIterative(String w){
		//Initializing variable
		String strClean = "";
		//for loop used to itirate through the word
		for (int i = 0;i < w.length();i++ ) {
			//assigning the ch variable
			char ch = w.charAt(i);
			//if to see if the string is equal to empty string 
			if(strClean == ""){
				//adding ch to the string 
				strClean += ch;
			}	
			if(!strClean.contains(String.valueOf(ch))){
				strClean += ch;
			}
			
		}
		
		return strClean;
	}
	public static String stringCleanRecursive(String w){
		//base case
		if(w.length() < 2)
			return w;
		//base case
		if(w.charAt(0) == w.charAt(1))
			//return to remove the letter if its the same
			return stringCleanRecursive(w.substring(1));
		else{
			return w.charAt(0) + stringCleanRecursive(w.substring(1));
		}
		
	}
	public static String allStarIterative(String w){
		//Initializing variables
		String allStar = "";
		char star = '*';
		//for loop to itirate through the word
		for(int i = 0; i < w.length();i++){
			//assigning the character at i to character variable
			char character = w.charAt(i);
			//adding character to the string allstar
			allStar += character;
			//if i doesnt equal to the length of the word
			if(i != w.length()-1){
				//adding the star character to the string
				allStar += star;
			}
		}
		
		return allStar;
	}
	public static String allStarRecursive(String w){
		//base case
		 if(w.length() <= 0){
            return w;
        }
        //recurssive to add the * 
        return w.charAt(0) + "*" + allStarRecursive(w.substring(1));
	}
	public static int countHiIterative(String w){
	//Initializing variable
	int count = 0;
	////for loop to itirate through the word
	for(int i = 0;i < w.length();i++){
		//assigning the character at i to h variable
		char h = w.charAt(i);
		//if to see if h variable equals to the letter h 
		if(h == 'h'){
			//assigning the ch variable to the letter at i+1
			char ch = w.charAt(i+1);
			//if to see if ch variable equals the letter i 
			if(ch == 'i'){
				//count how many hi they are
				count++;
			}
		}
	}
		
		return count;
	}
	public static int countHiRecursive(String w){

		//base case
		if(w.length() < 2)
			return 0;
		//base case
		if(w.substring(0,2).equals("hi")){
			//recurse to count how many hi are 
			return 1 + countHiRecursive(w.substring(1));
		}else {
			return countHiRecursive(w.substring(1));
		}

	}	
}