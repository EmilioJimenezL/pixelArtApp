package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class EditorPanel extends JPanel implements MouseListener, MouseMotionListener {

    int width, height, pixSize, pixNumWidth, pixNumHeight;
    Graphics graphics;
    BufferedImage image;
    JLabel label;


    public EditorPanel(int width, int height, int pixSize) {
        super();
        this.width = width;
        this.height = height;
        this.pixSize = pixSize;
        pixNumWidth = this.width/pixSize;
        pixNumHeight = this.height/pixSize;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();

        //canvas.addMouseListener(this);
        //add(canvas);
        // label = new JLabel();
        // label.setBounds(0, 0, 500, 500);
        addMouseListener(this);
        addMouseMotionListener(this);

        //setBackground(new Color(255, 255, 255));

        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(new Color(0, 255, 0));

        //graphics.drawLine(50, 0, 50, 400);
        //canvas.paint(graphics);
        //graphics.drawImage(image, 0, 0, canvas);
        drawGrid();
        //graphics.drawImage(image, 0, 0, canvas);

        graphics.setColor(new Color(0, 0, 255));
        //graphics.fillRect(0*10, 0*10, 0*10 + 10, 0*10 + 10);
    }

    // draws a 50x50 grid
    public void drawGrid() {
        // sets color to black
        graphics.setColor(new Color(0, 0, 0));
        // height and width are the same
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                graphics.setColor(Color.black);
                graphics.drawRect(i * this.pixSize, j * this.pixSize, pixSize, pixSize);
            }
        }
    }
    public void setColor(Color color){
        graphics.setColor(color);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        paintAndDraw(mouseEvent);
    }


    @Override
    public void mousePressed(MouseEvent mouseEvent) {


    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }


    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        paintAndDraw(mouseEvent);
    }

    void paintAndDraw(MouseEvent mouseEvent) {
        int x = mouseEvent.getX() / this.pixSize;
        int y = mouseEvent.getY() / this.pixSize;
        System.out.printf("@ %d, %d\n", x, y);
        //    graphics.setColor(new Color(0, 0, 255));
        graphics.fillRect(x * this.pixSize, y * this.pixSize, this.pixSize, this.pixSize);
        System.out.printf("@ RECT from %d, %d to %d, %d\n", x * this.pixSize, y * this.pixSize, x * this.pixSize + this.pixSize, y * this.pixSize + this.pixSize);
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
