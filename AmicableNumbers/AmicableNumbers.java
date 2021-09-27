import java.io.*;
import java.util.ArrayList;

public class AmicableNumbers
{
	public static void main(String args[])
	{
        AmicableNumbers app = new AmicableNumbers();
    }
        public AmicableNumbers()
        {
            File name = new File("AmicableInput.txt");
            try
            {
                BufferedReader input = new BufferedReader(new FileReader(name));
                String text,output="";
                while( (text=input.readLine())!= null)
                {
                    String[] pieces = text.split(" ");
                    int fNum = Integer.parseInt(pieces[0]);
                    int sNum = Integer.parseInt(pieces[1]);
                    amicableNumbers(fNum, sNum);
                    //System.out.println(text);
                    output+=text;
                }
            }
            catch (IOException io)
            {
                System.err.println("File does not exist");
            }
        }
    public void amicableNumbers(int fNum, int sNum)
    {
        ArrayList<Integer> fFac = new ArrayList<Integer>();
        ArrayList<Integer> sFac = new ArrayList<Integer>();
        int fFacSum = 0;
        int sFacSum = 0;
        for(int i = 1; i < fNum; i++)
        {
            if(fNum % i == 0)
            {
                fFac.add(i);
            }
            if(sNum % i == 0)
            {
                sFac.add(i);
            }
        }
        
        for(int i = 0; i < fFac.size(); i++)
        {
            fFacSum += fFac.get(i);
        }

        for(int i = 0; i < sFac.size(); i++)
        {
            sFacSum += sFac.get(i);
        }
        if(fFacSum == sNum && sFacSum == fNum)
        {
            System.out.println("The numbers " + fNum + " and " + sNum + " are amicable.");
            String fFacs = fFac.toString();
            String sFacs = sFac.toString();
            int fForm = fFacs.lastIndexOf(",");
            int sForm = sFacs.lastIndexOf(",");
            String fFacList = fFacs.substring(1, fForm-1) + " and" + fFacs.substring(fForm+1, fFacs.length()-1);
            String sFacList = sFacs.substring(1, sForm-1) + " and" + sFacs.substring(sForm+1, sFacs.length()-1);
            System.out.println("Factors of " + fNum + " are " + fFacList + ". Sum is " + sNum + ".");
            System.out.println("Factors of " + sNum + " are " + sFacList + ". Sum is " + fNum + ".");
        }
    }
}
