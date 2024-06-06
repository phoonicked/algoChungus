package algorithms;

import ui.sortVisualizer;
import javax.swing.JLabel;
import java.util.List;


public interface sortAlgorithm {
    List<int[]> runSort(int[] array, sortVisualizer panel, JLabel swapLabel);
    String getName();
}
