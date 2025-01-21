import java.io.*;
import java.net.*;


public class SocketClient{
    public static void main(String[] args) throws Exception {
        String ip = args[0];
        int port = 9999;
        Socket s = new Socket(ip, port);
        
        String str ="Harry Huy";
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pr = new PrintWriter(os);
        os.write(str);
        os.flush();

    }}
