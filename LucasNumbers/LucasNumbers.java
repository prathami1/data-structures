import java.io.*;
import java.math.*;

public class LucasNumbers
{
	public static void main(String args[])
	{
		LucasNumbers app = new LucasNumbers();
	}
	
	public LucasNumbers() {
		
		File name = new File("/Users/pratham/Documents/data-structures/LucasNumbers/LucasInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				BigInteger sequence = Lucas(Integer.parseInt(text));
                System.out.println(sequence);
				output+=text;
				Lucas(6);
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public BigInteger Lucas(int x) {
        BigInteger first = BigInteger.TWO;
		BigInteger second = BigInteger.ONE;
		BigInteger third;

        if (x == 0)
            return first;
		//for(int i = 2; i <= 0; i++)
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(BigInteger.valueOf(x)) <= 0; i = i.add(BigInteger.ONE)) {
            third = first.add(second);
            first = second;
            second = third;
        }
        return second;
    }
}