/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.personeel;

import be.vdab.util.DatumException;
import be.vdab.util.WerknemersDatum;
import java.io.Serializable;
import java.util.Objects;

/**
 * Abstracte klasse die alle functies en eigenschappen beschrijft van een Werknemer.
 * Beschrijft een werknemer en de operaties die erop mogelijk zijn. 
 * Elke werknemer heeft een personeelsnummer (groter dan of gelijk aan 1). Deze is niet noodzakelijk
 * uniek in deze implementatie. 
 * De datum van indiensttreding hoort steeds een geldige {@link WerknemersDatum} 
 * te zijn.
 * Een werknemer heeft verplicht een naam, maar wat deze is blijft in te vullen
 * door de gebruiker.
 *
 * @author yannick.thibos
 */
public abstract class Werknemer implements Comparable<Werknemer>, Serializable {

    private int personeelsNummer;
    private WerknemersDatum datumInDienst;
    private String naam;

    /**
     * Default constructor die een Werknemer creëert en zijn velden initialiseerd
     * op volgende waarden:
     * Personeelsnummer: -1
     * Datum indiensttreding: 12 februari 1977
     * Naam: "nog in te vullen"
     */
    public Werknemer() {
        this.personeelsNummer = -1;
        this.datumInDienst = new WerknemersDatum();
        this.naam = "nog niet ingevuld";
    }

    /**
     * Creëert een nieuwe Werknemer met opgegeven naam,personeelsnummer en 
     * datum van indiensttreding.
     * Bij het aanmaken van de Werknemer wordt een controle uitgevoerd op
     * de geldigheid van de naam, het personeelsnummer en de datum.
     * Een naam is een geldige naam als deze niet leeg is.
     * Een personeelsnummer is geldig als deze 1 of hoger is.
     * De datum van indiensttreding moet een bestaande datum zijn en kan enkel
     * na de datum van de oprichting van het bedrijf zijn.
     * Wanneer niet aan deze voorwaarde wordt voldaan krijgt men een
     * WerknemerException geworpen.
     * 
     * @param naam  Niet lege string die de naam van de werknemer is.
     * @param personeelsNummer  integer personeelsnummer groter dan of gelijk aan 1.
     * @param datumInDienst WerknemersDatum ten vroegste 12/02/1977 én een bestaande datum.
     * @throws WerknemerException   Wordt geworpen indien één van de parameters
     * niet voldoet aan de voorwaarden.
     */
    public Werknemer(String naam, int personeelsNummer, WerknemersDatum datumInDienst) throws WerknemerException {
        setNaam(naam);
        setPersoneelsNummer(personeelsNummer);
        setDatumInDienst(datumInDienst);
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    /**
     * Probeert het personeelsnummer te wijzigen naar de nieuwe parameter.
     * Wijzigt het personeelsnummer naar het nieuwe opgegeven personeelsnummer
     * indien het een geldige is.
     * Als dat niet het geval is krijgt men een WerknemerException geworpen.
     * 
     * @param personeelsNummer  integer waarde groter of gelijk aan 1
     * @throws WerknemerException   Wordt geworpen indien het personeelsnummer
     * 0 of negatief is.
     */
    public void setPersoneelsNummer(int personeelsNummer) throws WerknemerException {
        if (isGeldigPersoneelsNummer(personeelsNummer)) {
            this.personeelsNummer = personeelsNummer;
        } else {
            throw new WerknemerException("WerknemerException :: Ongeldig personeelsnummer (moet >= 1 zijn)");
        }
    }

    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    /**
     * Probeert de datum van indiensttreding te wijzigen naar de nieuwe parameter.
     * Wijzigt de datum van indiensttreding naar de opgegeven waarde indien het
     * een geldige datum is.
     * Een datum is geldig wanneer deze effectief bestaat, en chronologisch later
     * is dan de oprichtingsdatum van het bedrijf.
     * Als dat niet het geval is krijgt men een WerknemerException geworpen.
     * 
     * @param datumInDienst Geldige datum (tussen 12/02/1977 en 1/1/4100)
     * @throws WerknemerException   Wordt geworpen indien de gegeven datum 
     * geen bestaande/geldige datum is.
     */
    public void setDatumInDienst(WerknemersDatum datumInDienst) throws WerknemerException {
        if (datumInDienst != null) {
            try {
                datumInDienst.checkGeldigheidDatum(datumInDienst.getDag(), datumInDienst.getMaand(), datumInDienst.getJaar());
            } catch (DatumException causeEx) {
                throw new WerknemerException("WerknemerException :: " + causeEx.getMessage(), causeEx);
            }
            this.datumInDienst = datumInDienst;
        }
        else {
            throw new WerknemerException("WerknemerException :: Opgegeven datum is nullpointer");
        }
    }

    public String getNaam() {
        return naam;
    }

    /**
     * Probeert de naam van de werknemer te wijzigen naar de opgegeven waarde.
     * Wijzigt de naam van de werknemer naar de opgegeven String indien deze
     * een geldige naam is.
     * Een naam is geldig wanneer deze een non-null en niet lege String is ("").
     * 
     * @param naam  Niet-null en niet lege String met de nieuwe naam.
     * @throws WerknemerException Wordt geworpen indien de gegeven naam een
     * lege string is of een nullpointer is.
     */
    public void setNaam(String naam) throws WerknemerException {
        if (isGeldigeNaam(naam)) {
            this.naam = naam;
        } else {
            throw new WerknemerException("WerknemerException :: Ongeldige naam opgegeven");
        }
    }
    
    public abstract double getVerloning();

    private boolean isGeldigPersoneelsNummer(int personeelsNummer) {
        // personeelsNummer moet groter dan 0 zijn
        return personeelsNummer >= 1;
    }

    private boolean isGeldigeNaam(String naam) {
        // Naam mag geen lege String of nullpointer zijn
        if (naam == null) {
            return false;
        } else if ("".equals(naam)) {
            return false;
        }
        return true;
    }

    /**
     * Geeft de gegevens van de werknemer terug met tabs tussen elke member.
     * 
     * @return De gegevens van de werknemer, gescheiden door tabs.
     */
    @Override
    public String toString() {
        return datumInDienst + "\t" + personeelsNummer + "\t" + naam;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.personeelsNummer;
        hash = 23 * hash + Objects.hashCode(this.naam);
        return hash;
    }

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
        final Werknemer other = (Werknemer) obj;
        if (this.personeelsNummer != other.personeelsNummer) {
            return false;
        }
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        return true;
    }

    /**
     * Vergelijkt deze werknemer met de parameter op basis van de datum in dienst.
     * 
     * @param werknemer Werknemer waarmee vergeleken moet worden.
     * @return  -1 als deze werknemer eerder in dienst was.
     *          0 als ze dezelfde datum hebben van indienstname.
     *          1 als deze werknemer later in dienst was.
     */ 
    @Override
    public int compareTo(Werknemer werknemer) {
        return this.datumInDienst.compareTo(werknemer.getDatumInDienst());
    }
    
}
