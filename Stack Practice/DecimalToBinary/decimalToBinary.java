import java.util.Stack;
import java.io.*;

public class decimalToBinary
{
    public decimalToBinary()
    {
        File name = new File("Stack Practice/DecimalToBinary/input.txt");
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
                    toBinary(Integer.parseInt(pieces[i]));
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
        decimalToBinary app = new decimalToBinary();
    }

    public static void toBinary(int dec)
    {
        Stack<Integer> stack = new Stack<Integer>();   
        while(dec > 0)
        {    
            stack.push(dec%2);
            dec = dec/2;    
        }
        for(int i = stack.size(); i > 0; i--)
        {
            System.out.print(stack.peek());
            stack.pop();
        }
        System.out.println();
    }    
}