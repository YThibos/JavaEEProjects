/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author yannick.thibos
 */
public class WaarnemerDemo {
    
    public static void main (String[] args) {
        
        int temp;
        Scanner in = new Scanner(System.in);
        
        Waarnemer Frank = new Waarnemer();
        
        do {
            temp = in.nextInt();
            Frank.add(temp);
            System.out.println("Min: " + Frank.getMin());
            System.out.println("Max: " + Frank.getMax());
            System.out.println("Avg: " + Frank.getAvg());
        } while (temp != 999);
        
    }
    
}
