
public class ZichtRekening extends Rekening {

	private int maxKrediet;
	
	public ZichtRekening(String reknr, int maxKred) throws RekeningException {
		super(reknr);
		maxKrediet = maxKred;
	}
	
	@Override
	public void afhalen (double bedrag) {
		if (geefSaldo() - bedrag + maxKrediet > 0) super.afhalen(bedrag);
	}

	
	
}
