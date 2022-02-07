import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MapExample
{
    public MapExample()
    {
        HashMap<String, ArrayList<Integer>> diceMap = new HashMap<>();

        String[] names = {"Suns", "Nets", "Warriors", "Lakers"};

        for(int i = 0; i < names.length; i++)
            diceMap.put(names[i], new ArrayList<Integer>());

        for(int j = 0; j < 100; j++)
        {
            int name = (int)(Math.random()*names.length);
            int die2 = (int)(Math.random()*6)+1;
            diceMap.get(names[name]).add(die2);
        }

        //System.out.println(diceMap);

        for(int i = 0; i < names.length; i++)
            System.out.println(names[i] + ": " + diceMap.get(names[i]).size());
       
        Iterator<String> it = diceMap.keySet().iterator();

        //keySet - index values - values attached to each index
        //entrySet - has everything, not just index but everything that is attached to it as well

        while(it.hasNext())
            System.out.println(it.next());

        for(String name : diceMap.keySet())
            System.out.println(name);
    }

    public static void main(String[] args)
    {
        MapExample app = new MapExample();
    }
}