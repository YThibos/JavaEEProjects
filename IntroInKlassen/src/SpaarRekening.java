public class SpaarRekening extends Rekening {

	private static double intrest;

	public SpaarRekening(String reknr, double intrest) throws RekeningException {
		super(reknr);
		this.intrest = intrest;
	}

	@Override
	public double geefSaldo() {
		storten(berekenRente());
		return super.geefSaldo();
	}

	private double berekenRente() {
		return super.geefSaldo() * intrest / 100;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + intrest;
	}

	public void toon() {
		System.out.println("Dit is een spaarrekening waarop " + intrest
				+ "% intrest gegeven wordt.");
	}
}
