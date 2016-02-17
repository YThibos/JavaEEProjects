/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class StringDemo {

    public static void main(String[] args) {
        
        int i = 0;
        System.out.println(Stream.of("aap", "beer", "koala", "panda", "komodo", "kaketoe")
                .collect(Collectors.joining(",\n")));
        
    }
    
}
