/* import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Maze extends JPanel implements KeyListener
{

    JFrame frame;
    String[][] maze;
    int size = 9, startX = 1, startY = 0, dimX = 101, dimY = 151, shrink = 50;
    Hero hero;
    ArrayList<Wall> walls;
    boolean draw3D = false;
    

    public Maze()
    {
        setMaze();
        frame = new JFrame("A-mazing Program");
        frame.add(this);
        frame.addKeyListener(this);
        frame.setSize(1400, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        g.setColor(Color.GRAY);
        for(int r = 0; r < maze.length; r++)
        {
            for(int c = 0; c < maze[0].length; c++)
            {
                if(maze[r][c].equals("#"))
                {
                    g.fillRect(c * size + 10, r * size + 10, size, size);
                }
                else
                {
                    for(Wall wall:walls)
                    {
                        g.setColor(new Color(50, 50, 50));
                        g.fillPolygon(wall.getPoly());
                        g.setColor(Color.WHITE);
                        g.drawPolygon(wall.getPoly());
                    }
                }
            }
        }
        g.setColor(Color.RED);
        g.fillOval(hero.getC()*size + 10, hero.getR()*size + 10, hero.getDim(),hero.getDim());
    }

    public void setMaze()
    {
        maze = new String[dimX][dimY];
        File name = new File("MazeProgram/MazeBank/Maze3.txt");
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

        hero = new Hero(startX, startY, size, maze);

        if(draw3D)
        {
            createWalls();
        }
    }

    public void keyPressed(KeyEvent e)
    {     
        if(e.getKeyCode() == 32)
        {
            draw3D = !draw3D;
        }
        else
        {
            hero.move(e.getKeyCode());
        }
        repaint();

        if(draw3D)
        {
            createWalls();
        }
    }

    public void createWalls()
    {
        walls = new ArrayList<Wall>();
        
        int r = hero.getR();
        int c = hero.getC(); 
        int dir = hero.getDir();
        int vis = 5; // visibility distance

        for(int i = 0; i < vis; i++) 
        {
            if(dir == 0)
            {
                if(maze[r - i][c - 1].equals("#"))
                {
                    walls.add(leftWall(i));
                }
            }
        }
    }

    public Wall leftWall()
    {

    }

    public void keyReleased(KeyEvent e)
    {
        
    }

    public void keyTyped(KeyEvent e)
    {

    }
    public static void main(String[] args)
    {
        Maze app = new Maze();
    }
} */