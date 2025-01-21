
public class Lamda{
    public static void main(String[] args) {
        Print print = (s)-> {
            
            System.out.println("Make sound"+s);
        };
        Print lamda = (l)-> {
            System.out.println("Hello Everyone "+ l);
        };
        B obj =(s)-> {return "This is a Obj " +s;};

        lamda.print("I am Harry");
        printThing(print);
        System.out.println(obj.show("I have just created"));
    }
    static void printThing(Print thing){
        thing.print("??");
    }    
}
interface B {
    public String show(String s );

}
