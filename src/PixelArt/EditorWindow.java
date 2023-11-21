package PixelArt;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends JFrame {
    JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel;
    public EditorWindow(Editor editor){
        setSize(editor.width*2,editor.height*2);
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
        mainPanel.setPreferredSize(new Dimension(editor.width, editor.height));
        northPanel.setPreferredSize(new Dimension((this.getWidth() - editor.width)/2,(this.getHeight() - editor.height)/2));
        southPanel.setPreferredSize(new Dimension((this.getWidth() - editor.width)/2,(this.getHeight() - editor.height)/2));
        eastPanel.setPreferredSize(new Dimension((this.getWidth() - editor.width)/2,(this.getHeight() - editor.height)/2));
        westPanel.setPreferredSize(new Dimension((this.getWidth() - editor.width)/2,(this.getHeight() - editor.height)/2));
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(editor, BorderLayout.CENTER);
        setVisible(true);
    }
}
