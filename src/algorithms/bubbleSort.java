package algorithms;

import javax.swing.*;
import ui.sortVisualizer;

public class bubbleSort {
    public static void runSort(int[] array, sortVisualizer panel){
        int arraySize = array.length;
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    SwingUtilities.invokeLater(() -> {
                        panel.setSorted(false);
                        panel.repaint();
                    });
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        SwingUtilities.invokeLater(() -> {
            panel.setSorted(true);
            panel.repaint();
        });
    }

    public String getName(){
        return "Bubble Sort";
    }
}
