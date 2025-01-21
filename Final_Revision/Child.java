public class Child extends Inherit{
    protected int age;
    public Child(String name, int age){
        super(name);
        this.age = age;
    }
    @Override
    public void makeSound(){
        System.out.println("Oe oe");
    }
    public static void main(String[] args){
       Inherit c = new Child("Harry", 10);
       //System.out.println(c.meme(100));
    }
}
