package PixelArt;

import javax.swing.*;

public class IOWindow extends JFrame {
    IOPanel ioPanel;
    public IOWindow(){
        setName("PixArt: Archivos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setExtendedState(MAXIMIZED_BOTH);
        add(ioPanel = new IOPanel());
        setVisible(true);
    }
}
