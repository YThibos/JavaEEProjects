/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author yannick.thibos
 */
public class ActionListenerDemo extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    ActionListenerDemo () {
        super("Conversie");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField textField = new JTextField();
        JButton buttonHoofdletters = new JButton("hoofdletters");
        JButton buttonKleineletters =  new JButton("kleine letters");
        
        buttonHoofdletters.addActionListener(
            e -> {textField.setText(textField.getText().toUpperCase());
                System.out.println(e.getSource().toString());
                System.out.println("Upper");});
        buttonKleineletters.addActionListener(
            e -> textField.setText(textField.getText().toLowerCase()));
        
        add(textField, BorderLayout.NORTH);
        add(buttonHoofdletters, BorderLayout.WEST);
        add(buttonKleineletters, BorderLayout.EAST);
        pack();
    }
    
    public static void main(String[] args) {
        new ActionListenerDemo().setVisible(true);
    }
}
