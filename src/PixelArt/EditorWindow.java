package PixelArt;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditorWindow extends JFrame implements ActionListener, ChangeListener {
    Color color;
    JPanel northPanel, southPanel, eastPanel, westPanel;
    EditorPanel mainPanel;
    int pixSize, canvasWidth, canvasHeight;
    int screenWidth = getToolkit().getScreenSize().width;
    int screenHeight = getToolkit().getScreenSize().height;
    BufferedImage image;
    JLabel menuLabel, colorLable, toolsLabel;
    JButton saveImgBtn, openImgBtn, newImgBtn, mainMenuBtn;
    JColorChooser colorChooser;
    JFileChooser fileChooser = new JFileChooser();
    GridBagConstraints gbc = new GridBagConstraints();
    public EditorWindow(int editorWidth, int editorHeight, int pixSize){
        this.canvasWidth = editorWidth;
        this.canvasHeight = editorHeight;
        this.pixSize = pixSize;
        setSize(screenWidth, screenHeight);
        setName("PixArt: Editor");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = new EditorPanel(canvasWidth, canvasHeight, pixSize);
        int freeWidth = screenWidth - canvasWidth;
        int freeHeight = screenHeight - canvasHeight;
        northPanel = generateNorthPanel();
        southPanel = generateSouthPanel();
        eastPanel = generateEastPanel();
        westPanel = generateWestPanel();
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(canvasWidth, freeHeight/2));
        southPanel.setPreferredSize(new Dimension(canvasWidth,freeHeight/2));
        eastPanel.setPreferredSize(new Dimension(freeWidth/4,screenHeight));
        westPanel.setPreferredSize(new Dimension(3*(freeWidth/4),screenHeight));
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
        setSize(screenWidth, screenHeight);
        setName("PixArt: Editor");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = new EditorPanel(canvasWidth, canvasHeight, pixSize, backgroundImg);
        int freeWidth = screenWidth - canvasWidth;
        int freeHeight = screenHeight - canvasHeight;
        northPanel = generateNorthPanel();
        southPanel = generateSouthPanel();
        eastPanel = generateEastPanel();
        westPanel = generateWestPanel();
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(canvasWidth, freeHeight/2));
        southPanel.setPreferredSize(new Dimension(canvasWidth,freeHeight/2));
        eastPanel.setPreferredSize(new Dimension(freeWidth/4,screenHeight));
        westPanel.setPreferredSize(new Dimension(3*(freeWidth/4),screenHeight));
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
        return northPanel;
    }
    public JPanel generateSouthPanel(){
        this.southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        return southPanel;
    }
    public JPanel generateEastPanel(){
        this.eastPanel = new JPanel();
        eastPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(20,20,20,20);
        eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        saveImgBtn = new JButton("Guardar Imagen");
        saveImgBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        eastPanel.add(saveImgBtn, gbc);
        newImgBtn = new JButton("Nueva Imagen");
        newImgBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        eastPanel.add(newImgBtn, gbc);
        openImgBtn = new JButton("Abrir Imagen");
        openImgBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        eastPanel.add(openImgBtn, gbc);
        mainMenuBtn =  new JButton("Ir al menu principal");
        mainMenuBtn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        eastPanel.add(mainMenuBtn, gbc);
        return eastPanel;
    }
    public JPanel generateWestPanel(){
        this.westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        gbc.insets =  new Insets(40, 0, 40, 0);
        westPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        colorChooser =  new JColorChooser(Color.black);
        colorChooser.getSelectionModel().addChangeListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        westPanel.add(colorChooser, gbc);
        return westPanel;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(saveImgBtn)){
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showDialog(null, "Save");
            IOUtils.writeImage(image, fileChooser.getSelectedFile().getAbsolutePath());
        } else if (actionEvent.getSource().equals(mainMenuBtn)) {
            MenuWindow menuWindow =  new MenuWindow();
            this.setVisible(false);
        } else if (actionEvent.getSource().equals(openImgBtn)) {
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    } else {
                        String filename = f.getName().toLowerCase();
                        return filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png");
                    }
                }

                @Override
                public String getDescription() {
                    return "Static Images (*.jpg, *.png)";
                }
            });
            fileChooser.showDialog(null, "Load");
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                BufferedImage bkgImg = ImageIO.read(file);
                bkgImg = ImgUtils.resize(bkgImg, 1080, 720);
                EditorWindow editorWindow = new EditorWindow(1080, 720, 10, bkgImg);
            }catch (IOException e){
                e.printStackTrace();
            }
            setVisible(false);
        } else if (actionEvent.getSource().equals(newImgBtn)) {
            EditorWindow editorWindow = new EditorWindow(1080, 720, 10);
            this.setVisible(false);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(colorChooser.getSelectionModel())) {
            color = colorChooser.getColor();
            mainPanel.setColor(color);
        }
    }
}
