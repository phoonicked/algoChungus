package ui;

import algorithms.bubbleSort;

import javax.swing.*;
import java.awt.*;

public class sortVisualizer extends JPanel {
    private int[] array;

    public sortVisualizer(int[] array, int width, int height) {
        this.array = array;
        setPreferredSize(new Dimension(width, height));
    }

    public void runSort(){
        bubbleSort.runSort(array, this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        drawRectangles(g);
    }

    private void drawRectangles(Graphics g){
        int rectWidth = getWidth()/array.length;
        int rectHeight = getHeight()/array.length;
        for (int i = 0; i < array.length; i++) {
            int rectX = i * rectWidth;
            int rectY = getHeight() - array[i] * rectHeight;
            g.setColor(Color.CYAN);
            g.fillRect(rectX, rectY, rectWidth, array[i] * rectHeight);

            g.setColor(Color.BLACK);
            g.drawRect(rectX, rectY, rectWidth, array[i] * rectHeight);
        }
    }
}
