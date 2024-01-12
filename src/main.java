import ui.sortVisualizer;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int[] array = {5, 3, 8, 4, 2, 7, 1, 6};
            new sortVisualizer(array).setVisible(true);
        });
        System.out.println("Hello world!");
    }
}