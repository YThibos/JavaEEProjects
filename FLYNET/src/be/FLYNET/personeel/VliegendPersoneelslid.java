/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Abstracte klasse die een VliegendPersoneelslid beschrijft.
 * Bevat de basis eigenschappen en methodes die elk VliegendPersoneelslid
 * heeft.
 *
 * @author yannick.thibos
 */
public abstract class VliegendPersoneelslid extends Personeelslid implements Serializable {
    
    private static final long serialVersionUID = 1L;

    protected Graad graad;
    private Set<Certificaat> certificaten;

    public VliegendPersoneelslid(String personeelsID, String naam, 
            BigDecimal basisKostprijsPerDag, Adres adres, Graad graad,
            List<Certificaat> certificaten) throws PersoneelsException {
        
        // super constructor voor basis variabelen
        super(personeelsID, naam, basisKostprijsPerDag, adres);
        
        // setGraad is implementatie afhankelijk voor specifiek VliegendPersoneel
        setGraad(graad);
        
        // Maak de collection van certificaten klaar en voeg desnoods meegegeven toe
        this.certificaten = new TreeSet<>();
        if (certificaten != null) {
            certificaten.stream()
                    .forEach(this.certificaten::add);
        }
    }
    
    public Set<Certificaat> getCertificaten() {
        return certificaten;
    }
    
    public void addCertificaat(Certificaat certificaat) {
        certificaten.add(certificaat);
    }

    public void removeCertificaat(Certificaat certificaat) {
        certificaten.remove(certificaat);
    }
    
    abstract public void setGraad(Graad graad) throws PersoneelsException;
    
    public Graad getGraad() {
        return this.graad;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + graad + " - " + certificaten;
    }
    
}
