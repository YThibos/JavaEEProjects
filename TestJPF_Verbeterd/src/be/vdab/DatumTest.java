/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class DatumTest {
    
    public static void main(String[] args) {
        
        try {
            Datum d1 = new Datum(32, 13, 5100);
        } catch (DatumException ex) {
            System.out.println("Exception bij het initialiseren van d1:");
            System.out.println(ex);
        }
        
        Datum d2 = new Datum();
        System.out.println("1/1/1584 = " + d2);
        
        System.out.println("\nna setJaar(2000)");
        try {
            d2.setJaar(2000);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("1/1/2000 = " + d2);
        
        System.out.println("\nna setMaand(2)");
        try {
            d2.setMaand(2);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("1/2/2000 = " + d2);
        
        System.out.println("\nna setDag(29)");
        try {
            d2.setDag(29);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("29/2/2000 = " + d2);
        
        System.out.println("\nna setJaar(1900)");
        try {
            d2.setJaar(1900);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("29/2/2000 = " + d2);
        
        System.out.println("\nna setDag(31)");
        try {
            d2.setDag(31);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("29/2/2000 = " + d2);
        
        System.out.println("\nna setMaand(1)");
        try {
            d2.setMaand(1);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("29/1/2000 = " + d2);
        
        System.out.println("\nna setDag(31)");
        try {
            d2.setDag(31);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("31/1/2000 = " + d2);
        
        System.out.println("\nna setMaand(2)");
        try {
            d2.setMaand(2);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("31/1/2000 = " + d2);
        
        System.out.println("\nna setJaar(1600)");
        try {
            d2.setJaar(1600);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("31/1/1600 = " + d2);
        
        System.out.println("\nna setMaand(4)");
        try {
            d2.setMaand(4);
        } catch (DatumException ex) {
            System.out.println(ex);
        }
        System.out.println("31/1/1600 = " + d2);
        
    }
    
}
