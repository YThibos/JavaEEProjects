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
public class Oef8 {
    
    public static void main (String[] args) {
        
        int[] count = new int[100];
        int rand;
        
        for (int i = 0; i < 100; i++) {
            rand = (int)(Math.random() * 1000 + 1);
            count[i] = rand;
        }
        
        QuickSort sorter = new QuickSort();
        sorter.sort(count);
        
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        
    }
    
}
