import java.io.*;

public class JollySorting
{
	public JollySorting()
	{
		File name = new File("JollyInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text;
			while((text=input.readLine())!= null)
			{
				String[] pieces = text.split(" ");
				int[] nums = new int [pieces.length];
				for(int i = 0; i < pieces.length; i++)
				{
					nums[i]= Integer.parseInt(pieces[i]);
				}
				sort(nums);
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static void main(String args[])
	{
		JollySorting app = new JollySorting();
	}
	public void sort(int[] nums)
	{
		for(int i = 0; i < nums.length-1; i++)
		{
			int ind = i;
			while(ind>=0 && nums[ind]>nums[ind+1])
			{
				int temp = nums[ind];
				nums[ind] = nums[ind+1];
				nums[ind+1] = temp;
				ind--;
			}
		}

		for(int i = 1; i < nums.length-1; i+=2)
		{
			int temp = nums[i];
			nums[i]=nums[i+1];
			nums[i+1]=temp;
		}

		for(int i=0; i<nums.length; i++)
		System.out.print(nums[i] + " ");
		System.out.println();
	}
}