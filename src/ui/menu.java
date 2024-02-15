package ui;

import algorithms.bubbleSort;
import algorithms.selectionSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    private int[] array;
    private sortVisualizer visualizerPanel;
    private boolean sortingStarted = false;
    private JComboBox<String> algorithmSelector;

    public menu(){
        setTitle("Algorithm Chungus");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField inputField = new JTextField(20);
        JButton startButton = new JButton("Run");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sortingStarted){
                    sortingStarted = true;
                    String inputText = inputField.getText();
                    String[] values = inputText.split(",");
                    array = new int[values.length];
                    for (int i = 0; i < values.length; i++) {
                        array[i] = Integer.parseInt(values[i].trim());
                    }

                    if(visualizerPanel != null){
                        remove(visualizerPanel);
                    }

                    visualizerPanel = new sortVisualizer(array, getWidth(), getHeight() - 30);
                    add(visualizerPanel, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                    runAlgorithm();
                } else {
                    sortingStarted = false;
                }
            }
        });

        algorithmSelector = new JComboBox<>();
        algorithmSelector.addItem(algorithms.bubbleSort.setName());
        algorithmSelector.addItem(algorithms.selectionSort.setName());


        JPanel menuPanel = new JPanel();
        menuPanel.add(new JLabel("Enter values: "));
        menuPanel.add(inputField);
        menuPanel.add(algorithmSelector);
        menuPanel.add(startButton);

        add(menuPanel, BorderLayout.NORTH);
    }

    private void runAlgorithm(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the selected algorithm and run the corresponding sort
                String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
                if (selectedAlgorithm.equals("Bubble Sort")) {
                    bubbleSort.runSort(array, visualizerPanel);
                } else if (selectedAlgorithm.equals("Selection Sort")) {
                    selectionSort.runSort(array, visualizerPanel);
                }
                ((Timer) e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
