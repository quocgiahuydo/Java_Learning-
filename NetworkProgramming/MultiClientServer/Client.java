   import java.io.*;
   import java.net.*;

   public class Client {
       public static void main(String[] args) {
           try {
               Socket socket = new Socket("localhost", 9999); // Connect to the server

               // Get input and output streams for communication with the server
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

               // Send messages to the server

               // Receive messages from the server
               String message;
               while ((message = in.readLine()) != null) {
                   System.out.println("Received from server: " + message);
                   System.out.println("Enter your answer here:");
                   out.write(args[0]);
                   out.flush();
               }
               // Close the streams and socket when done
               in.close();
               out.close();
               socket.close();
               System.out.println("Server has closed");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }