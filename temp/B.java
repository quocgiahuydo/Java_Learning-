public class B extends A{
    int a;
    public B(int numb){
	super(numb);
	this.a = numb;
	}
    @Override
    public int foo(){
	return a + super.x + super.y + super.z;
    }
}


