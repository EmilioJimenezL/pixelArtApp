package PixelArt;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends JFrame {
    JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel;
    public EditorWindow(Editor editor){
        setSize(1280, 720);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = editor;
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLUE);
        eastPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.MAGENTA);
        mainPanel.setPreferredSize(new Dimension(100,100));
        northPanel.setPreferredSize(new Dimension(100,100));
        southPanel.setPreferredSize(new Dimension(100,100));
        eastPanel.setPreferredSize(new Dimension(100,100));
        westPanel.setPreferredSize(new Dimension(100,100));
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(editor, BorderLayout.CENTER);
        setVisible(true);
    }
}
