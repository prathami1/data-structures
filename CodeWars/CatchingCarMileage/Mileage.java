import java.util.*;
public class CarMileage {
  static ArrayList<Integer> list;
  public static int isInteresting(int number, int[] awesomePhrases) {
    // 0 = not interesting, 1 = interesting within two miles, 2 = interesting
    System.out.println(number);
    if(number < 98)
      return 0;
    if(number >= 100)
    {
      if(check(number, awesomePhrases))
        return 2;
    }
    if(number >= 99)
    {
      if(check(number+1, awesomePhrases))
        return 1;
    }
    if(number >= 98)
    {
      if(check(number+2, awesomePhrases))
        return 1;
    }
    return 0;
    
  }
  
  
  
  public static boolean check(int n, int[]phrases)
  {
    System.out.println(n);
    String temp = n+"";
    list = new ArrayList<Integer>();
    for(int i : phrases)
      list.add(i);
    int[] digits = new int[temp.length()];
    for(int i = 0; i < temp.length(); i++)
      digits[i] = Integer.parseInt(temp.charAt(i)+"");
  
    System.out.println(isIncrementing(digits) +"\n"+ isDecrementing(digits) +"\n"+ isPalindrome(n)  +"\n"+ hasZeroes(digits) +"\n"+ isSame(digits) +"\n"+ list.contains(n)) ; 
      
      
    if(isIncrementing(digits) || isDecrementing(digits) || isPalindrome(n)  || hasZeroes(digits) || isSame(digits) || list.contains(n))
      return true;
    return false;
  }
  
  public static boolean isIncrementing(int[] n)
  {
    boolean order = true;
    int i = 1;
    while(order && i < n.length)
    {
      if((n[i] - n[i-1]) != 1 && !(n[i] == 0 && n[i-1] == 9))
        order = false;
      i++;
    }
    return order;
  }
  
  public static boolean isDecrementing(int[] n)
  {
    boolean order = true;
    int i = 1;
    while(order && i < n.length)
    {
      if((n[i-1] - n[i]) != 1 )
        order = false;
      i++;
    }
    return order;
  }
  
  public static boolean isPalindrome(int n)
  {
    int r, sum = 0, temp = n;    
    while(n>0)
    {    
     r = n%10;    
     sum = (sum*10)+r;    
     n /= 10;    
    }    
    return (temp==sum);
  }
  
  public static boolean hasZeroes(int[] n)
  {
    boolean zero = true;
    int i = 1;
    while(zero && i < n.length)
    {
      if(n[i] != 0)
        zero = false;
      i++;
    }
    return zero;
  }
  
  public static boolean isSame(int[] n)
  {
    boolean same = true;
    int i = 0, num = n[0];
    while(same && i < n.length)
    {
      if(n[i] != num)
        same = false;
      i++;
    }
    return same;
  }
}
