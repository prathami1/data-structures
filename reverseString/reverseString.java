import java.util.Stack;
import java.io.*;

public class reverseString
{
    public reverseString()
    {
        File name = new File("reverseString/input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String[] pieces = text.split("\n"); 
				output+=text;
                for(int i = 0; i < pieces.length; i++)
                {
                    reverse(pieces[i]);
                }
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }
    public static void main(String[] args)
    {
        reverseString app = new reverseString();
    }

    public static void reverse(String input)
    {
        Stack<String> stack = new Stack<String>();   
		for (int i = 0; i < input.length(); i++)
		{
				stack.push(input.substring(i, i+1));
		}
		while (!stack.isEmpty())
		{
				System.out.print ( stack.pop() );
				if(!stack.empty())
					System.out.print("");
				else System.out.println();
		}
    }    
}