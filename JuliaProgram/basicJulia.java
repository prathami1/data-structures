import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class basicJulia extends JPanel implements AdjustmentListener, ActionListener
{
    JFrame frame;
    JScrollBar redBar, greenBar, blueBar;
    int red, green, blue;
    JPanel scrollPanel, buttonPanel, bigPanel;
    JButton reset;

    public basicJulia()
    {
        frame = new JFrame("Julia Program");
        
        
        //orientation, initial value, ?, lowerBound, upperBound3
        redBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
        red = redBar.getValue();
        redBar.addAdjustmentListener(this);

        greenBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
        green = greenBar.getValue();
        greenBar.addAdjustmentListener(this);

        blueBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
        blue = blueBar.getValue();
        blueBar.addAdjustmentListener(this);

        scrollPanel = new JPanel();
        scrollPanel.setLayout(new GridLayout(3, 1)); //rows, columns
        scrollPanel.add(redBar);
        scrollPanel.add(greenBar);
        scrollPanel.add(blueBar);

        reset = new JButton("Reset");
        reset.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.add(reset);

        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        bigPanel.add(scrollPanel, BorderLayout.CENTER);
        bigPanel.add(buttonPanel, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.add(bigPanel, BorderLayout.SOUTH);

        frame.setSize(1000,900);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        if(e.getSource() == redBar)
            red = redBar.getValue();
        if(e.getSource() == greenBar)
            green = greenBar.getValue();
        if(e.getSource() == blueBar)
            blue = blueBar.getValue();
        repaint();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == reset)
        {
            redBar.setValue(0);
            greenBar.setValue(0);
            blueBar.setValue(0);

            red = 0;
            green = 0;
            blue = 0;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(red, green, blue)); 
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    public static void main(String[] args)
    {
        basicJulia app = new basicJulia();
    }
}