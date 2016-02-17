/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.personeel;

import be.vdab.util.WerknemersDatum;
import java.io.Serializable;

/**
 * Klasse die een bediende beschrijft en zijn eigenschappen.
 * Beschrijft een bediende in het bedrijf en zijn eigenschappen.
 * Erft van de abstracte klasse Werknemer.
 * Elke bediende heeft een personeelsnummer (groter dan of gelijk aan 1). Deze is niet noodzakelijk
 * uniek in deze implementatie. 
 * De datum van indiensttreding hoort steeds een geldige {@link WerknemersDatum} 
 * te zijn.
 * Een bediende heeft verplicht een naam, maar wat deze is blijft in te vullen
 * door de gebruiker.
 * Bovenop de eigenschappen die een werknemer heeft, heeft een bediende een
 * maandwedde. Deze kan niet negatief zijn.
 * 
 * @author yannick.thibos
 */
public class Bediende extends Werknemer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private double maandwedde;

    /**
     * Default constructor die een Bediende creëert en zijn velden initialiseerd
     * op volgende waarden:
     * Personeelsnummer: -1
     * Datum indiensttreding: 12 februari 1977
     * Naam: "nog in te vullen"
     * Maandwedde: 1129.47
     */
    public Bediende() {
        super();
        maandwedde = 1129.47;
    }
    
    /**
     * Creëert een nieuwe Bediende met opgegeven naam, personeelsnummer en 
     * datum van indiensttreding.
     * Bij het aanmaken van de Bediende wordt een controle uitgevoerd op
     * de geldigheid van de naam, het personeelsnummer, de datum en de
     * maandwedde.
     * Een naam is een geldige naam als deze niet leeg is.
     * Een personeelsnummer is geldig als deze 1 of hoger is.
     * De datum van indiensttreding moet een bestaande datum zijn en kan enkel
     * na de datum van de oprichting van het bedrijf zijn.
     * Een maandwedde kan niet negatief zijn.
     * 
     * @param naam              Niet-lege en niet null string als naam van de bediende.
     * @param personeelsNummer  Integer waarde groter dan of gelijk aan 1.
     * @param datumInDienst     Datum van indiensttreding (moet geldige datum zijn)
     * @param maandwedde        Maandwedde van de bediende groter dan of gelijk aan 0.
     * @throws WerknemerException Wordt geworpen wanneer één van de parameters
     * niet aan zijn voorwaarden voldoet.
     */
    public Bediende(String naam, int personeelsNummer, 
            WerknemersDatum datumInDienst, double maandwedde) throws WerknemerException {
        super(naam, personeelsNummer, datumInDienst);
        setMaandwedde(maandwedde);
    }
    
    public double getMaandwedde() {
        return maandwedde;
    }

    /**
     * Probeert de maandwedde te wijzigen naar de nieuwe waarde.
     * Wijzigt de maandwedde naar de opgegeven parameter.
     * 
     * @param maandwedde            Niet-negatieve double waarde.
     * @throws WerknemerException   Wordt geworpen indien de parameter maandwedde
     * negatief is.
     */
    public void setMaandwedde(double maandwedde) throws WerknemerException {
        if (maandwedde >= 0) {
            this.maandwedde = maandwedde;
        }
        else {
            throw new WerknemerException("WerknemerException :: Maandwedde kan niet negatief zijn");
        }
    }

    /**
     * Geeft de gegevens van de bediende terug met tabs tussen elke member.
     * 
     * @return  De gegevens van de bediende, gescheiden door tabs.
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + String.format("%.2f", getVerloning());
    }

    @Override
    public double getVerloning() {
        return maandwedde;
    }
    
}
