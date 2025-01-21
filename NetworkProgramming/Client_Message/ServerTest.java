import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTest {
    public static void main(String[] args) throws InterruptedException {
        int numClients = 5; // Number of clients to simulate
        ExecutorService executorService = Executors.newFixedThreadPool(numClients);

        // Start the server in a separate thread
        new Thread(() -> {
            try {
                Server.main(null); // Calls the Server class's main method
            } catch (Exception e) {
                System.out.println("Server error: " + e);
            }
        }).start();

        // Wait briefly to ensure the server is running
        Thread.sleep(2000);

        // Simulate multiple clients connecting to the server
        for (int i = 1; i <= numClients; i++) {
            int clientId = i; // Assign a unique ID to each client
            executorService.execute(() -> simulateClient(clientId));
        }

        executorService.shutdown();
    }

    private static void simulateClient(int clientId) {
        try (Socket socket = new Socket("localhost", 2444);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            // Read the welcome message from the server
            String welcomeMessage = bufferedReader.readLine();
            System.out.println("Client " + clientId + " received: " + welcomeMessage);

            // Send a message to the server
            bufferedWriter.write("Hello from Client " + clientId);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // Read the server's response
            String serverResponse = bufferedReader.readLine();
            System.out.println("Client " + clientId + " received: " + serverResponse);

            // Send "Bye" to close the connection
            bufferedWriter.write("Bye");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Client " + clientId + " error: " + e);
        }
    }
}
