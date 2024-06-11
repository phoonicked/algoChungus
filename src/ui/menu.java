package ui;

import algorithms.sortAlgorithm;
import org.reflections.Reflections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class menu extends JFrame {
    private int[] array;
    private sortVisualizer visualizerPanel;
    private boolean sortingStarted = false;
    private final JComboBox<String> algorithmSelector;
    private final JLabel swapNumber;

    public menu() {
        setTitle("Algorithm Chungus");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField inputField = new JTextField(20);
        JButton startButton = new JButton("Run");
        startButton.addActionListener(e -> {
            if (!sortingStarted) {
                sortingStarted = true;
                String inputText = inputField.getText();
                String[] values = inputText.split(",");
                array = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    array[i] = Integer.parseInt(values[i].trim());
                }

                if (visualizerPanel != null) {
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

        swapNumber = new JLabel("Swaps: ");

        JPanel menuPanel = new JPanel();
        menuPanel.add(new JLabel("Enter values: "));
        menuPanel.add(inputField);
        menuPanel.add(algorithmSelector);
        menuPanel.add(startButton);
        menuPanel.add(swapNumber);

        add(menuPanel, BorderLayout.NORTH);

        JPanel arrowPanel = arrowPanel();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton practiceButton = new JButton("Practice");
        JButton quizButton = new JButton("Quiz");
        JButton explanationButton = new JButton("Explanation");

        buttonPanel.add(practiceButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(explanationButton);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(arrowPanel, BorderLayout.NORTH);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(containerPanel, BorderLayout.SOUTH);
    }

    private JPanel arrowPanel() {
        JPanel arrowPanel = new JPanel();
        arrowPanel.setLayout(new FlowLayout());
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(e -> visualizerPanel.previousStep());
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(e -> visualizerPanel.nextStep());
        JButton visualizeButton = new JButton("Visualize");
        visualizeButton.addActionListener(e -> {
            if (visualizerPanel != null) {
                remove(visualizerPanel);
            }
            visualizerPanel = new sortVisualizer(array, getWidth(), getHeight() - 100);
            add(visualizerPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });
        arrowPanel.add(prevButton);
        arrowPanel.add(nextButton);
        arrowPanel.add(visualizeButton);
        return arrowPanel;
    }

    public void loadAlgorithms() {
        Reflections reflections = new Reflections("algorithms");
        Set<Class<? extends sortAlgorithm>> classes = reflections.getSubTypesOf(sortAlgorithm.class);
        for (Class<? extends sortAlgorithm> c : classes) {
            try {
                sortAlgorithm algorithm = c.getDeclaredConstructor().newInstance();
                algorithmSelector.addItem(algorithm.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void runAlgorithm() {
        String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
        assert selectedAlgorithm != null;

        Reflections reflections = new Reflections("algorithms");
        Set<Class<? extends sortAlgorithm>> classes = reflections.getSubTypesOf(sortAlgorithm.class);
        for (Class<? extends sortAlgorithm> c : classes) {
            try {
                sortAlgorithm algorithm = c.getDeclaredConstructor().newInstance();
                if (algorithm.getName().equals(selectedAlgorithm)) {
                    List<int[]> steps = algorithm.runSort(array, visualizerPanel, swapNumber);
                    visualizerPanel.setSteps(steps);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        visualizerPanel.repaint();
    }
}
