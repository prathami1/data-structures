import java.io.*;	//this is the only one that is necessary for this template.
//You might need others depending on the task.

public class Template
{
	public static void main(String args[])
	{
		File name = new File("fileName.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				System.out.println(text);


				String[] pieces = text.split(","); //splitting data from a point and putting it into an array
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
