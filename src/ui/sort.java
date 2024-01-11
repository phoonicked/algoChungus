package ui;

import algorithms.bubbleSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class sort {
    public static JButton executeRunButton(JTextField inputField, JComboBox<String> selectAlgorithm, JPanel barPanel){
        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear existing bars
                barPanel.removeAll();

                // Parse the input to get the numbers
                String inputText = inputField.getText();
                String[] numbers = inputText.split(",");
                int[] array = new int[numbers.length];

                // Convert input string to array of integers
                for (int i = 0; i < numbers.length; i++) {
                    array[i] = Integer.parseInt(numbers[i].trim());
                }

                // Find the maximum value in the array
                int max = Arrays.stream(array).max().orElse(0);

                // Create and add bars based on the normalized values
                for (int value : array) {
                    JLabel bar = new JLabel(" ");
                    bar.setBackground(Color.ORANGE);
                    bar.setOpaque(true);

                    // Normalize the height of the bar based on the maximum value
                    int normalizedHeight = (int) (((double) value / max) * 200); // 200 is the maximum height
                    bar.setPreferredSize(new Dimension(30, normalizedHeight));

                    barPanel.add(bar);
                }

                // Refresh the UI
                barPanel.revalidate();
                barPanel.repaint();

                for (int i = 0; i < numbers.length; i++) {
                    array[i] = Integer.parseInt(numbers[i].trim());
                }
                String selectedAlgorithm = (String) selectAlgorithm.getSelectedItem();
                if(selectedAlgorithm.equals("Bubble Sort")){
                    bubbleSort sort = new bubbleSort();
                    sort.runSort(array);
                }
                System.out.println("Sorted Array: " + java.util.Arrays.toString(array));
            }
        });
        return runButton;
    }
}
