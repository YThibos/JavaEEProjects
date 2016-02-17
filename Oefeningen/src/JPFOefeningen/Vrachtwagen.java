package JPFOefeningen;

public class Vrachtwagen extends Voertuig implements Vervuiler {

    private float maxLading;    

    public Vrachtwagen() {
        super();
        maxLading = 10000;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Float.floatToIntBits(this.maxLading);
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
        final Vrachtwagen other = (Vrachtwagen) obj;
        return Float.floatToIntBits(this.maxLading) == Float.floatToIntBits(other.maxLading);
    }

    public Vrachtwagen(String polishouder, float kostprijs, int pk, float gemVerbruik, String nummerplaat, float maxLading) {
        super(polishouder, kostprijs, pk, gemVerbruik, nummerplaat);
        if (isValidMaxLading(maxLading)) {
            this.maxLading = maxLading;
        } else {
            this.maxLading = 10000;
        }
    }

    private boolean isValidMaxLading(float lading) {
        if (lading >= 0) {
            return true;
        }
        return false;
    }

    public float getMaxLading() {
        return maxLading;
    }

    public void setMaxLading(float maxLading) {
        this.maxLading = maxLading;
    }

    @Override
    public String toString() {
        return super.toString() + " " + maxLading;
    }

    @Override
    public void toon() {
        super.toon();
        System.out.println("Maximum lading: " + maxLading);
        System.out.println("Vervuilingsfactor: " + geefVervuiling());
    }

    @Override
    public double getKyotoScore() {
        return (gemVerbruik * pk) / maxLading;
    }

    @Override
    public double geefVervuiling() {
        return getKyotoScore() * 20;
    }

}
