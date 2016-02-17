/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Sterrenbeelden {

    private static final Path STERREN = Paths.get("/data/sterrenbeelden.txt");

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(STERREN)) {

            // stream.forEach(sterrenbeeld -> System.out.println(sterrenbeeld.toUpperCase()));

            String zoekString;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Geef een zoekterm in: ");
            zoekString = input.readLine();
            
            stream.filter( 
                    sterrenbeeld -> sterrenbeeld.contains(zoekString) )
                    .forEach( gevonden -> System.out.println(gevonden) );
            
        } catch (IOException ex) {
            Logger.getLogger(Sterrenbeelden.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
