/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.cursus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author yannick.thibos
 */
public class Begroeting extends JFrame implements ActionListener {

    private JTextField textfield;
    private JLabel text, response;
    private JButton button;
    
    private JPanel draw;
    private Graphics g;

    public Begroeting() {
        setTitle("Welkom");
    }

    public static void main(String[] args) {

        Begroeting frame = new Begroeting();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);

    }

    private void createGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        text = new JLabel("Geef uw naam: ");
        textfield = new JTextField(20);
        button = new JButton("Klik mij");
        response = new JLabel();

        JPanel panel = new JPanel();
        panel.add(text);
        panel.add(textfield);
        add(panel);

        add(button);
        add(response);
        
        draw = new JPanel();
        draw.setPreferredSize(new Dimension(350, 50));
        add(draw);
        
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String t = "\tWelkom, " + textfield.getText() + ".";
        response.setText(t);
        g = draw.getGraphics();
        g.drawString("Er is op de knop geklikt", 30, 10);
    }

}
