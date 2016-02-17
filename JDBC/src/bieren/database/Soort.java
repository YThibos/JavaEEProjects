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
public class Soort {
    
    private int id;
    private String naam;

    public Soort() {
        this.id = -1;
        this.naam = "null";
    }

    public Soort(int id, String naam) {
        this.id = id;
        this.naam = naam;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.naam);
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
        final Soort other = (Soort) obj;
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
        return "Soort{" + "id=" + id + ", naam=" + naam + '}';
    }
    
}
