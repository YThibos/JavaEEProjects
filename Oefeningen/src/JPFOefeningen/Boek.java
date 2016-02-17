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
public class Boek implements Voorwerp {

    protected String titel, auteur, eigenaar, genre;
    protected BigDecimal aankoopprijs;

    public Boek(String titel, String auteur, String genre, BigDecimal aankoopprijs) {
        this.titel = titel;
        this.auteur = auteur;
        this.eigenaar = "VDAB";
        this.genre = genre;
        this.aankoopprijs = aankoopprijs;
    }
    
    @Override
    public void gegevensTonen() {
        System.out.println("--Boek--");
        System.out.println(titel + " - " + auteur + " - " + eigenaar + " - " + genre);
        System.out.println("Aankoopprijs: " + aankoopprijs);
        
    }

    @Override
    public BigDecimal winstBerekenen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
