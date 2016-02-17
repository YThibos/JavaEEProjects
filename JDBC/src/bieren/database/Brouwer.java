/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren.database;

import java.util.Objects;

/**
 *
 * @author Yannick.Thibos
 */
public class Brouwer {
    
    private int id;
    private String naam;
    private String adres;
    private short postcode;
    private String gemeente;
    private int omzet;

    public Brouwer() {
        this.id = -1;
        this.naam = "null";
        this.adres = "null";
        this.postcode = -1;
        this.gemeente = "null";
        this.omzet = -1;
    }

    public Brouwer(int id, String naam, String adres, short postcode, String gemeente, int omzet) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.omzet = omzet;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public short getPostcode() {
        return postcode;
    }

    public void setPostcode(short postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public int getOmzet() {
        return omzet;
    }

    public void setOmzet(int omzet) {
        this.omzet = omzet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.naam);
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
        final Brouwer other = (Brouwer) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Brouwer{" + "id=" + id + ", naam=" + naam + ", adres=" + adres + ", postcode=" + postcode + ", gemeente=" + gemeente + ", omzet=" + omzet + '}';
    }

}
