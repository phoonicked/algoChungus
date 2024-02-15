package algorithms;

import javax.swing.*;
import ui.sortVisualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bubbleSort {
    public static void runSort(int[] array, sortVisualizer panel) {
        int arraySize = array.length;
        Timer timer = new Timer(100, null);

        timer.addActionListener(new ActionListener() {
            int i = 0;
            int j = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i < arraySize - 1) {
                    if (j < arraySize - i - 1) {
                        if (array[j] > array[j + 1]) {
                            swap(array, j, j + 1);
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


    private static void swap(int[] array, int i, int j){
        int temp=array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static String setName(){
        return "Bubble Sort";
    }
}
