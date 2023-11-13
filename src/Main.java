import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Ventana");
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel("Ejemplo");
        jPanel1.add(jLabel1);
        jFrame.add(jPanel1);
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
