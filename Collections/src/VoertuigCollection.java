/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import JPFOefeningen.Voertuig;
import JPFOefeningen.Personenwagen;
import JPFOefeningen.Vrachtwagen;
import java.util.TreeSet;

/**
 *
 * @author yannick.thibos
 */
public class VoertuigCollection {
    
    public static void main (String[] args) {
        
        TreeSet voertuigen = new TreeSet();
        
        voertuigen.add(new Personenwagen());
        voertuigen.add(new Personenwagen("Jan", 1000.0F, 100, 10.0F, "AAA-111", 5, 5));
        voertuigen.add(new Personenwagen("Piet", 2000.0F, 200, 20.0F, "BBB-123", 5, 5));
        voertuigen.add(new Vrachtwagen());
        voertuigen.add(new Vrachtwagen("Willy", 3000.0F, 300, 30.0F, "AAA-001", 10000.0F));
     
        for (Object object : voertuigen) {
            Voertuig v = (Voertuig) object;
            //System.out.println(v);
            v.toon();
            System.out.println();
        }
        
    }
    
}
