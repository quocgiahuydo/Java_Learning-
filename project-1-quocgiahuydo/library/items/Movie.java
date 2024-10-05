package library.items;
import library.items.Item;
import library.exceptions.*;
import java.util.ArrayList;
import java.io.*;
import javax.print.DocFlavor;
/**
 *TODO
 * Represents a Movie Item in the Library.
 */
public class Movie implements Item{
    private final int uID;
    private final int copies;
    private final int copiesAvailable;
    private final String title;
    private final String description;
    private final ArrayList<String> subjects;
    private final Genre genre; 
    private final int directorID;
    private final int duration; //in seconds

    public static class MovieBuilder{
        private final int uID;
        private int copies = 1;
        private int copiesAvailable;
        private String title;
        private String description;
        private ArrayList<String> subjects = new ArrayList<String>();
        private Genre genre; 
        private int directorID;
        private int duration; 
    
        /**
         * BookBuilder constructor; used to create a Book Item. The title is needed to set the unique ID (the hash code of the title plus "BOOK"). 
         * @param title Title for the Book.
         */
        public MovieBuilder(String title){
            this.title = title;
            this.uID = (title+"MOVIE").hashCode();
        }
    
        /**
         * Sets the number of copies (and thus the number of available copies).
         * @param copies The number of copies for the Book.
         * @return Returns the same BookBuilder instance.
         */
        public MovieBuilder setCopies(int copies){
            this.copies = copies;
            this.copiesAvailable = copies;
            return this;
        }
    
        /**
         * Sets the description.
         * @param description The description for the Book.
         * @return Returns the same BookBuilder instance.
         */
        public MovieBuilder setDescription(String description){
            this.description = description;
            return this;
        }
    
        /**
         * Sets the subjects.
         * @param subjects An array containing each subject.
         * @return Returns the same BookBuilder instance.
         */	
        public MovieBuilder setSubjects(String... subjects){
            this.subjects = new ArrayList<>();
            for(String s: subjects){
            this.subjects.add(s);
            }
            return this;
        }
    
        /**
         * Sets the genre.
         * @param genre The genre of the Book.
         * @return Returns the same BookBuilder instance.
         */	
        public MovieBuilder setGenre(Genre genre){
            this.genre = genre;
            return this;
        }
    
        /**
         * Sets the author.
         * @param name The name of the Book's author.
         * @return Returns the same BookBuilder instance.
         */	
        public MovieBuilder setDirector(String name){
            if(name != null)
            this.directorID = name.hashCode();
            return this;
        }
    
        /**
         * Sets the page count.
         * @param pageCount The number of pages for the Book.
         * @return Returns the same BookBuilder instance.
         */	
        public MovieBuilder setDuration(int duration){
            this.duration = duration;
            return this;
        }
    
        /**
         * Builds the Book object.
         * @return Returns the constructed Book.
         */	
        public Movie build(){
            return new Movie(this);
        }
        }
    
        /**
         * Constructs a Book object.
         * @param b BookBuilder object used to construct the Book.  
         */
        protected Movie(MovieBuilder b){
        uID = b.uID;
        copies = b.copies;
        copiesAvailable = b.copiesAvailable;
        title = b.title;
        description = b.description;
        subjects = b.subjects;
        genre = b.genre;
        directorID = b.directorID;
        duration = b.duration;
        }
    
        /**
         * Constructs a copy of the Book object with a different number of copies available.
         * @param b Book object used to construct a copy of the Book.
         * @param newCopiesAvailable the new number of copies available.
         */
        private Movie(Movie b, int newCopiesAvailable){
        uID = b.getUID();
            copies = b.getCopies();
        copiesAvailable = newCopiesAvailable;
        title = b.getTitle();
        description = b.getDescription();
        subjects = b.getSubjects();
        genre = b.getGenre();
        directorID = b.getDirectorID();
        duration = b.getDuration();
        }
        
        public boolean isAvailable(){
        if(copiesAvailable > 0)
            return true;
        return false;
        }
    
        public Item checkOut() throws CheckOutException{
        if(isAvailable())
            return new Movie(this, copiesAvailable - 1);
            throw new CheckOutException("Could not check out " + title  + "!");
        }
    
        public Item returnItem() throws ReturnException{
        if(copiesAvailable < copies)
            return new Movie(this, copiesAvailable + 1);
            throw new ReturnException("Could not return " + title  + "!");
        }
    
        public ArrayList<String> getSubjects(){
        return new ArrayList<String>(subjects);
        }
    
        public int getUID(){
        return uID;
        }
    
        public String getDescription(){
        return description;
        }
    
        public Genre getGenre(){
        return genre;
        }
    
        public int getCopies(){
        return copies;
        }
    
        public int getAvailableCopies(){
        return copiesAvailable;
        }
    
        public String getTitle(){
        return title;
        }
    
        /**
         * Gets the author id.
         *@return The author id is returned.
         */
        public int getDirectorID(){
        return directorID;
        }
    
        public int getArtistID(){
        return getDirectorID();
        }
        
        public int getDuration(){
        return this.duration;
        }

	    public String getLength(){
		return("Runtime: "+ String.valueOf(this.duration/3600)+"h");
	}
    
        @Override
        public String toString(){
        return String.format("%s (Movie, 0x%x)", title, uID);
        }
    }
    


