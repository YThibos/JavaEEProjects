
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Land {

    private String landcode, landnaam, hoofdstad;
    private int aantalInwoners, oppervlakte;

    public Land(String landcode, String landnaam, String hoofdstad, int aantalInwoners, int oppervlakte) {
        this.landcode = landcode;
        this.landnaam = landnaam;
        this.hoofdstad = hoofdstad;
        this.aantalInwoners = aantalInwoners;
        this.oppervlakte = oppervlakte;
    }

    
    public String getNaam() {
        return landnaam;
    }
    
    public double bevolkingsdichtheid() {
        return ((double)aantalInwoners / oppervlakte);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.landcode);
        hash = 83 * hash + Objects.hashCode(this.landnaam);
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
        final Land other = (Land) obj;
        if (!Objects.equals(this.landcode, other.landcode)) {
            return false;
        }
        if (!Objects.equals(this.landnaam, other.landnaam)) {
            return false;
        }
        return true;
    }
}
