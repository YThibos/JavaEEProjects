/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.winkel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public class Catalogus {
    
    private List<Product> producten;
    
    public Catalogus () {
        producten = new ArrayList<Product>();
    }
    
    public Catalogus (Collection<Product> c) {
        producten = new ArrayList<Product>();
        for (Product product : c) {
            producten.add(product);
        }
    }
    
    public Catalogus (Product[] p) {
        producten = new ArrayList<Product>();
        for (Product product : p) {
            producten.add(product);
        }
    }
    
    public Iterator<Product> iterator() {
        return producten.iterator();
    }
    
}
