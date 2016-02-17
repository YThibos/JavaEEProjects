/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.vloot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author yannick.thibos
 */
public class VliegMaatschappij implements Serializable {
    
    private static final long serialVerionUID = 1L;
    
    private int vliegMaatschappijID;
    private String vliegMaatschappijNaam;
    private List<LuchtVaartuig> vloot;

    public VliegMaatschappij(int vliegMaatschappijID, 
            String vliegMaatschappijNaam, List<LuchtVaartuig> vloot) 
            throws VliegMaatschappijException {
        this.vliegMaatschappijID = vliegMaatschappijID;
        setVliegMaatschappijNaam(vliegMaatschappijNaam);
        this.vloot = new ArrayList<>();
    }

    public int getVliegMaatschappijID() {
        return vliegMaatschappijID;
    }

    public void setVliegMaatschappijID(int vliegMaatschappijID) {
        this.vliegMaatschappijID = vliegMaatschappijID;
    }
    
    public String getVliegMaatschappijNaam() {
        return vliegMaatschappijNaam;
    }

    public final void setVliegMaatschappijNaam(String vliegMaatschappijNaam) throws VliegMaatschappijException {
        if (vliegMaatschappijNaam == null) {
            throw new VliegMaatschappijException("VliegMaatschappijException :: "
                    + "String vliegMaatschappijNaam kan niet null zijn");
        }
        if ("".equals(vliegMaatschappijNaam)) {
            throw new VliegMaatschappijException("VliegMaatschappijException :: "
                    + "Een VliegMaatschappij kan geen lege naam hebben");
        }
        this.vliegMaatschappijNaam = vliegMaatschappijNaam;
    }
    
    public void addLuchtVaartuigAanVloot(LuchtVaartuig luchtvaartuig) {
        vloot.add(luchtvaartuig);
    }
    
    public void removeLuchtVaartuigFromVloot(LuchtVaartuig luchtvaartuig) {
        vloot.remove(luchtvaartuig);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.vliegMaatschappijID;
        hash = 89 * hash + Objects.hashCode(this.vliegMaatschappijNaam);
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
        final VliegMaatschappij other = (VliegMaatschappij) obj;
        if (this.vliegMaatschappijID != other.vliegMaatschappijID) {
            return false;
        }
        if (!Objects.equals(this.vliegMaatschappijNaam, other.vliegMaatschappijNaam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VliegMaatschappij{" + "vliegMaatschappijID=" + vliegMaatschappijID + ", vliegMaatschappijNaam=" + vliegMaatschappijNaam + ", vloot=" + vloot + '}';
    }
    
}
