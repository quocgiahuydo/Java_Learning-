package library.people;
import java.util.Arrays;
import library.exceptions.ReturnException;
/**
 * Used to represent people who have memberships with the Library.
 */
public class Member extends Person{
    private final int memberID;
    private final int passkey;
    private int[] checkedOut={};

    /**
     *TODO
     * Constructs a Member object.
     *@param firstName The member's first name. 
     *@param lastName The member's last name.
     *@param memberID String used to set the memberID.
     *@param passkey String used to set the passkey.
     */
    
    public Member(String firstName, String lastName, String memberID, String passkey){
    
    super(firstName, lastName);
    this.memberID = memberID.hashCode();
    this.passkey = passkey.hashCode();
    }
    /**
     * Constructs a Member object. Used internally for creating altered copies.
     *@param firstName The member's first name. 
     *@param lastName The member's last name.
     *@param memberID The memberID.
     *@param passkey The passkey.
     *@param checkedOut The list of checked out item unique ids.
     */
    public Member(String firstName, String lastName, int memberID, int passkey, int[] checkedOut){
	super(firstName, lastName);
        this.memberID = memberID;
	this.passkey = passkey;
	this.checkedOut = checkedOut.clone();
    }

    /**
     * Get checked out unique ids.
     *@return returns array of unique ids of checked out items.
     */
    public int[] getCheckedOut(){
	return checkedOut.clone();
    }

    /**
     * Checks out item from the library.
     * @return new copy of Member with the newly checked out item added to the checked out list. 
     */
    public Member checkOut(int uID){
	int[] updatedCheckedOut = null;
	boolean foundEmpty = false;
	for(int i = 0; i < checkedOut.length; i++){
	    if(checkedOut[i] == -1){
	        updatedCheckedOut = this.checkedOut.clone();
		updatedCheckedOut[i] = uID;
		foundEmpty = true;
		break;
	    }
	}
	if(!foundEmpty){
	    updatedCheckedOut = Arrays.copyOf(checkedOut, checkedOut.length+1);
	    updatedCheckedOut[updatedCheckedOut.length-1] = uID;
	}
        return new Member(this.firstName, this.lastName, this.memberID, this.passkey, updatedCheckedOut.clone());
    }

    /**
     *TODO
     * Returns item to the library.
     * @return new copy of Member with the item returned and removed from the checked out list.
     * @throws ReturnException If the item cannot be returned (i.e. was never owned by the Member to begin with).
     */
    public Member returnItem(int uID) throws ReturnException{
        
        int[] borrowed_list = this.checkedOut.clone();
        int[] temp = new int [borrowed_list.length];
        int[] new_list = new int[borrowed_list.length];
        int[] final_list;
       
        if(borrowed_list.length!=0){
            final_list = new int[borrowed_list.length-1];
       
        }
        else{
            throw new ReturnException("Invalid List");
        }
        Boolean item_notfound = true; 
        for( int ct = 0; ct < borrowed_list.length; ct++){
            if(borrowed_list[ct]==uID){
                item_notfound=false;
                continue;
            }
            temp[ct] = borrowed_list[ct];
        }

        for (int j =0, k =0; j < borrowed_list.length; j ++){
                if(temp[j]==0){
                    continue;
                }
                new_list[k]=temp[j];
                k++;
        }
        for(int z =0; z<final_list.length;z++){
            final_list[z] = new_list[z];
        }

        if(item_notfound){
            throw new ReturnException("Items was not in your list");
        }       
        return new Member(this.firstName, this.lastName, this.memberID, this.passkey, final_list.clone());

    }


    /**
     *TODOy
     * Gets member id.
     *@return the member ID is returned.
     */
    public int getMemberID(){
    return this.memberID;
    }

    /**
     * Checks equality between the Staff member and another object. Two staff members are considered equal if their staff IDs and their passkeys are identical.
     * @return if the two Staff members are equal return true.
     */
    @Override
    public boolean equals(Object o){
	if(!(o instanceof Member))
	    return false;
	return ((Member)o).memberID == memberID && ((Member)o).passkey == passkey;
    }

    //TODO
    @Override
    public String toString(){
        return super.getName();
    }
}
