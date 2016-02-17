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
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasse om de implementatie van werknemers te testen. Maakt enkele werknemers
 * aan, slaat deze op in een HashMap, print deze naar de output en schrijft ze
 * vervolgens weg naar "personeel.dat".
 *
 * @author yannick.thibos
 */
public class Bedrijf {

    public static final File WERKNEMERSFILE = new File("personeel.dat");

    public static void main(String[] args) {

        SortedSet<Werknemer> werknemers = new TreeSet<>();

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

        for (int jaar = 1976; jaar <= 1977; jaar++) {
            for (int maand = 1; maand <= 3; maand++) {
                for (int dag = 10; dag < 14; dag++) {
                    try {
                        werknemers.add(new Kaderlid("Baas", 100, new WerknemersDatum(), 5000, "Oprichter"));
                        werknemers.add(new Bediende(Character.toString((char)(maand + 97)), dag,
                                new WerknemersDatum(dag, maand, jaar), 100));
                    } catch (WerknemerException | DatumException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }

        // Werknemers printen
        werknemers.stream().sorted().forEach(System.out::println);

        // Schrijft de HashSet werknemers weg naar "personeel.dat"
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(WERKNEMERSFILE))) {
            objectOut.writeObject(werknemers);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
