/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class MapDemo {
    
    public static void main(String[] args) {
        
        Map<Integer, List<String>> groentenPerLengte =
                Stream.of("sla", "kool", "wortel", "biet", "prei", "ui")
                .collect(Collectors.groupingBy(
                groente -> groente.length()));
        groentenPerLengte.entrySet().stream()
                .forEach(entry -> {
                System.out.println(entry.getKey());
                entry.getValue().stream()
                        .forEach(System.out::println);
                });
    }
    
}
