import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client{
    public static void main(String[] args) {
            Socket socket = null;
            InputStreamReader inputStreamReader = null;
            OutputStreamWriter outputStreamWriter=null;   
            BufferedReader  bufferedReader= null;
            BufferedWriter bufferedWriter = null;        
            Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket("localhost",2444);
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter=new BufferedWriter(outputStreamWriter);
            Boolean conditon = true;
            while(conditon){
                String inComeMsg = bufferedReader.readLine();
                System.out.println("Message from Server:" + inComeMsg);
                System.out.println("Please input your message: ");
                String sentMsg = scanner.nextLine();
                bufferedWriter.write(sentMsg);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                if(sentMsg.equals("Bye")){
                    conditon=false;
                    bufferedReader.close();
                    bufferedWriter.close();
                    inputStreamReader.close();
                    outputStreamWriter.close();
                    socket.close();
                }

            }
        } catch (Exception e) {

            System.out.println(e);
        }
        finally{
            try {
                if(socket!=null){
                    socket.close();
                }
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }
                if(inputStreamReader!=null){
                    inputStreamReader.close();
                }
                if(outputStreamWriter!=null);{
                    outputStreamWriter.close();
                }
            } catch (Exception e) {
            }
        }
    }
}