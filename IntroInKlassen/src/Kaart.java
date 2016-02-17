/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Kaart {
    
    private String kleur;
    private int rang;
    
    public Kaart() {
        rang = 1 + (int)Math.random() * ((13 - 1) + 1);
        int x = 1 + (int)Math.random() * ((2 - 1) + 1);
        
        switch (x) {
            case 1:
                kleur = "zwart";
                break;
            case 2:
                kleur = "rood";
                break;
        }
        
    }
    
}
