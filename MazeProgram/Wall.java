/* import java.awt.GradientPaint;
import java.awt.Color;

public class Wall {

    private int rows[], cols[], size;
    private String type;

    public Wall(int rows[], int cols[], int size, String type) {
        this.rows = rows;
        this.cols = cols;
        this.size = size;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int[] getRows() {
        return rows;
    }

    public int[] getCols() {
        return cols;
    }

    public int getNumSides() {
        return rows.length;
    }

} */

import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.Polygon;

public class Wall {

    private int rows[], cols[], r, g, b, size;
    private String type;

    public Wall(int rows[], int cols[], int r, int g, int b, int size, String type) {
        this.rows = rows;
        this.cols = cols;
        this.r = r;
        this.g = g;
        this.b = b;
        this.size = size;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int[] getRows() {
        return rows;
    }

    public int[] getCols() {
        return cols;
    }

    public int getNumSides() {
        return rows.length;
    }

    public Color getColor() {
        return new Color(r, g, b);
    }

    public void setColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Polygon getPoly()
    {
        return new Polygon(cols,rows,cols.length);

    }

}

