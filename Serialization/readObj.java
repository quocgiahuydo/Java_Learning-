import java.io.*;

public class readObj {
    public static void main(String[] args){
    try{
        String read;
        var fis = new FileInputStream(new File("/Users/harrydo/Documents/CS_210/Serialization/temp/hello"));
        var ois = new ObjectInputStream(fis);
        read = (String) ois.readObject(); 
        System.out.println(read);
    }
    catch (Exception e){
        System.out.println(e);
    }
}
}
