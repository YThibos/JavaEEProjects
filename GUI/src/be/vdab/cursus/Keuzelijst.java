/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.cursus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

public class Keuzelijst extends JFrame implements ListSelectionListener, ActionListener {

    private JList lstKies;
    private JComboBox comboKies;

    public Keuzelijst() {
        setTitle("Test met een Lijst");
    }

    public static void main(String[] args) {
        Keuzelijst frame = new Keuzelijst();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        String[] dranken = {"Bier", "Cola", "Koffie", "Thee", "Water", "Wijn"};
        lstKies = new JList(dranken);
        comboKies = new JComboBox(dranken);
        lstKies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        comboKies.setEditable(true);
        add(comboKies);
        add(lstKies);
        lstKies.addListSelectionListener(this);
        comboKies.addActionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Uw keuze: " + lstKies.getSelectedValue()); 
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("In de combo koos u: " + comboKies.getSelectedItem());
        pack();
    }
}
