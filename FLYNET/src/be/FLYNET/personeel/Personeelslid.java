/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Abstract class die de basiseigenschappen van elk Personeelslid beschrijft.
 *
 * @author yannick.thibos
 */
abstract class Personeelslid implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String personeelsID;
    private final String naam;
    private BigDecimal basisKostprijsPerDag;
    private Adres adres;

    // TODO !!!!!!!!!!!!
    /*
    Bij de setters controles inbouwen op de input!
    */
    
    public Personeelslid(String personeelsID, String naam, BigDecimal basisKostprijsPerDag, Adres adres) {
        this.personeelsID = personeelsID;
        this.naam = naam;
        this.basisKostprijsPerDag = basisKostprijsPerDag;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }
    
    public String getPersoneelsID() {
        return personeelsID;
    }

    public void setPersoneelsID(String personeelsID) {
        this.personeelsID = personeelsID;
    }

    public BigDecimal getBasisKostprijsPerDag() {
        return basisKostprijsPerDag;
    }

    public void setBasisKostprijsPerDag(BigDecimal basisKostprijsPerDag) {
        this.basisKostprijsPerDag = basisKostprijsPerDag;
    }

    public Adres getAdres() {
        return adres;
    }
    
    /**
     * 'Verhuist' het personeelslid naar het nieuwe adres.
     * Een adres blijft ongewijzigd, slechts de persoon die er woont kan 
     * wijzigen. Gebruik de methode verhuis om de wijziging van adres door
     * te voeren.
     * 
     * @param nieuwAdres        Het nieuwe Adres waar het personeelslid woont.
     * Kan niet null zijn en de velden mogen niet leeg zijn.
     * @throws AdresException   Wordt geworpen als meegegeven Adres null is.
     */
    public final void verhuis(Adres nieuwAdres) throws AdresException {
        if (nieuwAdres == null) {
            throw new AdresException("AdresException :: Adres mag niet null zijn");
        }
        this.adres = nieuwAdres;
    }

    /**
     * Hashcode op basis van personeelsID en naam.
     * PersoneelsID zou op zich uniek moeten zijn. Voor extra uniciteit wordt
     * naam mee als basis voor de HashCode gebruikt.
     * 
     * @return  HashCode op basis van personeelsID en naam.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.personeelsID);
        hash = 97 * hash + Objects.hashCode(this.naam);
        return hash;
    }

    /**
     * Controleert of dit Personeelslid gelijk is aan meegegeven parameter.
     * Twee personeelsleden worden als gelijk beschouwd als:<p>
     * - Ze hetzelfde object beschrijven<br>
     * - De twee personeelsleden zowel hetzelfde ID als dezelfde naam hebben.
     * 
     * @param obj   Het object waarmee vergeleken moet worden
     * @return      True als aan de voorwaarden voldaan is, anders false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personeelslid other = (Personeelslid) obj;
        if (!Objects.equals(this.personeelsID, other.personeelsID)) {
            return false;
        }
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return personeelsID + " - " + naam + ", " + adres + "\t€" + basisKostprijsPerDag;
    }
    
}
