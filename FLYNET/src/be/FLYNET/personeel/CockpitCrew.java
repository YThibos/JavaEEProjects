/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import be.FLYNET.IKost;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public class CockpitCrew extends VliegendPersoneelslid implements IKost, Serializable {
    
    private static final long serialVersionUID = 2L;
    
    private int vliegUren;

    public CockpitCrew(String personeelsID, String naam, 
            BigDecimal basisKostprijsPerDag, Adres adres, 
            Graad graad, List<Certificaat> certificaten, int vliegUren) throws PersoneelsException {
        super(personeelsID, naam, basisKostprijsPerDag, adres, graad, certificaten);
        setVliegUren(vliegUren);
    }

    public int getVliegUren() {
        return vliegUren;
    }

    public void setVliegUren(int vliegUren) throws PersoneelsException {
        if (vliegUren < 0) {
            throw new PersoneelsException("PersoneelsException :: "
                    + "Vlieguren kan niet negatief zijn");
        }
        this.vliegUren = vliegUren;
    }
    
    
    @Override
    public void setGraad(Graad graad) throws PersoneelsException {
        if (graad == Graad.Steward || graad == Graad.Purser) {
            throw new PersoneelsException("PersoneelsException :: "
                    + "CabinCrew personeel kan niet de graad Steward of Purser hebben");
        }
        else if (graad == null) {
            throw new PersoneelsException("PersoneelsException :: "
                    + "Graad mag geen nullpointer zijn");
        }
        this.graad = graad;
    }

    @Override
    public BigDecimal berekenTotaleKostprijsPerDag() {
        BigDecimal kostprijs = getBasisKostprijsPerDag();
        
        switch (graad) {
            case Captain:
                kostprijs = kostprijs.multiply(new BigDecimal("1.3")); //BigDecimal.valueOf(1.3)
                System.out.println("*****" + kostprijs);
                break;
            case SeniorFlightOfficer:
                kostprijs = kostprijs.multiply(BigDecimal.valueOf(1.2));
                break;
            case SecondOfficer:
                kostprijs = kostprijs.multiply(BigDecimal.valueOf(1.1));
                break;
        }
        
        
        if (getCertificaten().contains(Certificaat.CPL)) {
            kostprijs = kostprijs.add(BigDecimal.valueOf(50));
        }
        
        return kostprijs;
    }
    
}
