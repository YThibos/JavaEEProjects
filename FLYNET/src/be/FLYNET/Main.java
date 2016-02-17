/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET;

import be.FLYNET.personeel.Adres;
import be.FLYNET.personeel.AdresException;
import be.FLYNET.personeel.CabinCrew;
import be.FLYNET.personeel.Certificaat;
import be.FLYNET.personeel.CockpitCrew;
import be.FLYNET.personeel.Graad;
import be.FLYNET.personeel.PersoneelsException;
import be.FLYNET.personeel.VliegendPersoneelslid;
import be.FLYNET.vloot.LuchtVaartuig;
import be.FLYNET.vloot.LuchtVaartuigException;
import be.FLYNET.vloot.PassagiersVliegtuig;
import be.FLYNET.vloot.VliegMaatschappij;
import be.FLYNET.vloot.VliegMaatschappijException;
import be.FLYNET.vloot.VrachtVliegtuig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class Main {
    
    private static File PERSONEELSFILE = new File("personeel.dat");
    private static Path PERSONEELSFILE_PATH = Paths.get("personeel.dat");

    public static void main(String[] args) {

        // Lijsten met certificaten per crewlid voorbereiden
        List<Certificaat> kirkCertifi = new ArrayList<>();
        kirkCertifi.add(Certificaat.PPL);
        kirkCertifi.add(Certificaat.ATPL);
        kirkCertifi.add(Certificaat.CPL);

        List<Certificaat> spockCertifi = new ArrayList<>();
        spockCertifi.add(Certificaat.PPL);
        spockCertifi.add(Certificaat.EHBO);

        List<Certificaat> suluCertifi = new ArrayList<>();
        suluCertifi.add(Certificaat.FIRE);
        suluCertifi.add(Certificaat.EVAC);

        List<Certificaat> skyCertifi = new ArrayList<>();
        skyCertifi.add(Certificaat.FIRE);
        skyCertifi.add(Certificaat.EHBO);

        // Adressen aanmaken
        Adres keizerslaan11;
        Adres europalaan37;
        try {
            keizerslaan11 = new Adres("Keizerslaan 11", "1000", "Brussel");
            europalaan37 = new Adres("Europalaan 37", "3600", "Genk");
        } catch (AdresException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            keizerslaan11 = null;
            europalaan37 = null;
        }

        // Crewmembers klaarmaken
        CockpitCrew kirk, spock;
        CabinCrew sulu, skywalker;

        try {
            kirk = new CockpitCrew("001", "Captain Kirk", BigDecimal.valueOf(500), europalaan37, Graad.Captain, kirkCertifi, 5000);
            spock = new CockpitCrew("002", "Spock", BigDecimal.valueOf(400), keizerslaan11, Graad.SecondOfficer, spockCertifi, 4500);
            sulu = new CabinCrew("003", "Hikaru Sulu", BigDecimal.valueOf(300), europalaan37, Graad.Steward, suluCertifi, "Deur1");
            skywalker = new CabinCrew("004", "Skywalker", BigDecimal.valueOf(300), keizerslaan11, Graad.Purser, skyCertifi, "nooduitgang");
        } catch (PersoneelsException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            kirk = null;
            spock = null;
            sulu = null;
            skywalker = null;
        }

        // Vliegtuigen initialiseren
        PassagiersVliegtuig airbus, boeing;
        VrachtVliegtuig british, antonov;
        try {
            airbus = new PassagiersVliegtuig("AirbusA319", 880, 6850, BigDecimal.valueOf(1000), 141);
            boeing = new PassagiersVliegtuig("Boeing787", 913, 15700, BigDecimal.valueOf(2000), 330);
            british = new VrachtVliegtuig("BritishAerospace146", 750, 1600, BigDecimal.valueOf(600), 42);
            antonov = new VrachtVliegtuig("AntonovAn-225", 800, 15400, BigDecimal.valueOf(1500), 425);
        } catch (LuchtVaartuigException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            airbus = null;
            boeing = null;
            british = null;
            antonov = null;
        }

        // Vloten klaarzetten
        List<LuchtVaartuig> baVloot = new ArrayList<>();
        baVloot.add(airbus);
        baVloot.add(boeing);
        baVloot.add(british);

        List<LuchtVaartuig> tntVloot = new ArrayList<>();
        tntVloot.add(antonov);

        List<LuchtVaartuig> jafVloot = new ArrayList<>();
        jafVloot.add(boeing);
        jafVloot.add(british);

        List<LuchtVaartuig> thomasVloot = new ArrayList<>();
        thomasVloot.add(airbus);
        thomasVloot.add(boeing);

        // Maatschappijen oprichten
        VliegMaatschappij brusselsairlines, tntairways, jetairfly, thomascook;
        try {
            brusselsairlines = new VliegMaatschappij(1, "BrusselsAirlines", baVloot);
            tntairways = new VliegMaatschappij(2, "TNTAirways", tntVloot);
            jetairfly = new VliegMaatschappij(3, "Jetairfly", jafVloot);
            thomascook = new VliegMaatschappij(4, "ThomasCook", thomasVloot);
        } catch (VliegMaatschappijException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            brusselsairlines = null;
            tntairways = null;
            jetairfly = null;
            thomascook = null;
        }

        // Crews samenstellen
        List<VliegendPersoneelslid> newyorkCrew = new ArrayList<>();
        List<VliegendPersoneelslid> beijingCrew = new ArrayList<>();
        List<VliegendPersoneelslid> sydneyCrew = new ArrayList<>();
        List<VliegendPersoneelslid> singaporeCrew = new ArrayList<>();

        newyorkCrew.add(kirk);
        newyorkCrew.add(spock);
        newyorkCrew.add(sulu);
        newyorkCrew.add(skywalker);

        beijingCrew.add(kirk);
        beijingCrew.add(skywalker);

        sydneyCrew.add(kirk);
        sydneyCrew.add(spock);
        sydneyCrew.add(sulu);

        singaporeCrew.add(spock);

        // Vluchten boeken
        Vlucht newyork = new Vlucht(1, "New York", 2, brusselsairlines, boeing, newyorkCrew);
        Vlucht beijing = new Vlucht(2, "Beijing", 1, tntairways, antonov, beijingCrew);
        Vlucht sydney = new Vlucht(3, "Sydney", 3, thomascook, airbus, sydneyCrew);
        Vlucht singapore = new Vlucht(4, "Singapore", 2, brusselsairlines, british, singaporeCrew);

        List<Vlucht> vluchten = new ArrayList<>();
        vluchten.add(newyork);
        vluchten.add(beijing);
        vluchten.add(sydney);
        vluchten.add(singapore);

        System.out.println("==================================");
        System.out.println("Vrachtvluchten");
        System.out.println("==================================");

        vluchten.stream()
                .filter(vlucht -> vlucht.getToestel() instanceof VrachtVliegtuig)
                .forEach(vlucht -> vlucht.printVluchtData());//Vlucht::printVluchtData ; vlucht -> ((Vlucht)vlucht).printVluchtData();
        
        System.out.println("==================================");
        System.out.println("Passagiersvluchten");
        System.out.println("==================================");

        vluchten.stream()
                .filter(vlucht -> vlucht.getToestel() instanceof PassagiersVliegtuig)
                .forEach(Vlucht::printVluchtData);
        
        System.out.println("Naar bestand 'personeel.dat schrijven ... ");
        schrijfNaarBestand(vluchten);
        System.out.println(".. 'personeel.dat' weggeschreven.");
        
        System.out.println("Inlezen van 'personeel.dat' ...");
        Object gelezenObject = leesVanBestand();
        
        ArrayList<Vlucht> gelezenVluchten;
        if (gelezenObject != null) {
            gelezenVluchten = (ArrayList<Vlucht>) gelezenObject;
        } else {
            gelezenVluchten = null;
        }
        
        for (Vlucht vlucht : gelezenVluchten) {
            vlucht.printVluchtData();
        }
    }
    
    private static Object leesVanBestand() {
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PERSONEELSFILE))){
            Object o = in.readObject();
            return o;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        
    }
    
    private static void schrijfNaarBestand(List<Vlucht> o) {
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PERSONEELSFILE))){
            out.writeObject(o);
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }

}
