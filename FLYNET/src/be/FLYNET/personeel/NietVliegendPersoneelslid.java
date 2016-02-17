/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import be.FLYNET.IKost;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author yannick.thibos
 */
public class NietVliegendPersoneelslid extends Personeelslid implements IKost, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int urenPerWeek;
    
    /**
     * Creëert een nieuw NietVliegendPersoneelslid object.
     * Maakt een nieuw NietVliegendPersoneelslid object met de meegegeven parameters.
     * 
     * @param personeelsID
     * @param naam
     * @param basisKostprijsPerDag
     * @param adres
     * @param urenPerWeek
     * @throws PersoneelsException 
     */
    public NietVliegendPersoneelslid(String personeelsID, String naam, 
            BigDecimal basisKostprijsPerDag, Adres adres, int urenPerWeek) 
            throws PersoneelsException {
        super(personeelsID, naam, basisKostprijsPerDag, adres);
        setUrenPerWeek(urenPerWeek);
    }
    
    /**
     * Controleert op geldige input en wijzigt indien ja de aantal uren per week.
     * Het aantal uren per week mag voor een NietVliegendPersoneelslid gaan van 0
 tot en met 60. Alle andere waarden worden geweigerd.
     * 
     * @param urenPerWeek           Integer waarde uit [0,60] 
     * @throws PersoneelsException  Wordt geworpen als de parameter niet aan
     * de voorwaarde voldoet.
     */
    public final void setUrenPerWeek(int urenPerWeek) throws PersoneelsException {
        if (urenPerWeek < 0 || urenPerWeek > 60) {
            throw new PersoneelsException("PersoneelsException :: "
                    + "Aantal uren per week moet >= 0 en <= 60");
        }
        this.urenPerWeek = urenPerWeek;
    }

    /**
     * Geeft de totale kostprijs per dag voor een NietVliegendPersoneelslid.
     * 
     * @return  De totale kostprijs per dag voor dit NietVliegendPersoneelslid.
     */
    @Override
    public BigDecimal berekenTotaleKostprijsPerDag() {
        // Bij aanmaken van het object is mogelijks een nullpointer meegegeven
        // aan de BigDecimal.
        if (getBasisKostprijsPerDag() == null) {
            return BigDecimal.ZERO;
        }
        return getBasisKostprijsPerDag();
    }

    @Override
    public String toString() {
        return super.toString() + " " + urenPerWeek + "uren/week";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
