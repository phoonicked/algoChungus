package algorithms;

import javax.swing.JLabel;
import ui.sortVisualizer;
import java.util.ArrayList;
import java.util.List;

public class selectionSort implements sortAlgorithm {

    @Override
    public List<int[]> runSort(int[] array, sortVisualizer panel, JLabel swapLabel) {
        List<int[]> steps = new ArrayList<>();
        List<int[]> compareIndices = new ArrayList<>();
        int arraySize = array.length;
        int[] swapCount = {0};

        steps.add(array.clone());
        compareIndices.add(new int[] {-1, -1});

        for (int currentIndex = 0; currentIndex < arraySize - 1; currentIndex++) {
            int minimumIndex = currentIndex;
            for (int i = currentIndex + 1; i < arraySize; i++) {
                compareIndices.add(new int[] {currentIndex, i});
                if (array[i] < array[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            if (minimumIndex != currentIndex) {
                swap(array, currentIndex, minimumIndex, swapCount, swapLabel);
            }
            steps.add(array.clone());
            compareIndices.add(new int[] {-1, -1});
        }
        steps.add(array.clone());

        swapLabel.setText("Swaps: " + swapCount[0]);
        panel.setSteps(steps, compareIndices);
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
        return "Selection Sort";
    }
}
