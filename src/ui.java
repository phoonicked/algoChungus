import javax.swing.*;
import java.awt.*;

public class ui {
    public ui() {
        JFrame frame = new JFrame("Algorithm Chungus");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new FlowLayout());


        String[] availableAlgorithms = { "Bubble Sort", "Selection Sort"};
        final JComboBox<String> selectAlgorithm = new JComboBox<>(availableAlgorithms);
        panel.add(selectAlgorithm);

        JButton runButton = new JButton("Run");
        panel.add(runButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
