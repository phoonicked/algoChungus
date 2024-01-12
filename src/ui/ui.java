package ui;

import algorithms.bubbleSort;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ui {
    public ui() {
        JFrame frame = new JFrame("Algorithm Chungus");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());

        String[] availableAlgorithms = {"Bubble Sort", "Selection Sort"};
        final JComboBox<String> selectAlgorithm = new JComboBox<>(availableAlgorithms);
        selectAlgorithm.setPreferredSize(new Dimension(100, selectAlgorithm.getPreferredSize().height));
        menuPanel.add(selectAlgorithm);

        JTextField inputField = new JTextField("29,14,90,22,41,11,33");
        inputField.setPreferredSize(new Dimension(140, selectAlgorithm.getPreferredSize().height));
        menuPanel.add(inputField);

        // Call the executeRunButton method with the relevant components
        JButton runButton = sort.executeRunButton(inputField, selectAlgorithm);
        menuPanel.add(runButton);

        JPanel rectanglePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                drawRectangles(g);
            }
        };
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(rectanglePanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void drawRectangles(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(50,50,100,50);
        g.fillRect(200,100,80,120);
    }
}