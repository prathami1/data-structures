import java.io.*;
import java.util.*;

public class FirstTask
{
    public FirstTask()
    {
        File name = new File("input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text, output = "";
			while((text=input.readLine())!= null)
			{
				String[] pieces = text.split(" ");
                Queue(pieces);
				output += text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }

    public void Queue(String[] pieces)
    {
        Queue<Word> words = new LinkedList<Word>();
        PriorityQueue<Word> sortedWords = new PriorityQueue<Word>();
        PriorityQueue<Word> reverseWords = new PriorityQueue<Word>();

        for (String word : pieces) 
        {
            words.add(new Word(word));
            sortedWords.add(new Word(word));
            reverseWords.add(new DescendingWord(word));
        }

        System.out.printf("%-20s %-20s %s\n", "Original", "Sorted", "Reversed");

        while (!words.isEmpty()) 
        {
            System.out.printf("%-20s %-20s %s\n", words.poll(), sortedWords.poll(), reverseWords.poll());
        }
    }

    public static void main(String[] args)
    {
        FirstTask app = new FirstTask();
    }
}

class Word implements Comparable<Word> 
{
    String word;

    public Word(String word) 
    {
        this.word = word;
    }

    public String toString() 
    {
        return word;
    }

    public int compareTo(Word other) 
    {
        return word.toLowerCase().compareTo(other.toString().toLowerCase());
    }
}

class DescendingWord extends Word {

    public DescendingWord(String word) 
    {
        super(word);
    }

    public int compareTo(Word other) 
    {
        return -toString().toLowerCase().compareTo(other.toString().toLowerCase());
    }
}