public class Test{
    public static void main(String[] args){
	A a = new A(10);
	B b = new B(10);
	A c = b;
	System.out.println(a.foo());
	System.out.println(b.foo());
	
    }
}

