public class Person{
	private String name;
	private int id;
	double hoursWorked;
	double hourlyWage;
    int years;
	Person next;

	Person(){
	}
    
    Person(int i){
        id = i;
    }
    Person (String s, int i, double h, double w, int y){
        name = s;
        id = i;
        hoursWorked = h;
        hourlyWage = w;
        years = y;
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
        return  "Name: " + name+
				"\nid: " + id +
				"\nHours worked: " + hoursWorked +
				"\nHourly wage: " + hourlyWage +
				"\nYears worked: " + years + "\n";
    }
}