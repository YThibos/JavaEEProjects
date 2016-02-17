/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 *
 * @author yannick.thibos
 */
public class Landcode {
    
    private static final Path LAND_PATH = Paths.get("/data/landcodes.txt");
    
    private static Optional<String> zoek (String zoekString) {
        
        try (BufferedReader reader = Files.newBufferedReader(LAND_PATH)){
            for (String line; (line = reader.readLine()) != null;) {
                String code = line.substring(0, 2);
                if (code.equals(zoekString)) {
                    return Optional.of(line.substring(3));
                }
            }
        } catch (Exception e) {
            System.err.println("Exception caught. Returned Optional.empty()");
            return Optional.empty();
        }
        
        return Optional.empty();
    }
    
    public static void main(String[] args) {
        
        zoek("FI").ifPresent(land -> System.out.println("Gevonden: " + land));
        
    }
    
}
