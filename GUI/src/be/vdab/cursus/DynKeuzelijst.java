/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.cursus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public class DynKeuzelijst extends JFrame {
    private JList lstKies;
    private DefaultListModel mijnLijst;
    
    public DynKeuzelijst() {
        setSize(400,200);
        setTitle("Keuzelijst");
    }
    
    public static void main(String[] args) {
        DynKeuzelijst frame = new DynKeuzelijst();
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        mijnLijst = new DefaultListModel();
        mijnLijst.addElement("water");
        mijnLijst.addElement("bier");
        mijnLijst.addElement("wijn");
        lstKies = new JList(mijnLijst);
        
        add(lstKies);
        lstKies.addMouseListener(new MijnMuisListerer());
        
    }

    class MijnMuisListerer extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            List uwKeuze = lstKies.getSelectedValuesList();
            for (Object uwKeuze1 : uwKeuze) {
                System.out.println(uwKeuze1.toString());
            }
        }
        
    }
}
