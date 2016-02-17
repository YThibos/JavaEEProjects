/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class ForEach {
    
    public static void main(String[] args) {
        
        String[] groenten = {"tomaat", "sla", "ui", "prei"};
        Stream<String> stream = Arrays.stream(groenten);
        
        stream.forEach(groente -> System.out.println(groente));
        
        Arrays.stream(groenten).forEach(groente -> System.out.println(groente));
        
        List<String> fruiten = Arrays.asList("peer", "appel", "banaan", "kiwi");
        fruiten.stream().forEach(fruit -> System.out.print(fruit.charAt(0)) );
        
        System.out.println("");
        
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("A", 1); 
        map.put("B", 2); 
        map.put("C", 3); 
        map.put("D", 4); 
        map.put("E", 5); 
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + entry.getValue()));
        
        "Lambdafunaaa".chars().forEach(ch -> System.out.print((char)(ch + 1)) ); 
        
    }
    
}
