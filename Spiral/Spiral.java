import java.io.*;

public class Spiral
{
	public static void main(String args[])
	{
		File name = new File("SpiralInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				//System.out.println(text);
				int num = Integer.parseInt(text);
				createSpiral(num);
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public void createSpiral(int num)
	{
		for(int i = 0; i < num; i++)
		{
			for(int j = 0; j < num; j++)
			{
				String[][] pattern = new String[i][j];
				pattern[i][j] = "-";
				System.out.println(pattern[i][j]);
			}
		}
	}
}