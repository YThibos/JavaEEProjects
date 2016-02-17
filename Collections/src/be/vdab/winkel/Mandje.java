/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.winkel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author yannick.thibos
 */
public class Mandje {

    private Map<Product, Integer> mandje;

    public Mandje() {
        mandje = new HashMap<>();
    }

    public void add(Product product, Integer aantal) {
        if (!mandje.containsKey(product)) {
            mandje.put(product, aantal);
        } 
        else {
            set(product, aantal);
        }
    }

    public void set(Product product, Integer aantal) {
        Integer old = mandje.get(product);
        mandje.put(product, aantal + old);
    }

    public void remove(Product product) {
        mandje.remove(product);
    }

    public void clear() {
        mandje.clear();
    }

    public BigDecimal getSom() {
        BigDecimal som = BigDecimal.ZERO;
//        Iterator<Product> it = mandje.keySet().iterator();
//        while (it.hasNext()) {
//            Product product = it.next();
//            Integer aantal = mandje.get(product);
//            BigDecimal subTotaal = product.getPrijs().multiply(BigDecimal.valueOf(aantal));
//            som = som.add(subTotaal);
//        }
        for (Map.Entry<Product, Integer> entry : mandje.entrySet()) {
            // Voor elke entry in mandje, haal de prijs v/h product op, vermenigvuldig met
            // de prijs/eenheid en tel dit bij som
            som = som.add(entry.getKey().getPrijs().multiply(new BigDecimal(entry.getValue())));
        }
        return som;
    }

    public Iterator iterator() {
        return mandje.entrySet().iterator();
    }

}
