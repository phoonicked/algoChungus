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

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JPanel visualizerPanel = new JPanel();
        visualizerPanel.setLayout(new FlowLayout());

        String[] availableAlgorithms = {"Bubble Sort", "Selection Sort"};
        final JComboBox<String> selectAlgorithm = new JComboBox<>(availableAlgorithms);
        selectAlgorithm.setPreferredSize(new Dimension(100, selectAlgorithm.getPreferredSize().height));
        visualizerPanel.add(selectAlgorithm);

        JTextField inputField = new JTextField("29,14,90,22,41,11,33");
        inputField.setPreferredSize(new Dimension(140, selectAlgorithm.getPreferredSize().height));
        visualizerPanel.add(inputField);

        JPanel barPanel = new JPanel();
        barPanel.setLayout(new BorderLayout());

        // Default bars
        int[] values = {29, 14, 90, 22, 41, 11, 33};
        int maxBarHeight = 200;  // Maximum height for the bars

        for (int value : values) {
            int barHeight = (int) ((double) value / Arrays.stream(values).max().getAsInt() * maxBarHeight);
            JLabel bar = new JLabel(" ");
            bar.setBackground(Color.ORANGE);
            bar.setOpaque(true);
            bar.setPreferredSize(new Dimension(30, barHeight));
            barPanel.add(bar);
        }

        menuPanel.add(visualizerPanel);
        menuPanel.add(barPanel);

        // Call the executeRunButton method with the relevant components
        JButton runButton = sort.executeRunButton(inputField, selectAlgorithm, barPanel);

        // Add the runButton to the visualizerPanel
        visualizerPanel.add(runButton);

        frame.add(menuPanel);
        frame.setVisible(true);
    }
}