package example.library;


public class Staff extends People{
    private final String firstName;
    private final String lastName;
    public Staff(String firstname, String lastname)
    {
	this.firstName = firstname;
	this.lastName = lastname;
    }
    public String  getName(){
	People new_mem = new People(this.firstName, this.lastName);
	return new_mem.getName();
    }
}


	
