package PixelArt;

import javax.swing.*;
import java.awt.*;

public class WindowUtils {
    public JFrame WindowUtils() {
        JFrame jFrame = new JFrame("PixArt");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1280, 720);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel jPanel1 = new JPanel();
        jFrame.add(jPanel1);
        JLabel jLabel1 = new JLabel("Ejemplo");
        jPanel1.add(jLabel1);
        jFrame.setVisible(true);
        return jFrame;
    }
    public JFrame showMainMenu(){
        JFrame jFrame = new JFrame("PixArt");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1280, 720);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLayout(new GridLayout());
        JPanel mainTitle = new JPanel();
        mainTitle.setLayout(new GridLayout(2, 3, 100, 100));
        JButton buttonStart =  new JButton("Iniciar");
        JLabel labelTitle = new JLabel("PixArt: Aplicacion PixelArt");
        mainTitle.add(labelTitle);
        mainTitle.add(buttonStart);
        jFrame.add(mainTitle);
        jFrame.setVisible(true);
        return jFrame;
    }
}
