public class Kahumo {
	public static double[] serve(double food, double flavor, int mouths) 
  {
    double [] result = new double [mouths];
    double tempFood = food+1, count = 1, countTotal = count;
    if(flavor!=1)
    {  
      for(int i = 1; i < mouths; i++)
      {
        count*=flavor;
        countTotal+=count;
      }
      tempFood = food/countTotal;
    }
    else
      tempFood = food/mouths;
    result[0] = tempFood;
    for(int i = 1; i < mouths; i++)
      result[i] = result[i-1] * flavor;
    return result;
	}
}
