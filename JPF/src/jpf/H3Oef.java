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
public class H3Oef {
    
    public static void main (String[] args) {
        
        int[] array = new int[5];
        int sum = 0;
        double avg;
        
        array[0] = (int)(Math.random() * 100) + 1;
        array[1] = (int)(Math.random() * 100) + 1;
        array[2] = (int)(Math.random() * 100) + 1;
        array[3] = (int)(Math.random() * 100) + 1;
        array[4] = (int)(Math.random() * 100) + 1;
        
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
            sum += array[i];
        }
        System.out.println("\nSum = " +  sum);
        avg = (double)sum / array.length;
        System.out.println("Avg = " + avg);
    }
    
}
