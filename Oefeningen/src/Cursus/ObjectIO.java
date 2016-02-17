/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class ObjectIO {
    
    public static void main(String[] args) {
        
        FileOutputStream fout = null;
        ObjectOutputStream obj = null;
        
        try {
            fout = new FileOutputStream("werknemers.dat");
            obj = new ObjectOutputStream(fout);
            
            Werknemer magazijnier = new Werknemer("Jos", "Deman", new BigDecimal(1200));
            Werknemer telefoniste = new Werknemer("Juliette", "Devrouw", new BigDecimal(1250));
            Werknemer directeur = new Werknemer("Willy", "Denbaas", new BigDecimal(5000));
            
            Werknemer[] werknemers = new Werknemer[] {magazijnier, telefoniste, directeur};
            
            obj.writeObject(werknemers);
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (!(obj == null)) {
                try {
                    obj.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        
        FileInputStream fin = null;
        ObjectInputStream objin = null;
        
        try {
            
            fin = new FileInputStream("werknemers.dat");
            objin = new ObjectInputStream(fin);
            
            Werknemer[] werknemers = (Werknemer[]) objin.readObject();
            for (Werknemer werknemer : werknemers) {
                System.out.println(werknemer.getVolledigeNaam() + ": " + werknemer.getWedde());
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (!(objin == null)) {
                try {
                    objin.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        
    }
    
}
