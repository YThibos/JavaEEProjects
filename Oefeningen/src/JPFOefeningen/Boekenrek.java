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
public class Boekenrek implements Voorwerp {
    
    private int hoogte, breedte;
    private BigDecimal aankoopprijs, winst;

    public Boekenrek(int hoogte, int breedte, BigDecimal aankoopprijs, BigDecimal winst) {
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.aankoopprijs = aankoopprijs;
        this.winst = winst;
    }
    
    @Override
    public void gegevensTonen() {
        System.out.println("--Boekenrek--");
        System.out.println("H: " + hoogte + "\tB: " + breedte);
        System.out.println("Aankoopprijs: "  + aankoopprijs + "\tWinst: " + winstBerekenen());
        
    }

    @Override
    public BigDecimal winstBerekenen() {
        return aankoopprijs.multiply(new BigDecimal(2));
    }
     
    
    
}
