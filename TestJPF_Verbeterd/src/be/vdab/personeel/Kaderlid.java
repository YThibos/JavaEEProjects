/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.personeel;

import be.vdab.util.WerknemersDatum;
import java.io.Serializable;

/**
 * Klasse die een kaderlid beschrijft en zijn eigenschappen.
 * Beschrijft een kaderlid in het bedrijf en zijn eigenschappen.
 * Erft van de abstracte klasse Bediende.
 * Elk kaderlid heeft een personeelsnummer (groter dan of gelijk aan 1). Deze is niet noodzakelijk
 * uniek in deze implementatie. 
 * De datum van indiensttreding hoort steeds een geldige {@link WerknemersDatum} 
 * te zijn.
 * Een kaderlid heeft verplicht een naam, maar wat deze is blijft in te vullen
 * door de gebruiker.
 * Bovenop de eigenschappen die een bediende heeft, heeft een kaderlid een
 * functietitel. 
 *
 * @author yannick.thibos
 */
public class Kaderlid extends Bediende implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String functietitel;
    
    /**
     * Default constructor die een Kaderlid creëert en zijn velden initialiseerd
     * op volgende waarden:
     * Personeelsnummer: -1
     * Datum indiensttreding: 12 februari 1977
     * Naam: "nog in te vullen"
     * Maandwedde: 1129.47
     * Functietitel: "manager
     */
    public Kaderlid() {
        super();
        functietitel = "manager";
    }

    /**
     * Creëert een nieuw Kaderlid met opgegeven naam, personeelsnummer en 
     * datum van indiensttreding.
     * Bij het aanmaken van het Kaderlid wordt een controle uitgevoerd op
     * de geldigheid van de naam, het personeelsnummer, de datum, de
     * maandwedde en de functietitel.
     * Een naam is een geldige naam als deze niet leeg is.
     * Een personeelsnummer is geldig als deze 1 of hoger is.
     * De datum van indiensttreding moet een bestaande datum zijn en kan enkel
     * na de datum van de oprichting van het bedrijf zijn.
     * Een maandwedde kan niet negatief zijn.
     * De functietitel kan niet leeg en niet null zijn.
     * Wanneer niet aan deze voorwaarde wordt voldaan krijgt men een
     * WerknemerException geworpen.
     * 
     * @param naam  Niet-lege en niet null string die de naam van het kaderlid geeft.
     * @param personeelsNummer  Integer waarde groter dan of gelijk aan 1.
     * @param datumInDienst     Geldige datum van indiensttreding.
     * @param maandwedde        Maandwedde van het kaderlid (groter dan of gelijk aan 0).
     * @param functietitel      Niet-lege en niet null string die de functie van het kaderlid
     *                          beschrijft
     * @throws WerknemerException Wordt geworpen indien één van de parameters niet
     * aan de voorwaarden voldoet.
     */
    public Kaderlid(String naam, int personeelsNummer, WerknemersDatum datumInDienst, 
            double maandwedde, String functietitel) throws WerknemerException {
        super(naam, personeelsNummer, datumInDienst, maandwedde);
        setFunctietitel(functietitel);
    }
    
    public String getFunctietitel() {
        return functietitel;
    }

    /**
     * Probeert de functietitel te wijzigen naar de opgegeven waarde.
     * Wijzigt de functietitel naar de nieuwe waarde als deze niet null en
     * niet leeg is. 
     * 
     * @param functietitel          Niet-null en niet-lege String.
     * @throws WerknemerException   Wordt geworpen als de gegeven functietitel
     * leeg is of een nullpointer bevat.
     */
    public void setFunctietitel(String functietitel) throws WerknemerException {
        if (functietitel == null) {
            throw new WerknemerException("WerknemerException :: Functietitel kan geen nullpointer zijn");
        }
        else if ("".equals(functietitel)){
            throw new WerknemerException("WerknemerException :: Functietitel kan geen lege string zijn");
        }
        this.functietitel = functietitel;
    }

    /**
     * Geeft de gegevens van het kaderlid terug met tabs tussen elke member.
     * 
     * @return  De gegevens van het kaderlid, gescheiden door tabs.
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + functietitel;
    }
    
}
