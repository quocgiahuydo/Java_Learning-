import java.io.*;

public class LinkedList<T extends Serializable> implements Serializable{
    private static final long serialVersionUID = 1;
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
	oos.defaultWriteObject();
	oos.writeInt(this.size);
	for(Node n = head; n != null; n = n.next){
	    oos.writeObject(n.data);
	}
    }

    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException{
	ois.defaultReadObject();
	int list_size = ois.readInt();
	for(int i = 0; i < list_size; i++){	    
	    this.append((T) ois.readObject());
	}
    }
    
    private class Node{
	T data;
	Node next;
	Node(T data){
	    this.data = data;
	    next = null;
	}
    }

    transient int size;
    transient Node head;
    transient Node tail;
    
    public void append(T data){
	Node n = new Node(data);
	if(head == null){
	    head = n;
	    tail = n;
	}
	tail.next = n;
	tail = n;
	size++;
    }
    @Override
    public String toString(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" -> ");
            curr= curr.next;
        }
        return null;
    }

    public static void main(String args[]){
	int elements = Integer.parseInt(args[0]);
	LinkedList<Integer> l = new LinkedList<Integer>();
	for(int i = 0; i < elements; i++){
	    l.append(i);
	}
	try{
	    var fos = new FileOutputStream(new File("/Users/harrydo/Documents/CS_210/Serialization/temp/linkedlist"));
	    var oos = new ObjectOutputStream(fos);             
	    oos.writeObject(l);
	    oos.flush();
	    var fis = new FileInputStream(new File("/Users/harrydo/Documents/CS_210/Serialization/temp/linkedlist"));
	    var ois = new ObjectInputStream(fis);            
	    LinkedList<Integer> file_l = (LinkedList<Integer>) ois.readObject();
        System.out.println("Here are what you print out");
        file_l.toString();
	}catch(Exception e){
	    System.out.println("Something went wrong!");
	    System.out.println(e);
	}

    }
}