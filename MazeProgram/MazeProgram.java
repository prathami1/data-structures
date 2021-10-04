import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MazeProgram extends JPanel {

    JFrame frame;
    String[][] maze;
    int size = 20;
    public MazeProgram()
    {
        setMaze();
        frame = new JFrame("A-mazing Program");
        frame.add(this);
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        g.setColor(Color.GREEN);
        for(int r = 0; r < maze.length; r++)
        {
            for(int c = 0; c < maze[0].length; c++)
            {
                if(maze[r][c].equals("#"))
                {
                    g.fillRect(c*size + size, r*size + size, size, size);
                }
            }
        }
    }

    public void setMaze()
    {
        maze = new String[18][41];
        File name = new File("Classwork/Maze.txt");
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text;
            int r = 0;
            while((text=input.readLine())!= null)
			{
                maze[r] = text.split("");
                r++;
			}
        }
        catch (IOException io)
		{
			System.err.println("File does not exist");
		}

        
    }
    public static void main(String[] args)
    {
        MazeProgram app = new MazeProgram();
    }
}
