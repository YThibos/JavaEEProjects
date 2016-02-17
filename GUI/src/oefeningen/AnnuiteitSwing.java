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
public class AnnuiteitSwing extends JFrame implements ActionListener {
    
    private JLabel lblRente, lblPerioden, lblKapitaal;
    private JTextField txtRente, txtPerioden, txtKapitaal;
    private JLabel lblResultaat;
    private JButton btnBereken;
    
    public AnnuiteitSwing()  {
        setSize(400,200);
    }

    public static void main(String[] args) {
        
        AnnuiteitSwing frame = new AnnuiteitSwing();
        frame.createGUI();
        frame.setVisible(true);
        
    }
    
    private void createGUI() {
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lblRente = new JLabel("Periodieke rentevoet: ");
        add(lblRente);
        
        txtRente = new JTextField();
        add(txtRente);
        
        lblPerioden = new JLabel("Aantal perioden: ");
        add(lblPerioden);
        
        txtPerioden = new JTextField();
        add(txtPerioden);
        
        lblKapitaal = new JLabel("Ontleend kapitaal: ");
        add(lblKapitaal);
        
        txtKapitaal = new JTextField();
        add(txtKapitaal);
        
        btnBereken = new JButton("Bereken afbetaling");
        btnBereken.addActionListener(this);
        add(btnBereken);
        
        lblResultaat = new JLabel("0.0");
        add(lblResultaat);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double i = Double.parseDouble(txtRente.getText());
        int n = Integer.parseInt(txtPerioden.getText()) / 12;
        int T = Integer.parseInt(txtKapitaal.getText());
        
        double resultaat = 0, temp;
        
        temp = Math.pow((1+i), n);
        temp = 1 - (1/temp);
        temp = T * (i / temp);
        resultaat = temp / 12;
        
        lblResultaat.setText(Double.toString(resultaat));
    }
    
}
