
import java.text.DecimalFormat;

public class BankBediende {

    public static void main(String[] args) {
        DecimalFormat fmt = new DecimalFormat("#,##0.00");
        Rekening[] rekeningen = new Rekening[3];
        try {
            rekeningen[0] = new SpaarRekening("035-0621094-44", 2.5);
            rekeningen[1] = new ZichtRekening("784-5879305-64", 1000);
            rekeningen[2] = new SpaarRekening("001-3456789-01", 5.5);
            rekeningen[0].storten(100.0);
            rekeningen[1].storten(200.0);
            rekeningen[1].afhalen(50.0);
        } catch (RekeningException re) {
            System.out.println(re.getMessage() + re.getVerkeerdRekeningNr());
        }
        for (int i = 0; i != rekeningen.length; i++) {
            if (rekeningen[i] != null) {
                System.out.println(rekeningen[i].toString());
            }
        }

    }
}
