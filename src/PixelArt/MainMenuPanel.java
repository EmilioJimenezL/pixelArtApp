package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel implements ActionListener {
    JButton startBtn, exitBtn;
    JLabel titleLbl;
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    public MainMenuPanel(){
        setLayout(new GridBagLayout());

        gridBagConstraints.insets = new Insets(100,100,100,100);
        titleLbl = new JLabel("PixArt");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(titleLbl, gridBagConstraints);
        startBtn = new JButton("Iniciar");
        startBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(startBtn, gridBagConstraints);

        exitBtn = new JButton("Salir");
        exitBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(exitBtn, gridBagConstraints);



    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
        if (event.getSource().equals(exitBtn)) {
            System.out.println("Boton SALIR presionado");
            JOptionPane.showMessageDialog(null, "Gracias por usar PixArt.\n" +
                    "Saliendo...", "Exit", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("TERMINANDO PROGRAMA...");
            System.exit(0);
        } else if (event.getSource().equals(startBtn)) {
            Editor editor = new Editor(500,500, 10);
            EditorWindow editorWindow = new EditorWindow(editor);
        }
    }

}
