/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefeningen;

import java.util.Date;

/**
 *
 * @author yannick.thibos
 */
public class Taakinvulling {

    private Date datum;
    private String naam, functie, activiteit;
    private int aantalUren;

    public Taakinvulling(Date datum, String naam, String functie, String activiteit, int aantalUren) {
        this.datum = datum;
        this.naam = naam;
        this.functie = functie;
        this.activiteit = activiteit;
        this.aantalUren = aantalUren;
    }

    @Override
    public String toString() {
        return "-- Taakinvulling --\n" + "Datum: " + datum + "\tNaam: " + naam + 
                "\nFunctie: " + functie + "\tActiviteit: " + activiteit + "\nAantal uren: " + aantalUren;
    }

}
