
public class subclass extends abstractExample {
    public int exp;
    public subclass(String name, int age, int exp )
    {
	super(name,age);
	this.exp = exp;
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
