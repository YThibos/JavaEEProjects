/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.vloot;

import be.FLYNET.IKost;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author yannick.thibos
 */
public abstract class LuchtVaartuig implements IKost, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String type;
    private int kruissnelheid;
    private int vliegbereik;
    private BigDecimal basisKostprijsPerDag;

    public LuchtVaartuig(String type, int kruissnelheid, int vliegbereik, 
            BigDecimal basisKostprijsPerDag) 
            throws LuchtVaartuigException {
        setType(type);
        setKruissnelheid(kruissnelheid);
        setVliegbereik(vliegbereik);
        setBasisKostprijsPerDag(basisKostprijsPerDag);
    }

    public String getType() {
        return type;
    }

    public final void setType(String type) throws LuchtVaartuigException {
        if (type == null) {
            throw new LuchtVaartuigException("LuchtVaartuigException :: "
                    + "String type mag niet null zijn");
        }
        if ("".equals(type)) {
            throw new LuchtVaartuigException("LuchtVaartuigException :: "
                    + "String type mag niet leeg zijn");
        }
        this.type = type;
    }

    public int getKruissnelheid() {
        return kruissnelheid;
    }

    public final void setKruissnelheid(int kruissnelheid) throws LuchtVaartuigException {
        if (kruissnelheid <= 0) {
            throw new LuchtVaartuigException("LuchtVaartuigException :: "
                    + "Een LuchtVaartuig moet een kruissnelheid hebben groten dan nul");
        }
        this.kruissnelheid = kruissnelheid;
    }

    public int getVliegbereik() {
        return vliegbereik;
    }

    public final void setVliegbereik(int vliegbereik) throws LuchtVaartuigException {
        if (vliegbereik <= 0) {
            throw new LuchtVaartuigException("LuchtVaartuigException :: "
                    + "Een LuchtVaartuig moet een vliegbereik hebben groter dan nul");
        }
        this.vliegbereik = vliegbereik;
    }

    public BigDecimal getBasisKostprijsPerDag() {
        return basisKostprijsPerDag;
    }

    public final void setBasisKostprijsPerDag(BigDecimal basisKostprijsPerDag) {
        Objects.requireNonNull(basisKostprijsPerDag, "LuchtVaartuigException :: "
                + "De basiskostprijs mag geen nullpointer zijn");
        this.basisKostprijsPerDag = basisKostprijsPerDag;
    }
    
    @Override
    public abstract BigDecimal berekenTotaleKostprijsPerDag();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.type);
        return hash;
    }

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
        final LuchtVaartuig other = (LuchtVaartuig) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return type + "\t" + kruissnelheid + "km/u " + vliegbereik + "km €" + basisKostprijsPerDag;
    }
    
    
    
}
