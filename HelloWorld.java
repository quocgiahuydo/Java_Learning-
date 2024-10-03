import java.util.Scanner;

public class HelloWorld{

	public static void main(String[] args){

	Scanner scnr = new Scanner(System.in);

	int loop_numbs = scnr.nextInt();

	for(int i = 0; i < loop_numbs; i++)
	    {
        System.out.println("Hello World!");
	}
	System.out.println("Harryr Do");
    }
}