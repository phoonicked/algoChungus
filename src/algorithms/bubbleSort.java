package algorithms;

import javax.swing.*;
import ui.sortVisualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bubbleSort implements sortAlgorithm {
    @Override
    public void runSort(int[] array, sortVisualizer panel, JLabel swapLabel) {
        int arraySize = array.length;
        int[] swapCount = {0};
        Timer timer = new Timer(100, null);

        timer.addActionListener(new ActionListener() {
            int i = 0;
            int j = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i < arraySize - 1) {
                    if (j < arraySize - i - 1) {
                        if (array[j] > array[j + 1]) {
                            swap(array, j, j + 1, swapCount, swapLabel);
                            panel.setSorted(false);
                            panel.repaint();
                        }
                        j++;
                    } else {
                        j = 0;
                        i++;
                    }
                } else {
                    timer.stop();
                    panel.setSorted(true);
                    panel.repaint();
                }
            }
        });
        timer.start();
    }


    private static void swap(int[] array, int i, int j, int[] swapCount, JLabel swapLabel) {
        int temp=array[i];
        array[i] = array[j];
        array[j] = temp;
        swapCount[0]++;
        swapLabel.setText("Swaps: " + swapCount[0]);
    }

    @Override
    public String getName(){
        return "Bubble Sort";
    }
}
