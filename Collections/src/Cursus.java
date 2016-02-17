
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author yannick.thibos
 */
public class Cursus implements Comparable<Cursus> {
    
    private int cursusNr;
    private String cursusNaam;
    private int prijs;
    
    public Cursus(int nr, String naam, int prijs) {
        cursusNr = nr;
        cursusNaam = naam;
        this.prijs = prijs;
    }

    public int getCursusNr() {
        return cursusNr;
    }

    public void setCursusNr(int cursusNr) {
        this.cursusNr = cursusNr;
    }

    public String getCursusNaam() {
        return cursusNaam;
    }

    public void setCursusNaam(String cursusNaam) {
        this.cursusNaam = cursusNaam;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
    
    @Override
    public String toString() {
        return (cursusNr + "\t" + cursusNaam + "\t" + prijs);
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cursus)) {
            return false;
        }
        Cursus c = (Cursus)o;
        return cursusNr == c.getCursusNr();
    }
    
    @Override
    public int hashCode() {
        return cursusNr;
    }

   @Override
   public int compareTo(Cursus c) {
       // Sorteren op cursusnr, consistent met equals().
       if (cursusNr < c.getCursusNr()) {
           return -1;
       } else if ( cursusNr > c.getCursusNr()) {
           return 1;
       } else {
           return 0;
       }
   }
   
   public static Comparator<Cursus> getDalendePrijsComparator() {
       return new Comparator<Cursus> () {

           @Override
           public int compare(Cursus c1, Cursus c2) {
               return c2.getPrijs() == c1.getPrijs() ? -1 : c2.getPrijs() - c1.getPrijs();
           }
           
       };
   }
    
}
