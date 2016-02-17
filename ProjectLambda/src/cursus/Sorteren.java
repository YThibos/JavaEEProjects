/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class Sorteren {
    
    public static void main(String[] args) {

        Comparator<String> comparator = 
                (groente1, groente2) -> groente1.length() - groente2.length();
        
        comparator = comparator.thenComparing(
         (groente1, groente2) -> groente1.compareTo(groente2));
        
        Stream.of("sla", "wortel", "patatjes","kool", "bloemkool", "patatten", "ui")
                .sorted(comparator)
                .forEach(groente -> System.out.println(groente));
    }
    
}
