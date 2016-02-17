
public abstract class Rekening {

    private String rekeningNr;
    private double saldo;

    public Rekening(String reknr) throws RekeningException {
        isRekNrOk(reknr);
        rekeningNr = reknr;
        saldo = 0;
    }

    public void storten(double bedrag) {
        saldo += bedrag;
    }

    public void afhalen(double bedrag) {
        saldo -= bedrag;
    }

    public void overschrijven(Rekening rek, double bedrag) throws RekeningException {        
        afhalen(bedrag);
        rek.storten(bedrag);
    }

    public double geefSaldo() {
        return saldo;
    }

    @Override
    // Is een annotation: dit komt later aan bod
    public String toString() {
        return rekeningNr + ", " + saldo;
    }

    private void isRekNrOk(String reknr) throws RekeningException {
        if (reknr.length() == 14) {
//            int d1 = Integer.parseInt(reknr.substring(0, 3));
//            int d2 = Integer.parseInt(reknr.substring(4, 11));
//            int d3 = Integer.parseInt(reknr.substring(12, 14));
//            
//            long deeltal = d1 * 10000000L + d2;
//            int rest = (int)(deeltal % 97);
//            if (rest == 0) rest = 97;
//            
//            if (!(rest == d3))
//                throw new RekeningException("Ongeldig rekeningnummer! ", reknr);
//            
        } 
        else {
            throw new RekeningException("Rekeningnummer moet uit 14 cijfers bestaan!", rekeningNr);
        }
    }

}
