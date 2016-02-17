/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

import java.io.Serializable;
import java.util.Objects;

/**
 * Immutable class die de nodige velden van een Adres beschrijft. 
 * Een adres is een onwijzigbaar gegeven. Meerdere personen kunnen op één adres
 * inwonende zijn. Wanneer iemand van adres verandert, 
 * verhuist de inwonende maar blijft het adres hetzelfde.<br>
 * Zie {@link Personeelslid} voor meer informatie over 'verhuizen'.
 *
 * @author yannick.thibos
 */
public final class Adres implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String straatEnHuisnr;
    private String postcode;
    private String gemeente;

    /**
     * Maakt een nieuw Adres object met gegeven parameters. 
     * Maak een adres aan per bestaand adres.<br>
     * Bij meerdere inwonenden, laat verwijzende velden dan
     * steeds naar hetzelfde Adres object wijzen.
     *
     * @param straatEnHuisnr    Niet-lege en niet null String met de straat en het
     * huisnummer van het Adres.
     * @param postcode          Niet-lege en niet null String met de postcode.
     * @param gemeente          Niet-lege en niet null String met de gemeente.
     * @throws AdresException Lege String of nullpointer wordt niet aanvaard als
     * input voor de parameters. AdresException wordt geworpen als dit toch het
     * geval is.
     */
    public Adres(String straatEnHuisnr, String postcode, String gemeente) {
        setStraatEnHuisnr(straatEnHuisnr);
        setPostcode(postcode);
        setGemeente(gemeente);
    }

    private void setGemeente(String gemeente) throws AdresException {
        if (gemeente == null) {
            throw new AdresException("AdresException :: String postcode"
                    + " is een nullpointer");
        }
        if ("".equals(gemeente)) {
            throw new AdresException("AdresException :: String postcode"
                    + " mag niet leeg zijn");
        }
        this.gemeente = gemeente;
    }

    private void setPostcode(String postcode) throws AdresException {
        if (postcode == null) {
            throw new AdresException("AdresException :: String postcode"
                    + " is een nullpointer");
        }
        if ("".equals(postcode)) {
            throw new AdresException("AdresException :: String postcode"
                    + " mag niet leeg zijn");
        }
        this.postcode = postcode;
    }

    private void setStraatEnHuisnr(String straatEnHuisnr) throws AdresException {
        if (straatEnHuisnr == null) {
            throw new AdresException("AdresException :: String straatEnHuisnr"
                    + " is een nullpointer");
        }
        if ("".equals(straatEnHuisnr)) {
            throw new AdresException("AdresException :: String straatEnHuisnr"
                    + " mag niet leeg zijn");
        }
        this.straatEnHuisnr = straatEnHuisnr;
    }

    public String getStraatEnHuisnr() {
        return straatEnHuisnr;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.straatEnHuisnr);
        hash = 29 * hash + Objects.hashCode(this.postcode);
        hash = 29 * hash + Objects.hashCode(this.gemeente);
        return hash;
    }

    /**
     * Controleert of dit adres hetzelfde is als de parameter.
     * Een adres wordt als gelijk beschouwd als ze ofwel:
     * <p>
     * - Hetzelfde object beschrijven.<br>
     * - Exact dezelfde waarden hebben voor alle velden.
     * 
     * @param obj
     * @return 
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
        final Adres other = (Adres) obj;
        if (!Objects.equals(this.straatEnHuisnr, other.straatEnHuisnr)) {
            return false;
        }
        if (!Objects.equals(this.postcode, other.postcode)) {
            return false;
        }
        if (!Objects.equals(this.gemeente, other.gemeente)) {
            return false;
        }
        return true;
    }

    /**
     * Geeft de waarden van straat en huisnummer, postcode en gemeente terug in een String.
     * 
     * @return  straatEnHuisnummer \t-\t postcode gemeente
     */
    @Override
    public String toString() {
        return straatEnHuisnr + "\t-\t" + postcode + " " + gemeente;
    }

}
