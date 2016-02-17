/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.bank.rekening;

import java.math.BigDecimal;

/**
 * Eenvoudige beschrijving van een Rekening waarmee een bank werkt.
 * Een rekeningnummer is om de eenvoud te bewaren niet gescheiden door koppeltekens of
 * bevat geen IBAN. Het bestaat uit 12 cijfers, waarvan de laatste 2 cijfers controlecijfers zijn.
 * Een rekeningsaldo kan niet onder nul gaan in deze implementatie.
 *
 * @author yannick.thibos
 */
public class Rekening {

    private final long rekeningNr;
    private BigDecimal saldo;

    /**
     * Maakt een nieuwe rekening aan op basis van gegeven rekeningnummer.
     * Probeert een nieuwe rekening aan te maken met gegeven rekeningnummer.
     * Het opgegeven rekeningnummer wordt eerst gevalideerd. Een geldig rekeningnummer
     * bestaat uit exact 12 cijfers, waarvan de laatste 2 cijfers de rest zijn
     * na gehele deling van de eerste 10 cijfers door 97.
     * Het saldo wordt op nul gezet.
     * 
     * @param rekeningNr Het rekeningnummer dat aan de nieuwe rekening gekoppeld wordt.
     * @throws RekeningException Wordt geworpen indien het rekeningnummer niet exact 12 cijfers telt
     * of wanneer de controle het rekeningnummer ongeldig vindt.
     */
    public Rekening(long rekeningNr) throws RekeningException {
        valideerRekeningNr(rekeningNr);
        this.rekeningNr = rekeningNr;
        this.saldo = BigDecimal.ZERO;
    }

    /**
     * Maakt een nieuwe rekening aan op basis van gegeven rekeningnummer.
     * Probeert een nieuwe rekening aan te maken met gegeven rekeningnummer.
     * Het opgegeven rekeningnummer wordt eerst gevalideerd. Een geldig rekeningnummer
     * bestaat uit exact 12 cijfers, waarvan de laatste 2 cijfers de rest zijn
     * na gehele deling van de eerste 10 cijfers door 97.
     * Het saldo wordt op het meegegeven saldo gezet.
     * 
     * @param rekeningNr Het rekeningnummer dat aan de nieuwe rekening gekoppeld wordt.
     * @param startSaldo Het startsaldo dat aan de nieuwe rekening wordt toegekend.
     * @throws RekeningException - Indien het rekeningnummer niet exact 12 cijfers telt
     * of wanneer de controle het rekeningnummer ongeldig vindt.<br>
     * - Indien het meegegeven startsaldo negatief is (nul is wel toegelaten).
     */
    public Rekening(long rekeningNr, BigDecimal startSaldo) throws RekeningException {
        valideerRekeningNr(rekeningNr);
        this.rekeningNr = rekeningNr;
        if (startSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new RekeningException("Meegegeven startsaldo mag niet nul zijn");
        }
        this.saldo = startSaldo;
    }

    public long getRekeningNr() {
        return rekeningNr;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * Valideert een rekeningnummer op geldigheid.
     * Een rekeningnummer is geldig wanneer het voldoet aan volgende eisen:
     * <br> - Het bestaat uit exact 12 cijfers
     * <br> - De laatste twee cijfers vormen de rest wanneer men de eerste 10 cijfers
     * geheel deelt door 97.
     * @param rekeningNr
     * @throws RekeningException Wordt geworpen wanneer aan minstens 1 van de voorwaarden niet wordt voldaan.
     */
    private void valideerRekeningNr(long rekeningNr) throws RekeningException {
        if (rekeningNr < 0) {
            throw new RekeningException("Een rekeningnummer kan niet negatief zijn");
        }

        int rekeningNrLengte = String.valueOf(rekeningNr).length();
        if (rekeningNrLengte != 12) {
            throw new RekeningException("Een rekeningnummer bevat exact 12 cijfers");
        }

        int eersteTienCijfers = (int) (rekeningNr / 100);
        int restCijfers = (int) (rekeningNr % 100);
        if (eersteTienCijfers % 97 != restCijfers) {
            throw new RekeningException("Controlecijfers niet gelijk aan rest na controledeling");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.rekeningNr ^ (this.rekeningNr >>> 32));
        return hash;
    }

    /**
     * Controleert of twee rekeningen 'gelijk' zijn.
     * Rekeningen worden als gelijk beschouwd als ze ofwel:
     * <br> - Naar hetzelfde object verwijzen.
     * <br> - De rekeningnummers identiek zijn.
     * @param obj Het object waarmee gelijkheid getest wordt.
     * @return 'True' indien aan 1 van de voorwaarden voldaan wordt.
     * <br> 'False' in alle andere gevallen.
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
        final Rekening other = (Rekening) obj;
        return this.rekeningNr == other.rekeningNr;
    }

    @Override
    public String toString() {
        return String.format("Rekeningnummer: %-20d%nSaldo: %-20.2f", this.getRekeningNr(), this.getSaldo());
    }

    /**
     * Verricht een overschrijving van deze rekening naar een opgegeven rekening voor meegegeven bedrag.
     * De verrichting wordt enkel uitgevoerd wanneer de doel rekening niet gelijk is aan de rekening waarop
     * verricht wordt, wanneer de verrichting het saldo niet onder nul zou brengen en indien
     * het over te schrijven bedrag strict positief is.
     * @param naarRekening De rekening waarop het over te schrijven bedrag terecht komt.
     * @param bedrag Het over te schrijven bedrag (strict positief)
     * @throws RekeningException Wordt geworpen wanneer aan 1 van de voorwaarden niet voldaan wordt.
     */
    public void schrijfOver(Rekening naarRekening, BigDecimal bedrag) throws RekeningException {

        if (this.equals(naarRekening)) {
            throw new RekeningException("'Van' en 'naar' rekeningen mogen niet gelijk zijn bij een overschrijving");
        }
        if (bedrag.compareTo(BigDecimal.ZERO) < 1) {
            throw new RekeningException("Over te schrijven bedrag mag niet negatief zijn");
        }

        this.haalAf(bedrag);
        naarRekening.stort(bedrag);

    }

    /**
     * Haalt een opgegeven bedrag van de rekening af.
     * De verrichting wordt enkel doorgevoerd wanneer het opgegeven bedrag strict
     * positief is, en wanneer het de rekening niet onder nul zou brengen.
     * @param bedrag Het af te halen bedrag (strict positief).
     * @throws RekeningException Geworpen wanneer 1 van de voorwaarden geschonden wordt.
     */
    public void haalAf(BigDecimal bedrag) throws RekeningException {
        if (bedrag.compareTo(BigDecimal.ZERO) < 1) {
            throw new RekeningException("Het af te halen bedrag dient strict positief te zijn");
        }
        if (this.getSaldo().compareTo(bedrag) < 0) {
            throw new RekeningException("Saldo ontoereikend voor de gevraagde overschrijving");
        }
        this.saldo = this.saldo.subtract(bedrag);
    }

    /**
     * Zet het opgegeven bedrag op de rekening.
     * Een storting wordt enkel doorgevoerd wanneer het opgegeven bedrag strict positief is.
     * 
     * @param bedrag Het te storten bedrag (strict positief).
     * @throws RekeningException Wordt geworpen wanneer het te storten bedrag nul of negatief is.
     */
    public void stort(BigDecimal bedrag) throws RekeningException {
        if (bedrag.compareTo(BigDecimal.ZERO) < 1) {
            throw new RekeningException("Het te storten bedrag dient strict positief te zijn");
        }
        this.saldo = this.saldo.add(bedrag);
    }
}
