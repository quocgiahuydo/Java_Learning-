import java.util.Arrays;
public class Example{
    int[] arr;
    public Example(Example ex){
	this.arr = new int[ex.arr.length];
	for(int i =0; i < this.arr.length; i++){
	    this.arr[i] = ex.arr[i];
	}
    }
    public Example(int[] arr){
	  this.arr =Arrays.copyOf(arr, arr.length);
      }
	
    
}
