/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefeningen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author yannick.thibos
 */
public class Oef35 extends JFrame implements ActionListener {

    private JButton btnLinks, btnRechts, btnMidden;

    public Oef35() {
        setSize(400, 200);
        setTitle("Spelen met knopjes");
    }

    public static void main(String[] args) {

        Oef35 frame = new Oef35();
        frame.createGUI();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLinks) {
            btnRechts.setEnabled(true);
            btnLinks.setEnabled(false);
            btnMidden.setEnabled(false);
        } else if (e.getSource() == btnRechts) {
            btnLinks.setEnabled(true);
            btnRechts.setEnabled(false);
            btnMidden.setEnabled(true);
        } else if (e.getSource() == btnMidden) {
            JOptionPane.showMessageDialog(null, "Hello world.");
        }

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnLinks = new JButton("Disable -->");
        ImageIcon icon = new ImageIcon("C:/JPFProjecten/firefox.png");
        btnMidden = new JButton("Toon melding", icon);
        btnMidden.setSize(50, 10);
        btnRechts = new JButton("<-- Enable");
        
        btnRechts.setEnabled(false);

        btnLinks.addActionListener(this);
        btnMidden.addActionListener(this);
        btnRechts.addActionListener(this);

        add(btnLinks);
        add(btnMidden);
        add(btnRechts);
    }

}
