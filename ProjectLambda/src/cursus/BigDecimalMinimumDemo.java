/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class BigDecimalMinimumDemo {
    
    public static void main(String[] args) {
        
        Stream.of(
                BigDecimal.valueOf(1.1), BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.5))
                .min((get1, get2) -> get1.compareTo(get2))
                .ifPresent(System.out::println);
        
    }
    
}
