import java.io.*;

public class Spiral
{
	public static void main(String args[])
	{
		File name = new File("SpiralInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				//System.out.println(text);
				int SR = 0, SC = 0, ER = (Integer.parseInt(text)-1), EC = (Integer.parseInt(text)-1);
				createBoard(ER, EC);

				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static void createBoard(int ER, int EC)
	{
		String[][] board = new String[ER + 1][EC + 1];

		for (int i = 0; i <= ER; i++) {
			for (int j = 0; j <= EC; j++) {
				board[i][j] = "- ";
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}