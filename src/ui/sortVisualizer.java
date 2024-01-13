package ui;

import javax.swing.*;
import java.awt.*;

public class sortVisualizer extends JPanel {
    private int[] array;
    private boolean sorted = false;

    public sortVisualizer(int[] array, int width, int height) {
        this.array = array;
        setPreferredSize(new Dimension(width, height));
    }

    public void setSorted(boolean sorted){
        this.sorted = sorted;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRectangles(g);
    }

    private void drawRectangles(Graphics g) {
        int rectWidth = getWidth() / array.length;
        int rectHeight = getHeight() / array.length;
        for (int i = 0; i < array.length; i++) {
            int rectX = i * rectWidth;
            int rectY = getHeight() - array[i] * rectHeight;
            if(sorted){
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.CYAN);
            }
            g.fillRect(rectX, rectY, rectWidth, array[i] * rectHeight);

            g.setColor(Color.BLACK);
            g.drawRect(rectX, rectY, rectWidth, array[i] * rectHeight);
        }
    }
}
