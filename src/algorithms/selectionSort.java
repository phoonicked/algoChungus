package algorithms;

import javax.swing.*;
import ui.sortVisualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectionSort {
    public static void runSort(int[] array, sortVisualizer panel) {
        int arraySize = array.length;
        Timer timer = new Timer(200, new ActionListener() {
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
                    int temp = array[currentIndex];
                    array[currentIndex] = array[minimumIndex];
                    array[minimumIndex] = temp;
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

    public static String setName(){
        return "Selection Sort";
    }
}
