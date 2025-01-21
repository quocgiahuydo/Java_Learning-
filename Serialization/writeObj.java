import java.io.*;
public class writeObj{
    public static void main(String[] args){
        String s =args[0];
        try{
        var fos = new FileOutputStream(new File("/Users/harrydo/Documents/CS_210/Serialization/temp/hello"));
        var oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();

    }
    catch( Exception e){
        System.out.println(e);
    }
}
}