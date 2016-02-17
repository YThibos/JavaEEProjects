/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class LandnamenSorteren {

    private static final Path LANDEN = Paths.get("/data/landcodes.txt");
    
    public static void main(String[] args) {
        
        try {
            Stream<String> stream = Files.lines(LANDEN);
            
            stream.map(land -> land.substring(land.indexOf(' '), land.length()))
                    .sorted()
                    .forEach(land -> System.out.println(land));
                    
        } catch (IOException ex) {
            Logger.getLogger(LandnamenSorteren.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
