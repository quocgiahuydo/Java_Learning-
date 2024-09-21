import java.util.Scanner;
public class salary{
    public static void main(String[] args){
	Scanner scnr = new Scanner(System.in);
	System.out.println("Please input your hours of working: ");
	int hours = scnr.nextInt();
	
	int wages = 15;
	double tax_rate = 0.1;
	int total = wages * hours;
	double tax = tax_rate*total;
	double income = total - tax;
	System.out.print("Your total wage is:");
	System.out.println(income);
    }
}

