package ui;

import algorithms.bubbleSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    private int[] array;
    private JPanel visualizerPanel;

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

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bubbleSort.runSort(array, visualizerPanel);
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer.start();
            }
        });

        JPanel menuPanel = new JPanel();
        menuPanel.add(new JLabel("Enter values: "));
        menuPanel.add(inputField);
        menuPanel.add(startButton);

        add(menuPanel, BorderLayout.NORTH);
    }
}
