package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Editor extends JPanel implements MouseListener, MouseMotionListener {

    int width, height;
    Graphics graphics;
    BufferedImage image;
    Canvas canvas;
    JLabel label;


    public Editor(int width, int height){
       super();
       this.width = width;
       this.height = height;
       image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
       graphics = image.createGraphics();

       canvas = new Canvas();
       canvas.setBounds(0,0,500,500);

       //canvas.addMouseListener(this);
       //add(canvas);
      // label = new JLabel();
      // label.setBounds(0, 0, 500, 500);
       addMouseListener(this);
       addMouseMotionListener(this);

       //setBackground(new Color(255, 255, 255));

       graphics.setColor(new Color(255, 255, 255));
       graphics.fillRect(0,0,500,500);
       graphics.setColor(new Color(0, 255, 0));

       //graphics.drawLine(50, 0, 50, 400);
       //canvas.paint(graphics);
       //graphics.drawImage(image, 0, 0, canvas);
       drawGrid();
       //graphics.drawImage(image, 0, 0, canvas);

        graphics.setColor( new Color(0, 0, 255) );
        //graphics.fillRect(0*10, 0*10, 0*10 + 10, 0*10 + 10);

    }

    // draws a 50x50 grid
    public void drawGrid(){
        // sets color to black
        graphics.setColor(new Color(0,0,0));
        // height and width are the same

        for(int i = 0; i < height; i = i + height/50){
           graphics.drawLine(i, 0, i, 500);
           graphics.drawLine(0, i, 500, i);
       }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX() / 10;
        int y = mouseEvent.getY() / 10;
        System.out.printf("@ %d, %d\n", x, y);
        graphics.setColor( new Color(0, 0, 255) );
        graphics.fillRect(x*10, y*10, 10, 10);
        System.out.printf("@ RECT from %d, %d to %d, %d\n", x*10, y*10, x*10+10, y*10+10);
        repaint();

    }



    @Override
    public void mousePressed(MouseEvent mouseEvent) {


    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.printf("aaaa");

    }


    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int x = mouseEvent.getX() / 10;
        int y = mouseEvent.getY() / 10;
        System.out.printf("@ %d, %d\n", x, y);
        graphics.setColor( new Color(0, 0, 255) );
        graphics.fillRect(x*10, y*10, 10, 10);
        System.out.printf("@ RECT from %d, %d to %d, %d\n", x*10, y*10, x*10+10, y*10+10);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
