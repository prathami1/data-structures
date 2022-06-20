import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class Minesweeper extends JPanel
{
    JFrame frame;
    JToggleButton[][] grid;
    JPanel gridPanel;
    int dimR = 9, dimC = 9;
    public Minesweeper()
    {
        frame = new JFrame("Minesweeper");
        frame.add(this);

        setGrid(dimR, dimC);

        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void setGrid(int dimR, int dimC)
    {
        if(gridPanel != null)
            frame.remove(gridPanel);

        gridPanel = new JPanel();
        frame.add(gridPanel);
        gridPanel.setLayout(new GridLayout(dimR, dimC));

    }

    public static void main(String[] args)
    { Minesweeper app = new Minesweeper(); }
}