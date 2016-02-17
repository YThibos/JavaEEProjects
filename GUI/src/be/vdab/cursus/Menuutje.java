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
public class Menuutje extends JFrame implements ActionListener {

    private JMenuBar menuBalk;
    private JMenu bestandMenu, wijzigMenu;
    private JMenuItem openItem, saveItem, copyItem, pasteItem, closeItem;
    private JTextField keuze;

    public static void main(String[] args) {

        Menuutje frame = new Menuutje();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        menuBalk = new JMenuBar();
        setJMenuBar(menuBalk);

        // "Bestand" menu opbouwen
        bestandMenu = new JMenu("Bestand");

        openItem = new JMenuItem("Openen");
        bestandMenu.add(openItem);
        openItem.addActionListener(this);

        saveItem = new JMenuItem("Opslaan..");
        bestandMenu.add(saveItem);
        saveItem.addActionListener(this);

        bestandMenu.addSeparator();

        closeItem = new JMenuItem("Sluiten");
        bestandMenu.add(closeItem);
        closeItem.addActionListener(this);

        menuBalk.add(bestandMenu);
        // EINDE BESTANDMENU

        // "Bewerken" menu opbouwen
        wijzigMenu = new JMenu("Bewerken");

        copyItem = new JMenuItem("Kopieren");
        wijzigMenu.add(copyItem);
        copyItem.addActionListener(this);

        pasteItem = new JMenuItem("Plakken");
        wijzigMenu.add(pasteItem);
        pasteItem.addActionListener(this);

        menuBalk.add(wijzigMenu);
        // EINDE KEUZEMENU

        keuze = new JTextField(10);
        add(keuze);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            keuze.setText("U koos : Openen ");
        }
        if (e.getSource() == saveItem) {
            keuze.setText("U koos: Bewaren");
        }
        if (e.getSource() == closeItem) {
            System.exit(0);
        }
        if (e.getSource() == copyItem) {
            keuze.setText("U koos: Kopieren");
        }
        if (e.getSource() == pasteItem) {
            keuze.setText("U koos: Plakken");
        }
    }

}
