interface Divison{
    boolean checkNumb(int x);
}

public class Divisibl {
    public static void main(String[] args) {
        Divison divBytwo = (x)-> x %2 ==0;
        Divison divBythree = (x)->x%3==0;
        for(int i =0; i <100; i++){
         if (divBythree.checkNumb(i) && divBytwo.checkNumb(i)){
                System.out.println(i+" =" +(i*2)*(i*2));    
            }
        else    if(divBytwo.checkNumb(i)){
                System.out.println(i+" =" +i*2);
            }

            else if(divBythree.checkNumb(i)){
                System.out.println(i+" =" +i*i);
            }
           
           else {
            System.out.println(i+" ="+i);
        }
    }
    }
}