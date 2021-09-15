import java.io.*;	//this is the only one that is necessary for this template.
//You might need others depending on the task.

public class Reducer
{
	public Reducer()
	{
		File name = new File("ReducerInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				//System.out.println(text);

				String[] pieces = text.split("/"); //splitting data from a point and putting it into an array
				int numer = Integer.parseInt(pieces[0]);
				int denom = Integer.parseInt(pieces[1]);
				reduceIt(numer, denom);
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public void reduceIt(int numer, int denom)
	{
		int gcf = findGCF(numer, denom);

		System.out.println(numer + "/" + denom);

		numer/=gcf;
		denom/=gcf;

		if(numer > denom)
		{
			int rem = numer % denom;
			//numer -= rem;

			int constant = numer/denom;

			if(rem == 0)
			{
				System.out.println("\t" + constant);
			}
			else
			{
				System.out.println("\t" + constant + " " + rem + "/" + denom);
			}

		}
		else
		{
			System.out.println("\t" + numer + "/" + denom);
		}
	}

	public int findGCF(int numer, int denom)
	{
		int factor = numer;
		if(numer > denom)
			factor = denom;
		while (!(numer % factor == 0 && denom % factor == 0))
			factor--;
		return factor;
	}

	public static void main(String args[])
	{
		Reducer app = new Reducer();
	}
}