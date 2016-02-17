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
public class Bakker implements Runnable {
    
    private Stapel stapel;
    private String naam;

    public Bakker(Stapel stapel, String naam) {
        this.stapel = stapel;
        this.naam = naam;
    }
    
    @Override
    public void run() {
    
        for (int i = 1; i <= 10; i++) {
            stapel.voegtoe(naam);
            System.out.println(naam + " legde 1 op de stapel. Aantal gelegd: " + i  + "\t\t\t" + stapel.getAantal());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        
        System.out.println(naam + "UITGEBAKKEN!");
        
    }
    
}
