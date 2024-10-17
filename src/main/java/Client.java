import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.net.Socket;

import static java.lang.System.out;

public class Client {
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, Server.PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String response = in.readLine();
            out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
