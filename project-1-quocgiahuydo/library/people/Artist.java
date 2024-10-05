package library.people;
/**
 * Used to represent Artists who have works in the Library catalogue.
 */
public class Artist extends Person{
     private final int artistID;
    
    /**
     *TODO
     * Constructs an Artist object. Sets the artist id to the hash code of the first name plus the last name with a space inbetween.
     *@param firstName The artist's first name. 
     *@param lastName The artist's last name.
     */
    private String artist_id; 
   
    public Artist(String firstName, String lastName){
	super(firstName, lastName);
	this.artist_id = super.firstName + " " + super.lastName;
	this.artistID = this.artist_id.hashCode();
    }

    /**
     *TODO
     * Gets the artist id.
    // *@return Returns the artist id.
     */
      public int getArtistID(){
	  return this.artistID;
      }

    //TODO
	@Override
      public String toString(){
	return super.getName();
       }
}
