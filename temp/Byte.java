import java.util.Scanner;
public class Byte{
     public static void main(String[] args){
	 int[][]mat = {{1,2,3},{4,5,6},{7,8,8}};
	 int sum =0;
	 for(int[]  s: mat){
	     for(int i : s){
	     sum +=i;
	     }
}
	 System.out.println("Sum of the array "+sum);
}
}

