/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.personeel.Kaderlid;
import be.vdab.personeel.*;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemersDatum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse om de implementatie van werknemers te testen.
 * Maakt enkele werknemers aan, slaat deze op in een HashMap, print deze naar
 * de output en schrijft ze vervolgens weg naar "personeel.dat".
 * 
 * @author yannick.thibos
 */
public class Bedrijf {
    
    public static final File WERKNEMERSFILE = new File("personeel.dat");
    
    public static void main(String[] args) {
        
        Set<Werknemer> werknemers = new HashSet<>();
        
        System.out.println("Anna toevoegen:");
        try {
            werknemers.add(new Arbeider("Anna", 1, new WerknemersDatum(1, 2, 1980), 15));
        } catch (WerknemerException ex) {
            System.out.println(ex);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Brenda toevoegen:");
        try {
            werknemers.add(new Bediende("Brenda", 2, new WerknemersDatum(1, 3, 1980), 1500));
        } catch (WerknemerException ex) {
            System.out.println(ex);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Carla toevoegen:");
        try {
            werknemers.add(new Arbeider("Carla", 3, new WerknemersDatum(1, 2, 1979), 15));
        } catch (WerknemerException ex) {
            System.out.println(ex);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Daniella toevoegen:");
        try {
            werknemers.add(new Bediende("Daniella", 4, new WerknemersDatum(1, 3, 1978), 1500));
        } catch (WerknemerException ex) {
            System.out.println(ex);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Els toevoegen:");
        try {
            werknemers.add(new Kaderlid("Els", 5, new WerknemersDatum(13, 3, 1977), 2500, "chef"));
        } catch (WerknemerException ex) {
            System.out.println(ex);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        
        try {
            werknemers.add(new Bediende("Jos", 10, new WerknemersDatum(11, 3, 1601), 2000));
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Jos niet toegevoegd");
        }
        
        // Werknemers printen
        werknemers.stream().sorted().forEach(System.out::println);
        
        // Schrijft de HashSet werknemers weg naar "personeel.dat"
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(WERKNEMERSFILE))){
            objectOut.writeObject(werknemers);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
