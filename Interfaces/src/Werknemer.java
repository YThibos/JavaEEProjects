/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Werknemer implements Kost {

    private String naam;
    private double wedde;
    
    public Werknemer(String naam, double wedde) {
        this.naam = naam;
        this.wedde = wedde;
    }
    
    @Override
    public double bedragKost() {
       return wedde;
    }

    @Override
    public boolean personeelsKost() {
        return true;
    }
    
    public double getWedde() {
        return wedde;
    }
    
}
