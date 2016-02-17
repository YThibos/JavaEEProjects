/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPFOefeningen;

import java.math.BigDecimal;

/**
 *
 * @author yannick.thibos
 */
public class LeesBoek extends Boek {
    
    private String onderwerp;

    public LeesBoek(String onderwerp, String titel, String auteur, String genre, BigDecimal aankoopprijs) {
        super(titel, auteur, genre, aankoopprijs);
        this.onderwerp = onderwerp;
    }
    
    @Override
    public BigDecimal winstBerekenen() {
        return aankoopprijs.multiply(new BigDecimal(1.5));
    }
    
}
