package ui;

import algorithms.sortAlgorithm;
import org.reflections.Reflections;
import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    private int[] array;
    private sortVisualizer visualizerPanel;
    private boolean sortingStarted = false;
    private final JComboBox<String> algorithmSelector;
    private final JLabel timeLabel;
    private final JLabel swapNumber;

    public menu(){
        setTitle("Algorithm Chungus");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField inputField = new JTextField(20);
        JButton startButton = new JButton("Run");
        startButton.addActionListener(e -> {
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

                visualizerPanel = new sortVisualizer(array, getWidth(), getHeight() - 100);
                add(visualizerPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
                runAlgorithm();
            } else {
                sortingStarted = false;
            }
        });

        algorithmSelector = new JComboBox<>();
        loadAlgorithms();

        timeLabel = new JLabel("Time: ");
        swapNumber = new JLabel("Swaps: ");


        JPanel menuPanel = new JPanel();
        menuPanel.add(new JLabel("Enter values: "));
        menuPanel.add(inputField);
        menuPanel.add(algorithmSelector);
        menuPanel.add(startButton);
        menuPanel.add(timeLabel);
        menuPanel.add(swapNumber);

        add(menuPanel, BorderLayout.NORTH);
    }

    public void loadAlgorithms(){
        Reflections reflections = new Reflections("algorithms");
        Set<Class<? extends sortAlgorithm>> classes = reflections.getSubTypesOf(sortAlgorithm.class);
        for(Class<? extends sortAlgorithm> c : classes){
            try {
                sortAlgorithm algorithm = c.getDeclaredConstructor().newInstance();
                algorithmSelector.addItem(algorithm.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void runAlgorithm(){
        String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
        assert selectedAlgorithm != null;

        Reflections reflections = new Reflections("algorithms");
        Set<Class<? extends sortAlgorithm>> classes = reflections.getSubTypesOf(sortAlgorithm.class);
        for(Class<? extends sortAlgorithm> c : classes){
            try {
                sortAlgorithm algorithm = c.getDeclaredConstructor().newInstance();
                if(algorithm.getName().equals(selectedAlgorithm)){
                    algorithm.runSort(array, visualizerPanel, swapNumber);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Timer timer = new Timer(0, new ActionListener() {
            final long startTime = System.currentTimeMillis();
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop();
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                timeLabel.setText("Time: " + executionTime + " ms");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
