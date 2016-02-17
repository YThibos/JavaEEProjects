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
public class H4Oef {
    
    public static void main (String[] args) {
        
        int[] count = new int[101];
        int rand;
        
        for (int i = 0; i < 10000; i++) {
            
            rand = (int)(Math.random() * 100 + 1);
            count[rand] += 1;
            
        }
        
        for (int j = 0; j < count.length; j++) {
            System.out.println(j + " kwam " + count[j] + " keer voor.");
        }
        
        
    }
    
}
