[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/jN1dkvwR)
# Project 1 - Creating a Library
## Contents
1. [Introduction](#introduction)
2. [Source Code](#source-code)
3. [Given Code](#given-code)
4. [Reading The Javadoc](#reading-the-javadoc)
5. [Your Task](#your-task)
6. [Submit Your Work](#submit-your-work)
7. [Grading](#grading)
8. [Rubric](#rubric)
9. [Examples](#examples)
10. [Tips](#tips)
11. [Installing JDK 22](#installing-jdk-22)

## Introduction
In this project you will add new functionality to a Java program dedicated to the management of a library. The goal of this project is to become familiar with how _inheritance_ works in Java, to get some experience managing Java packages, and learn some Java basics.

This is an individual project and is expected to be completed without any code-sharing between yourself and your classmates.

This project contributes 6.25% toward the final grade.

This project and all subsequent projects will make use of JDK 22, which means you'll need a version of Java equivalent or newer. [Click here](#installing-jdk-22) to learn how to install JDK 22 on the remote system.

## Source Code
For this and all the later projects, you will be working on the baseline code that needs to be
downloaded from this Github repo. Furthermore, all projects will include a corresponding `javadoc` which you can read to aid you in your implementations. **Please make sure you read this whole section, as well as the [grading guidelines](#grading), before cloning the repo on Github.**

## Given Code
If you take a look at the current repo you’ll see that you’ve been given quite a bit of skeleton code to get
you started on completing the project. This section is dedicated to giving a brief overview of the different classes that you’ll be using.

### The Library Class
The Library object acts as a database the stores Items, is used by Members, and is managed by Staff. Many of the methods associated with altering the state of the Library must be validated with a proper Staff object (this is why the Library constructor takes an initial Staff member). More information on the Library class can be found in the `javadoc`.

### The Item Interface
The Item interface details the behaviour expected from Item objects. I have provided a Book class which implements Item. You'll find that it's impossible to instantiate an Item without specifying a class which implements it, this is part of Java's object model---interfaces simply describe shared behaviour.

Item also contains a static enum, Genre. Enums are a special type of class in Java which deal only in predifined constants. There are only seven types of genres capable of being enumerated in our Library: `SCI_FI`, `FANTASY`, `DRAMA`, `HORROR`, `CRIME`, `COMEDY`, `NONFICTION`. You can access them like so: `Item.Genre.SCI_FI`.

**The Item interface does not need to be altered.**

### The Book Class
Book is an implementation of the Item interface, but it looks a little different than some of the classes I've shown in class up to this point. **Book is immuatable** which means that the state of a Book object should never change; in the event a Book needs to be altered a new Book object is returned with the altered features. It is almost always preferrable to use immutable objects when writing Java code (the reasons for which will, ideally, be discussed at a later point in lecture).

Because Book is immutable, we need some way of constructing a Book object. The most convenient way to do so is by using a Builder pattern. Many Java objects use this pattern (i.e, the Calendar object). In order to facilitate the usage of the builder pattern Book contains a static inner class BookBuilder which *is mutable*. Only on invocation of the build() method does BookBuilder return an immutable Book object. This means to instantiate a Book object I cannot directly call its constructor, but must instead invoke the Builder methods. The Driver provides many examples of how to use the API. 

**The Book class does not need to be altered.**

### The Person Class
The Person class defines what it means to store Person-like data on the database. Much like Item, Person cannot be instantiated despite looking somewhat like Book or Library. This is because Person is *abstract* which means it is allowed to implement instance methods and define instance fields. It provides a scaffold for developing more specific types of people.

### The Artist Class
The Artist class defines which artists exist in the Library. Artists have a unique ID which is derived from calling the String objects hashCode() method on the first name plus the last name with a space in between.

### The Member Class
The Member class represents people who use the Library's services. Members are Persons who have a unique member ID and passkey, the values of which are calculated by using the String object's hashCode() method. Members also have a list of items that they currently have checked out---since each item has a unique ID all we need to do is store the ID in an array and look at that array to see which items are in a Member's possession.  

### The Staff Class
The Staff class represents people who mange the Library. Staff, much like members, have a unique ID and a passkey, the values of which are calculated by using the String object's hashCode() method. The Staff type exists because staff members have greater access to database queries/requests.

### The Exceptions Package
You'll notice that many method signatures include something along the lines of `throws InvalidPermissionsError`. These special objects are called "exceptions" in Java and are useful for providing detailed information about why a portion of code may not have executed as intented. Throwing an exception is quite easy. For example, if I wish to throw an InvalidPermissionsError all I need to do is write: `throw new InvalidPermissionsError(msg)` where `msg` is a String containing some kind of useful error message for the user. I have provided you with four custom exceptions: CheckOutException, DuplicateError, InvalidPermissionsError, and ReturnException. Check the `javadoc` to know which methods should throw which errors.  

**The Exceptions do not need to be altered.**

### The OrderedList Class
I have provided an Ordered Linked List implementation for you to use for collecting Items, Staffs, Members, and Artists. The reason for using this will be more apparent in Project 2. You can check the `javadoc` for more instruction on how to use the API. You'll want to use unique IDs as the key values and the objects themselves as the contained data.

### The Driver Class
The Driver class provides a small set of instructions that can be used to test your implementation. Unlike the other classes, the Driver contains a main method which acts as the entry point for the Java Virtual Machine (JVM) to run the bytecode created by your calls to `javac`. Without a main the class files wouldn't be able to run.

The Driver is there to help you get started testing out your code; it does not, however, contain every conceivable test that could be run. When the TAs test your code it will be done **with our own Driver file**.

### The Makefile
You've been provided a makefile that always compiles `Driver.java` as well as all accompanying `java` files in the source code. (There are more clever ways to write makefiles than what is presented, but I didn't bother to do so here since our code base is rather tiny.) When you are in the base directory, you can compile your files with a call to `make`; I have provided the `-g` flag so you can use jdb to debug any object and `-d` so all of the class files end up in a directory called "build". You can call `make clean -k` to remove all `class` files and temporary emacs files from your directories.

You may alter the makefile however you like, but there is no need to do so.

## Reading The Javadoc
Using `javadoc`, I have compiled a set of documentation that you can read to help provide you with direction on how certain methods should behave. Once you clone this repo you can easily read through the documentation by clicking on `index.html` and opening it in your browser of choice. Once you've done so, you can freely click around on the hyperlinks to view in finer and finer detail all of the packages, classes, and methods that should be implemented for the finished project.

## Your Task
- Implement all methods marked with TODO in the following java files: `Library.java`, `Staff.java`, `Artist.java`, `Member.java`, and `Person.java`
- Fully implement the Movie class (use the Book class as a stencil)

## Submit Your Work
Once your code is ready for grading, make sure you commit it to the Github Classroom Repo. **Any commits pushed after the deadline will be considered late submissions.**

Please also include a `PROJ1.txt` file explaining your experience working on this project.
- The status of your implementation (especially, if not fully complete).
- A description of how your code works, if that is not completely clear by reading the code (note that this should not be necessary, ideally your code should be self-documenting).
- Possibly a log of test cases which work and which don't work.
- Any other material you believe is relevant to the grading of your project.
**Suggestion**: Test your code thoroughly on a CS machine before submitting.

## Grading
The following are the general grading guidelines for this and all future projects.
- Late penalty is 30\% of the points scored for each of the first two days late, and will not be graded thereafter.
- If the submitted code cannot be successfully patched to the baseline source code, or the patched code does not compile:
  ```
  1	TA will try to fix the problem (for no more than 3 minutes);
  2	if (problem solved)
  3	  1%-10% points off (based on how complex the fix is, TA's discretion);
  4	else
  5	  TA may contact the student by email or schedule a demo to fix the problem;
  6	  if (problem solved)
  7	    11%-20% points off (based on how complex the fix is, TA's discretion);
  8	  else
  9	    All points off;

  ```
So in the case that TA contacts you to fix a problem, please respond to TA's email promptly or show up at the demo appointment on time; otherwise the line 9 above will be effective.
- If the code is not working as required in the project spec, the TA should take points based on the assigned full points of the task and the actual problem.
- Lastly but not the least, stick to the collaboration policy stated in the syllabus: you may discuss with your fellow students, but code should absolutely be kept private. You may not use any kind of generative AI to assist you. Any kind of cheating will result in zero points on the project, and further reporting.

## Rubric
- Code Compiles (20 Points)
- Movie can be instantiated properly and is immutable (10 Points)
- A baseline of 70 points is granted. All Library queries/requests will be tested (`allArtistItems`, `allAvailableItems`, `checkOutItem`, etc.). Each failed query/request will result in -5 points.

*Note*: Strings will be tested by calling `cleanString(yourString).equals(cleanString(myString))` where `cleanString(str)` is a wrapper around `str.replaceAll("[\n\t\r ]", "").toLowerCase()`. This is done to minimize the potential for false negatives.

## Examples
Below are examples of what each query should return given the following Library state:
- Books

| Title | Author | Copies | Desc | Genre | Pages | Subject |
| ------ | ------ | ------ | ------ | ------ | ------ | ------ | 
| Gravity's Rainbow | Thomas Pynchon | 1 | A novel by Thomas Pynchon | DRAMA | 760 | WW2, V2-Rocket, Statistics |
| V | Thomas Pynchon | 3 | A novel by Thomas Pynchon | DRAMA | 492 | WW2, Sewer Alligators, Kilroy |
| Hamlet | William Shakespeare | 2 | A play by Shakespeare | DRAMA | 432 | Denmark, Patricide, Existentialism |
| Sot-Weed Factor | John Barth | 1 | A novel by John Barth | COMEDY | 768 | Maryland, Poetry |

- Movies

| Title | Director | Copies | Desc | Genre | Duration (s) | Subject |
| ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| Bad Lieutenant | Abel Ferrara | 1 | A movie by Abel Ferrara | CRIME | 5760 | Gambling, Sports, Catholocism |
| Andrei Rublev | Andrei Tarkovsky | 1 | A movie by Andrei Tarkovsky | DRAMA | 10980 | Painting, Icons, Pagans |
| Suspiria | Dario Argento | 2 | A movie by Dario Argento | HORROR | 5940 | Dancing, Witchcraft |
| Wake in Fright | Ted Kotcheff | 1 | A movie by Ted Kotcheff | HORROR | 6540 | Drinking, Australia, Kangaroos |

- Staff

| First Name | Last Name | userID | passkey |
| ------ | ------ | ------ | ------ |
| Kurt | Godel | kGod | incompleteness |
| John | von Neumann | JVN | EDVAC |

- Members

| First Name | Last Name | userID | passkey | Items
| ------ | ------ | ------ | ------ | ------ |
| Alan | Turing | aTuring | enigmaUTM | Hamlet, Bad Lieutenant |
| Alonzo | Church | aChurch | lambda | ... |

#### Expected Output
1. ```
   System.out.println(String.format("""                                                                                                                          
                                 Book: %s                                                                                                                     
                                 Movie: %s                                                                                                                    
                                 Artist: %s                                                                                                                   
                                 Member: %s                                                                                                                   
                                 Staff: %s                                                                                                                    
                                 """,                                                                                                                         
                                 gR,                                                                                                                          
                                 wakeInFright,                                                                                                                
                                 new Artist("John", "Barth"),
                                 aTuring,
                                 kGod));
   ```
```
Book: Gravity's Rainbow (Book, 0x2dbf9a39)
Movie: Wake in Fright (Movie, 0xca65029b)
Artist: Barth, John
Member: Turing, Alan
Staff: Godel, Kurt
```

2. `System.out.println(allArtistItems(aChurch, new Artist("Thomas", "Pynchon")));`
```
Results for Pynchon, Thomas: V (Book, 0x4db183f), Gravity's Rainbow (Book, 0x2dbf9a39)
```
3. `System.out.println(lib.allAvailableItems(aChurch));`
```
Available Titles: Bad Lieutenant (Movie, 0xb987b0f4), Wake in Fright (Movie, 0xca65029b), V (Book, 0x4db183f), Suspiria (Movie, 0xa37a630), Hamlet (Book, 0x21724a90), Gravity's Rainbow (Book, 0x2dbf9a39), Andrei Rublev (Movie, 0x31c18f51), Sot-Weed Factor (Book, 0x5d134876)
```
4. `System.out.println(lib.allGenreItems(Items.Genre.HORROR));`
```
Results for HORROR: Wake in Fright (Movie, 0xca65029b), Suspiria (Movie, 0xa37a630)
```
5. `System.out.println(lib.getDetailedItemInfo(aTuring, suspiria.getUID()));`
```
Details for 0xa37a630: 
	Title: Suspiria
	Author: Argento, Dario
	Description: A movie by Dario Argento
	Genre: HORROR
	Runtime: 1hr 39m 0s
	Copies: (2/2)
	Subjects: [Dancing, Witchcraft]
	UID: 0xa37a630
```
6. `System.out.println(lib.getDetailedItemInfo(aTuring, 0));`
```
Details for 0x0: ~There's nothing here~
```
7. ```
   System.out.println(lib.memberCheckedOutItems(JVN, aTuring));      
   System.out.println(lib.memberCheckedOutItems(JVN, aChurch));
   ```
```
Results for Turing, Alan items checked out: Hamlet (Book, 0x21724a90), Bad Lieutenant (Movie, 0xb987b0f4)
Results for Church, Alonzo items checked out: ~There's nothing here~
```
## Tips
- For formatting an integer `intVar` into its hexadecimal representation you can use `String.format("0x%x", intVar)`
- For constructing the more complicated String returns I recommend using [StringBuilder](https://docs.oracle.com/en%2Fjava%2Fjavase%2F22%2Fdocs%2Fapi%2F%2F/java.base/java/lang/StringBuilder.html). Call the [append](https://docs.oracle.com/en%2Fjava%2Fjavase%2F22%2Fdocs%2Fapi%2F%2F/java.base/java/lang/StringBuilder.html#append(java.lang.String)) method for concatenation and [toString](https://docs.oracle.com/en%2Fjava%2Fjavase%2F22%2Fdocs%2Fapi%2F%2F/java.base/java/lang/StringBuilder.html#toString()) to turn the StringBuilder into a proper Java String.
- If you'd like to iterate over every element in the OrderedList you can call the `getKeys()` method to get an [ArrayList](https://docs.oracle.com/en%2Fjava%2Fjavase%2F22%2Fdocs%2Fapi%2F%2F/java.base/java/util/ArrayList.html) containing every key. Afterwards, you can use those keys to `get()` elements stored with those keys from the OrderedList.
- Take note of the angle brackets (`<>`) used to declare certain types (ArrayList and OrderedList). These are called generics and we will learn more about them later in the semester. For this project our catalogue is an OrderedList of type OrderedList<Integer, Item>. This means that the keys are integers and the data are Items. **For all lists the Integer key corresponds to the uID of the object being stored.**

## Installing JDK 22
Installing JDK 22 is rather trivial, but may seem a bit arcane at first blush. 

The first thing you'll need is the JDK itself. SSH into your remote server and run the following:
```bash
wget https://download.java.net/java/GA/jdk22.0.2/c9ecb94cd31b495da20a27d4581645e8/9/GPL/openjdk-22.0.2_linux-x64_bin.tar.gz .
```
This will download a tar.gz archive file of the jdk into the directory you are currently working in. Next, we'll need to extract the compressed files:
```bash
tar -xzvf openjdk-22.0.2_linux-x64_bin.tar.gz
```
This should have created a folder called `jdk-22.0.2/`. Now we can remove the original tar file:
```bash
rm ./openjdk-22.0.2_linux-x64_bin.tar.gz
```
We're going to go the route of updating the PATH environment variable to include a search of this newly created directory. All you need to do is run:
```bash
export PATH="$HOME/jdk-22.0.2/bin/:$PATH"
```
We can test if this worked by running:
```bash 
java --version
```
If you see version 22.0.2 then it was a success! The only problem is that this *is not permanent* as we've only temporarily changed the PATH to include our new jdk. We can fix this by editing the `.bashrc` file in the home (`~/`) directory. Open the file and append the following:
```bash
PATH="$HOME/jdk-22.0.2/bin/:$PATH"
```
Every time the shell is connected to the PATH variable will be updated to include the jdk's bin directory.
