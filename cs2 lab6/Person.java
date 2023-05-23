public class Person {
	
	private String name;
	private int id;
	Person next = null;

	Person(){
	}
    
    Person(int i){
        id = i;
    }
    Person (String s, int i){
        name = s;
        id = i;
        
    }
    
    String getName(){
        return name;
    }
    void setName(String n){
        name = n;
    }
    
    int getId(){
        return id;
    }
    void setId(int i){
        id = i;
    }

    public String toString(){
        return "Name: "+name+
            "\nid: "+id+"\n";
    }
}