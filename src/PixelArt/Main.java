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

        /*JFrame window2 = new JFrame("drawing canvas");
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Editor editor = new Editor(500, 500);

        window2.add(editor);
        window2.setSize(500, 500);
        window2.setResizable(false);
        window2.setVisible(true);
        editor.setColor(Color.YELLOW);*/
    }
}
