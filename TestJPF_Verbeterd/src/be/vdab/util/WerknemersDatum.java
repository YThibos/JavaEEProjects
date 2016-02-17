/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Uitbreidende klasse van Datum, met extra functionaliteit specifiek aan
 * het bedrijf.
 *
 * @author yannick.thibos
 */
public class WerknemersDatum extends Datum implements Serializable {

    private final int DAG_VAN_OPRICHTING = 12;
    private final int MAAND_VAN_OPRICHTING = 2;
    private final int JAAR_VAN_OPRICHTING = 1977;

    /**
     * Creëert WerknemersDatum die geïnitialiseerd is op de oprichtingsdatum v/h bedrijf.
     * Maakt een nieuwe WerknemersDatum die geïnitialiseerd is op de
     * oprichtingsdatum van het bedrijf (12 februari 1977).
     */
    public WerknemersDatum() {
        try {
            setDatum(DAG_VAN_OPRICHTING, MAAND_VAN_OPRICHTING, JAAR_VAN_OPRICHTING);
        } catch (DatumException ex) {
            // KAN ZICH NIET VOORDOEN TENZIJ WAARDEN V VARIABELEN VERANDEREN
            System.err.println(ex);
        }
    }

    /**
     * Constructor die een Datum probeert te creëren met gegeven parameters.
     * Indien de datum buiten aanvaarde minimum en maximum vallen, of indien de
     * datum onbestaande is, krijgt men een DatumException geworpen.
     * 
     * @param dag       integer waarde voor een dag tussen 1 en 28/29/30/31
     * (afhankelijk van de maand en al dan niet schrikkeljaar).
     * @param maand     integer waarde voor een maand tussen 1 en 12.
     * @param jaar      integer waarde voor een jaar tussen 1977 en 4099.
     * @throws DatumException Wordt geworpen indien de gegeven datum niet bestaat
     * of niet binnen de toegelaten grenzen ligt.
     */
    public WerknemersDatum (int dag, int maand, int jaar) throws DatumException {
        checkGeldigheidDatum(dag, maand, jaar);
        // WANNEER HIER MET setDag, setMaand en setJaar WORDT GEWERKT FLIPT DE BOEL?
        setDatum(dag, maand, jaar);
    }
    
    /**
     * Controleert de meegegeven datum op geldigheid.
     * Een geldige datum is een effectief bestaande datum conform de 
     * Gregoriaanse Kalender. Controle op schrikkeljaar is aanwezig 
     * (gebruik makend de static method Datum.isSchrikkeljaar).
     * Een aanvaarde datum bevindt zich tussen 12 februari 1977 (dag van de
     * oprichting van het bedrijf) en 31 december 4099.
     * Als de datum niet aan de voorwaarden voldoet, of niet bestaat, 
     * krijgt men een DatumException geworpen.
     * 
     * @param dag       integer waarde voor een dag tussen 1 en 28/29/30/31
     * (afhankelijk van de maand en al dan niet schrikkeljaar).
     * @param maand     integer waarde voor een maand tussen 1 en 12.
     * @param jaar      integer waarde voor een jaar tussen 1977 en 4099.
     * @throws DatumException Wordt geworpen indien de gegeven datum niet bestaat
     * of niet binnen de toegelaten grenzen ligt.
     */
    @Override
    public void checkGeldigheidDatum (int dag, int maand, int jaar) throws DatumException {
        super.checkGeldigheidDatum(dag, maand, jaar);
        
//        if (jaar < 1977 && maand < 2 && dag < 12) {
//            throw new DatumException("DatumException :: WerknemersDatum kan niet voor de dag van de oprichting v/h bedrijf zijn (12 februari 1977)");
//        }

        Datum nieuweDatum = new Datum(dag, maand, jaar);
        Datum oprichtingsDatum = new Datum(DAG_VAN_OPRICHTING, MAAND_VAN_OPRICHTING, JAAR_VAN_OPRICHTING);

        if (nieuweDatum.compareTo(oprichtingsDatum) < 0) {
            throw new DatumException("DatumException :: "
                    + "WerknemersDatum " + new Datum(dag, maand, jaar) + " kan niet voor de dag van de oprichting v/h bedrijf zijn (12 februari 1977)");
        }
        
    }

}
