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
public class Oef34 extends JFrame implements ActionListener {
    
    private JTextField txfTemp;
    private JLabel lblCelcius, lblFarenheit;
    private JButton btnConvert;
    
    public static void main(String[] args) {
        
        Oef34 frame = new Oef34();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);
        
    }

    private void createGUI() {
        
        JPanel pnlCelc = new JPanel();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        txfTemp = new JTextField(20);
        pnlCelc.add(txfTemp);
        
        lblCelcius = new JLabel("Celcius");
        pnlCelc.add(lblCelcius);
        
        add(pnlCelc);
        
        JPanel pnlFahr = new JPanel();
        
        btnConvert = new JButton("Converteer");
        pnlFahr.add(btnConvert);
        btnConvert.addActionListener(this);
        
        lblFarenheit = new JLabel("Fahrenheit");
        pnlFahr.add(lblFarenheit);
        
        add(pnlFahr);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double c, f;
        try {
            c = Double.parseDouble(txfTemp.getText());
        } catch (Exception exc) {
            System.err.println("EXCEPTION :: Kon niet converteren, ongeldige waarde ingegeven");
            c = 0;
        }
        f = c * 9/5 + 32;
        lblFarenheit.setText(f + " Fahrenheit");
    }
    
}
