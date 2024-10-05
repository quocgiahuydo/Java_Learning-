import library.*;
import library.items.*;
import library.people.*;
/*
  You'll need to properly import the package files to use the different classes here. 
 */
public class Driver{
    public static void main(String[] args){
    Staff admin = new Staff("Joseph","Raskind","admin","admin"); //The Staff constructor creating a primordial staff member for the Library.
	Library lib = new Library(admin); //The Library constructor being invoked.
	Staff admin2 = new Staff("Harry Huy","Do", "creator", "mamnager");
	Book gR = new Book.BookBuilder("Gravity's Rainbow")
	                  .setCopies(1)
	                  .setDescription("A novel by Thomas Pynchon")
	                  .setGenre(Item.Genre.DRAMA)
	                  .setAuthor("Thomas Pynchon")
	                  .setPages(760)
	                  .setSubjects("WW2", "V2-Rocket", "Statistics")
	                  .build();
	int[] user_lists={324242,2342342,2342423};

	Member user_2 = new Member("Alan","Walker",21012005,222222,user_lists);
					  
	Member user = new Member("Alan", "Turing", "aturing", "UTM"); //Creating a member to add to the library
	try{
	    lib.addMember(admin, user);
	       lib.addStaff(admin, admin2);
		lib.addMember(admin2, user_2); 
		//addMember throws a checked exception which must be caught
	}catch(Exception e){
	    e.printStackTrace();
	}
	//Creating a Book Item. Book uses a Builder pattern: we leverage a public static class, BookBuilder, which is a mutable object, unlike Book which is immutable. Each call to a subsequent setter returns the same instance of the BookBuilder that is being mutated.
	
	Book v = new Book.BookBuilder("V")
	                 .setCopies(1)
	                 .setDescription("A novel by Thomas Pynchon")
	                 .setGenre(Item.Genre.DRAMA)
	                 .setAuthor("Thomas Pynchon")
	                 .setPages(492)
					 .setSubjects("Action","Adventures")
	                 .build();
	Book hamlet = new Book.BookBuilder("Hamlet")
	                      .setCopies(3)
	                      .setDescription("A play by Shakespeare")
	                      .setGenre(Item.Genre.DRAMA)
	                      .setAuthor("William Shakespeare")
	                      .setPages(100)
	                      .build();
	Book neuroM = new Book.BookBuilder("Neuromancer")
	                      .setCopies(2)
	                      .setDescription("A novel by William Gaddis")
	                      .setGenre(Item.Genre.SCI_FI)
	                      .setAuthor("William Gaddis")
	                      .setPages(250)
	                      .build();
	Movie hamletMovie = new Movie.MovieBuilder("Hamlet")
	                             .setCopies(2)
	                             .setDescription("A movie by Kenneth Branagh")
	                             .setGenre(Item.Genre.DRAMA)
	                             .setDirector("Kenneth Branagh")
	                             .setDuration(4*60*60 + 2*60)
								 .setSubjects("History", "gsdfhfsgj")
	                             .build();
	
	Artist thomasP = new Artist("Thomas", "Pynchon");
	Artist williamS =  new Artist("William", "Shakespeare");
	Artist williamG = new Artist("William", "Gaddis");
	Artist kennethB = new Artist("Kenneth", "Branagh");
	
	int[] userlist2 = {};
	
	Member user3 = new Member("Somename", "surname", 21323,1321313, userlist2);
	try{
	    lib.addMember(admin2, user3);
	    lib.addItem(admin, gR);
	    lib.addItem(admin, v);
	    lib.addItem(admin, hamlet);
	    lib.addItem(admin, neuroM);
	    lib.addItem(admin, hamletMovie);

	    lib.addArtist(admin, thomasP);
	    lib.addArtist(admin, williamS);
	    lib.addArtist(admin, williamG);
	    lib.addArtist(admin, kennethB);

	    System.out.println(lib.getCatalogue(admin));
	    System.out.println(lib.getArtists(admin));
	    System.out.println(lib.getStaff(admin));
	    System.out.println(lib.getMembers(admin));

	    System.out.println(lib.allArtistItems(user, thomasP));
	    System.out.println(lib.allGenreItems(user, Item.Genre.DRAMA));
	    System.out.println(lib.allGenreItems(user, Item.Genre.COMEDY));
		System.out.println(lib.checkOutItem(admin2, user3, hamletMovie));
		//System.out.println(lib.checkOutItem(admin, user, neuroM));

		System.out.println(lib.memberCheckedOutItems(admin, user));

		System.out.println(lib.checkOutItem(admin2, user_2, hamlet));

		System.out.println(lib.checkOutItem(admin, user_2, v));
		System.out.println("Testcasee212"+lib.returnItem(admin, user3, hamletMovie));
		

		System.out.println(lib.memberCheckedOutItems(admin, user_2));

		System.out.println(lib.allAvailableItems(user));

	    System.out.println(lib.getDetailedItemInfo(user, v.getUID()));

	    System.out.println(lib.getDetailedItemInfo(user, hamlet.getUID()));
		
		System.out.println(lib.checkOutItem(admin2, user_2, hamlet));

		System.out.println(lib.memberCheckedOutItems(admin, user_2));

		System.out.println(lib.getDetailedItemInfo(admin, hamlet.getUID()));
		

		

		
		

	}catch(Exception e){
	    e.printStackTrace();
	}
    }

}
