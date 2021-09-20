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

                        //new method

                while (startRow <= endRow && startColumn <= endColumn) {

                    // Going Right
                    for (int c = startColumn; c <= endColumn; c++) {
                        spiral[startRow][c] = "* ";
                        // System.out.println(spiral[startRow][c]);
                    }
                    startRow++;

                    if (startColumn >= 1)
                        startColumn++;

                    // Going Down
                    for (int r = startRow; r <= endRow; r++) {
                        spiral[r][endColumn] = "* ";
                        // System.out.println(spiral[r][endColumn]);
                    }
                    endColumn--;
                    startRow++;

                    // Going Left
                    for (int c = endColumn; c >= startColumn; c--) {
                        spiral[endRow][c] = "* ";
                        // System.out.println(spiral[endRow][c]);
                    }
                    endColumn--;
                    endRow--;

                    // Going Up
                    for (int r = endRow; r >= startRow; r--) {
                        spiral[r][startColumn] = "* ";
                        // System.out.println(spiral[r][startColumn]);
                    }
                    endRow--;
                    startColumn++;
                }

                if (spiral.length % 4 == 2) {
                    spiral[(spiral.length) / 2][(spiral.length - 2) / 2] = "- ";
                }

                for (int i = 0; i <= spiral.length - 1; i++) {
                    for (int k = 0; k <= spiral.length - 1; k++) {
                        System.out.print(spiral[i][k]);
                    }
                    System.out.println();
                }

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
