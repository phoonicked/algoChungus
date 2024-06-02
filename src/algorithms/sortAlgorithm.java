package algorithms;

import ui.sortVisualizer;
import javax.swing.JLabel;

public interface sortAlgorithm {
    void runSort(int[] array, sortVisualizer panel, JLabel swapLabel);
    String getName();
}
