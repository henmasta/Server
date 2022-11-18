import java.io.*;
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        while(true) {
            try {
                serverSocket = new ServerSocket(8000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 8000.");
                System.exit(1);
            }

            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                        clientSocket.getInputStream()));
            String inputLine, outputLine;
            FromServer FS = new FromServer();
            //FromClient FC = new FromClient();

            outputLine = FS.processInput(null);
            out.print(outputLine);
            out.println("\nu>>> ");
            inputLine = in.readLine();
            System.out.println("he>>> " + inputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = FS.processInput(inputLine);
                out.println(outputLine);
            }
        
            if (outputLine == ("exit")) {
                out.close();
                in.close();
                
                clientSocket.close();
                serverSocket.close();
            }
        }
    }
}