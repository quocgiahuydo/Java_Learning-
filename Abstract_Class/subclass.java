
public class subclass extends abstractExample {

    public subclass(String name, int age )
    {
        super(name, age);
    }
    @Override
    public String getName(){
        System.out.println("Testing");
        return super.getName();
    }
    public int getAge(){
        return super.age;
    }
}
