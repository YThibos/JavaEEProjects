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
public class Main {

    public static void main(String[] args) {

        InsectenLezer insect1 = new InsectenLezer("c:/teksten/insecten1.csv", System.out);
        InsectenLezer insect2 = new InsectenLezer("c:/teksten/insecten2.csv", System.err);

        Thread thread1 = new Thread(insect1);
        Thread thread2 = new Thread(insect2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Aantal regels met prijs < 3: ");
        System.out.println(insect1.getTeller() + insect2.getTeller());

    }

}
