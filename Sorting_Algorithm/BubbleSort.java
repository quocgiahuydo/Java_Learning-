public class BubbleSort {
    public static void main(String[] args){
    int arr[] ={-10,41,144,-24,4,24,10,-6,0,7,78,1,2};
    for(int c:arr){
        System.out.print((c)+", ");
    }
    System.out.println(" ");
    for(int i=0; i< arr.length;i++){
        boolean swapped =false;
        for(int j =0; j<(arr.length)-i-1; j++){
            if(arr[j]>arr[j+1]){
                int curr=arr[j+1];
                arr[j+1]= arr[j];
                arr[j] = curr;
                swapped=true;
            for(int c:arr){
                    System.out.print((c)+", ");
                }
                System.out.println(" ");
            }
        }
        if(swapped==false){
            break;
        }
    }
}
}
