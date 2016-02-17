/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren.database;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Yannick.Thibos
 */
public class Bier implements Comparable<Bier>{
    
    private int id;
    private String naam;
    private int brouwerid;
    private int soortid;
    private float alcohol;
    private LocalDate verkochtsinds;
    
    public Bier() {
        this.id = -1;
        this.naam = "null";
        this.brouwerid = -1;
        this.soortid = -1;
        this.alcohol = 0.0f;
        this.verkochtsinds = LocalDate.now();
    }

    public Bier(int id, String naam, int brouwerid, int soortid, float alcohol, LocalDate verkochtsinds) {
        this.id = id;
        this.naam = naam;
        this.brouwerid = brouwerid;
        this.soortid = soortid;
        this.alcohol = alcohol;
        this.verkochtsinds = verkochtsinds;
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

    public int getBrouwerid() {
        return brouwerid;
    }

    public void setBrouwerid(int brouwerid) {
        this.brouwerid = brouwerid;
    }

    public int getSoortid() {
        return soortid;
    }

    public void setSoortid(int soortid) {
        this.soortid = soortid;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public LocalDate getVerkochtsinds() {
        return verkochtsinds;
    }

    public void setVerkochtsinds(LocalDate verkochtsinds) {
        this.verkochtsinds = verkochtsinds;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.naam);
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
        final Bier other = (Bier) obj;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = formatter.format(verkochtsinds);
        return String.format("%5d %100s %5d %5d %4.1f%% %s", id, naam, brouwerid, soortid, alcohol, formattedDate);
    }

    /** 
     * Vergelijkt dit Bier object met meegegeven Bier op volgorde.
     * Volgorde wordt bepaald door alfabetische volgorde op 'naam'.
     * De String naam wordt vergeleken mbv String.compareTo()
     * 
     * @param anderBier
     * @return -Negatieve integer indien deze naam 'kleiner dan' die van de parameter is<br>
     * -Nul indien de objecten gelijk zijn (en/of eenzelfde index hebben)<br>
     * -Positieve integer indien deze naam 'groter dan' die van de parameter is
     * 
     */
    @Override
    public int compareTo(Bier anderBier) {
        if (this.equals(anderBier)) {
            return 0;
        }
        return naam.compareTo(anderBier.getNaam());
    }
    
}
