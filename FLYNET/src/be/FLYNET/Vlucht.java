/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET;

import be.FLYNET.personeel.CabinCrew;
import be.FLYNET.personeel.CockpitCrew;
import be.FLYNET.personeel.VliegendPersoneelslid;
import be.FLYNET.vloot.LuchtVaartuig;
import be.FLYNET.vloot.VliegMaatschappij;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public final class Vlucht implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int vluchtID;
    private String bestemming;
    private int duurtijdInDagen;
    private VliegMaatschappij vliegMaatschappij;
    private LuchtVaartuig toestel;
    private List<VliegendPersoneelslid> personeel;

    public Vlucht(int vluchtID, String bestemming, int duurtijdInDagen,
            VliegMaatschappij vliegMaatschappij, LuchtVaartuig toestel,
            List<VliegendPersoneelslid> personeel) {
        setVluchtID(vluchtID);
        setBestemming(bestemming);
        setDuurtijdInDagen(duurtijdInDagen);
        setVliegMaatschappij(vliegMaatschappij);
        setToestel(toestel);
        this.personeel = new ArrayList<>();

        if (personeel != null) {
            personeel.stream().forEach(this.personeel::add);
        }
    }

    public int getVluchtID() {
        return vluchtID;
    }

    private void setVluchtID(int vluchtID) {
        this.vluchtID = vluchtID;
    }

    public String getBestemming() {
        return bestemming;
    }

    private void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public int getDuurtijdInDagen() {
        return duurtijdInDagen;
    }

    private void setDuurtijdInDagen(int duurtijdInDagen) {
        this.duurtijdInDagen = duurtijdInDagen;
    }

    public VliegMaatschappij getVliegMaatschappij() {
        return vliegMaatschappij;
    }

    private void setVliegMaatschappij(VliegMaatschappij vliegMaatschappij) {
        this.vliegMaatschappij = vliegMaatschappij;
    }

    public LuchtVaartuig getToestel() {
        return toestel;
    }

    private void setToestel(LuchtVaartuig toestel) {
        this.toestel = toestel;
    }

    public List<VliegendPersoneelslid> getPersoneel() {
        return personeel;
    }

    private void setPersoneel(List<VliegendPersoneelslid> personeel) {
        this.personeel = personeel;
    }

    public final BigDecimal berekenVluchtKost() {
        BigDecimal totaleKostprijs = BigDecimal.ZERO;
        BigDecimal aantalDagen = BigDecimal.valueOf(duurtijdInDagen);

        // Vermenigvuldig het aantal dagen vliegen met de kostprijs per dag
        // v/h vliegtuig
        totaleKostprijs = totaleKostprijs.add(
                toestel.berekenTotaleKostprijsPerDag().multiply(aantalDagen)
        );

        // Vermenigvuldig het aantal dagen vliegen met de kostprijs per dag
        // per personeelslid aan boord
        for (VliegendPersoneelslid vliegendPersoneelslid : personeel) {
           totaleKostprijs = totaleKostprijs.add(
                        ((IKost) vliegendPersoneelslid)
                        .berekenTotaleKostprijsPerDag().multiply(aantalDagen)
                );
//            if (vliegendPersoneelslid instanceof CabinCrew) {
//                totaleKostprijs = totaleKostprijs.add(
//                        ((CabinCrew) vliegendPersoneelslid)
//                        .berekenTotaleKostprijsPerDag().multiply(aantalDagen)
//                );
//            } else if (vliegendPersoneelslid instanceof CockpitCrew) {
//                totaleKostprijs = totaleKostprijs.add(
//                        ((CockpitCrew) vliegendPersoneelslid)
//                        .berekenTotaleKostprijsPerDag().multiply(aantalDagen)
//                );
//            } else {
//                totaleKostprijs = totaleKostprijs.add(
//                        vliegendPersoneelslid.getBasisKostprijsPerDag()
//                        .multiply(aantalDagen));
//            }
        }

        return totaleKostprijs;
    }

    private BigDecimal totalePersoneelskost() {
        BigDecimal totaal = BigDecimal.ZERO;

        for (VliegendPersoneelslid crewlid : personeel) {
            if (crewlid instanceof CabinCrew) {
                totaal = totaal.add(((CabinCrew) crewlid).berekenTotaleKostprijsPerDag()
                        .multiply(BigDecimal.valueOf(getDuurtijdInDagen())));
            }
            if (crewlid instanceof CockpitCrew) {
                totaal = totaal.add(((CockpitCrew) crewlid).berekenTotaleKostprijsPerDag()
                        .multiply(BigDecimal.valueOf(getDuurtijdInDagen())));
            }
        }

        return totaal;
    }

    public void printVluchtData() {

        System.out.print(vluchtID + ": " + getBestemming()
                + "<" + getVliegMaatschappij().getVliegMaatschappijNaam() + "> - "
                + getToestel().getType()
                + "<" + getToestel().berekenTotaleKostprijsPerDag()
                .multiply(BigDecimal.valueOf(getDuurtijdInDagen()))
                .toString() + "> - "
                + "vluchtprijs " + berekenVluchtKost()
                + " over " + getDuurtijdInDagen() + " dagen"
                + "\n");
        System.out.println("------------------------------------------");

        System.out.print("Totale personeelskost voor deze vlucht: "
                + totalePersoneelskost().toString() + "\n\n");

        System.out.print("Cockpitcrew: \n");
        personeel.stream().filter(crewlid -> crewlid instanceof CockpitCrew)
                .forEach(crewlid -> 
                    System.out.print(crewlid.getPersoneelsID() + ": "
                    + crewlid.getNaam() + " - " + crewlid.getGraad() + "\n"
                    + "Certificaten: " + crewlid.getCertificaten() + "\n"
                    + "Vlieguren: " + ((CockpitCrew)crewlid).getVliegUren() + "\n"
                    + "Kostprijs deze vlucht: " + 
                            ((CockpitCrew)crewlid).berekenTotaleKostprijsPerDag()
                            .multiply(BigDecimal.valueOf(getDuurtijdInDagen()))+ "\n\n"));
        
        System.out.print("Cabincrew: \n");
        personeel.stream().filter(crewlid -> crewlid instanceof CabinCrew)
                .forEach(crewlid -> 
                    System.out.print(crewlid.getPersoneelsID() + ": "
                    + crewlid.getNaam() + " - " + crewlid.getGraad() + "\n"
                    + "Certificaten: " + crewlid.getCertificaten() + "\n"
                    + "Werkpositie: " + ((CabinCrew)crewlid).getWerkpositie() + "\n"
                    + "Kostprijs deze vlucht: " + 
                            ((CabinCrew)crewlid).berekenTotaleKostprijsPerDag()
                            .multiply(BigDecimal.valueOf(getDuurtijdInDagen()))+ "\n\n"));

    }

    @Override
    public String toString() {
        return "Vlucht{\n" 
                + "vluchtID=" + vluchtID + ", bestemming=" + bestemming 
                + ", duurtijdInDagen=" + duurtijdInDagen + ", vliegMaatschappij=" + vliegMaatschappij + ", toestel=" + toestel + ", personeel=" + personeel + '}';
    }

}
