import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class stringFrequency
{
    public stringFrequency()
    {
		TreeMap<String, ArrayList<String>> alphaMap = new TreeMap<>();

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String[] alphabetPieces = alphabet.split("");

		for(int i = 0; i < alphabetPieces.length; i++)
			alphaMap.put(alphabetPieces[i], new ArrayList<String>());

        File name = new File("String Frequency/Strings.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text, output = "";
			while((text=input.readLine())!= null)
			{
				String[] pieces = text.split("");
				output += text;
				alphaCount(alphabetPieces, pieces, alphaMap);
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }

	public void alphaCount(String[] alphabetPieces, String[] pieces, TreeMap<String, ArrayList<String>> alphaMap)
	{
		for(int i = 0; i < pieces.length; i++)
		{
			for(int j = 0; j < alphabetPieces.length; j++)
				if(alphabetPieces[j].equalsIgnoreCase(pieces[i]))
					alphaMap.get(alphabetPieces[j]).add(pieces[i]);
		}

		for(int i = 0; i < alphabetPieces.length; i++)
            System.out.print(alphabetPieces[i] + ": " + alphaMap.get(alphabetPieces[i]).size() + ", ");
	}

    public static void main(String[] args)
    {
        stringFrequency app = new stringFrequency();
    }
}