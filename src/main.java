import ui.ui;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ui::new);
        System.out.println("Hello world!");
    }
}