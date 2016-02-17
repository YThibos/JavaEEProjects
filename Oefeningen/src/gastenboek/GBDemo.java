/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastenboek;

import com.sun.org.glassfish.gmbal.GmbalMBean;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class GBDemo {

    public static void main(String[] args) {

        GBManager gastenboekManager = new GBManager();
        Gastenboek mijnGastenboek = gastenboekManager.laden();

        Scanner console = new Scanner(System.in);
        char input;

        do {

            System.out.println("*** GASTENBOEK MENU ***");
            System.out.println("1. Gastenboek lezen");
            System.out.println("2. Berichten schrijven");
            System.out.println("3. <QUIT>");
            System.out.print(">>");

            input = console.nextLine().charAt(0);
            System.out.println();
            
            switch (input) {
                case '1':

                    // Laat de manager het gastenboek uit het bestand laden naar mijnGastenboek
                    // mijnGastenboek = gastenboekManager.laden();

                    // Print het gastenboek
                    gastenboekManager.printGastenboek(mijnGastenboek);
                    break;

                case '2':

                    String naam,
                     bericht;

                    // Vraag en stel de input samen van een nieuw bericht
                    System.out.println("--Nieuw bericht--");
                    System.out.print("Naam: ");
                    naam = console.nextLine();
                    System.out.println("\nBericht: ");
                    bericht = console.nextLine();

                    // Schrijf het bericht weg naar het gastenboek, 
                    //en laat de manager meteen naar file wegschrijven
                    gastenboekManager.nieuwBericht(mijnGastenboek, naam, bericht);
                    gastenboekManager.opslaan(mijnGastenboek);

                    break;

                case '3':
                    // QUIT
                    return;
                case '4':
                    Gastenboek leeg = new Gastenboek();
                    gastenboekManager.opslaan(leeg);
                    System.out.println("Gastenboek leeg");
                default:
                    System.out.println("Ongeldige keuze.\n");
            }

        } while (input != '3');

    }

}
