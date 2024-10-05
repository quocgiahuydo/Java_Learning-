package library;
import library.exceptions.*;
import library.items.*;
import library.people.*;
import library.structures.*;
import java.util.ArrayList;

/**
 *Class which represents a Library. The library contains Staff, Members, Artists, and Items.
 *
 */
public class Library{
    private final OrderedList<Integer, Item> catalogue;
    private final OrderedList<Integer, Staff> staffList;
    private final OrderedList<Integer, Member> memberList;
    private final OrderedList<Integer, Artist> artistList;

    /**
     *Constructor for creating a Library. A staff member must be supplied to guarantee the library can be altered.
     *@param admin used to initialize the Library
     */
    public Library(Staff admin){
	catalogue = new OrderedList<>();
	staffList = new OrderedList<>();
	staffList.insert(admin.getStaffID(), admin);
	memberList = new OrderedList<>();
    artistList = new OrderedList<>();
    }

    /**
     *TODO
     *Method which validates given staff member
     *@param staff used to check if provided Staff object exists in the Library.
     *@return if staff is validated, true is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     */

    
    public boolean validateStaff(Staff staff) throws InvalidPermissionsError {
        Staff temp = staffList.get(staff.getStaffID());
        if(temp==null){
            throw new InvalidPermissionsError("Invalid Permission");
        }
        else{
            return true;
        }
        

    }

    /**
     *TODO
     *Method which validates given member
     *@param member used to check if provided Member object exists in the Library.
     *@return if member is validated, true is returned.
     *@throws InvalidPermissionsError if member has invalid permissions
     */
    public boolean validateMember(Member member) throws InvalidPermissionsError{
        Member temp_mem = memberList.get(member.getMemberID());
        if(temp_mem == null){
        throw new InvalidPermissionsError("Invalid Permission");
    }
    else{
        return true;
    }
    
}

    /**
     *TODO
     *Method which adds an Item to the Library
     *@param staff Used to check correct permissions are sent to alter Library.
     *@param item Item to be added.
     *@return if the item is added, true is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     *@throws DuplicateError if item with the same uID exists in the Library
     */

    public boolean addItem(Staff staff, Item item) throws InvalidPermissionsError, DuplicateError{
        Staff temp;
        Item item_temp;
        item_temp = catalogue.get(item.getUID());
        temp = staffList.get(staff.getStaffID());
        if (temp != null){
            if(item_temp !=null){
                throw new DuplicateError("The item has been in the catalogue");
            }
            else{
                catalogue.insert(item.getUID(), item );
                return true;
            }

        }
        else {
            throw new InvalidPermissionsError("You dont have the permission to access");
    }
        
    }
    
    /**
     *TODO
     *Method which adds an Artists to the Library
     *@param staff Used to check correct permissions are sent to alter Library.
     *@param artist Artist to be added.
     *@return if the artist is added, true is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     *@throws DuplicateError if artist with the same artistID exists in the Library
     */
    public boolean addArtist(Staff staff, Artist artist)throws InvalidPermissionsError, DuplicateError{
        Staff temp;
        Artist artist_temp;
        artist_temp = artistList.get(artist.getArtistID());
        temp = staffList.get(staff.getStaffID());
        if (temp != null){
            if(artist_temp !=null){
                throw new DuplicateError("This artist is in the list");
            }
            else{
                artistList.insert(artist.getArtistID(), artist );
                return true;
            }

        }
        else {
            throw new InvalidPermissionsError("You dont have the permission to access");
    }
        
    }
    
    /**
     *TODO
     *Method which adds a Staff to the Library
     *@param staff Used to check correct permissions are sent to alter Library.
     *@param oStaff Staff to be added.
     *@return if the staff is added, true is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     *@throws DuplicateError if staff with the same staffID exists in the Library
     */

     public boolean addStaff(Staff staff, Staff oStaff) throws InvalidPermissionsError, DuplicateError{
        Staff temp_staff = staffList.get(staff.getStaffID());
        Staff temp_oStaff = staffList.get(oStaff.getStaffID());
        if (temp_staff != null){
            if(temp_oStaff!=null){
                throw new DuplicateError("This staff is already in the system");
            }
            else{
                staffList.insert(oStaff.getStaffID(), oStaff);
                return true;
            }

        }
        else {
            throw new InvalidPermissionsError("Users dont have the permission to access");
    }
     }


    /**
     *TODO
     *Method which adds a Member to the Library
     *@param staff Used to check correct permissions are sent to alter Library.
     *@param member Member to be added.
     *@return if the artist is added, true is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     *@throws DuplicateError if member with the same memberID exists in the Library
     */
    public boolean addMember(Staff staff, Member member)throws InvalidPermissionsError, DuplicateError{
        Staff temp_staff = staffList.get(staff.getStaffID());
        Member temp_mem = memberList.get(member.getMemberID());
        if (temp_staff != null){
            if(temp_mem!=null){
                throw new DuplicateError("This member is already in the system");
            }
            else{
                memberList.insert(member.getMemberID(), member);
                return true;
            }

        }
        else {
            throw new InvalidPermissionsError("Users dont have the permission to access");
    }
     }



    /**
     *TODO
     *Checks out the Item from the Library
     *@param staff Used to check correct permissions are sent to alter Library.
     *@param member Member who is receiving the copy.
     *@param item Item to be added.
     *@return if the book can be checked out, true is returned; if the book cannot be checked out, false is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     */
    public boolean checkOutItem(Staff staff, Member member, Item item)throws InvalidPermissionsError{
        Member temp = memberList.get(member.getMemberID());
        Item tem_item = catalogue.get(item.getUID());
        int[] mem_list = temp.getCheckedOut();
        try {
        validateStaff(staff);
        for(Integer i :mem_list){
            if(i == item.getUID()){
                throw new DuplicateError("This item has been checkedouted to this Member");
            }
        }
        tem_item = tem_item.checkOut();
        catalogue.insert(item.getUID(),tem_item);
        member = temp.checkOut(item.getUID());
        memberList.insert(member.getMemberID(), member);
        return true;   
        
    } catch (InvalidPermissionsError e) {
        throw new InvalidPermissionsError("Invalid Permission");
    } catch (CheckOutException e){
        System.out.println(e);
        return false;
    } 
        catch (Exception e){
            System.out.println(e);
            return false;
    }
}

    

    /**
     *TODO
     *Returns checked out Item from the Library
     *@param staff Used to check correct permissions are sent to alter Library.
     *@param member Member who is returning the copy.
     *@param item Item to be returned.
     *@return if the book was successfully returned, true is returned; if the book cannot be returned, false is returned.
     *@throws InvalidPermissionsError if staff has invalid permissions
     */    
    public boolean returnItem(Staff staff, Member member, Item item) throws InvalidPermissionsError{
        Member temp = memberList.get(member.getMemberID());
        Item item_temp = catalogue.get(item.getUID());
        try {
            validateStaff(staff);
            item_temp=item_temp.returnItem();
            temp=temp.returnItem(item.getUID());
            catalogue.insert(item.getUID(), item_temp);
            memberList.insert(member.getMemberID(), temp);
            return true;   
            
        } catch (InvalidPermissionsError e) {
            throw new InvalidPermissionsError("Invalid Permission");
        } catch (ReturnException e){
            return false;   
        }
    }

    /**
     *Returns the current Library catalogue.
     *@param person Used to check correct permissions are sent to receive catalogue information.
     *@return a copy of the internal catalogue.
     *@throws InvalidPermissionsError if person has invalid permissions
     */    
    public OrderedList<Integer, Item> getCatalogue(Person person) throws InvalidPermissionsError{
	switch (person){
	    case Member m -> validateMember(m);
	    case Staff s -> validateStaff(s);
	    default -> throw new InvalidPermissionsError("null value");
	}
	return new OrderedList<Integer, Item>(catalogue);
    }

    /**
     *TODO
     *Returns all artists in the current Library catalogue.
     *@param person Used to check correct permissions are sent to receive artist information.
     *@return a copy of the internal artist list.
     *@throws InvalidPermissionsError if person has invalid permissions
     */    
    public OrderedList<Integer, Artist> getArtists(Person person) throws InvalidPermissionsError{
    switch (person){
        case Staff s -> validateStaff(s);
        case Member m -> validateMember(m);
        default -> throw new InvalidPermissionsError("null value");
        }
        return new OrderedList<Integer, Artist>(artistList);
    }



    /**
     *TODO
     *Returns all staff in the Library.
     *@param staff Used to check correct permissions are sent to receive staff information.
     *@return a copy of the internal staff list.
     *@throws InvalidPermissionsError if person has invalid permissions
     */    
    public OrderedList<Integer, Staff> getStaff(Staff staff) throws InvalidPermissionsError{
        try {
            validateStaff(staff);
            return new OrderedList<Integer, Staff>(staffList);
        } catch ( InvalidPermissionsError e) {
            throw new InvalidPermissionsError("null value");
    }
}


    /**
     *TODO
     *Returns all members in the Library.
     *@param staff Used to check correct permissions are sent to receive member information.
     *@return a copy of the internal member list.
     *@throws InvalidPermissionsError if person has invalid permissions
     */    
    public OrderedList<Integer, Member> getMembers(Staff staff) throws InvalidPermissionsError{
        try {
            validateStaff(staff);
            return new OrderedList<Integer, Member>(memberList);
        } catch ( InvalidPermissionsError e) {
            throw new InvalidPermissionsError("null value");
    }
    }

    /**
     *TODO
     *Returns all items associated with the given Artist in the Library.
     *@param person Used to check correct permissions are sent to receive staff information.
     *@param artist Artist to match with items.
     *@return String listing all items associated with given artist.
     *@throws InvalidPermissionsError if person has invalid permissions
     */    
    public String allArtistItems(Person person, Artist artist) throws InvalidPermissionsError{
        switch (person){
            case Staff s -> validateStaff(s);
            case Member m -> validateMember(m);
            default -> throw new InvalidPermissionsError("null value");
            }
        StringBuilder temp = new StringBuilder();
        ArrayList<Integer> arr;
        arr = catalogue.getKeys();
        System.out.print("Result for "+artist.getName()+": ");
        int j =1;
        for(Integer i:arr){            
            Item h = catalogue.get(i);
            if(h.getArtistID()== artist.getArtistID()){
                temp.append(h.toString()).append(", ");
            }
        }
        
        return temp.toString();
    }


    /**
     *TODO
     *Returns all items associated with the given Genre in the Library.
     *@param person Used to check correct permissions are sent to receive staff information.
     *@param genre Genre to match with items.
     *@return String listing all items associated with given artist.
     *@throws InvalidPermissionsError if person has invalid permissions
     */
    public String allGenreItems(Person person, Item.Genre genre) throws InvalidPermissionsError{
 
       
        ArrayList<Integer> arr;
        StringBuilder temp = new StringBuilder();
        arr =catalogue.getKeys();
        switch (person){
            case Staff s -> validateStaff(s);
            case Member m -> validateMember(m);
            default -> throw new InvalidPermissionsError("null value");
            }
        System.out.print("Result for "+ genre+": ");
        for(Integer i : arr){
            Item h = catalogue.get(i);
            if(h.getGenre() == genre){
                temp.append(h.toString()).append(" ");

            }
        }
        return temp.toString();
        
}  





    /**
     *TODO
     *Returns all items checked out by Member in the Library.
     *@param staff Used to check correct permissions are sent to receive Member information.
     *@param member Member to find checked out items.
     *@return String listing all items checked out by member.
     *@throws InvalidPermissionsError if person has invalid permissions
     */        
    public String memberCheckedOutItems(Staff staff, Member member) throws InvalidPermissionsError, CheckOutException{
    
    ArrayList<Integer> arr;
    StringBuilder temp = new StringBuilder();
    arr = catalogue.getKeys();
    
    try{
        Member temp2;
        temp2 = memberList.get(member.getMemberID());     
        int[] list = temp2.getCheckedOut();            
        validateStaff(staff);
        int j =1;
        for(Integer i : arr){
            Item h = catalogue.get(i);
            for(int ct =0; ct < list.length; ct++){
                if(h.getUID() == list[ct]){
                    temp.append(h.toString()).append(" ");
                if(j++!= arr.size()){
                        temp.append(", ");
                    }
                }
        }
        }
        if(list.equals(null) || list.length==0){
            return ("Restult for "+ member.getName()+": ~There's nothing here");
        }
    }catch (InvalidPermissionsError e) {
        throw new InvalidPermissionsError("null value");
}  
    catch (Exception e){
        return ("Restult for "+ member.getName()+": ~There's nothing here~");
    }
        
    return ("Result for "+ member.getName() +": "+temp.toString());
}

    
    

    

    /**
     *TODO
     *Returns all available items in the Library.
     *@param person Used to check correct permissions are sent to receive available item information.
     *@return String listing all available items.
     *@throws InvalidPermissionsError if person has invalid permissions
     */        
    public String allAvailableItems(Person person) throws InvalidPermissionsError{
    
    ArrayList<Integer> arr;
    StringBuilder temp = new StringBuilder();
    arr = catalogue.getKeys();
    switch (person){
        case Staff s -> validateStaff(s);
        case Member m -> validateMember(m);
        default -> throw new InvalidPermissionsError("null value");
        }
    int j =1;
    for(Integer i: arr){
        Item h = catalogue.get(i);
        if(h.getAvailableCopies()>0){
            temp.append(h.toString()).append(", ");
            
        }
    }   
        return ("Available Titles: "+temp.toString());
    }


    /**
     *TODO
     *Returns all information about the given item.
     *@param person Used to check correct permissions are sent to receive available item information.
     *@param uID unique ID associated with desired item.
     *@return String listing all information present for the given item.
     *@throws InvalidPermissionsError if person has invalid permissions
     */        
   public String getDetailedItemInfo(Person person, int uID) throws InvalidPermissionsError{
    ArrayList<Integer> arr;
    StringBuilder temp = new StringBuilder();
    arr = catalogue.getKeys();
    switch (person){
        case Staff s -> validateStaff(s);
        case Member m -> validateMember(m);
        default -> throw new InvalidPermissionsError("null value");
        }
   
    for(Integer i : arr){
        Item h = catalogue.get(i);
        if(h.getUID()==uID){
            temp.append("\t"+"Title: "+ h.getTitle()+"\n").append("\t"+"Author: "+ artistList.get((h.getArtistID()))
            +"\n").append("\t"+"Description: "+ h.getDescription()+"\n").append("\t"+"Genre: "+ h.getGenre()+"\n")
            .append("\t"+h.getLength()+"\n").append("\t"+"Copies: "+ h.getAvailableCopies()+"/"+h.getCopies()+"\n").
            append("\t"+"Subject: "+ h.getSubjects()+"\n").append("\t"+"UID: "+ String.format("0x%x",h.getUID())+"\n");
        }
    }
    return (String.format("Details for 0x%x\n",uID)+ temp.toString());
}
}
