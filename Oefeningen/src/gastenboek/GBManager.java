/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastenboek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class GBManager {

    private static final String FILENAME = "C:\\JPFProjecten\\gastenboek.dat";

    public void opslaan(Gastenboek gastenboek) {

        FileOutputStream fout = null;
        ObjectOutputStream objOut = null;

        try {

            fout = new FileOutputStream(FILENAME, false);
            objOut = new ObjectOutputStream(fout);

            objOut.writeObject(gastenboek.getEntries());

        } catch (IOException e) {
            System.out.println("***Exception caught writing guestbook to " + FILENAME + "***");
            System.out.println(e.getMessage());
        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException e) {
                    System.out.println("***Exception caught closing " + FILENAME + "***");
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public Gastenboek laden() {

        File file = new File(FILENAME);

        FileInputStream fin = null;
        ObjectInputStream objIn = null;

        if (file.exists()) {
            try {

                fin = new FileInputStream(file);
                objIn = new ObjectInputStream(fin);
                
                
                Gastenboek gastenboek = new Gastenboek();
                List<GastenboekEntry> entries = (List<GastenboekEntry>) objIn.readObject();
                for (GastenboekEntry entry : entries) {
                    gastenboek.addEntry(entry);
                }

                return (Gastenboek) gastenboek;

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("***Exception trying to load " + FILENAME + "***");
                System.out.println(e.getMessage());
                return null;
            } finally {
                if (fin != null && objIn != null) {
                    try {
                        fin.close();
                        objIn.close();
                    } catch (IOException e) {
                        System.out.println("***Exception caught closing FileInputStreams***");
                    }
                }
            }

        } else {
            return new Gastenboek();
        }
    }

    public void nieuwBericht(Gastenboek gastenboek, GastenboekEntry entry) {
        gastenboek.addEntry(entry);
        System.out.println("**Entry toegevoegd**");
    }

    public void nieuwBericht(Gastenboek gastenboek, String schrijver, String bericht) {
        GastenboekEntry entry = new GastenboekEntry(schrijver, bericht);
        gastenboek.addEntry(entry);
        System.out.println("**Bericht toegevoegd**\n");
    }

    public void printGastenboek(Gastenboek gastenboek) {
        System.out.println("--Het GastenBoek--");
        List<GastenboekEntry> entries = gastenboek.getEntries();
        if (entries.isEmpty()) {
            System.out.println("GEEN BERICHTEN");
        } else {
            for (GastenboekEntry entry : entries) {
                System.out.println(entry);
            }
        }
        System.out.println();
    }
}
