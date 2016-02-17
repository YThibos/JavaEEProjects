/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.winkel;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author yannick.thibos
 */
public class WinkelDemo {
    
    public static void main(String[] args) {
        
        Product[] p = { new Product("Keyboard", BigDecimal.valueOf(50.0)),
        new Product("Muis", BigDecimal.valueOf(25.0)),
        new Product("Printer", BigDecimal.valueOf(30.0)),
        new Product("Scherm", BigDecimal.valueOf(100.0)),
        new Product("Grafische kaart", BigDecimal.valueOf(300.0)),
        new Product("Moederbord", BigDecimal.valueOf(90.0)),
        new Product("CPU", BigDecimal.valueOf(150.0)),
        new Product("RAM", BigDecimal.valueOf(50.0))};
        
        
        Mandje basket = new Mandje();
        for (Product product : p) {
            basket.add(product, (int)(Math.random() * 5));
        }
        
        print(basket);
        
        System.out.println("Te Betalen: " + basket.getSom());
        System.out.println();
        
        Catalogus catalogus = new Catalogus(p);
        
        Iterator<Product> pi = catalogus.iterator();
        int i = 1;
        
        Mandje mandje = new Mandje();
        
        while (pi.hasNext()) {
            Product prod = pi.next();
            System.out.println(prod);
            i++;
            if (i%2==0) {
                mandje.add(prod, i);
            }
        }
        
        System.out.println("U kocht:");
        Iterator<Map.Entry<Product, Integer>> mi = mandje.iterator();
        while (mi.hasNext()) {
            Map.Entry<Product, Integer> aankoop = mi.next();
            System.out.printf("%s %d \n", aankoop.getKey(), aankoop.getValue());
        }
        
        System.out.printf("U kocht voor een totaal van: %.2f \n", mandje.getSom());
    }
    
    private static void print(Mandje m) {
        System.out.println("*** Inhoud van mandje ***");
        Iterator it = m.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
