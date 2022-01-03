
import java.io.*;

public class threadDemo
{
    public static void main(String[] args)
    {
        Thread thread1 = new Thread("t1")
        {
            @Override
            public void run()
            {
                /*for(int i = 0; i <= 10; i++)
                    System.out.println(getName() + " " + i);*/
                File name = new File("text.txt");
                try
                {
                    BufferedReader input = new BufferedReader(new FileReader(name));
        
                    String text,output="";
                    while( (text=input.readLine())!= null)
                    {
                        System.out.println(text);
                        String[] pieces = text.split(" ");
                        output+=text;
                    }
                }
                catch (IOException io)
                {
                    System.err.println("File does not exist");
                }
            }
        };

        Thread thread2 = new Thread("t2")
        {
            @Override
            public void run()
            {
                /*or(int i = 0; i <= 10; i++)
                    System.out.println(getName() + " " + i);*/
                File name = new File("text2.txt");
                try
                {
                    BufferedReader input = new BufferedReader(new FileReader(name));
        
                    String text,output="";
                    while( (text=input.readLine())!= null)
                    {
                        System.out.println(text);
                        String[] pieces = text.split(" ");
                        output+=text;
                    }
                }
                catch (IOException io)
                {
                    System.err.println("File does not exist");
                }
            }
        };

        thread1.start();
        thread2.start();

        try 
        {
            thread1.join();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }
}