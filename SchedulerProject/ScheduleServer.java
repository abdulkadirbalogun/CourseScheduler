import ocsf.server.*;

public class ScheduleServer extends AbstractServer
{
	//Class variables
	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;
	
	
	//Constructor
	/**
	 * Constructs an instance of the schedule server.
	 * 
	 * @param port The port number to connect on.
	 */
	public ScheduleServer(int port)
	{
		super(port);
	}

	
	//Instance methods
	
	
	/**
	 * This methods handles any messages recieved from the client.
	 * 
	 * @param msg The message recieved from the client.
	 * @param client The connection from which the message originated.
	 */
	protected void handleMessageFromClient(Object msg, ConnectionToClient client)
	{
		System.out.println("Message received: " + msg + " from " + client);
		interpretMessage(msg.toString(), client);
	}
	
	/**
	 * This method overrides the one in the superclass.  Called
	 * when the server starts listening for connections.
	 */
	protected void serverStarted()
	{
	  System.out.println("Server listening for connections on port " + getPort());
	  
	}
	
	/**
	 * This method overrides the one in the superclass.
	 * Called when the server stops listening for connections.
	 */
	protected void serverStopped()
	{
		System.out.println("Server has stopped listening for connections.");
	}
	
	/**
	 * 
	 */
	protected void clientConnected(ConnectionToClient client)
	{
		
	}
	
	/**
	 * This method interprets what the client sends to the user and calls
	 * the requested set of operations.
	 */
	private void interpretMessage(String msg, ConnectionToClient client)
	{

		FileManager fm = new FileManager();
		
		String command;
		String parameter = "";
		
		if (msg.indexOf(' ')>0)
		{
			command = msg.substring(0, msg.indexOf(' '));
			parameter = msg.substring(msg.indexOf(' ') + 1);
		}
		else
		{
			command = msg;
		}
		
		try
	    {
			if (command.equalsIgnoreCase("login"))
			{
				if (!fm.checkLogin(parameter))
				{
					client.sendToClient("Invalid login, disconnecting");
					client.close();
				}
				else client.sendToClient("Login successful.");
			}
			else if (command.equalsIgnoreCase("update"))
			{
				client.sendToClient(fm.retrieveUpdates(parameter));
			}
			else if (command.equalsIgnoreCase("lesson"))
			{
				client.sendToClient(fm.retrieveLessons(parameter));
			}
			else if (command.equalsIgnoreCase("task"))
			{
				client.sendToClient(fm.retrieveTasks(parameter));
			}
			else
			{
				client.sendToClient("Command not valid");
			}
	    }
	    catch (Exception ex)
	    {
	    	System.out.println("Failed to send data to client.");
	    }
		
	}
	
	//Class methods
	
	/**
	 * This method is responsible for the creation of the server instance.
	 * 
	 * @param args[0] The port number to listen on. Defaults to DEFAULT_PORT
	 * 		if no argument is entered.
	 */
	public static void main(String[] args)
	{
		int port; //port to listen on
		
		try
		{
			port = Integer.parseInt(args[0]);
		}
		catch (Throwable t)
		{
			port = DEFAULT_PORT;
		}
		
		ScheduleServer sv = new ScheduleServer(port);
		
		
		try
		{
			sv.listen();
		}
		catch (Exception ex)
		{
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
	
}
