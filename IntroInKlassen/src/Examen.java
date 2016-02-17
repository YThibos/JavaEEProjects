/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Examen {
    
    public static void main (String[] args) {
        
        Student s1 = new Student("Joske");
        Student s2 = new Student("Jefke", 100);
        
        s1.setScore(10);
        
        System.out.println(s1.getNaam() + " scoorde " + s1.getScore());
       System.out.println(s2.getNaam() + " scoorde " + s2.getScore());
        
    }
    
}
