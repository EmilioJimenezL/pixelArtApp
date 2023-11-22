package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EditorWindow extends JFrame implements MouseListener, MouseMotionListener, ActionListener {
    JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel;
    int pixNumWidth, pixNumHeight, pixSize, canvasWidth, canvasHeight;
    Graphics graphics;
    BufferedImage image;
    JLabel label;
    JButton saveImageButton;
    public EditorWindow(){
        setSize(1920, 1080);
        setName("PixArt: Editor");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel = generateEditorPanel(1080, 720, 10);
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLUE);
        eastPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.MAGENTA);
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        northPanel.setPreferredSize(new Dimension(((this.getWidth() - mainPanel.getWidth())/2), ((this.getHeight() - mainPanel.getHeight())/2)));
        southPanel.setPreferredSize(new Dimension(((this.getWidth() - mainPanel.getWidth())/2), ((this.getHeight() - mainPanel.getHeight())/2)));
        eastPanel.setPreferredSize(new Dimension(((this.getWidth() - mainPanel.getWidth())/2), ((this.getHeight() - mainPanel.getHeight())/2)));
        westPanel.setPreferredSize(new Dimension(((this.getWidth() - mainPanel.getWidth())/2), ((this.getHeight() - mainPanel.getHeight())/2)));
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        saveImageButton = new JButton("Guardar Imagen");
        saveImageButton.addActionListener(this);
        southPanel.add(saveImageButton);

        setVisible(true);
    }
    public JPanel generateEditorPanel(int width, int height, int pixSize){
        JPanel editorPanel = new JPanel();
        editorPanel.setDoubleBuffered(true);
        editorPanel.setLayout(new FlowLayout());
        this.canvasHeight = height;
        this.canvasWidth = width;
        this.pixSize = pixSize;
        this.pixNumWidth = width/pixSize;
        this.pixNumHeight = height/pixSize;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        //addMouseListener(this);
        addMouseMotionListener(this);
        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, width, height);
        drawGrid();
        graphics.setColor(new Color(0, 255, 0));
        return editorPanel;
    }
    public void drawGrid() {
        // sets color to black
        graphics.setColor(new Color(0, 0, 0));
        // height and width are the same
        for (int i = 0; i < this.canvasWidth; i++) {
            for (int j = 0; j < this.canvasHeight; j++) {
                //graphics.setColor(Color.black);
                graphics.drawRect(i * this.pixSize, j * this.pixSize, this.pixSize, this.pixSize);
            }
        }
    }
    public void paintAndDraw(MouseEvent mouseEvent) {
        int x = mouseEvent.getX() / this.pixSize;
        int y = mouseEvent.getY() / this.pixSize;
        System.out.printf("@ %d, %d\n", x, y);
        //    graphics.setColor(new Color(0, 0, 255));
        graphics.fillRect(x * this.pixSize, y * this.pixSize, this.pixSize, this.pixSize);
        System.out.printf("@ RECT from %d, %d to %d, %d\n", x * this.pixSize, y * this.pixSize, x * this.pixSize + this.pixSize, y * this.pixSize + this.pixSize);
        repaint();
        //paint(this.getGraphics());


    }

//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//        g.drawImage(image, 0, 0, this);
//    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        paintAndDraw(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        paintAndDraw(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
