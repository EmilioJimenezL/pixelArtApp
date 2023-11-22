package PixelArt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class IOUtils {
    public static BufferedImage readImage(String filePath, String fileName){
        File imgFile = new File(filePath + fileName);
        BufferedImage img = null;
        if (imgFile.exists()) {
            System.out.println("Archivo encontrado, cargando...");
            try {
                img = ImageIO.read(imgFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("No se encontro el archivo, creando nuevo archivo...");
            img = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = img.createGraphics();
            graphics2D.fillRect(0,0,img.getWidth(), img.getHeight());
            try {
                imgFile.createNewFile();
                ImageIO.write(img, "PNG", imgFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
    public static void writeImage(BufferedImage img, String absoluteFilePath){
        File imgFile = new File(absoluteFilePath);
        if (imgFile.exists()) {
            System.out.println("El archivo ya existe, sobreescribiendo...");
            JOptionPane.showMessageDialog(null, "El archivo ya existe, sobreescribiendo.", "Guardar Imagen", JOptionPane.WARNING_MESSAGE);
            try {
                ImageIO.write(img, "PNG", imgFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Guardando dibujo...");
            try {
                imgFile.createNewFile();
                ImageIO.write(img, "PNG", imgFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
