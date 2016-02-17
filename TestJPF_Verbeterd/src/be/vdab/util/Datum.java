/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Een klasse datum die een correcte, bestaande datum aanvaardt conform de
 * opgave 'Test Java Programming Fundamentals'. 
 * Een datum aangemaakt met de default constructor is '1/1/1584' 
 * Aanvaarde data zijn een geldige, bestaande datum
 * en situeert zich tussen 1/1/1584 en 31/12/4099. 
 * Controle op schrikkeljaar is aanwezig. Bij het aanmaken van een
 * foutieve datum krijgt men een DatumException geworpen. Het proberen wijzigen
 * van een bestaande Datum naar een onaanvaarde datum laat het object
 * ongewijzigd.
 *
 * @author yannick.thibos
 */
public class Datum implements IDatum, Comparable<Datum>, Serializable {
    
    private static final long serialVersionUID = 1L;

    private int dag;
    private int maand;
    private int jaar;

    private static final List<Integer> MAANDEN30DAGEN;

    static {
        /*
        Onwijzigbare lijst aanmaken die alle maanden bevat die exact
        30 dagen tellen. Te gebruiken bij controle op bestaande dagen.
        */
        ArrayList<Integer> maanden30dagen = new ArrayList<>(5);
        maanden30dagen.add(4);
        maanden30dagen.add(6);
        maanden30dagen.add(9);
        maanden30dagen.add(11);

        MAANDEN30DAGEN = Collections.unmodifiableList(maanden30dagen);
    }

    /**
     * Default constructor die de een Datum creëert en initialiseert op 1
     * januari 1584 (de vroegste datum mogelijk in deze implementatie).
     */
    public Datum() {
        this.dag = 1;
        this.maand = 1;
        this.jaar = 1584;
    }

    /**
     * Constructor die een Datum probeert te creëren met gegeven parameters.
     * Maakt een nieuwe datum aan op basis van de opgegeven parameters.
     *
     * @param dag       integer waarde voor een dag tussen 1 en 28/29/30/31
     * (afhankelijk van de maand en al dan niet schrikkeljaar).
     * @param maand     integer waarde voor een maand tussen 1 en 12.
     * @param jaar      integer waarde voor een jaar tussen 1584 en 4099.
     * @throws DatumException   Wordt geworpen indien de gegeven datum geen
     * geldige/bestaande datum is.
     */
    public Datum(int dag, int maand, int jaar) throws DatumException {
        checkGeldigheidDatum(dag, maand, jaar);
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    /**
     * Controleert de meegegeven datum op geldigheid.
     * Een geldige datum is een effectief bestaande datum conform de 
     * Gregoriaanse Kalender. Controle op schrikkeljaar is aanwezig 
     * (gebruik makend de static method Datum.isSchrikkeljaar).
     * Een aanvaarde datum bevindt zich tussen 1 januari 1584 en
     * 31 december 4099.
     * Als de datum niet aan de voorwaarden voldoet, of niet bestaat, 
     * krijgt men een DatumException geworpen.
     * 
     * @param dag       Integer waarde voor een dag tussen 1 en 28/29/30/31
     * (afhankelijk van de maand en al dan niet schrikkeljaar).
     * @param maand     Integer waarde voor een maand tussen 1 en 12.
     * @param jaar      Integer waarde voor een jaar tussen 1584 en 4099.
     * @throws DatumException   Wordt geworpen indien de gegeven datum geen
     * geldige/bestaande datum is.
     */
    public void checkGeldigheidDatum(int dag, int maand, int jaar) throws DatumException {
        if (jaar < 1584 || jaar > 4099) {
            throw new DatumException("DatumException :: Jaartal moet tussen 1584 en 4099 zijn");
        }
        if (maand < 1 || maand > 12) {
            throw new DatumException("DatumException :: Maand moet tussen 1 en 12 zijn");
        }
        if (dag < 1 || dag > 31) {
            throw new DatumException("DatumException :: Dag moet tussen 1 en 31 zijn");
        }
        if (MAANDEN30DAGEN.contains(maand)) {
            if (dag == 31) {
                throw new DatumException("DatumException :: 31ste bestaat niet voor de maand " + maand);
            }
        }
        if (maand == 2) {
            if (!isSchrikkeljaar(jaar) & (dag > 28)) {
                throw new DatumException("DatumException :: Februari telt slechts 28 dagen in jaar " + jaar);
            } else if (isSchrikkeljaar(jaar) & (dag > 29)) {
                throw new DatumException("DatumException :: Februari telt nooit meer dan 29 dagen");
            }
        }
    }

    /**
     * Methode die test of een gegeven jaar een schrikkeljaar is.
     * 
     * @param jaar  Jaar dat getest moet worden of deze een schrikkeljaar is.
     * @return  True als 'jaar' een schrikkeljaar is, anders false.
     */
    private static boolean isSchrikkeljaar(int jaar) {
        // Formule die 'jaar' controleert of het een schrikkeljaar is of niet
        return (jaar % 400 == 0 || jaar % 100 != 0 && jaar % 4 == 0);
    }

    /**
     * Probeert de Datum te wijzigen naar de gegeven dag. Maand en jaar blijven
     * ongewijzigd.
     * Indien de nieuwe datum onbestaande is, blijft het object ongewijzigd.
     * 
     * @param dag       Integer waarde voor een dag tussen 1 en 28/29/30/31
     * (afhankelijk van de maand en al dan niet schrikkeljaar).

     */
    @Override
    public void setDag(int dag) throws DatumException {
        checkGeldigheidDatum(dag, this.maand, this.jaar);
        this.dag = dag;
    }

    @Override
    public int getDag() {
        return dag;
    }

    /**
     * Probeert de Datum te wijzigen naar de gegeven maand. Dag en jaar blijven
     * ongewijzigd.
     * Indien de nieuwe datum ongeldig is, blijft het object ongewijzigd.
     * 
     * @param maand     Integer waarde voor een maand tussen 1 en 12.
     */
    @Override
    public void setMaand(int maand) throws DatumException {
        checkGeldigheidDatum(this.dag, maand, this.jaar);
        this.maand = maand;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    /**
     * Probeert de Datum te wijzigen naar de gegeven jaar. Dag en maand blijven
     * ongewijzigd.
     * Indien de nieuwe datum ongeldig is, blijft het object ongewijzigd.
     * 
     * @param jaar      Integer waarde voor een jaar tussen 1584 en 4099.
     */
    @Override
    public void setJaar(int jaar) throws DatumException {
        checkGeldigheidDatum(this.dag, this.maand, jaar);
        this.jaar = jaar;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    /**
     * Probeert de Datum te wijzigen naar de nieuwe opgegeven datum volgens
     * de parameters. 
     * Indien de gegeven datum onbestaande is, of buiten aanvaarde grenzen valt,
     * blijft het object ongewijzigd.
     * 
     * @param dag       Integer waarde voor een dag tussen 1 en 28/29/30/31
     * (afhankelijk van de maand en al dan niet schrikkeljaar).
     * @param maand     Integer waarde voor een maand tussen 1 en 12.
     * @param jaar      Integer waarde voor een jaar tussen 1584 en 4099.
     */
    @Override
    public void setDatum(int dag, int maand, int jaar) throws DatumException {
        checkGeldigheidDatum(dag, maand, jaar);
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }
    
    /**
     * Overridden toString methode die de Datum teruggeeft in een geformatteerde
     * String met de vorm "dd/mm/jjjj".
     * 
     * @return geformatteerde String in de vorm "dd/mm/jjjj".
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dag, maand, jaar);
    }

    /**
     * Vergelijking met een meegegeven datum die de chronologische volgorde bepaalt.
     * 
     * Een datum is 'kleiner dan' een andere datum wanneer deze chronologisch
     * vroeger is op de kalender. Ze zijn gelijk wanneer ze exact dezelfde
     * datum beschrijven of verwijzen naar dezelfde objecten. Een datum is
     * 'groter dan' een andere datum wanneer deze chronologisch later is op de
     * kalender.
     * 
     * @param datum De datum waarmee vergeleken moet worden.
     * @return  -1 als deze Datum vroeger is dan parameter Datum
     *          0 als deze datum hetzelfde resultaat geeft als equals(datum)
     *          1 als deze datum later is dan parameter Datum
     */
    @Override
    public int compareTo(Datum datum) {
        // Gelijke datums (of Datum objecten) returnt 0 (consistent met equals)
        if (this.equals(datum)) {
            return 0;
        } else if (this.getJaar() > datum.getJaar()) {
            return 1;
        } else if (this.getJaar() == datum.getJaar()) {
            if (this.getMaand() > datum.getMaand()) {
                return 1;
            } else if (this.getMaand() == datum.getMaand()) {
                if (this.getDag() > datum.getDag()) {
                    return 1;
                } else if (this.getDag() == datum.getDag()) {
                    return 0;
                }
            }
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.dag;
        hash = 37 * hash + this.maand;
        hash = 37 * hash + this.jaar;
        return hash;
    }

    /**
     * Vergelijkt deze datum met meegegeven parameter Datum op gelijkheid.
     * 
     * Een Datum wordt gelijk beschouwd slechts als:
     * - Ze hetzelfde object beschrijven
     * - Ze dezelfde waarden hebben voor dag, maand en jaar.
     * 
     * @param obj   Object waarmee vergeleken wordt op gelijkheid.
     * @return  true als beide objecten dezelfde datum beschrijven, of hetzelfde
     * object.
     *          false in alle andere gevallen.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Datum other = (Datum) obj;
        if (this.dag != other.dag) {
            return false;
        }
        if (this.maand != other.maand) {
            return false;
        }
        if (this.jaar != other.jaar) {
            return false;
        }
        return true;
    }
    
}
