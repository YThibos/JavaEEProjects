/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.bank.database;

/**
 * Klasse die alle gebruikte queries om te communiceren met de database groepeert.
 *
 * @author yannick.thibos
 */
public interface Queries {

    public static final String SQL_INSERT_NIEUWE_REKENING = "INSERT INTO"
            + " rekeningen(rekeningNr, saldo)"
            + " VALUES (?, ?)";
    public static final String SQL_SELECT_REKENINGEN = "SELECT"
            + " rekeningNr, saldo FROM rekeningen WHERE rekeningNr = ?";
    public static final String SQL_SELECT_VANNAAR_REKENINGEN = "SELECT"
            + " rekeningNr, saldo FROM rekeningen WHERE rekeningNr IN (?,?)";
    public static final String SQL_UPDATE_REKENINGEN = "UPDATE rekeningen"
            + " SET saldo = ? WHERE rekeningNr = ?";
    public static final String SQL_DELETE_ALL_RECORDS = "DELETE FROM rekeningen"
            + " WHERE rekeningNr LIKE '%'";
    
//    private Queries() {
//    }

}
