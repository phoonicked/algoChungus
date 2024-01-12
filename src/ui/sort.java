package ui;

import algorithms.bubbleSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sort {
    public static JButton executeRunButton(JTextField inputField, JComboBox<String> selectAlgorithm){
        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Parse the input to get the numbers
                String inputText = inputField.getText();
                String[] numbers = inputText.split(",");
                int[] array = new int[numbers.length];

                for (int i = 0; i < numbers.length; i++) {
                    array[i] = Integer.parseInt(numbers[i].trim());
                }
                String selectedAlgorithm = (String) selectAlgorithm.getSelectedItem();
                if(selectedAlgorithm.equals("Bubble Sort")){
                    bubbleSort sort = new bubbleSort();
                    //sort.runSort(array);
                }
                System.out.println("Sorted Array: " + java.util.Arrays.toString(array));
            }
        });
        return runButton;
    }
}
