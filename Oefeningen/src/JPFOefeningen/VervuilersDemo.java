/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPFOefeningen;

/**
 *
 * @author yannick.thibos
 */
public class VervuilersDemo {
    
    public static void main (String[] args) {

        Vervuiler[] v = new Vervuiler[10];
        
        v[0] = new Personenwagen();
        v[1] = new Vrachtwagen();
        v[2] = new Stookketel(1.0F);
        v[3] = new PersonenwagenBuilder().setPolishouder("ikke").setKostprijs(1000.0F).setPk(100).setGemVerbruik(5.0F).setNummerplaat("BLA").setAantalDeuren(5).setAantalPassagiers(5).createPersonenwagen();
        v[4] = new Vrachtwagen("jij", 20000F, 200, 15.0F, "random", 15000F);
        
        for (Vervuiler obj : v) { 
            if (obj != null){
            System.out.println(obj.geefVervuiling());                
            } else {
                System.out.println("nulleks");
            }
        }
        
    }
    
}
