package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EditorWindow extends JFrame implements ActionListener {
    JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel;
    int pixNumWidth, pixNumHeight, pixSize, canvasWidth, canvasHeight;
    Graphics graphics;
    BufferedImage image;
    JLabel label;
    JButton saveImageButton;
    public EditorWindow(int editorWidth, int editorHeight, int pixSize){
        this.canvasWidth = editorWidth;
        this.canvasHeight = editorHeight;
        this.pixSize = pixSize;
        setSize(1920, 1080);
        setName("PixArt: Editor");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = new EditorPanel(canvasWidth, canvasHeight, pixSize);
        int freeWidth = 1920 - canvasWidth;
        int freeHeight = 1080 - canvasHeight;
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLUE);
        eastPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.MAGENTA);
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(1920, freeHeight/2));
        southPanel.setPreferredSize(new Dimension(1920,freeHeight/2));
        eastPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        westPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        add(northPanel, BorderLayout.PAGE_START);
        add(southPanel, BorderLayout.PAGE_END);
        add(eastPanel, BorderLayout.LINE_START);
        add(westPanel, BorderLayout.LINE_END);
        add(mainPanel, BorderLayout.CENTER);
        saveImageButton = new JButton("Guardar Imagen");
        saveImageButton.addActionListener(this);
        southPanel.add(saveImageButton);

        setVisible(true);
    }
    public EditorWindow(int editorWidth, int editorHeight, int pixSize, BufferedImage backgroundImg){
        this.canvasWidth = editorWidth;
        this.canvasHeight = editorHeight;
        this.pixSize = pixSize;
        setSize(1920, 1080);
        setName("PixArt: Editor");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = new EditorPanel(canvasWidth, canvasHeight, pixSize, backgroundImg);
        int freeWidth = 1920 - canvasWidth;
        int freeHeight = 1080 - canvasHeight;
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLUE);
        eastPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.MAGENTA);
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(1920, freeHeight/2));
        southPanel.setPreferredSize(new Dimension(1920,freeHeight/2));
        eastPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        westPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        add(northPanel, BorderLayout.PAGE_START);
        add(southPanel, BorderLayout.PAGE_END);
        add(eastPanel, BorderLayout.LINE_START);
        add(westPanel, BorderLayout.LINE_END);
        add(mainPanel, BorderLayout.CENTER);
        saveImageButton = new JButton("Guardar Imagen");
        saveImageButton.addActionListener(this);
        southPanel.add(saveImageButton);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(saveImageButton)){
            //System.out.printf("save image button\n");
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showDialog(null, "Save");
            IOUtils.writeImage(image, fileChooser.getSelectedFile().getAbsolutePath());
            //File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

            //System.out.println(file.getAbsolutePath());
        }

    }
}
