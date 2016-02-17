/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

/**
 *
 * @author yannick.thibos
 */
public class Klant implements Runnable {

    private Stapel stapel;
    private String naam;

    public Klant(Stapel stapel, String naam) {
        this.stapel = stapel;
        this.naam = naam;
    }

    @Override
    public void run() {

        int aantalGegeten = 0;
        
        while (aantalGegeten < 5) {
            if (stapel.isNietLeeg()) {
                stapel.neemAf(naam);
                System.out.println(naam + " nam 1 af. Aantal gegeten: " + aantalGegeten + "\t\t\t" + stapel.getAantal());
                ++aantalGegeten;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }

        System.out.println(naam + " VOLDAAN!");
        
    }

}
