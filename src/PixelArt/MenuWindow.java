package PixelArt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
