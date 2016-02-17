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
public class GemiddeldenDemo {

    public static void main(String[] args) {

        double[] doubles = new double[1000000];

        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.random() * 100;
        }
        Gemiddelden gem1 = new Gemiddelden(doubles, 0, doubles.length / 2 - 1, System.out);
        Gemiddelden gem2 = new Gemiddelden(doubles, doubles.length / 2, doubles.length, System.err);
        Thread thread1 = new Thread(gem1);
        Thread thread2 = new Thread(gem2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GemiddeldenDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Avg: ");
        System.out.println(gem1.getAvg() + gem2.getAvg() / 2);
    }

}
