/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursus;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author yannick.thibos
 */
public class Werknemer implements Serializable {
    
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;

    public Werknemer(String voornaam, String familienaam, BigDecimal wedde) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.wedde = wedde;
    }
    
    public String getVolledigeNaam() {
        return voornaam + " " + familienaam;
    }
    
    public BigDecimal getWedde() {
        return wedde;
    }
    
}
