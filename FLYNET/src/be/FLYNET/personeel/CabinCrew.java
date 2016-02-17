/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import be.FLYNET.IKost;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author yannick.thibos
 */
public class CabinCrew extends VliegendPersoneelslid implements IKost, Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final List<Graad> toegelatenGraden;
    
    static {
        toegelatenGraden = new ArrayList<>();
        toegelatenGraden.add(Graad.Purser);
        toegelatenGraden.add(Graad.Steward);
    }
    
    private String werkpositie;

    public CabinCrew(String personeelsID, String naam,
            BigDecimal basisKostprijsPerDag, Adres adres, Graad graad, 
            List<Certificaat> certificaten, String werkpositie) throws PersoneelsException {
        super(personeelsID, naam, basisKostprijsPerDag, adres, graad, certificaten);
        setWerkpositie(werkpositie);
    }

    public String getWerkpositie() {
        return werkpositie;
    }

    public void setWerkpositie(String werkpositie) throws PersoneelsException {
        Objects.requireNonNull(werkpositie, "NullPointerException :: "
                + "Werkpositie mag niet null zijn");
        if ("".equals(werkpositie)) {
            throw new PersoneelsException("PersoneelsException :: "
                    + "Werkpositie mag geen lege string zijn");
        }
        this.werkpositie = werkpositie;
    }
    
    @Override
    public void setGraad(Graad graad) throws PersoneelsException {
        Objects.requireNonNull(graad, "NullPointerException :: "
                + "Graad mag niet null zijn");
        if (!toegelatenGraden.contains(graad)) {
            throw new PersoneelsException("PersoneelsException :: "
                    + "CabinCrew kan enkel de graad Steward of Purser hebben");
        }
        this.graad = graad;
    }

    @Override
    public BigDecimal berekenTotaleKostprijsPerDag() {
        BigDecimal kostprijs = getBasisKostprijsPerDag();
        
        if (graad == Graad.Purser) {
            kostprijs = kostprijs.multiply(BigDecimal.valueOf(1.2));
        }
        if (getCertificaten().contains(Certificaat.EHBO)) {
            kostprijs = kostprijs.add(BigDecimal.valueOf(5));
        }
        
        return kostprijs;
    }
    
    
    
}
