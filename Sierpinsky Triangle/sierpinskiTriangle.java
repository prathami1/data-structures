import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;

public class sierpinskiTriangle extends JPanel implements KeyListener
{
    JFrame frame;
    ArrayList<Point> listpoint = new ArrayList<Point>();
    int num = 1;

    public SierpinskisTriangle()
    {
        frame = new JFrame("Sier Triangle");
        frame.add(this);
        frame.setSize(1000,800);
        frame.addKeyListener(this);
        SierpinksiProcess();
        Points();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class Point 
    {
        private int x;
        private int y;
        private Color color;
        public Point(int x, int y, Color color)
        {
            this.x=x;
            this.y=y;
            this.color=color;
        }

        public Color getColor()
        { return color; }

        public int getX()
        { return x; }

        public int getY()
        { return y; }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,frame.getWidth(),frame.getHeight());
        for(Point p:listpoint)
        {
            g.setColor(p.getColor());
            g.fillOval(p.getX(),p.getY(),2,2);
        }
    }

    public void SierpinksiProcess()
    {
        Point p1 = new Point(500,100,Color.YELLOW);
        Point p2 = new Point(100,700,Color.YELLOW);
        Point p3 = new Point(900,700,Color.YELLOW);

        int[] xx = new int[3];
        xx[0] = p1.getX();
        xx[1] = p2.getX();
        xx[2] = p3.getX();
        int[] yy = new int[3];
        yy[0] = p1.getY();
        yy[1] = p2.getY();
        yy[2] = p3.getY();

        listpoint.add(p1);
        listpoint.add(p2);
        listpoint.add(p3);

        Polygon triangle = new Polygon(xx,yy,3);
        int x;
        int y;
        
        do
        {
             x = (int)(Math.random()*frame.getWidth());
             y = (int)(Math.random()*frame.getHeight());
        } while(!triangle.contains(x,y));

        Point p4 = new Point(x,y,Color.YELLOW);
        listpoint.add(p4);
    }

    public void Points()
    {
        int randpointX = listpoint.get(3).getX();
        int randpointY = listpoint.get(3).getY();
        while(num>0) 
        {
            int cornerpointX = 0;
            int cornerpointY = 0;
            int randnum = (int)(Math.random()*3)+1;
            switch (randnum)
            {
                case 1:
                        cornerpointX = listpoint.get(0).getX();
                        cornerpointY = listpoint.get(0).getY();
                        break;
                case 2: cornerpointX = listpoint.get(1).getX();
                        cornerpointY = listpoint.get(1).getY();
                        break;
                case 3:
                        cornerpointX = listpoint.get(2).getX();
                        cornerpointY = listpoint.get(2).getY();
                        break;
            }
            int halfwaypointX = (randpointX + cornerpointX)/2;
            int halfwaypointY = (randpointY + cornerpointY)/2;
            Point point = new Point(halfwaypointX,halfwaypointY,Color.YELLOW);
            listpoint.add(point);
             randpointX = halfwaypointX;
             randpointY = halfwaypointY;
            num--;
            repaint();
        }
    }

    public void keyPressed(KeyEvent e)
    {
        int num = KeyEvent.VK_SPACE;
        num += num;
        Points();
        repaint();
    }
    
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }

    public static void main (String[]args)
    { sierpinskiTriangle app = new sierpinskiTriangle(); }
}