/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.cursus;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author yannick.thibos
 */
public class HelloWorldDemo extends JFrame {

    private JLabel label;

    public static void main(String[] args) {
        HelloWorldDemo frame = new HelloWorldDemo();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label = new JLabel("Hello world!");
        add(label);
    }
}
