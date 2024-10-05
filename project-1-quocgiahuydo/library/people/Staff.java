package library.people;
/**
 * Used to represent staff who work for the Library.
 */
public class Staff extends Person{
    private final int staffID;
    private final int passkey;
    
    /**
     *TODO
     * Constructs a Staff object.
     *@param firstName The artist's first name. 
     *@param lastName The artist's last name.
     *@param staffID String used to set the staffID.
     *@param passkey String used to set the passkey.
     */
  public Staff(String firstName, String lastName, String staffiD, String pasSkey){
      super(firstName, lastName);
      	this.staffID = staffiD.hashCode();
	this.passkey = pasSkey.hashCode();
    
	
    
    /**
     *TODO
     * Gets the staff id.
     * @return Staff ID is returned.
     */
    }
 public int getStaffID(){
	return this.staffID;
    }

    /**
     * Checks equality between the Staff member and another object. Two staff members are considered equal if their staff IDs and their passkeys are identical.
     * @return if the two Staff members are equal return true.
     */
    //    Override
	public boolean equals(Object o){
	if(!(o instanceof Staff)){
	    
	    return false;
	}
	return ((Staff)o).staffID == staffID && ((Staff)o).passkey == passkey;
    }

    //TODO
    @Override
    public String toString(){
	return super.getName();
     }
}
