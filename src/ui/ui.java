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

        // Add the runButton to the menuPanel
        menuPanel.add(runButton);

        frame.add(menuPanel);
        frame.setVisible(true);
    }
}