    import pack.*;

public class A {
    public void a1 () {}
     public static void main ( String [] args ) {
        A a = new A();
        B b = new B();
        C c = new C();
        a.a1();
        c.b1();
        //c.b2();
        ((B) c).c1();
        ((A) c).a1();
        

     }
    }