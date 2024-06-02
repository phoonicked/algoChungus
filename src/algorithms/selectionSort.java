package algorithms;

import javax.swing.*;
import ui.sortVisualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectionSort implements sortAlgorithm {
    @Override
    public void runSort(int[] array, sortVisualizer panel, JLabel swapLabel) {
        int arraySize = array.length;
        int[] swapCount = {0};
        Timer timer = new Timer(100, new ActionListener() {
            int currentIndex = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < arraySize - 1) {
                    int minimumIndex = currentIndex;
                    for (int i = currentIndex + 1; i < arraySize; i++) {
                        if (array[i] < array[minimumIndex]) {
                            minimumIndex = i;
                        }
                    }
                    if(minimumIndex != currentIndex){
                        int temp = array[currentIndex];
                        array[currentIndex] = array[minimumIndex];
                        array[minimumIndex] = temp;
                        swapCount[0]++;
                        swapLabel.setText("Swaps: " + swapCount[0]);
                    }
                    panel.setSorted(false);
                    panel.repaint();
                    currentIndex++;
                } else {
                    ((Timer) e.getSource()).stop();
                    panel.setSorted(true);
                    panel.repaint();
                }
            }
        });
        timer.start();
    }

    @Override
    public String getName(){
        return "Selection Sort";
    }
}
