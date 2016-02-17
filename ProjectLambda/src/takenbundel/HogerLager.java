/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author yannick.thibos
 */
public class HogerLager extends JFrame {

    private int number, guesses;
    private JTextField txtGuess;
    private JButton btnGuess;

    HogerLager() {
        super("Hoger - Lager");

        number = (int) (Math.random() * 10) + 1;
        guesses = 0;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField txtGuess = new JTextField();

        btnGuess = new JButton("Guess..");
        btnGuess.addActionListener(
                e -> compare());

        add(txtGuess, BorderLayout.NORTH);
        add(btnGuess, BorderLayout.SOUTH);

        pack();
    }

    private void compare() {
        guesses++;

        try {
            int x = Integer.parseInt(txtGuess.getText());
            if (x == number) {
                JOptionPane.showMessageDialog(this, "Found in " + guesses + " tries.");
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(this, 
                        (x < number) ? "Hoger" : "Lager" );
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Geef een geheel getal in.");
        }
    }

    public static void main(String[] args) {
        new HogerLager().setVisible(true);
    }
}
