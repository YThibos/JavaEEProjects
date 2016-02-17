/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class FlatMapDemo {
    
    public static void main(String[] args) {
        
        Stream.of("The lord of the rings", "The Hobbit")
                .map(titel -> titel.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .map(woord -> woord.toUpperCase())
                .distinct()
                .sorted((s1, s2) -> -(s1.compareTo(s2)))
                .forEach(System.out::println);
        
    }
    
}
