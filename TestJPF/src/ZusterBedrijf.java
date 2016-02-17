
import be.vdab.Bedrijf;
import be.vdab.personeel.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Klasse die de implementatie van werknemers test.
 * Leest de weggeschreven werknemers door de klasse Bedrijf en drukt deze af
 * (in oplopende volgorde van naam)
 * 
 * @author yannick.thibos
 */
public class ZusterBedrijf {
    
    public static void main(String[] args) {
        
        Set<Werknemer> werknemers;
        
        // Maak de inputstreams aan in try-with-resources
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(Bedrijf.WERKNEMERSFILE))) {
            werknemers = (Set<Werknemer>) objIn.readObject();
        } catch (Exception e) {
            System.out.println(e);
            werknemers = null;
        }
        
        // Bij succesvol lezen, print de gelezen HashSet af
        if (werknemers != null) {
            werknemers
                    .stream()
                    .sorted((werknemer1, werknemer2)  -> werknemer1.getNaam().compareTo(werknemer2.getNaam()))
                    .forEach(System.out::println);
        }
        
    }
    
}
