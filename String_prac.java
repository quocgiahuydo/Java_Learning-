import java.util.Scanner;

public class String_prac{
    public static void main(String[] args){
	
	Scanner scnr = new Scanner(System.in); //Create Object Scanner named scnr
	System.out.println("Please input the first text");
	String name = scnr.next();//scnr.next() method print without whitespace
	System.out.println();
	String temp = scnr.nextLine();
	System.out.println("Please input the second text");
	String space_name = scnr.nextLine();
	System.out.println("Here are yours outdput:");
	System.out.println("1) "+ name);
	System.out.println("2) "+ space_name);
    }
}

