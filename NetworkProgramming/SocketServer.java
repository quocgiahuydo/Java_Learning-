import java.io.*;
import java.net.*;
public class SocketServer implements Runnable{
    public static void main(String[] args) {
        try{
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Server is opened");
        Socket s = ss.accept();
        System.out.println("Server is connected");
        BufferedReader  bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str;
        while((str=bf.readLine())!=null){
            System.out.println(str);
        }
        System.out.println("Finished");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void run(){
        
    }
}