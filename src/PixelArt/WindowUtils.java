package PixelArt;

import javax.swing.*;

public class WindowUtils {
    public JFrame WindowUtils() {
        JFrame jFrame = new JFrame("PixArt");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1080, 720);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel jPanel1 = new JPanel();
        jFrame.add(jPanel1);
        JLabel jLabel1 = new JLabel("Ejemplo");
        jPanel1.add(jLabel1);
        jFrame.setVisible(true);
        return jFrame;
    }
}
