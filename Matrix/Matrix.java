import java.io.*;	

public class Matrix
{
	public static void main(String args[])
	{
		File name = new File("/Users/pratham/Documents/data-structures/Matrix/MatrixInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				//System.out.println(text);

				String[] pieces = text.split("\t"); 
				int first = Integer.parseInt(pieces[0]);
				int second = Integer.parseInt(pieces[1]);
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}