import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args) {
        try{
        Socket socket =null;
        ServerSocket serverSocket=null;
        serverSocket= new ServerSocket(2444);
        while(true){
            try{
            socket =serverSocket.accept();
            ServerHandler serverHandler = new ServerHandler(socket);
            Thread task = new Thread(serverHandler);
            task.start();
            }
        
            catch(Exception e ){
                System.out.println(e);
            }
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }    
    }

class ServerHandler implements  Runnable{

    InputStreamReader inputStreamReader =null;
    OutputStreamWriter outputStreamWriter =null;
    BufferedReader bufferedReader=null;
    BufferedWriter bufferedWriter=null;
    ServerSocket serverSocket = null;
    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try{
        this.inputStreamReader = new InputStreamReader(socket.getInputStream());
        this. outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        this.bufferedReader = new BufferedReader(this.inputStreamReader);
        this.bufferedWriter = new BufferedWriter(this.outputStreamWriter);
        String welcomeMsg ="Welcome to the Server";
            bufferedWriter.write(welcomeMsg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            Boolean condition = true;
            while(condition){
                String msgfromClient = bufferedReader.readLine();
                System.out.println("Message from Client "+ msgfromClient);
                bufferedWriter.write("Do you have anything else to say ?");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                if(msgfromClient.equals("Bye")){
                    condition=false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try {
                
            socket.close();
            serverSocket.close();
            } catch (Exception e) {
            }
        }
    }
}