/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class InsectenLezer implements Runnable {
    
    private String bestandsNaam;
    private BigDecimal maximum = new BigDecimal(3);
    private PrintStream stream;
    
    private int teller;
    
    public InsectenLezer(String bestandsNaam, PrintStream stream) {
        this.stream = stream;
        this.bestandsNaam = bestandsNaam;
    }
    
    public int getTeller() {
        return teller;
    }
    
    @Override
    public void run() {
        
        BufferedReader reader = null;
        
        try {
            
            reader = new BufferedReader(new FileReader(bestandsNaam));
            String regel = reader.readLine();
            
            while (regel != null) {
                String[] tokens = regel.split(";");
                BigDecimal prijs = new BigDecimal(tokens[1]);
                if (prijs.compareTo(maximum) <= 0) {
                    
                    ++teller;
                }
                regel = reader.readLine();
            }
            
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
        
    }
    
}
