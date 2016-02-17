/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class Klok implements Runnable {

    @Override
    public void run() {

        boolean verderDoen = true;

        while (verderDoen) {
            System.out.println(new Date());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Klok gestopt.");
                verderDoen = false;
            }
        }

    }
}
