public class Run{
    public static void main(String[] args){
	int[] arr = {1,2,3,4,5,6};
	System.out.println(ArrayOps.sum(arr)); //1. Should print 21
	System.out.println(ArrayOps.average(arr));//2. Should print 3.5
	System.out.println(ArrayOps.find(arr, 3)); //3. Should print true
	System.out.println(ArrayOps.find(arr, 7)); //4. Should print false
    }
}
