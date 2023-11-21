package PixelArt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IOWindow extends JFrame implements ActionListener {
    JPanel ioPanel;
    JButton newFileBtn, searcFileBtn;
    JLabel textLabel;
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
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
        gridBagConstraints.insets = new Insets(100,100,100,100);
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
        return IOPanel;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(newFileBtn)) {
            EditorPanel editorPanel = new EditorPanel(1080, 720, 10);
            EditorWindow editorWindow = new EditorWindow(editorPanel);
            setVisible(false);
        }
    }
}
