public class Arr{
    public static void main(String[] args){
	int i =1;
	while (i < 100){
	    i++;
	    if(i%2==0){
		continue;
	    }
	    i+=100;
		}
	for(;i>10;i++){
	    if(i%5 ==0){
		break;
	    }
	    i*=2;
	}
	System.out.println(i);
    }
}
