import java.io.*;
import java.net.*;
import java.util.Scanner;

class FromClient {

    public String processOutput(String theOutput) {
        BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    clientSocket.getInputStream()));
        theOutput = in.readLine();
        return theOutput;
    }
}