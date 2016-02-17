/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class GetalMain {
    
    public static void main (String[] args) {
        
        Getal mijnGetal = new Getal(13);
        System.out.println("Getal is: "); mijnGetal.print();
        mijnGetal.setX(-100);
        System.out.println("Getal is: "); mijnGetal.print();
        System.out.println("Absolute waarde van getal: " + mijnGetal.absoluut()); 
        System.out.println("150 bij opgeteld: " + mijnGetal.som(150));
        
        System.out.println("Als double: " + mijnGetal.toDouble());
        
    }
    
}
