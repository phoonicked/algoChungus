import ui.menu;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menu().setVisible(true));
        System.out.println("Hello world!");
    }
}