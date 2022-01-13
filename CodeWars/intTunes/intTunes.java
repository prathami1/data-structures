import java.util.*;
public class Kata {
    public static boolean isTune (int[] notes) {
      if(notes==null || notes.length==0)
        return false;
      ArrayList<Integer> list=new ArrayList<Integer>();
      entry(list);
      for(int i = 0; i <= 12; i++)
      {
        if(inTune(list,notes,i))
          return true; 
      }
      return false;
    }
    public static boolean inTune(ArrayList<Integer> list,int[] n, int key)
    {
        for(int i = 0; i < n.length; i++)
        {  
          int temp = n[i] + key;
          while(temp < 0)
            temp+=12;
          if(!list.contains(temp%12))
            return false;
        }
        return true;
    }
    public static void entry(ArrayList<Integer> l)
    {
      l.add(0);
      l.add(1);
      l.add(3);
      l.add(5);
      l.add(6);
      l.add(8);
      l.add(10);
    }
}
