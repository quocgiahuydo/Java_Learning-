interface OddEvenFunc{
    boolean evaluateNumb(int x);
}


public class OddEven {
    public static void main(String[] args){
        OddEvenFunc iSEven = (x)-> x % 2 ==0;

        OddEvenFunc iSOdd = (x)-> x % 2 !=0;
        for(int i =0; i<100; i++){
            if(iSEven.evaluateNumb(i)){
                System.out.println(i+" is Even");
            }

            else if(iSOdd.evaluateNumb(i)){
                System.out.println(i+" is Odd");
            }
            else{
                System.out.println(i+" is netiher");
            }
                
            }
        }

    }
