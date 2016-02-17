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
public class VrachtVliegtuig extends LuchtVaartuig implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int laadvermogen;

    public VrachtVliegtuig(String type, int kruissnelheid, int vliegbereik, 
            BigDecimal basisKostprijsPerDag, int laadvermogen) throws LuchtVaartuigException {
        super(type, kruissnelheid, vliegbereik, basisKostprijsPerDag);
        setLaadvermogen(laadvermogen);
    }

    public int getLaadvermogen() {
        return laadvermogen;
    }

    public final void setLaadvermogen(int laadvermogen) throws LuchtVaartuigException {
        if (laadvermogen <= 0) {
            throw new LuchtVaartuigException("LuchtVaartuigException :: "
                    + "Een VrachtVliegtuig moet minstens 1kg kunnen laden");
        }
        this.laadvermogen = laadvermogen;
    }
    
    
    @Override
    public BigDecimal berekenTotaleKostprijsPerDag() {
        BigDecimal kostprijs;
        
        // Totale kostprijs per dag = €100 per ton laadvermogen
        kostprijs = getBasisKostprijsPerDag();
        kostprijs = kostprijs
                .add(BigDecimal.valueOf(100)
                        .multiply(BigDecimal.valueOf(laadvermogen)));
        
        return kostprijs;
    }
    
}
