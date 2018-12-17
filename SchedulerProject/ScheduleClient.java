import ocsf.client.AbstractClient;
import java.io.*;

public class ScheduleClient extends AbstractClient
{
	final public static int DEFAULT_PORT = 5555;
	
	public ScheduleClient(String host, int port) throws IOException
	{
		super(host, port); //call superclass constructor
		openConnection();
	}
	
	protected void handleMessageFromServer(Object msg)
	{
		System.out.println(">\n" + msg.toString());
	}
	
	public void handleMessageFromUser(String message)
	{
		try
		{
			sendToServer(message);
		}
		catch(IOException e)
		{
			System.out.println("Could not send message to server.  Terminating client.");
			quit();
		}
	}
	
	public void quit()
	{
		try
		{
			closeConnection();
		}
		catch (IOException e) {}
		System.exit(0);
	}
	
	public void accept()
	{
		try
		{
			BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
			String message;
			
			while (true)
			{
				message = fromConsole.readLine();
				handleMessageFromUser(message);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Unexpected error while reading from the console!");
		}
	}
	
	public static void main(String[] args)
	{
		String host = "localhost";
		String login = "";
		ScheduleClient client;
		try
		{
			login = args[0] + " " + args[1];
		}
		catch (ArrayIndexOutOfBoundsException e) {}
		
		try
		{
			client = new ScheduleClient(host, DEFAULT_PORT);
			client.handleMessageFromUser("login " + login);
			client.accept();
		}
		catch (IOException exception)
		{
			System.out.println("Error: Can't setup connection! Terminating client.");
			System.exit(1);
		}
		
		
	}
}
