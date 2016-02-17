/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPFOefeningen;


public class PersonenwagenBuilder {

    private String polishouder;
    private float kostprijs;
    private int pk;
    private float gemVerbruik;
    private String nummerplaat;
    private int aantalDeuren;
    private int aantalPassagiers;

    public PersonenwagenBuilder() {
    }

    public PersonenwagenBuilder setPolishouder(String polishouder) {
        this.polishouder = polishouder;
        return this;
    }

    public PersonenwagenBuilder setKostprijs(float kostprijs) {
        this.kostprijs = kostprijs;
        return this;
    }

    public PersonenwagenBuilder setPk(int pk) {
        this.pk = pk;
        return this;
    }

    public PersonenwagenBuilder setGemVerbruik(float gemVerbruik) {
        this.gemVerbruik = gemVerbruik;
        return this;
    }

    public PersonenwagenBuilder setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
        return this;
    }

    public PersonenwagenBuilder setAantalDeuren(int aantalDeuren) {
        this.aantalDeuren = aantalDeuren;
        return this;
    }

    public PersonenwagenBuilder setAantalPassagiers(int aantalPassagiers) {
        this.aantalPassagiers = aantalPassagiers;
        return this;
    }

    public Personenwagen createPersonenwagen() {
        return new Personenwagen(polishouder, kostprijs, pk, gemVerbruik, nummerplaat, aantalDeuren, aantalPassagiers);
    }
    
}
