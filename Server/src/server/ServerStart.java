package server;
import java.io.*;
import java.net.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*; 

public class ServerStart {
    private int portNumber=500;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    public BufferedReader in;
    public Vector inf=new Vector();
    public void Run(){
        try{
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));            
            String inputLine = in.readLine();
            MainStruct i=new MainStruct();
            i.Name=inputLine;
            
            inputLine = in.readLine();
            i.Topic=inputLine;
            
            inputLine = in.readLine();
            i.Location=inputLine;
            
            inputLine = in.readLine();
            i.Target=inputLine;
            
            inputLine = in.readLine();
            i.Contact=inputLine;

            inf.add(i);
            ClientInvestor Cli=new ClientInvestor(this);
            Cli.setVisible(true);
        }
        catch(IOException exp){
        }
    }
}
