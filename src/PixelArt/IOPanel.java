package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class IOPanel extends JPanel implements ActionListener {
    JButton newFileBtn, searcFileBtn;
    JLabel textLabel;
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    public IOPanel(){
        setLayout(new GridBagLayout());
        gridBagConstraints.insets = new Insets(100,100,100,100);
        textLabel = new JLabel("Desea abrir una imagen para editar o crear un nuevo archivo?");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(textLabel, gridBagConstraints);
        newFileBtn = new JButton("Buscar Archivo");
        newFileBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(newFileBtn, gridBagConstraints);
        searcFileBtn = new JButton("Buscar Archivo");
        searcFileBtn.addActionListener(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(searcFileBtn, gridBagConstraints);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
