import java.util.*;

class DoubleLinear {
    
    public static int dblLinear (int n) {
        Integer x = 1;
        int y = 0, z = 0, counter = 0, listSize = 3, maxtimes = n+(n/2);
        TreeSet<Integer> list = new TreeSet<>();
        list.add(1);
        while(listSize < maxtimes)
        {
            y = 2*x+1;
            z = 3*x+1;
            if (list.add(y))
            {
                listSize++;
            }
            if (list.add(z))
            {
                listSize++;
            }
            counter++;
            x = new ArrayList<>(list).get(counter);
        }
        x = new ArrayList<>(list).get(n);
        return x;
    }
}
