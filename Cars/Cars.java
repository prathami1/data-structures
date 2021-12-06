import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.*;
import java.util.Stack;

public class Cars 
{
    public Cars()
    {
        Queue<Car> CarQueue = new LinkedList<>();
        Stack<Car> CarStack = new Stack<>();
        PriorityQueue<Car> carPQ = new PriorityQueue<>();

        try
        {
            BufferedReader input = new BufferedReader(new FileReader(new File("input.txt")));
            String text;
            input.readLine();

            while ((text = input.readLine()) != null) 
            {
                String[] props = text.split("\\s+");
                CarQueue.add(new Car(Integer.parseInt(props[5]), Integer.parseInt(props[1]), Integer.parseInt(props[3]), Integer.parseInt(props[2]), Integer.parseInt(props[4]), Integer.parseInt(props[7]), Integer.parseInt(props[0]), Integer.parseInt(props[6])));
            }

            System.out.printf("%-10s %-7s %-15s %-7s %-10s %-17s %-10s %-15s\n", "Car ID", "MPG", "Engine Size", "HP", "Weight", "Acceleration", "Origin", "# of Cylinders");

            while (!CarQueue.isEmpty() || CarQueue.peek() != null) 
            {
                System.out.println(CarStack.push(CarQueue.poll()));
            }
            System.out.println("\n-------------------------------------------------------------\n");
            System.out.printf("%-10s %-7s %-15s %-7s %-10s %-17s %-10s %-15s\n", "Car ID", "MPG", "Engine Size", "HP", "Weight", "Acceleration", "Origin", "# of Cylinders");
            while (!CarStack.empty()) 
            {
                Car temp = CarStack.pop();
                carPQ.add(temp);
                System.out.println(temp);
            }
            System.out.println("\n-------------------------------------------------------------\n");
            System.out.printf("%-10s %-7s %-15s %-7s %-10s %-17s %-10s %-15s\n", "Car ID", "MPG", "Engine Size", "HP", "Weight", "Acceleration", "Origin", "# of Cylinders");
            while (!carPQ.isEmpty() || carPQ.peek() != null) 
            {
                System.out.println(carPQ.poll());
            }
        }
        catch(Exception e)
        {
            System.out.println("File does not exist");
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        Cars app = new Cars();
    }
}

class Car implements Comparable<Car>
{
    private int acceleration;
    private int mpg;
    private int horsepower;
    private int weight;
    private int engineSize;
    private int numCylinders;
    private int id;
    private int origin;

    public Car(int acceleration, int mpg, int horsepower, int weight, int engineSize, int numCylinders, int id, int origin)
    {
        this.acceleration = acceleration;
        this.mpg = mpg;
        this.horsepower = horsepower;
        this.weight = weight;
        this.engineSize = engineSize;
        this.numCylinders = numCylinders;
        this.id = id;
        this.origin = origin;
    }

    public int getAccel() 
    {
        return acceleration;
    }

    public int getMPG() 
    {
        return mpg;
    }

    public int getHP() 
    {
        return horsepower;
    }

    public int getEngineSize() 
    {
        return engineSize;
    }

    public int getCyclinders() 
    {
        return numCylinders;
    }

    public int getOrigin() 
    {
        return origin;
    }

    public int getWeight() 
    {
        return weight;
    }

    public int getID() 
    {
        return id;
    }

    public int compareTo(Car other)
    {
        if (acceleration != other.acceleration)
            return acceleration - other.acceleration;
        if (mpg != other.getMPG())
            return mpg - other.getMPG();
        if (horsepower != other.getHP())
            return horsepower - other.getHP();
        if (engineSize != other.getEngineSize())
            return engineSize - other.getEngineSize();
        if (weight != other.getWeight())
            return weight - other.getWeight();
        if (numCylinders != other.getCyclinders())
            return numCylinders - other.getCyclinders();
        if (id != other.getID())
            return id - other.getID();
        return 0;
    }

    public String toString() 
    {
        return String.format("%-10d %-7d %-15d %-7d %-10d %-17d %-10d %-15d", id, mpg, engineSize, horsepower, weight, acceleration, origin, numCylinders);
    }
}