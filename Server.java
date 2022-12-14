import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8999);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 8999.");
            System.exit(-1);
        }
        while (true) {
            System.out.println("Waiting for connection");
	        new Router(serverSocket.accept()).start(); // thread created
        }
    }
}