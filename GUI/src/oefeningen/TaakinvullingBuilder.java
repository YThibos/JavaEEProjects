/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefeningen;

import java.util.Date;


public class TaakinvullingBuilder {

    private Date datum;
    private String naam;
    private String functie;
    private String activiteit;
    private int aantalUren;

    public TaakinvullingBuilder() {
    }

    public TaakinvullingBuilder setDatum(Date datum) {
        this.datum = datum;
        return this;
    }

    public TaakinvullingBuilder setNaam(String naam) {
        this.naam = naam;
        return this;
    }

    public TaakinvullingBuilder setFunctie(String functie) {
        this.functie = functie;
        return this;
    }

    public TaakinvullingBuilder setActiviteit(String activiteit) {
        this.activiteit = activiteit;
        return this;
    }

    public TaakinvullingBuilder setAantalUren(int aantalUren) {
        this.aantalUren = aantalUren;
        return this;
    }

    public Taakinvulling createTaakinvulling() {
        return new Taakinvulling(datum, naam, functie, activiteit, aantalUren);
    }
    
}
