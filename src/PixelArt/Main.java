package PixelArt;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("PixArt");
        MainMenu mainMenu = new MainMenu();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1280, 720);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.add(mainMenu);
        window.setResizable(false);
        window.setVisible(true);
    }
}
