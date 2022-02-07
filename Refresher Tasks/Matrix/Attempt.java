import java.io.*;	

public class Attempt
{
	public static void main(String args[])
	{
		Attempt app = new Attempt();
	}
	public Attempt()
	{
		File name = new File("/Users/pratham/Documents/data-structures/Attempt/AttemptInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String[] pieces = text.split("\t"); 
				String first = pieces[0];
				String second = pieces[1];
				
				operate(first, second);
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public void operate(String first, String second)
	{
		
	}
}