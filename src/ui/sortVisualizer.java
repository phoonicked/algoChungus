package ui;

import algorithms.bubbleSort;

import javax.swing.*;
import java.awt.*;

public class sortVisualizer extends JFrame {
    private int[] array;

    public sortVisualizer(int[] array) {
        this.array = array;
        setTitle("Algorithm Chungus");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bubbleSort bs = new bubbleSort();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRectangles(g);
            }
        };

        add(panel);

        JButton startButton = new JButton("Run");
        startButton.addActionListener(e -> {
            bubbleSort.runSort(array, panel);
        });

        add(startButton, BorderLayout.SOUTH);
    }

    private void drawRectangles(Graphics g){
        int width = getWidth()/array.length;
        for (int i = 0; i < array.length; i++) {
            int height = array[i] * 30;
            g.setColor(Color.CYAN);
            g.fillRect(i * width, getHeight() - height, width, height);

            g.setColor(Color.BLACK);
            g.drawRect(i * width, getHeight() - height, width, height);
        }
    }
}
