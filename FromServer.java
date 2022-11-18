import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FromServer {

    public String processInput(String theInput) {
        System.out.print("u>>> ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine(); 

        String theOutput = null;

        theOutput = "he>>> " + inputString;
        
        return theOutput; 
    }
}