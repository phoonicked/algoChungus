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
        selectAlgorithm.setPreferredSize(new Dimension(100, selectAlgorithm.getPreferredSize().height));
        panel.add(selectAlgorithm);

        JTextField inputField = new JTextField("29,14,90,22,41,11,33");
        inputField.setPreferredSize(new Dimension(140, selectAlgorithm.getPreferredSize().height));
        panel.add(inputField);

        JButton runButton = new JButton("Run");
        panel.add(runButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
