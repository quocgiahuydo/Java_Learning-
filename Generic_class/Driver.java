public class Driver{
    public static void main(String[] args){

	Box<String> bstr = new Box<>("Hello World ");
	System.out.print("PRINTING Box<String>:\t");
	bstr.print();

	Box<Integer> bint = new Box<>(1);
	System.out.print("PRINTING Box<Integer>:\t");
	bint.print();
 
	Box[] bArr = {bstr, bint};
	Boxes bs = new Boxes(bArr);
	System.out.print("CHECKING EMPTY BOXES BEFORE UNBOXING:\t");
	System.out.println(bs.emptyBoxes());
	
	System.out.print("LOOKING INSIDE bs:\t");
	bs.lookInside();
	System.out.print("CHECKING EMPTY BOXES AFTER UNBOXING:\t");
	System.out.println(bs.emptyBoxes());
    }
}
