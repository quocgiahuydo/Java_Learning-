public class ArrayOps{
    //Add together every element in the array 
    public static int sum(int[] arr){
	int sum = 0;
	for(int i = 0; i < arr.length; i++){
	    sum += arr[i];
	}
	return sum;
    }
    //Get the average of the values in the array
    public static float average(int[] arr){
        float sum = sum(arr);
        return sum / arr.length;
    }    
    //Naive while loop to iterate over the array to find the given value
    public static boolean find(int[] arr, int val){
        int i = 0;
	boolean found = true;
	while(i < arr.length){
	    if(arr[i] == val){
		return found;
	    }
	    i++;
	}
	return !found;
    }
}
