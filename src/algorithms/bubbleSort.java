package algorithms;

import javax.swing.*;
import ui.sortVisualizer;
import java.util.ArrayList;
import java.util.List;

public class bubbleSort implements sortAlgorithm {
    @Override
    public List<int[]> runSort(int[] array, sortVisualizer panel, JLabel swapLabel) {
        List<int[]> steps = new ArrayList<>();
        int arraySize = array.length;
        int[] swapCount = {0};

        steps.add(array.clone());

        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1, swapCount, swapLabel);
                    panel.setSorted(false);
                }
                steps.add(array.clone());
            }
        }
        panel.setSorted(true);
        steps.add(array.clone());

        swapLabel.setText("Swaps: " + swapCount[0]);

        return steps;
    }

    private static void swap(int[] array, int i, int j, int[] swapCount, JLabel swapLabel) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swapCount[0]++;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
