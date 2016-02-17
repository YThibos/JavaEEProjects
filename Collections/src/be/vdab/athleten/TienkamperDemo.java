/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.athleten;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author yannick.thibos
 */
public class TienkamperDemo {
    
    public static void main(String[] args) {
        
        List<Tienkamper> alKampers = new ArrayList<>();
        
        System.out.println("***Tienkampers in een ArrayList***");
        vul(alKampers);
        print(alKampers);
        
        System.out.println("");
        
        Set<Tienkamper> tsKampers = new TreeSet<>();
        
        System.out.println("***Tienkampers in een TreeSet***");
        vul(tsKampers);
        print(tsKampers);
        
        System.out.println("");
        
        List<Tienkamper> alKampersC = new ArrayList<>();
        
        System.out.println("***Tienkampers in een ArrayList met comparator op punten***");
        vul(alKampersC);
        Collections.sort(alKampersC, Tienkamper.getPuntenComparator());
        print(alKampersC);
        
        System.out.println("");
        
        Set<Tienkamper> tsKamperC = new TreeSet<>(Tienkamper.getPuntenComparator());
        
        System.out.println("***Tienkampers in een TreeSet met comparator op punten****");        
        vul(tsKamperC);
        print(tsKamperC);
        
    }
    
    private static void vul(Collection<Tienkamper> c) {
            c.add(new Tienkamper("Jan", 10));
            c.add(new Tienkamper("Tom", 50));
            c.add(new Tienkamper("Tim", 5));
            c.add(new Tienkamper("Jozef", 25));
            c.add(new Tienkamper("Strever", 100));
            c.add(new Tienkamper("Jan", 100));
    }
    
    private static void print(Collection<Tienkamper> c) {
        for (Tienkamper tienkamper : c) {
            System.out.println(tienkamper);
        }
    }
    
}
