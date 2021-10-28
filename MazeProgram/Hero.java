public class Hero {

    int r, c;
    int dim;
    String[][] maze;
    private int dir;
    private Location loc;

    public Hero(int r, int c, int dim, String[][] maze)
    {
        this.r = r;
        this.c = c;
        this.dim = dim;
        this.maze = maze;
        dir = 2;
        loc = new Location(r,c);
        // 1 forward, 2 right, 3 back, 4 left
    }
    public int getR()
    {
        return r;
    }
    public int getC()
    {
        return c;
    }
    public void move(int key)
    {
        if(key == 38)
        {
            if(!maze[r][c+1].equals("#") && dir == 2)
                c++;
            if(!maze[r][c-1].equals("#") && dir == 4)
                c--;
            if(!maze[r-1][c].equals("#") && dir == 3)
                r--;
            if(!maze[r+1][c].equals("#") && dir == 1)
                r++;
        }
        else if(key == 37)
        {
            dir--;
            if (dir < 1)
                dir = 4;
        }
        else if(key == 39)
        {
            dir++;
            if (dir > 4)
                dir = 1;
        }
    }
    public int getDim()
    {
        return dim;
    }
    public Location getLoc() {
        return loc;
    }
    public int getDir() {
        return dir;
    }
} 