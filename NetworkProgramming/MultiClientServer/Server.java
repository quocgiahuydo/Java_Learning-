import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class Server{
    public static void main(String[] args){
        try{
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Server has started");
        while(true){
                Socket clientSocket = ss.accept();
                System.out.println("Has connect to the server "+ 
                clientSocket.getInetAddress().getHostAddress());
                ClientHandler cl = new ClientHandler((Socket) clientSocket);
                new Thread(cl).start();
            } 
            }
        catch(Exception e){
            System.out.println(e);
        }
        }
     
    }

    class ClientHandler implements Runnable{
        private Socket SocketHandled;
        public ClientHandler(Socket S){
            this.SocketHandled = S;
        }
        @Override
        public void run(){
            try {
                String message;
                String response ="Server has responsed";
                PrintWriter out = new PrintWriter(SocketHandled.getOutputStream(),true);
                Boolean condition = true;
                while(condition){
                    System.out.println("1) For more conversation");
                    System.out.println("2) To end this conversation");
                    BufferedReader bf = new BufferedReader(new InputStreamReader(
                    this.SocketHandled.getInputStream()));
                    System.out.println("Please answer here");
                    String answ = bf.readLine(); 
                    if(Integer.parseInt(answ)==1){
                        System.out.println("So you want to close then");
                        condition=false;
                        out.write("Good talks friends");
                        bf.close();
                        out.close();
                        SocketHandled.close();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

     }  
