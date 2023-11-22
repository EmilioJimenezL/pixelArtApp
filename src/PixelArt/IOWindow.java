package PixelArt;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class IOWindow extends JFrame implements ActionListener {
    JPanel ioPanel;
    JButton newFileBtn, searcFileBtn, returnMenuBtn;
    JLabel textLabel;
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    JFileChooser fileChooser = new JFileChooser();
    public IOWindow(){
        setName("PixArt: Archivos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setExtendedState(MAXIMIZED_BOTH);
        add(ioPanel = generateIOPanel());
        setVisible(true);
    }
    public JPanel generateIOPanel(){
        JPanel IOPanel = new JPanel();
        IOPanel.setLayout(new GridBagLayout());
        gridBagConstraints.insets = new Insets(50,100,50,100);
        textLabel = new JLabel("Desea abrir una imagen para editar o crear un nuevo archivo?");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        IOPanel.add(textLabel, gridBagConstraints);
        newFileBtn = new JButton("Nuevo Archivo");
        newFileBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        IOPanel.add(newFileBtn, gridBagConstraints);
        searcFileBtn = new JButton("Buscar Archivo");
        searcFileBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        IOPanel.add(searcFileBtn, gridBagConstraints);
        returnMenuBtn = new JButton("Regresar al Menú");
        returnMenuBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        IOPanel.add(returnMenuBtn, gridBagConstraints);
        return IOPanel;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(newFileBtn)) {
            //EditorPanel editorPanel = new EditorPanel(1080, 720, 10);
            EditorWindow editorWindow = new EditorWindow(1080,720,10);
            setVisible(false);
        } else if (event.getSource().equals(returnMenuBtn)) {
            MenuWindow menuWindow = new MenuWindow();
            this.setVisible(false);

        } else if (event.getSource().equals(searcFileBtn)) {
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
        }
    }
}
