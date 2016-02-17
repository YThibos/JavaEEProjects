/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class Sterrenbeelden2 {
    
    public static void main(String[] args) {
        
        try {
            Stream<String> stream = Files.lines(Paths.get("/data/sterrenbeelden.txt"));
            
            stream.map(String::toUpperCase)
                    .forEach(System.out::println);
            
        } catch (IOException ex) {
            Logger.getLogger(Sterrenbeelden2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
