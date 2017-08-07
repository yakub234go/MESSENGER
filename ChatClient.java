import java.net.*;
import java.io.*;

public class ChatClient
{
	String serv;
	int port;
	ChatClient()
	{
		serv = "127.0.0.1";
		port = 8080;
	}
	
	public void connect_to_server()
	{
		try
		{
			System.out.println("Connecting to " + serv + " on port " + port);
			Socket client = new Socket(serv, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
			client.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}