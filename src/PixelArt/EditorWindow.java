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
    JLabel redLabel, greenLabel, blueLabel;
    JButton saveImageButton, applyColorBtn;
    JSlider redSlider, greenSlider, blueSlider;
    GridBagConstraints gbc = new GridBagConstraints();
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
        northPanel = generateNorthPanel();
        southPanel = generateSouthPanel();
        eastPanel = generateEastPanel();
        westPanel = generateWestPanel();
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(1920, freeHeight/2));
        southPanel.setPreferredSize(new Dimension(1920,freeHeight/2));
        eastPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        westPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        add(northPanel, BorderLayout.PAGE_START);
        add(southPanel, BorderLayout.PAGE_END);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
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
        northPanel = generateNorthPanel();
        southPanel = generateSouthPanel();
        eastPanel = generateEastPanel();
        westPanel = generateWestPanel();
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(1920, freeHeight/2));
        southPanel.setPreferredSize(new Dimension(1920,freeHeight/2));
        eastPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        westPanel.setPreferredSize(new Dimension(freeWidth/2,1080));
        add(northPanel, BorderLayout.PAGE_START);
        add(southPanel, BorderLayout.PAGE_END);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public JPanel generateNorthPanel(){
        this.northPanel = new JPanel();
        northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        northPanel.add(new Label("PIXART"));
        return northPanel;
    }
    public JPanel generateSouthPanel(){
        this.southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        return southPanel;
    }
    public JPanel generateEastPanel(){
        this.eastPanel = new JPanel();
        eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        saveImageButton = new JButton("Guardar Imagen");
        saveImageButton.addActionListener(this);
        eastPanel.add(saveImageButton);
        return eastPanel;
    }
    public JPanel generateWestPanel(){
        this.westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        gbc.insets =  new Insets(40, 10, 40, 10);
        westPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        redSlider = new JSlider();
        gbc.gridx = 0;
        gbc.gridy = 0;
        westPanel.add(redSlider, gbc);
        greenSlider = new JSlider();
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(greenSlider, gbc);
        blueSlider = new JSlider();
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(blueSlider, gbc);
        redLabel = new JLabel("R");
        gbc.gridx = 1;
        gbc.gridy = 0;
        westPanel.add(redLabel, gbc);
        greenLabel = new JLabel("G");
        gbc.gridx = 1;
        gbc.gridy = 1;
        westPanel.add(greenLabel, gbc);
        blueLabel = new JLabel("B");
        gbc.gridx = 1;
        gbc.gridy = 2;
        westPanel.add(blueLabel, gbc);
        applyColorBtn = new JButton("Aplicar");
        applyColorBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        westPanel.add(applyColorBtn, gbc);
        return westPanel;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(saveImageButton)){
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setCurrentDirectory(new File("C:\\Users\\emiiv\\Pictures"));
            fileChooser.showDialog(null, "Save");
            IOUtils.writeImage(image, fileChooser.getSelectedFile().getAbsolutePath());
        } else if (actionEvent.getSource().equals(applyColorBtn)) {
            Color color = new Color((100/255)*redSlider.getValue(), (100/255)*greenSlider.getValue(), (100/255)*blueSlider.getValue());
            mainPanel.getGraphics().setColor(color);
        }

    }
}
