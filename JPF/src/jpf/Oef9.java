/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpf;

/**
 *
 * @author yannick.thibos
 */
public class Oef9 {
    
    public static void main (String[] args) {
    
        int[] getallen = new int[7];
        int rand;
        boolean drawn;
        
        // Trek 7 getallen
        for (int i = 0; i < getallen.length; i++) {    
            // Blijf getallen trekken tot hij uniek is.
            do {
                drawn = false;
                // Trek nieuw getal uit [1, 42]
                rand = 1 + (int)(Math.random() * ((42 - 1) + 1));
                //System.out.println(rand);
                // Zoek of deze al getrokken is
                for (int j = 0; j < i; j++) {
                    //System.out.println("   " + getallen[j]);
                    if (getallen[j] ==  rand) {
                        drawn = true;
                        //System.out.println("found");
                    }
                }
            } while (drawn == true);
            getallen[i] = rand;
        }
        
        // Sorteer de ballen
        QuickSort sorter = new QuickSort();
        sorter.sort(getallen);
        
        // Print de lijst
        for (int teller = 0; teller < getallen.length; teller++)
            System.out.print(getallen[teller] + " ");
        
    }
    
}
