package PixelArt;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EditorWindow extends JFrame implements ActionListener, ChangeListener {
    Color color;
    JPanel northPanel, southPanel, eastPanel, westPanel;
    EditorPanel mainPanel;
    int pixNumWidth, pixNumHeight, pixSize, canvasWidth, canvasHeight;
    BufferedImage image;
    JLabel redLabel, greenLabel, blueLabel, currentColorLabel, currentColorTextLabel;
    JButton saveImageButton, redBtn, greenBtn, blueBtn, yellowBtn, pinkBtn, orangeBtn, blackBtn, whiteBtn;
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
        northPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(10,10,10,10);
        northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        redBtn = new JButton();
        redBtn.setBackground(Color.red);
        redBtn.setOpaque(true);
        redBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        northPanel.add(redBtn, gbc);
        greenBtn = new JButton();
        greenBtn.setBackground(Color.green);
        greenBtn.setOpaque(true);
        greenBtn.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        northPanel.add(greenBtn, gbc);
        blueBtn = new JButton();
        blueBtn.setBackground(Color.blue);
        blueBtn.setOpaque(true);
        blueBtn.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 0;
        northPanel.add(blueBtn, gbc);
        yellowBtn = new JButton();
        yellowBtn.setBackground(Color.yellow);
        yellowBtn.setOpaque(true);
        yellowBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        northPanel.add(yellowBtn, gbc);
        orangeBtn = new JButton();
        orangeBtn.setBackground(Color.orange);
        orangeBtn.setOpaque(true);
        orangeBtn.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        northPanel.add(orangeBtn, gbc);
        pinkBtn = new JButton();
        pinkBtn.setBackground(Color.pink);
        pinkBtn.setOpaque(true);
        pinkBtn.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 1;
        northPanel.add(pinkBtn, gbc);
        blackBtn = new JButton();
        blackBtn.setBackground(Color.black);
        blackBtn.setOpaque(true);
        blackBtn.addActionListener(this);
        gbc.gridx = 3;
        gbc.gridy = 0;
        northPanel.add(blackBtn, gbc);
        whiteBtn = new JButton();
        whiteBtn.setBackground(Color.white);
        whiteBtn.setOpaque(true);
        whiteBtn.addActionListener(this);
        gbc.gridx = 3;
        gbc.gridy = 1;
        northPanel.add(whiteBtn, gbc);
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
        redSlider = new JSlider(0,255, 0);
        redSlider.addChangeListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        westPanel.add(redSlider, gbc);
        greenSlider = new JSlider(0,255, 0);
        greenSlider.addChangeListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        westPanel.add(greenSlider, gbc);
        blueSlider = new JSlider(0,255, 0);
        blueSlider.addChangeListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        westPanel.add(blueSlider, gbc);
        redLabel = new JLabel("R: " + redSlider.getValue());
        gbc.gridx = 1;
        gbc.gridy = 0;
        westPanel.add(redLabel, gbc);
        greenLabel = new JLabel("G: " + greenSlider.getValue());
        gbc.gridx = 1;
        gbc.gridy = 1;
        westPanel.add(greenLabel, gbc);
        blueLabel = new JLabel("B: " + blueSlider.getValue());
        gbc.gridx = 1;
        gbc.gridy = 2;
        westPanel.add(blueLabel, gbc);
        currentColorTextLabel = new JLabel("Color actual:");
        currentColorTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        westPanel.add(currentColorTextLabel, gbc);
        currentColorLabel = new JLabel("    ");
        currentColorLabel.setOpaque(true);
        currentColorLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        currentColorLabel.setBackground(Color.black);
        gbc.gridx = 1;
        gbc.gridy = 3;
        westPanel.add(currentColorLabel, gbc);
        return westPanel;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(saveImageButton)){
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showDialog(null, "Save");
            IOUtils.writeImage(image, fileChooser.getSelectedFile().getAbsolutePath());
        } else {
            if (actionEvent.getSource().equals(redBtn)) {
                color = Color.red;
            } else if (actionEvent.getSource().equals(greenBtn)) {
                color = Color.green;
            } else if (actionEvent.getSource().equals(blueBtn)) {
                color = Color.blue;
            } else if (actionEvent.getSource().equals(orangeBtn)) {
                color = Color.orange;
            } else if (actionEvent.getSource().equals(yellowBtn)) {
                color = Color.YELLOW;
            } else if (actionEvent.getSource().equals(pinkBtn)) {
                color = Color.pink;
            } else if (actionEvent.getSource().equals(blackBtn)) {
                color = Color.black;
            } else if (actionEvent.getSource().equals(whiteBtn)) {
                color = Color.white;
            }
            mainPanel.setColor(color);
            currentColorLabel.setBackground(color);
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        color = new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
        this.redLabel.setText("R: " + redSlider.getValue());
        this.greenLabel.setText("G: " + greenSlider.getValue());
        this.blueLabel.setText("B: " + blueSlider.getValue());
        this.currentColorLabel.setBackground(color);
        mainPanel.setColor(color);
    }
}
