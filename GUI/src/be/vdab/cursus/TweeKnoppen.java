/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.cursus;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author yannick.thibos
 */
public class TweeKnoppen extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button1;
    private JButton button2;

    public TweeKnoppen() {
        setTitle("Test met twee knoppen");
    }

    public static void main(String[] args) {

        TweeKnoppen frame = new TweeKnoppen();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);
    }

    private void createGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        label = new JLabel("Druk op een kop");
        button1 = new JButton("Knop 1");
        button2 = new JButton("Knop 2");
        
        add(button1);
        add(button2);
        add(label);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            label.setText("Er is op " + e.getActionCommand() + " gedrukt.");
        }
        else {
            label.setText("Er is op " + e.getActionCommand() + " gedrukt.");
        }
        pack();
        
    }

}
