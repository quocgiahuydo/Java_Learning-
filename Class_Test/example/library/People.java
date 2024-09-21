package example.library;

public abstract class People{
    private final String firstname;
    private final String lastname;
    private String fullname;
    public People(String Firstname, String Lastname){
	this.firstname= Firstname;
	this.lastname = Lastname;
    }
    public String getName(){
	return this.fullname = this.firstname + " " + this.lastname;
    }
}

