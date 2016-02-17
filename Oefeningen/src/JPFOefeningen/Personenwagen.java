package JPFOefeningen;

public class Personenwagen extends Voertuig implements Vervuiler {

    private int aantalDeuren;
    private int aantalPassagiers;

    public Personenwagen() {
        super();
        aantalDeuren = 4;
        aantalPassagiers = 5;
    }

    public Personenwagen(String polishouder, float kostprijs, int pk, float gemVerbruik, String nummerplaat,
            int aantalDeuren, int aantalPassagiers) {
        super(polishouder, kostprijs, pk, gemVerbruik, nummerplaat);
        if (notNeg(aantalDeuren)) {
            this.aantalDeuren = aantalDeuren;
        } else {
            this.aantalDeuren = 4;
        }
        if (notNeg(aantalPassagiers)) {
            this.aantalPassagiers = aantalPassagiers;
        } else {
            this.aantalPassagiers = 5;
        }
    }

    public int getAantalDeuren() {
        return aantalDeuren;
    }

    public void setAantalDeuren(int aantalDeuren) {
        this.aantalDeuren = aantalDeuren;
    }

    public int getAantalPassagiers() {
        return aantalPassagiers;
    }

    public void setAantalPassagiers(int aantalPassagiers) {
        this.aantalPassagiers = aantalPassagiers;
    }

    private boolean notNeg(int x) {
        if (x >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " " + aantalDeuren + " " + aantalPassagiers + " " + getKyotoScore();
    }

    @Override
    public void toon() {
        super.toon();
        System.out.println("Aantal deuren: " + aantalDeuren);
        System.out.println("Aantal passagiers: " + aantalPassagiers);
        System.out.println("Vervuilingsfactor: " + geefVervuiling());
    }

    @Override
    public double getKyotoScore() {
        return (gemVerbruik * pk) / aantalPassagiers;
    }

    @Override
    public double geefVervuiling() {
        return getKyotoScore() * 5;
    }

}
