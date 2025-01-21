
//Selction Sort Algorithm
import java.util.Arrays;
class SelectionSort{
    public static void main(String[] args){
	int[] arr ={-10,41,144,-24,4,24,10,-6,0,7,78,1,2};
	System.out.println("Array before sorted: ");
	System.out.println(Arrays.toString(arr));
	
		for (int i = 0; i < arr.length; i++){
	    int j = i;
	    int temp = i;
	    	while(j<arr.length){
				if(arr[j]>arr[temp]){ //If arr[j] < arr[temp]
		    	temp = j; //==> temp index will become j 
			}
				j++;
	    }
	    	if(temp!=i){
				int curr = arr[i];
				arr[i] = arr[temp];
				arr[temp] = curr;
	    }
	    System.out.println(Arrays.toString(arr));
	}      

    }
}
