/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.vloot;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author yannick.thibos
 */
public class PassagiersVliegtuig extends LuchtVaartuig implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int aantalPassagiers;

    public PassagiersVliegtuig(String type, int kruissnelheid, int vliegbereik, 
            BigDecimal basisKostprijsPerDag, int aantalPassagiers) throws LuchtVaartuigException {
        super(type, kruissnelheid, vliegbereik, basisKostprijsPerDag);
        setAantalPassagiers(aantalPassagiers);
    }

    public int getAantalPassagiers() {
        return aantalPassagiers;
    }

    public final void setAantalPassagiers(int aantalPassagiers) throws LuchtVaartuigException {
        if (aantalPassagiers <= 0) {
            throw new LuchtVaartuigException("LuchtVaartuigException :: "
                    + "Een PassagiersVliegtuig moet minstens 1 passagier kunnen laden");
        }
        this.aantalPassagiers = aantalPassagiers;
    }
    
    @Override
    public BigDecimal berekenTotaleKostprijsPerDag() {
        BigDecimal kostprijs;
        
        // Totale kostprijs per dag = €10 per passagier
        kostprijs = getBasisKostprijsPerDag();
        kostprijs = kostprijs
                .add(BigDecimal.TEN
                        .multiply(BigDecimal.valueOf(aantalPassagiers)));
        
        return kostprijs;
    }

    @Override
    public String toString() {
        return super.toString() + " " + aantalPassagiers;
    }
    
}
