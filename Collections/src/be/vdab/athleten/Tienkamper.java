/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.athleten;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author yannick.thibos
 */
public class Tienkamper implements Comparable<Tienkamper> {
    
    private String naam;
    private int punten;
    
    public Tienkamper(String naam, int punten) {
        this.naam = naam;
        this.punten = punten;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.naam);
        return hash;
    }
    
    @Override
    public int compareTo(Tienkamper t) {
        // Twee dezelfde Tienkampers zijn gelijk in ordening
        // Consisten met equals()
        if (equals(t)) return 0;
        // Natuurlijke ordening op naam
        return getNaam().compareTo(t.getNaam());
    }

    @Override
    public boolean equals(Object obj) {
        // Elk object is equal aan zichzelf
        if (this == obj) {
            return true;
        }
        // Als het te vergelijken object null is kan het niet gelijk zijn
        if (obj == null) {
            return false;
        }
        // Een Tienkamper kan alleen equal zijn als de andere ook een Tienkamper is
        if (getClass() != obj.getClass()) {
            return false;
        }
        // Een Tienkamper is equal aan een andere Tienkamper als ze dezelfde naam hebben
        final Tienkamper other = (Tienkamper) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Naam: " + naam + "\tPunten: " + punten;
    }
    
    public static Comparator<Tienkamper> getPuntenComparator() {
        return new Comparator<Tienkamper> () {
            @Override
            public int compare(Tienkamper o1, Tienkamper o2) {
                return o1.getPunten() - o2.getPunten();
            }
        };
    }
    
}
