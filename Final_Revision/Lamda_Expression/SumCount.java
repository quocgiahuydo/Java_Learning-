interface SumCountfunc{
    boolean checkNumb(int x);
}

public class SumCount {
    public static void main(String[] args){
    SumCountfunc func = (x)-> x%2==0;
    int ctr =0;
    int sum =0;
    for(int i =1 ; i<10; i++){
        if(func.checkNumb(i)){
            sum+=i;
            ctr++;
        }
    }
    System.out.print("The sum is "+ sum+'\n');
    System.out.print("Number of even number "+ ctr);
    
    
}
}
