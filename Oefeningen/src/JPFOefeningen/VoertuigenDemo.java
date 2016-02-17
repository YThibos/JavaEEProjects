package JPFOefeningen;


public class VoertuigenDemo {

	public static void main (String[] args) {
		
		Voertuig[] wagens = new Voertuig[10];
		
		wagens[0] = new Personenwagen();
		wagens[1] = new PersonenwagenBuilder().setPolishouder("Yannick").setKostprijs(4000F).setPk(111).setGemVerbruik(5.5F).setNummerplaat("1-GSY-595").setAantalDeuren(5).setAantalPassagiers(5).createPersonenwagen();
		wagens[2] = new PersonenwagenBuilder().setPolishouder("Negdeuren en pass").setKostprijs(10000F).setPk(500).setGemVerbruik(10.0F).setNummerplaat("Debus").setAantalDeuren(-100).setAantalPassagiers(-50).createPersonenwagen();
		wagens[3] = new Vrachtwagen();
		wagens[4] = new Vrachtwagen("Josdentrucker", 20000, 200, 20.0F, "PUFPUF", 15000);
		wagens[5] = new Vrachtwagen("Neglading", 50000F, 400, 30.0F, "POEFPOEF", -100);
		
            for (Voertuig wagen : wagens) {
                if (wagen != null) {
                    System.out.println("orgineel:" + wagen);
                    wagen.toon();
                    System.out.println();
                }
            }
            for (Voertuig wagen : wagens) {
                if (wagen != null) {
                    System.out.println("in lus :" + wagen);
                    wagen = null;
                    if (wagen != null) {                        
                    wagen.toon();
                    } else {
                        System.out.println("geen wagen");
                    }
                    System.out.println();
                }
            }
            for (Voertuig wagen : wagens) {
                if (wagen != null) {
                    System.out.println("na lus:" + wagen);
                    wagen.toon();
                    System.out.println();
                }
            }
		
	}
	
}
