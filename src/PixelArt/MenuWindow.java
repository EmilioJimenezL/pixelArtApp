package PixelArt;

import javax.swing.*;

public class MenuWindow extends JFrame {
    JPanel menuPanel;
    public MenuWindow(){
        setTitle("PixArt: Menu");
        setSize(1280, 720);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(menuPanel = new MainMenuPanel());
        setVisible(true);
    }
}
