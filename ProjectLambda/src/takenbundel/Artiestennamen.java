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
public class Artiestennamen {
    
    private static final Path ARTISTS = Paths.get("/data/albumsartists.txt");
    
    public static void main(String[] args) {
        
        try {
            Stream<String> stream = Files.lines(ARTISTS);
            
            stream.map(line -> line.substring(line.indexOf(',') + 1, line.length()))
                    .distinct()
                    .sorted()
                    .forEach( artist -> System.out.println(artist));
            
        } catch (IOException ex) {
            Logger.getLogger(Artiestennamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
