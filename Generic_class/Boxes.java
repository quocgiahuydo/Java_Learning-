public class Boxes   {
    Box<?>[]  arr;
    private int empty_boxes;
    public Boxes(Box[] boxes){
	this.arr = boxes; 
 
    }
    public void lookInside(){
	int ct = 0;
	while (ct < arr.length){
	    arr[ct].unBox();
		ct +=1;
	}
    }
    public int emptyBoxes(){
        int count = 0;
	int emptyBoxes=0;
	while (count < arr.length){
	    if (arr[count].isEmpty() == true)
		{emptyBoxes +=1;
	    }
	    this.empty_boxes = emptyBoxes;
	    count +=1;
	}
	return this.empty_boxes;
    }
}

	
