/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class LaatsteLand {
    
    public static void main(String[] args) {
        
        try (Stream<String> stream = Files.lines(Paths.get("/data/landcodes.txt"))) {
            
            stream.map(fullString -> fullString.substring(fullString.indexOf(" ")+1))
                    .max((s1, s2) -> s1.compareTo(s2))
                    .ifPresent(System.out::print);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
