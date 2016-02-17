/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.cursus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keuzevakjes extends JFrame implements ItemListener {

    private JCheckBox drinken;
    private JTextField resultaat;
    private JRadioButton bier, water, wijn;
    private ButtonGroup drankenGroep;

    public Keuzevakjes() {
        setTitle("Test met keuzevakjes en radiobuttons");
    }

    public static void main(String[] args) {
        Keuzevakjes frame = new Keuzevakjes();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        drinken = new JCheckBox("Wenst u iets te drinken?", false);
        resultaat = new JTextField(20);
        add(drinken);
        add(resultaat);

        bier = new JRadioButton("bier", false);
        water = new JRadioButton("water", false);
        wijn = new JRadioButton("wijn", false);

        drankenGroep = new ButtonGroup();
        drankenGroep.add(water);
        drankenGroep.add(bier);
        drankenGroep.add(wijn);
        add(water);
        add(bier);
        add(wijn);
        
        water.setVisible(false);
        bier.setVisible(false);
        wijn.setVisible(false);

        drinken.addItemListener(this);
        water.addItemListener(this);
        bier.addItemListener(this);
        wijn.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (drinken.isSelected()) {
            resultaat.setText("U wenst iets te drinken.");
            water.setVisible(true);
            bier.setVisible(true);
            wijn.setVisible(true);
            if (e.getSource() == water) {
                resultaat.setText(resultaat.getText() + " U koos water.");
            };
            if (e.getSource() == bier) {
                resultaat.setText(resultaat.getText() + " U koos bier.");
            };
            if (e.getSource() == wijn) {
                resultaat.setText(resultaat.getText() + " U koos wijn.");
            };
        } else {
            resultaat.setText("U hebt dus geen dorst.");
            water.setVisible(false);
            bier.setVisible(false);
            wijn.setVisible(false);
        }
        pack();
    }
}
