public class InsertionSort {
    public static void main(String[] args) {
            int arr[] = {12,5,3,10,7};
            for(int c:arr){
                    System.out.print((c)+", ");
                }
                System.out.println(" ");
            int temp;
            for(int i =0; i< arr.length;i++){
                int j = i;
                temp = j-1;
                while(temp>=0){
                    if(arr[j]<arr[temp]){
                        int curr = arr[temp];
                        arr[temp] = arr[j];
                        arr[j] = curr;
                    }
                    temp--;
                    j--;
                }
                for(int c:arr){
                    System.out.print((c)+", ");
                }
                System.out.println(" ");
                
            }
       
    }
}
    

