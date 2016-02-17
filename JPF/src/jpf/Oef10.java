/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpf;

import java.util.Scanner;

/**
 *
 * @author yannick.thibos
 */
public class Oef10 {
    
    public static void main (String[] args) {
        
        int aantal;
        
        System.out.println("Hoeveel huisdieren heb je?");
        
        Scanner sc = new Scanner(System.in);
        aantal = sc.nextInt();
        
        switch (aantal) {
            case 0:
                System.out.println("Geen huisdieren.");
                break;
            case 1:
                System.out.println("1 huisdier.");
                break;
            case 2:
                System.out.println("2 huisdieren.");
                break;
            case 3:
                System.out.println("3 huisdieren.");
                break;
            default:
                System.out.println(">3 huisdieren.");
        }
        
    }
    
}
