import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MazeProgram extends JPanel implements KeyListener
{

    JFrame frame;
    String[][] maze;
    int size = 9, startX = 1, startY = 0, dimX = 30, dimY = 74, shrink = 50; //101, 151
    Hero hero;
    ArrayList<Wall> walls;
    boolean draw3D = false;
    
    public MazeProgram()
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
        if(!draw3D)
        {
            for(int r = 0; r < maze.length; r++)
            {
                for(int c = 0; c < maze[0].length; c++)
                {
                    if(maze[r][c].equals("#"))
                    {
                        g.fillRect(c * size + 10, r * size + 10, size, size);
                    }
                }
            }
            g.setColor(Color.RED);
            g.fillOval(hero.getC()*size + 10, hero.getR()*size + 10, hero.getDim(),hero.getDim());
        }
        else
        {
            for(Wall wall:walls)
            {
                g.setColor(new Color(50,50,50));
                g.fillPolygon(wall.getPoly());
                g.setColor(Color.WHITE);
                g.drawPolygon(wall.getPoly());
            }

        }
    }

    public void setMaze()
    {
        maze = new String[dimX][dimY];
        File name = new File("MazeProgram/MazeBank/Maze2.txt");
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
        hero.move(e.getKeyCode());
     
        

        if(draw3D)
        {
            createWalls();
        }
        repaint();
    }

    public void createWalls() 
    {
        walls = new ArrayList<Wall>();

        setFloorsandCeilings();

        int rr = hero.getLoc().getR();
        int cc = hero.getLoc().getC();
        int dir = hero.getDir();

        for (int n = 0; n < 5; n++) 
        {
            walls.add(getLeftPath(n));
            walls.add(getRightPath(n));
        }

        boolean oneFront;
        switch (dir) 
        {
            case 1: // up
                oneFront = true;
                for (int n = 0; n < 5; n++) 
                {
                    try 
                    {
                        if (oneFront) 
                        {
                            if (maze[rr - n][cc - 1].equals(' ')) 
                            {
                                walls.add(getLeft(n));
                            } 
                            else 
                            {
                                walls.add(getFloorLeft(n + 1));
                                walls.add(getCeilingLeft(n + 1));
                            }
                            if (maze[rr - n][cc + 1].equals(' ')) 
                            {
                                walls.add(getRight(n));
                            } 
                            else 
                            {
                                walls.add(getFloorRight(n + 1));
                                walls.add(getCeilingRight(n + 1));
                            }
                            if (maze[rr - n][cc].equals(' ')) {
                                walls.add(getFront(n));
                                oneFront = false;
                            }
                        }
                    } 
                    catch (ArrayIndexOutOfBoundsException e) 
                    {

                    }
                }
                break;
            case 2: // right
                oneFront = true;
                for (int n = 0; n < 5; n++) {
                    try {
                        if (oneFront) {
                            if (maze[rr - 1][cc + n].equals(' ')) {
                                walls.add(getLeft(n));
                            } else {
                                walls.add(getFloorLeft(n + 1));
                                walls.add(getCeilingLeft(n + 1));
                            }
                            if (maze[rr + 1][cc + n].equals(' ')) {
                                walls.add(getRight(n));
                            } else {
                                walls.add(getFloorRight(n + 1));
                                walls.add(getCeilingRight(n + 1));
                            }
                            if (maze[rr][cc + n].equals(' ')) {
                                walls.add(getFront(n));
                                oneFront = false;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
                break;
            case 3: // down
                oneFront = true;
                for (int n = 0; n < 5; n++) {
                    try {
                        if (oneFront) {
                            if (maze[rr + n][cc + 1].equals(' ')) {
                                walls.add(getLeft(n));
                            } else {
                                walls.add(getFloorLeft(n + 1));
                                walls.add(getCeilingLeft(n + 1));
                            }
                            if (maze[rr + n][cc - 1].equals(' ')) {
                                walls.add(getRight(n));
                            } else {
                                walls.add(getFloorRight(n + 1));
                                walls.add(getCeilingRight(n + 1));
                            }
                            if (maze[rr + n][cc].equals(' ')) {
                                walls.add(getFront(n));
                                oneFront = false;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
                break;
            case 4: // left
                oneFront = true;
                for (int n = 0; n < 5; n++) {
                    try {
                        if (oneFront) {
                            if (maze[rr + 1][cc - n].equals(' ')) {
                                walls.add(getLeft(n));
                            } else {
                                walls.add(getFloorLeft(n + 1));
                                walls.add(getCeilingLeft(n + 1));
                            }
                            if (maze[rr - 1][cc - n].equals(' ')) {
                                walls.add(getRight(n));
                            } else {
                                walls.add(getFloorRight(n + 1));
                                walls.add(getCeilingRight(n + 1));
                            }
                            if (maze[rr][cc - n].equals(' ')) {
                                walls.add(getFront(n));
                                oneFront = false;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
                break;
            }
    }

    public void setFloorsandCeilings() {
        for (int i = 0; i < 5; i++) {
            int[] rLocs = { 700 - (shrink * i), 650 - (shrink * i), 650 - (shrink * i), 700 - (shrink * i) };
            int[] cLocs = { 750 - (shrink * i), 700 - (shrink * i), 100 + (shrink * i), 50 + (shrink * i) };
            walls.add(new Wall(rLocs, cLocs, 255 - shrink * (i), 255 - shrink * (i), 255 - shrink * (i), size,
                    "FloorMain"));
        }
        for (int i = 0; i < 5; i++) {
            int[] rLocs = { 100 + (shrink * i), 150 + (shrink * i), 150 + (shrink * i), 100 + (shrink * i) };
            int[] cLocs = { 750 - (shrink * i), 700 - (shrink * i), 100 + (shrink * i), 50 + (shrink * i) };
            walls.add(new Wall(rLocs, cLocs, 255 - shrink * (i), 255 - shrink * (i), 255 - shrink * (i), size,
                    "CeilMain"));
        }

    }

    public Wall getLeft(int n) // trapezoid
    {
        int[] rLocs = { 100 + shrink * n, 150 + shrink * n, 650 - shrink * n, 700 - shrink * n };
        int[] cLocs = { 100 + shrink * n, 150 + shrink * n, 150 + shrink * n, 100 + shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * n, 255 - shrink * n, 255 - shrink * n, size, "LeftWall");
    }

    public Wall getRight(int n) // trapezoid
    {
        int[] rLocs = { 100 + shrink * n, 150 + shrink * n, 650 - shrink * n, 700 - shrink * n };
        int[] cLocs = { 700 - shrink * n, 650 - shrink * n, 650 - shrink * n, 700 - shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * n, 255 - shrink * n, 255 - shrink * n, size, "RightWall");
    }

    public Wall getFront(int n) // trapezoid
    {
        int[] rLocs = { 100 + 50 * n, 100 + 50 * n, 700 - 50 * n, 700 - 50 * n };
        int[] cLocs = { 100 + 50 * n, 700 - 50 * n, 700 - 50 * n, 100 + 50 * n };
        return new Wall(rLocs, cLocs, 255 - shrink * n, 255 - shrink * n, 255 - shrink * n, size, "FrontWall");
    }

    public Wall getLeftPath(int n) // rectangle
    {
        int[] rLocs = { 100 + shrink * n, 100 + shrink * n, 700 - shrink * n, 700 - shrink * n };
        int[] cLocs = { 50 + shrink * n, 100 + shrink * n, 100 + shrink * n, 50 + shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * n, 255 - shrink * n, 255 - shrink * n, size, "LeftPath");
    }

    public Wall getRightPath(int n) // rectangle
    {
        int[] rLocs = { 100 + shrink * n, 100 + shrink * n, 700 - shrink * n, 700 - shrink * n };
        int[] cLocs = { 750 - shrink * n, 700 - shrink * n, 700 - shrink * n, 750 - shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * n, 255 - shrink * n, 255 - shrink * n, size, "RightPath");
    }

    public Wall getFloorLeft(int n) // triangle
    {
        int[] rLocs = { 750 - shrink * n, 700 - shrink * n, 700 - shrink * n };
        int[] cLocs = { 50 + shrink * n, 50 + shrink * n, 100 + shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * (n - 1), 255 - shrink * (n - 1), 255 - shrink * (n - 1), size,
                "FloorLeft");
    }

    public Wall getCeilingLeft(int n) // triangle
    {
        int[] rLocs = { 50 + shrink * n, 100 + shrink * n, 100 + shrink * n };
        int[] cLocs = { 50 + shrink * n, 50 + shrink * n, 100 + shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * (n - 1), 255 - shrink * (n - 1), 255 - shrink * (n - 1), size,
                "CeilLeft");
    }

    public Wall getFloorRight(int n) // triangle
    {
        int[] rLocs = { 750 - shrink * n, 700 - shrink * n, 700 - shrink * n };
        int[] cLocs = { 750 - shrink * n, 750 - shrink * n, 700 - shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * (n - 1), 255 - shrink * (n - 1), 255 - shrink * (n - 1), size,
                "FloorRight");
    }

    public Wall getCeilingRight(int n) // triangle
    {
        int[] rLocs = { 50 + shrink * n, 100 + shrink * n, 100 + shrink * n };
        int[] cLocs = { 750 - shrink * n, 750 - shrink * n, 700 - shrink * n };
        return new Wall(rLocs, cLocs, 255 - shrink * (n - 1), 255 - shrink * (n - 1), 255 - shrink * (n - 1), size,
                "CeilRight");
    }


    public void keyReleased(KeyEvent e)
    {
        
    }

    public void keyTyped(KeyEvent e)
    {

    }
    public static void main(String[] args)
    {
        MazeProgram app = new MazeProgram();
    }
}
