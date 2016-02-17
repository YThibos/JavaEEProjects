/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class ListDemo {
    
    public static List<String> gesorteerdeGroenten() {
        return Stream.of("sla", "wortel", "kool", "biet")
                .sorted()
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        gesorteerdeGroenten().forEach(System.out::println);//item -> System.out.println(item)
        gesorteerdeGroenten().stream().forEach(System.out::println);
//        System.out.println(gesorteerdeGroenten());
        for (String arg : gesorteerdeGroenten()) {
            System.out.println(arg);
        }
    }
    
}
