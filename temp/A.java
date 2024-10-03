public class A{
    int value;
    int x , y, z;
    public A(){}
    public A(int x, int y, int z){
	this.x = x;
	this.y =y;
	this.z = z;
	}
    public A (int i){
	this.value =i;
	this.x =i;
	this.y =i;
	this.z =i;
    }
    
    public static A makeCopy(A val){
	return val;
    }
    public int foo(){
	return x+y+z;
    }
  }
