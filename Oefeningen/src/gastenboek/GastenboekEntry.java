/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastenboek;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yannick.thibos
 */
class GastenboekEntry implements Comparable<GastenboekEntry>, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Date datum;
    private String schrijver;
    private String boodschap;

    public GastenboekEntry(String schrijver, String boodschap) {
        this.datum = new Date();
        this.schrijver = schrijver;
        this.boodschap = boodschap;
    }

    public Date getDatum() {
        return datum;
    }

    public String getSchrijver() {
        return schrijver;
    }

    public String getBoodschap() {
        return boodschap;
    }

    @Override
    public String toString() {
        return "\n" + "Datum: " + datum + "\tSchrijver: " + schrijver + "\n\"" + boodschap + "\"\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.datum);
        hash = 89 * hash + Objects.hashCode(this.schrijver);
        hash = 89 * hash + Objects.hashCode(this.boodschap);
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
        final GastenboekEntry other = (GastenboekEntry) obj;
        if (!Objects.equals(this.schrijver, other.schrijver)) {
            return false;
        }
        if (!Objects.equals(this.boodschap, other.boodschap)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(GastenboekEntry o) {
        if (equals(o)) return 0;
        return datum.compareTo(o.getDatum());
    }
    
}
