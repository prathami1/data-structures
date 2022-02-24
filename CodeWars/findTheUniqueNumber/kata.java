// Make sure your class is public
 public class Kata {
    public static double findUniq(double arr[]) 
    {
      double uNum = 0;
      for(int i = 1; i < arr.length-1; i++)
      {
        if(arr[i-1] != arr[i] && arr[i] != arr[i+1])
          uNum = arr[i];
        else if(arr[0] != arr[i])
          uNum = arr[0];
        else if(arr[arr.length-1] != arr[i])
          uNum = arr[arr.length-1];
      }
      return uNum;
    }
}
