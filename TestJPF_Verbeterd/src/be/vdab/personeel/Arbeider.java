/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.personeel;

import be.vdab.util.WerknemersDatum;
import java.io.Serializable;

/**
 * Klasse die een arbeider beschrijft en zijn eigenschappen.
 * Beschrijft een arbeider in het bedrijf en zijn eigenschappen.
 * Erft van de abstracte klasse Werknemer.
 * Elke arbeider heeft een personeelsnummer (groter dan of gelijk aan 1). Deze is niet noodzakelijk
 * uniek in deze implementatie. 
 * De datum van indiensttreding hoort steeds een geldige {@link WerknemersDatum} 
 * te zijn.
 * Een arbeider heeft verplicht een naam, maar wat deze is blijft in te vullen
 * door de gebruiker.
 * Bovenop de eigenschappen die een werknemer heeft, heeft een arbeider een
 * uurloon. Deze kan niet negatief zijn.
 * 
 * @author yannick.thibos
 */
public class Arbeider extends Werknemer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private float uurloon;

    /**
     * Default constructor die een Bediende creëert en zijn velden initialiseerd
     * op volgende waarden:
     * Personeelsnummer: -1
     * Datum indiensttreding: 12 februari 1977
     * Naam: "nog in te vullen"
     * Uurloon: 9.76
     */
    public Arbeider() {
        super();
        uurloon = 9.76F;
    }

    /**
     * Creëert een nieuwe Arbeider met opgegeven naam,personeelsnummer en 
     * datum van indiensttreding.
     * Bij het aanmaken van de Arbeider wordt een controle uitgevoerd op
     * de geldigheid van de naam, het personeelsnummer, de datum en het uurloon.
     * Een naam is een geldige naam als deze niet leeg is.
     * Een personeelsnummer is geldig als deze 1 of hoger is.
     * De datum van indiensttreding moet een bestaande datum zijn en kan enkel
     * na de datum van de oprichting van het bedrijf zijn.
     * Een uurloon kan niet negatief zijn.
     * Wanneer niet aan deze voorwaarde wordt voldaan krijgt men een
     * WerknemerException geworpen.
     * 
     * @param uurloon   Het uurloon van de arbeider. Mag niet negatief zijn.
     * @param naam      Niet-lege en niet null string als naam van de arbeider.
     * @param personeelsNummer  Integer waarde groter dan of gelijk aan 1.
     * @param datumInDienst     Datum van indiensttreding (moet geldige datum zijn)
     * @throws WerknemerException   Wordt geworpen indien één van de parameters
     * niet aan zijn voorwaarde voldoet.
     */
    public Arbeider(String naam, int personeelsNummer, WerknemersDatum datumInDienst, float uurloon) throws WerknemerException {
        super(naam, personeelsNummer, datumInDienst);
        setUurloon(uurloon);
    }
    
    public float getUurloon() {
        return uurloon;
    }

    /**
     * Probeert het uurloon van de arbeider te wijzigen naar de nieuwe waarde.
     * Wijzigt het uurloon naar de nieuwe waarde indien deze niet negatief is.
     * Is dit toch het geval wordt de wijziging niet doorgevoerd.
     * 
     * @param uurloon               Niet negatieve float.
     * @throws WerknemerException   Wordt geworpen als uurloon negatief is.
     */
    public void setUurloon(float uurloon) throws WerknemerException {
        if (uurloon >= 0) {
            this.uurloon = uurloon;
        }
        else {
            throw new WerknemerException("WerknemerException :: Uurloon kan niet negatief zijn");
        }
    }

    /**
     * Geeft de gegevens van de arbeider terug in een String met tabs tussen elke member.
     * 
     * @return  De gegevens van de arbeider in een String, gescheiden door tabs. 
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + String.format("%.2f",getVerloning());
    }

    @Override
    public double getVerloning() {
        return (uurloon * 7.6 * 65) / 3;
    }
    
}
