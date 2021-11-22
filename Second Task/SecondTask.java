import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class SecondTask 
{
    public SecondTask()
    {
        Queue<Passenger> q = new LinkedList<Passenger>();
        File file = new File("input.txt");
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(file));
            List<String> lines = Files.readAllLines(file.toPath());
            for (int i = 0; i < lines.size(); i += 3) 
            {
                q.add(new Passenger(lines.get(i), lines.get(i + 2), lines.get(i + 1)));
            }
            while (!q.isEmpty()) 
            {
                System.out.println(q.poll());
            }
        }
        catch(Exception e)
        {
            System.out.println("FileReader/BufferedReader error");
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        SecondTask app = new SecondTask();
    }
}

class Passenger implements Comparable<Passenger>
{
    private String firstName;
    private String lastName;
    private String city;
    private String time;

    public Passenger(String name, String time, String city)
    {
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
        this.time = time;
        this.city = city;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String flightCity()
    {
        return city;
    }

    public String flightTime()
    {
        return time;
    }

    public int etdCalc()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String reformattedTime = time.split(":")[0].length() > 1 ? time : "0" + time;
        if((reformattedTime.substring(6).equals("AM") && !time.split(":")[0].equals("12")) || (reformattedTime.substring(6).equals("PM") && time.split(":").equals("12")))
        {
            reformattedTime = reformattedTime.substring(0, 6);
        }
        else
        {
            reformattedTime = (Integer.parseInt(time.split(":")[0]) + 12) + ":" + time.split(":")[1].substring(0);
        }
        try
        {
            Date flightTime = sdf.parse(reformattedTime);
            Date currentTime = sdf.parse("09:03");
            long delta = TimeUnit.MINUTES.convert(flightTime.getTime() - currentTime.getTime(), TimeUnit.MILLISECONDS);
            if(delta < 0)
            {
                delta += 24L * 60;
            }
            return (int)(delta);
        }
        catch(Exception e)
        {
            System.out.println("sdf parse incorrect");
            e.printStackTrace();
        }
        return 0;
    }

    public String toString() 
    {
        int minutes = etdCalc();
        return lastName + ", " + firstName + " - " + city + " - " + time + " - " + (minutes > 60 ? (minutes / 60) + " hour" + (minutes > 120 ? "s" : "") + " and " : "") + (minutes % 60) + " minutes from now";
    }

    public int compareTo(Passenger other) 
    {
        int a = etdCalc();
        int b = other.etdCalc();
        if ((a > 60 && b > 60) || a == b)
            return 0;
        return (a - b);
    }
}

