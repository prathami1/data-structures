import java.io.*;

public class Spiral
{
    public static void main(String[] args)
    {
       File name = new File("/Users/pratham/Downloads/data-structures-main/Spiral/SpiralInput.txt");

        try
        {
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text,output="";

            while ((text = input.readLine()) != null)
            {

                int SR = 0, SC = 0, ER = (Integer.parseInt(text)-1), EC = (Integer.parseInt(text)-1);

                String[][] board = new String[ER + 1][EC + 1];

                for (int i = 0; i <= ER; i++)
                {
                    for (int j = 0; j <= EC; j++)
                    {
                        board[i][j] = "- ";
                    }
                }

                while (SR <= ER && SC <= EC)
                {

                    for (int c = SC; c <= EC; c++)
                    {
                        board[SR][c] = "* ";
                    }
                    SR++;

                    if (SC >= 1)
                    {
                        SC++;
					}

                    for (int r = SR; r <= ER; r++)
                    {
                        board[r][EC] = "* ";
                    }
                    EC--;
                    SR++;

                    for (int c = EC; c >= SC; c--)
                    {
                        board[ER][c] = "* ";
                    }
                    EC--;
                    ER--;

                    for (int r = ER; r >= SR; r--)
                    {
                        board[r][SC] = "* ";
                    }
                    ER--;
                    SC++;
                }

                if (board.length % 4 == 2)
                {
                    board[(board.length) / 2][(board.length - 2) / 2] = "- ";
                }

                for (int i = 0; i <= board.length - 1; i++)
                {
                    for (int j = 0; j <= board.length - 1; j++)
                    {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
				output+=text;
            }

        }
        catch (IOException e)
        {
			System.err.println("File does not exist");
        }

    }

}
