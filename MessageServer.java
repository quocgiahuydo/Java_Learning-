import java.io.*;
import java.net.*;
public class MessageServer {
    public static void main(String[] args) {
        int port = 12345; // Choose a port number

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); 
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle client communication here (e.g., create a new thread)
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
