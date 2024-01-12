package algorithms;

import javax.swing.*;

public class bubbleSort {
    public static void runSort(int[] array, JPanel panel){
        int arraySize = array.length;
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    panel.repaint();
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String getName(){
        return "Bubble Sort";
    }
}
