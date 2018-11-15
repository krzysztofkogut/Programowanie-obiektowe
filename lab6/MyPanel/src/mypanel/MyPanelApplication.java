package mypanel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyPanelApplication extends JFrame {
    
    public MyPanelApplication() {
        super("Shapes");
        setSize(new Dimension(300,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        setLookAndFeel();
        add(panel);
        setVisible(true);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                + "systemowego wyglądu: " + e);
        }
    }
    
    public static void main(String[] arguments) {
        MyPanelApplication my = new MyPanelApplication();
    }
}