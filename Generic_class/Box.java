public  class Box<T>{
    private T box_value;
    private int box_numb;
    public static int counter = 0;
    public int increment(){
	return counter +=1;
    }
    public Box(T value){
	
	this.box_numb = increment();
	this.box_value = value;
        }
	
    public void print(){
	System.out.println("Box "+ this.box_numb+ ": " +this.box_value);
    }
    public int getID(){
	return this.box_numb;
}
    public T unBox(){
	System.out.println("Unboxing Box " +this.box_numb +": "+ this.box_value);
	return this.box_value = null;
    }
    public boolean isEmpty(){
	if(this.box_value == null){
	    return true; }
	return false;
	
}
}



    
    
