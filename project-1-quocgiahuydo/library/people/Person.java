package library.people;
/**
 * Person object used to represent Staff, Members, and Artists.
 */
public abstract class Person{
    protected final String firstName;
    protected final String lastName;
    /**
     *TODO
     * Gets the person's name. 
     *@return returns the first and last name in the following format: "LASTNAME, FIRSTNAME" 
     */
    protected String fullname ;  
    public String getName(){
	return this.fullname = this.lastName + ", " + this.firstName;
    }
    public Person(String firstname, String lastname){
	this.firstName = firstname;
	this.lastName = lastname;
    }
}
