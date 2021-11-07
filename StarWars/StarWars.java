import java.util.Stack;
import java.io.*;

public class StarWars
{
    public StarWars()
    {
        File name = new File("StarWars/input.csv");
        Stack<Character> male = new Stack<Character>();   
        Stack<Character> female = new Stack<Character>();   
        Stack<Character> droids = new Stack<Character>();   
        Stack<Character> birthYear = new Stack<Character>();  
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text, output = "";
			while( (text=input.readLine())!= null)
			{
                sort(text, male, female, droids, birthYear);
            }
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}

        System.out.println("Male Characters");
        System.out.println(String.format("%s%50s", "Name", "HomeWorld"));
        while (!male.empty()) 
        {
            System.out.println(male.pop());
        }

        System.out.println("\nFemale Characters");
        System.out.println(String.format("%s%50s", "Name", "HomeWorld"));
        while (!female.empty()) 
        {
            System.out.println(female.pop());
        }

        System.out.println("\nDroids");
        System.out.println(String.format("%s%50s", "Name", "HomeWorld"));
        while (!droids.empty()) 
        {
            System.out.println(droids.pop());
        }

        System.out.println("\nAges");
        System.out.println(String.format("%s%50s%25s", "Name", "HomeWorld", "Birth Year (BBY)"));
        while(!birthYear.empty()) 
        {
            Character character = birthYear.pop();
            if(character.homeWorld.equals("NA"))
            {
                if(character.birthYear.contains("."))
                {
                    System.out.println(String.format("%-45s%-18s%s", character.name, character.homeWorld, character.birthYear));
                }
                else
                {
                    System.out.println(String.format("%-45s%-18s%s", character.name, character.homeWorld, character.birthYear + ".0"));
                }
            }
            else
            {
                if(character.birthYear.contains("."))
                {
                    System.out.println(String.format("%-45s%-18s%s", character.name, "Unknown", character.birthYear));
                }
                else
                {
                    System.out.println(String.format("%-45s%-18s%s", character.name, "Unknown", character.birthYear + ".0"));
                }
            }
        }
    }
    public static void main(String[] args)
    {
        StarWars app = new StarWars();
    }

    public static void sort(String input, Stack male, Stack female, Stack droids, Stack birthYear)
    {   
        String[] pieces = input.split(",");
        if(pieces.length == 9)
        {
            if(pieces[6].equals("male"))
            {
                male.push(new Character(pieces[0], pieces[5], pieces[6], pieces[7], pieces[8]));
            }
            else if(pieces[6].equals("female"))
            {
                female.push(new Character(pieces[0], pieces[5], pieces[6], pieces[7], pieces[8]));
            }
            if(pieces[8].equals("Droid"))
            {
                droids.push(new Character(pieces[0], pieces[5], pieces[6], pieces[7], pieces[8]));
            }
            if(pieces[5].equals("NA"))
            {
                //birthYear.push(new Character(pieces[0], pieces[5].substring(0, pieces[5].length() - 3), pieces[6], pieces[7], pieces[8]));
                birthYear.push(new Character(pieces[0], pieces[5], pieces[6], pieces[7], pieces[8]));
            }
        }
        else if(pieces.length == 10)
        {
            if(pieces[7].equals("male"))
            {
                male.push(new Character(pieces[0], pieces[6], pieces[7], pieces[8], pieces[9]));
            }
            else if(pieces[7].equals("female"))
            {
                female.push(new Character(pieces[0], pieces[6], pieces[7], pieces[8], pieces[9]));
            }
            if(pieces[8].equals("Droid"))
            {
                droids.push(new Character(pieces[0], pieces[6], pieces[7], pieces[8], pieces[9]));
            }
            if(pieces[6].equals("NA"))
            {
                //birthYear.push(new Character(pieces[0], pieces[6].substring(0, pieces[6].length() - 3), pieces[7], pieces[8], pieces[9]));
                birthYear.push(new Character(pieces[0], pieces[6], pieces[7], pieces[8], pieces[9]));
            }
        }

    }    
}

class Character 
{
    public String name;
    public String birthYear;
    public String gender;
    public String homeWorld;
    public String species;

    public Character(String name, String birthYear, String gender, String homeWorld, String species) 
    {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.species = species;
    }

    public String toString() 
    {
        if (!homeWorld.equals("NA")) 
        {
            return String.format("%-45s%-5s", name, homeWorld);
        }
        return String.format("%-45s%-5s", name, "Unknown");
    }
}