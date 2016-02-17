/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

/**
 *
 * @author yannick.thibos
 */
public class Rechthoek implements Comparable<Rechthoek>{
    
    private int lengte, breedte;
    
    Rechthoek(int lengte, int breedte) {
        this.lengte = lengte;
        this.breedte = breedte;
    }
    
    public int oppervlakte() {
        return lengte*breedte;
    }

    @Override
    public int compareTo(Rechthoek o) {
        if (this.equals(o)) {
            return 0;
        }
        else {
            return this.oppervlakte() - o.oppervlakte();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.lengte;
        hash = 89 * hash + this.breedte;
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
        final Rechthoek other = (Rechthoek) obj;
        if (this.lengte != other.lengte) {
            return false;
        }
        if (this.breedte != other.breedte) {
            return false;
        }
        return true;
    }
    
    
}
