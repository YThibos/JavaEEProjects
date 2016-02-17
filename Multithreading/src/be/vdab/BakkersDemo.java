/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class BakkersDemo {

    public static void main(String[] args) {

        Stapel stapel = new Stapel();
        Thread thread1 = new Thread(new Bakker(stapel, "Bakker1"));
        Thread thread2 = new Thread(new Bakker(stapel, "Bakker2"));
        
        Thread cons1 = new Thread(new Klant(stapel, "Eter1"));
        Thread cons2 = new Thread(new Klant(stapel, "Eter2"));
        Thread cons3 = new Thread(new Klant(stapel, "Eter3"));
        Thread cons4 = new Thread(new Klant(stapel, "Eter4"));

        thread1.start();
        thread2.start();
        
        cons1.start();
        cons2.start();
        cons3.start();
        cons4.start();

        try {
            thread1.join();
            thread2.join();
            cons1.join();
            cons2.join();
            cons3.join();
            cons4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BakkersDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Aantal op de stapel: " + stapel.getAantal());

    }

}
