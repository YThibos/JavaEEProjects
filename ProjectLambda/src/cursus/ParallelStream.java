/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class ParallelStream {
    
    private static void zonderParallel(long aantalWaarden) {
        
        Random random = new Random();
        long voor = System.nanoTime();
        
        Stream.generate(() -> BigDecimal.valueOf(random.nextDouble()))
                .limit(aantalWaarden)
                .filter(getal -> getal.remainder(BigDecimal.valueOf(2))
                .compareTo(BigDecimal.ZERO) == 0)
                .max((vorig, getal) -> vorig.compareTo(getal));
        
        System.out.println(
                String.format("%,16d:%,16d zonder parallel", aantalWaarden, System.nanoTime() - voor));
    }
    
    private static void metParallel(long aantalWaarden) {
        
        Random random = new Random();
        long voor = System.nanoTime();
        
        Stream.generate(() -> BigDecimal.valueOf(random.nextDouble()))
                .parallel()
                .limit(aantalWaarden)
                .filter(getal -> getal.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO) == 0)
                .max((vorig, getal) -> vorig.compareTo(getal));
        System.out.println(
        String.format("%,16d:%,16d met parallel", aantalWaarden, System.nanoTime() - voor));
        
    }
    
    public static void main(String[] args) {
        
        Stream.of(10,100,1_000,10_000, 100_000, 1_000000, 10_000000, 100_000000)
                .forEach(aantalWaarden -> 
                {zonderParallel(aantalWaarden); metParallel(aantalWaarden);});
        System.out.println("End");
        
    }
}
