import java.net.*;
import java.io.*;

public class ChatServer extends Thread
{
	private ServerSocket servsoc;
	
	ChatServer() throws IOException
	{
		servsoc = new ServerSocket(8080);
		servsoc.setSoTimeout(10000);
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Waiting for client on port " +servsoc.getLocalPort() + "...");
				Socket server = servsoc.accept();
            
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()+ "\nGoodbye!");
				server.close();
            }
			catch(SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
				break;
			}
			catch(IOException e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String [] args)
	{
		try
		{
			Thread t = new ChatServer();
			t.start();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}