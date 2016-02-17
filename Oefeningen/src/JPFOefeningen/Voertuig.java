package JPFOefeningen;

import java.util.Objects;

public abstract class Voertuig implements Privaat, Milieu, Comparable {

    protected String polishouder;
    protected float kostprijs;
    protected int pk;
    protected float gemVerbruik;
    protected String nummerplaat;

    public Voertuig() {
        polishouder = "onbepaald";
        kostprijs = 0;
        pk = 0;
        gemVerbruik = 0;
        nummerplaat = "onbepaald";
    }

    public Voertuig(String polishouder, float kostprijs, int pk, float gemVerbruik, String nummerplaat) {
        this.polishouder = polishouder;
        this.kostprijs = kostprijs;
        this.pk = pk;
        this.gemVerbruik = gemVerbruik;
        this.nummerplaat = nummerplaat;
    }

    public String getPolishouder() {
        return polishouder;
    }

    public void setPolishouder(String polishouder) {
        this.polishouder = polishouder;
    }

    public float getKostprijs() {
        return kostprijs;
    }

    public void setKostprijs(float kostprijs) {
        this.kostprijs = kostprijs;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public float getGemVerbruik() {
        return gemVerbruik;
    }

    public void setGemVerbruik(float gemVerbruik) {
        this.gemVerbruik = gemVerbruik;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    @Override
    public String toString() {
        return polishouder + " " + kostprijs + " " + pk + " " + gemVerbruik + " " + nummerplaat + " " + getKyotoScore();
    }

    public void toon() {
        System.out.println(polishouder + " :: " + nummerplaat);
        System.out.println("Kostprijs: " + kostprijs);
        System.out.println("PK's: " + pk);
        System.out.println("Gemiddeld verbruik: " + gemVerbruik);
        System.out.println("Kyoto score: " + getKyotoScore());
    }

    public abstract double getKyotoScore();

    @Override
    public void geefPrivaatData() {
        System.out.println(polishouder + " " + nummerplaat);
    }

    @Override
    public void geefMilieuData() {
        System.out.println(pk + " " + kostprijs + " " + gemVerbruik);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Voertuig)) {
            return false;
        }
        Voertuig v = (Voertuig) o;
        return nummerplaat.equals(v.nummerplaat);
    }
    
    @Override 
    public int compareTo(Object o) {
        // Sorteren op nummerplaat
        Voertuig v = (Voertuig) o;
        return nummerplaat.compareTo(v.nummerplaat);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nummerplaat);
        return hash;
    }
    
}
