package JPFOefeningen;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Oef17 {
    
    public static void main (String[] args) {
        
        Scanner in = new Scanner(System.in);
        String getypt;
        
        do {
        
            getypt = in.next();

        String lowerGetypt = getypt.toLowerCase();
        
        int teller = 0;
        
        for (int i = 0; i < lowerGetypt.length(); i++) {
            
            if (getypt.charAt(i) == ('a' | 'A') || 
                    getypt.charAt(i) == ('e' | 'E') ||
                    getypt.charAt(i) == ('i' | 'I') ||
                    getypt.charAt(i) == ('o' | 'O') ||
                    getypt.charAt(i) == ('u' | 'U')) {
                teller++;
            }
        }
        
        System.out.println(teller + " klinkers.");
        
        } while (!getypt.equals("stop"));
    }
    
}
