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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class TekstEnDir {
    
    private static final Path LANGUAGES = Paths.get("/data/languages.txt");
    private static final Path DATA = Paths.get("C:/");
    
    public static void main(String[] args) {
        
//        try (Stream<String> stream = Files.lines(LANGUAGES)){
//            stream.forEach(line -> System.out.println(line) );
//        } catch (Exception e) {
//        }

        try (Stream<Path> stream = Files.list(DATA)) {
            stream.forEach(entry -> System.out.println(entry.getFileName()));
        } catch (IOException ex) {
            Logger.getLogger(TekstEnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
