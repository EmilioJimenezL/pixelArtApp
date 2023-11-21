package PixelArt;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends JFrame {
    JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel;
    public EditorWindow(EditorPanel editorPanel){
        setSize(1920, 1080);
        setName("PixArt: Editor");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = editorPanel;
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLUE);
        eastPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.MAGENTA);
        mainPanel.setPreferredSize(new Dimension(editorPanel.width, editorPanel.height));
        northPanel.setPreferredSize(new Dimension((this.getWidth() - editorPanel.width)/2,(this.getHeight() - editorPanel.height)/2));
        southPanel.setPreferredSize(new Dimension((this.getWidth() - editorPanel.width)/2,(this.getHeight() - editorPanel.height)/2));
        eastPanel.setPreferredSize(new Dimension((this.getWidth() - editorPanel.width)/2,(this.getHeight() - editorPanel.height)/2));
        westPanel.setPreferredSize(new Dimension((this.getWidth() - editorPanel.width)/2,(this.getHeight() - editorPanel.height)/2));
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(editorPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
