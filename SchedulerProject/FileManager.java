import java.io.*;

public class FileManager
{
	public String filePath;
	
	/**
	 * Constructor for the FileManager object
	 */
	public FileManager()
	{
		this.filePath = this.getClass().getClassLoader().getResource("").getPath();
	}
	
	/**
	 * Reads
	 * @return
	 */
	public String readFile(String path)
	{
		String line = "";
		String r = "";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(getPath() + path)));
			
			try
			{
				while ((line = br.readLine()) != null) {
			        r += line + "\n";
			    }
			}
			catch (IOException e)
			{
				System.out.println("Whoops");
			}
			finally
			{
			    try
			    {
			        br.close();
			    }
			    catch (IOException e)
			    {
			        System.out.println("closing BufferedReader failed");
			    }
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found");
			r = "ERROR: Unable to locate file.";
		}
		return r;
	}
	
	public String retrieveUpdates(String course)
	{
		String line = "";
		String r = "";
		int counter = 0;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(getPath() + "data/" + course + "/update.txt/")));
			
			try
			{
				while ((line = br.readLine()) != null) {
					if (counter == 3) counter = 0;
					switch (counter)
					{
					case 0: r += "Type:  " + line + "\n";
							break;
					case 1: r += "Description:  " + line + "\n";
							break;
					case 2: r += "***************\n";
							break;
					}
					counter++;
			    }
			}
			catch (IOException e)
			{
				System.out.println("Whoops");
			}
			finally
			{
			    try
			    {
			        br.close();
			    }
			    catch (IOException e)
			    {
			        System.out.println("closing BufferedReader failed");
			    }
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found");
			r = "ERROR: Unable to locate file.";
		}
		return r;
	}
	
	public String retrieveTasks(String course)
	{
		String line = "";
		String r = "";
		int counter = 0;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(getPath() + "data/" + course + "/task.txt/")));
			
			try
			{
				while ((line = br.readLine()) != null) {
					if (counter == 4) counter = 0;
					switch (counter)
					{
					case 0: r += "Type:  " + line + "\n";
							break;
					case 1: r += "DueDate:  " + line + "\n";
							break;
					case 2: r += "Description:  " + line + "\n";
							break;
					case 3: r += "***************\n";
							break;
					}
					counter++;
			    }
			}
			catch (IOException e)
			{
				System.out.println("Whoops");
			}
			finally
			{
			    try
			    {
			        br.close();
			    }
			    catch (IOException e)
			    {
			        System.out.println("closing BufferedReader failed");
			    }
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found");
			r = "ERROR: Unable to locate file.";
		}
		return r;
	}
	
	public String retrieveLessons(String course)
	{
		String line = "";
		String r = "";
		int counter = 0;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(getPath() + "data/" + course + "/lesson.txt/")));
			
			try
			{
				while ((line = br.readLine()) != null) {
					if (counter == 6) counter = 0;
					switch (counter)
					{
					case 0: r += "Type:  " + line + "\n";
							break;
					case 1: r += "Room:  " + line + "\n";
							break;
					case 2: r += "Day:  " + line + "\n";
							break;
					case 3: r += "StartTime:  " + line + "\n";
							break;
					case 4: r += "EndTime:  " + line + "\n";
							break;
					case 5: r += "***************\n";
							break;
					}
					counter++;
			    }
			}
			catch (IOException e)
			{
				System.out.println("Whoops");
			}
			finally
			{
			    try
			    {
			        br.close();
			    }
			    catch (IOException e)
			    {
			        System.out.println("closing BufferedReader failed");
			    }
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found");
			r = "ERROR: Unable to locate file.";
		}
		return r;
	}
	public boolean checkLogin(String s)
	{
		String line = "";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(getPath() + "/data/user.txt")));
			
			try
			{
				while ((line = br.readLine()) != null) {
			        if (s.equals(line)) return true;
			    }
			}
			catch (IOException e)
			{
				System.out.println("Whoops");
			}
			finally
			{
			    try
			    {
			        br.close();
			    }
			    catch (IOException e)
			    {
			        System.out.println("closing BufferedReader failed");
			    }
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found");
		}
		return false;
	}
	
	
	
	public String getPath()
	{
		return this.filePath;
	}
	
	
	
	public static void main(String[] args)
	{
		
	}
}
