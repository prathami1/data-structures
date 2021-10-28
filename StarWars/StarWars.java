import java.util.Stack;
import java.io.*;

public class StarWars
{
    public StarWars()
    {
        File name = new File("StarWars/input.csv");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text, output = "";
			while( (text=input.readLine())!= null)
			{
				String[] pieces = text.split("\n"); 
				output += text;
                for(int i = 0; i < pieces.length; i++)
                {
                    sort(pieces[i]);
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
        StarWars app = new StarWars();
    }

    public static void sort(String input)
    {
        Stack<String> male = new Stack<String>();   
        Stack<String> female = new Stack<String>();   
        Stack<String> droids = new Stack<String>();   
        Stack<String> birthYear = new Stack<String>();   
        String[] pieces = input.split(",");
		if(pieces[6].equals("male"))
        {
            for(int i = 0; i < pieces.length; i++)
            {
                male.push(pieces[i]);
            }
        }
        else if(pieces[6].equals("female"))
        {
            for(int i = 0; i < pieces.length; i++)
            {
                female.push(pieces[i]);
            }
        }
    }    

    public class Character
    {
        String name;
        int birthYear;
        String gender;
        String homeWorld;
        String species;

        public String getName()
        {
            return name;
        }

        public int getBirthYear()
        {
            return birthYear;
        }

        public String getGender()
        {
            return gender;
        }

        public String getHomeWorld()
        {
            return homeWorld;
        }

        public String species()
        {
            return species;
        }
    }
}