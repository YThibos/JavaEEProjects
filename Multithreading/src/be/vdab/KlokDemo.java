/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import java.util.Scanner;

/**
 *
 * @author yannick.thibos
 */
public class KlokDemo {

    public static void main(String[] args) {
        
        Klok klok = new Klok();
        
        Thread tiktak = new Thread(klok);
        tiktak.setDaemon(true);
        
        tiktak.start();
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        //tiktak.interrupt();
        
        
        
    }
    
}
