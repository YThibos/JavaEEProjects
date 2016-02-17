/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author yannick.thibos
 */
public class ArrayDemo extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private static final Path STERRENBEELDEN = Paths.get("/data/sterrenbeelden.txt");
    
    public ArrayDemo() {
        
        super("Sterrenbeelden");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JList<String> listSterrenbeelden;
        
        try (Stream<String> stream = Files.lines(STERRENBEELDEN)) {
            listSterrenbeelden = new JList<>(
            stream.sorted()
            //.toArray(size -> new String[size]));
                    .toArray(String[]::new));
        } catch (Exception e) {
            System.err.println("Exception");
            listSterrenbeelden = new JList<>();
        }
        add(new JScrollPane(listSterrenbeelden));
        pack();
        setExtendedState(JFrame.MAXIMIZED_VERT);
    }
    
    public static void main(String[] args) {
        new ArrayDemo().setVisible(true);
    }
}
